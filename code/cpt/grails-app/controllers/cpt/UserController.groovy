package cpt

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN', 'IS_AUTHENTICATED_FULLY'])
class UserController {

	def index() {
		redirect(action: "list", params: params)
	}
	
	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[list: User.list(params), total: User.count()]
	}
	
	def create() {
		if(request.get) {
			return [instance: new User()]
		}
		else if(request.post) {
			return save()
		}
	}
	
	def save() {
		def instance = new User(params)
		instance.enabled = true
		instance.accountExpired = false
		instance.accountLocked = false
		instance.passwordExpired = false
		
		if (!params.password.equals(params.password2)) {
			instance.validate() //might as well report other errors too
			instance.errors.rejectValue('password', message(code:'default.password.mismatch.message'))
			return [instance: instance]
		}
		
		if (!instance.createWithUserRole()) {
			//chain(action: "create", model: [instance: instance])
			return [instance: instance]
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'user.label'), instance.username])
		redirect(action: "show", id: instance.id)
	}
	
	def show() {
		def instance = User.get(params.id)
		if (!instance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
			redirect(action: "list")
			return
		}

		[instance: instance]
	}
	
	def update() {
		
	}
	
	def delete() {
		
	}
	
	def resetPassword() {
		if(request.get) {
			def instance = User.get(params.id)
			[instance: instance]
		}
		else if(request.post) {
			def instance = User.get(params.id)
			if (!instance) {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
				redirect(action: "list")
				return
			}
	
			if (params.version) {
				def version = params.version.toLong()
				if (instance.version > version) {
					instance.errors.rejectValue("version", "default.optimistic.locking.failure",
							[message(code: 'user.label', default: 'User')] as Object[],
							"Another user has updated this User while you were editing")
					return [instance: instance]
				}
			}
			
			if (!params.password.equals(params.password2)) {
			instance.errors.rejectValue('password', message(code:'default.password.mismatch.message'))
				return [instance: instance]
			}
			
			instance.password = params.password
			if (!instance.save(flush: true)) {
				return [instance: instance]
			}
	
			flash.message = "Password for ${instance.username} changed"
			redirect(action: "show", id: instance.id)
		}
	}
}
