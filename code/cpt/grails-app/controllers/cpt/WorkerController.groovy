package cpt

import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ADMIN'])
class WorkerController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		[list: Worker.list(params), total: Worker.count()]
	}

	def create() {
		if(request.get) {
			return [instance: new Worker()]
		}
		else if(request.post) {
			return save()
		}
	}

	def save() {
		def instance = new Worker(params)
		if (!instance.save(flush: true)) {
			return [instance: instance]
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'worker.label'), instance.id])
		redirect(action: "show", id: instance.id)
	}

	def show() {
		if(request.get) {
			def instance = Worker.get(params.id)
			if (!instance) {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'worker.label'), params.id])
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
		def instanceW = Worker.get(params.id)
		if (!instanceW) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'worker.label'), params.id])
			redirect(action: "list")
			return
		}
		
		//store copy of old values
		def instanceR = new Worker()
		instanceR.properties = instanceW.properties
		instanceW.properties = params
		
		if (params.version) {
			def version = params.version.toLong()
			if (instanceW.version > version) {
				instanceW.errors.rejectValue("version", "default.optimistic.locking.failure",
						[message(code: 'worker.label')] as Object[],
						"Another user has updated this Worker while you were editing")
				render(view: "show", model: [instanceR: instanceR, instanceW: instanceW])
				return
			}
		}

		if (!instanceW.save(flush: true)) {
			render(view: "show", model: [instanceR: instanceR, instanceW: instanceW])
			return
		}

		flash.message = message(code: 'default.renamed.message', args: [message(code: 'worker.label'), instanceR.name, instanceW.name])
		redirect(action: "show", id: instanceW.id)
	}

	def delete() {
		def workerInstance = Worker.get(params.id)
		if (!workerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'worker.label', default: 'Worker'), params.id])
			redirect(action: "list")
			return
		}

		try {
			workerInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'worker.label', default: 'Worker'), params.id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'worker.label', default: 'Worker'), params.id])
			redirect(action: "show", id: params.id)
		}
	}
}
