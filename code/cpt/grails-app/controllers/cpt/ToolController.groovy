package cpt

import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ADMIN'])
class ToolController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[toolInstanceList: Tool.list(params), toolInstanceTotal: Tool.count()]
	}

	def create() {
		if(request.get) {
			return [instance: new Tool(), names: ""]
		}
		else if(request.post) {
			return save()
		}
	}

	def save() {
		def instance = new Tool()
		def newInstance
		int nameCount = 0
		Tool.withTransaction { status ->
			params.names.eachLine { line, i ->
				if(line.length() > 0) {
					nameCount++
					newInstance = new Tool(name: line)
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
				flash.message = message(code: 'default.created.message', args: [message(code: 'tool.label'), newInstance.name])
				redirect(action: "show", id: newInstance.id)
			}
			else {
				flash.message = message(code: 'default.batch.created.message', args: [nameCount, message(code: 'tool.labels')])
				redirect(action: "list")
			}
		}
	}

	def show() {
		if(request.get) {
			def instance = Tool.get(params.id)
			if (!instance) {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'tool.label'), params.id])
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
		def instanceW = Tool.get(params.id)
		if (!instanceW) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tool.label'), params.id])
			redirect(action: "list")
			return
		}
		
		//store copy of old values
		def instanceR = new Tool()
		instanceR.properties = instanceW.properties
		instanceW.properties = params
		
		if (params.version) {
			def version = params.version.toLong()
			if (instanceW.version > version) {
				instanceW.errors.rejectValue("version", "default.optimistic.locking.failure",
						[message(code: 'tool.label', default: 'Tool')] as Object[],
						"Another user has updated this Tool while you were editing")
				render(view: "show", model: [instanceR: instanceR, instanceW: instanceW])
				return
			}
		}

		if (!instanceW.save(flush: true)) {
			render(view: "show", model: [instanceR: instanceR, instanceW: instanceW])
			return
		}

		flash.message = message(code: 'default.renamed.message', args: [message(code: 'tool.label'), instanceR.name, instanceW.name])
		redirect(action: "show", id: instanceW.id)
	}

	def delete() {
		def toolInstance = Tool.get(params.id)
		if (!toolInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tool.label', default: 'Tool'), params.id])
			redirect(action: "list")
			return
		}

		try {
			toolInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'tool.label', default: 'Tool'), params.id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tool.label', default: 'Tool'), params.id])
			redirect(action: "show", id: params.id)
		}
	}
}
