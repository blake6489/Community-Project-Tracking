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
		[instance: new User(params)]
	}
	
	def save() {
		def instance = new User(params)
		if (!instance.save(flush: true)) {
			render(view: "create", model: [instance: instance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), instance.id])
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
}
