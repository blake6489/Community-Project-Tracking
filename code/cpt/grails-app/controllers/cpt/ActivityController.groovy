package cpt

import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ADMIN'])
class ActivityController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		[list: Activity.list(params), total: Activity.count()]
	}

	def create() {
		if(request.get) {
			return [instance: new Activity(), names: ""]
		}
		else if(request.post) {
			return save()
		}
	}

	def save() {
		def instance = new Activity()
		def newInstance
		int nameCount = 0
		Activity.withTransaction { status ->
			params.names.eachLine { line, i ->
				if(line.length() > 0) {
					nameCount++
					newInstance = new Activity(name: line)
					if(!newInstance.save()) {
						status.setRollbackOnly()
						for(error in newInstance.errors.allErrors) {
							instance.errors.reject("Line ${i+1}: ${message(error:error)}")
						}
					}
				}
			}
		}
		if(instance.errors.hasErrors()) {
			return [instance: instance, names: params.names]
		}
		else {
			if(nameCount == 1) {
				flash.message = message(code: 'default.created.message', args: [message(code: 'activity.label'), newInstance.name])
				redirect(action: "show", id: newInstance.id)
			}
			else {
				flash.message = message(code: 'default.batch.created.message', args: [nameCount, message(code: 'activity.labels')])
				redirect(action: "list")
			}
		}
	}

	def show() {
		if(request.get) {
			def instance = Activity.get(params.id)
			if (!instance) {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'activity.label'), params.id])
				redirect(action: "list")
				return
			}
	
			[instanceR: instance, instanceW: instance]
		}
		else if(request.post) {
			return update()
		}
	}

	def update() {
		def instanceW = Activity.get(params.id)
		if (!instanceW) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'activity.label'), params.id])
			redirect(action: "list")
			return
		}
		
		//store copy of old values
		def instanceR = new Activity()
		instanceR.properties = instanceW.properties
		instanceW.properties = params
		
		if (params.version) {
			def version = params.version.toLong()
			if (instanceW.version > version) {
				instanceW.errors.rejectValue("version", "default.optimistic.locking.failure",
						[message(code: 'activity.label', default: 'Activity')] as Object[],
						"Another user has updated this Activity while you were editing")
				render(view: "show", model: [instanceR: instanceR, instanceW: instanceW])
				return
			}
		}

		if (!instanceW.save(flush: true)) {
			render(view: "show", model: [instanceR: instanceR, instanceW: instanceW])
			return
		}

		flash.message = message(code: 'default.renamed.message', args: [message(code: 'activity.label'), instanceR.name, instanceW.name])
		redirect(action: "show", id: instanceW.id)
	}

	def delete() {
		def activityInstance = Activity.get(params.id)
		if (!activityInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'activity.label', default: 'Activity'), params.id])
			redirect(action: "list")
			return
		}

		try {
			activityInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'activity.label', default: 'Activity'), params.id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'activity.label', default: 'Activity'), params.id])
			redirect(action: "show", id: params.id)
		}
	}
}
