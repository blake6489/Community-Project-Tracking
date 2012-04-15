package cpt

import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

import cpt.Location;

@Secured(['ROLE_ADMIN'])
class LocationController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[locationInstanceList: Location.list(params), locationInstanceTotal: Location.count()]
	}

	def create() {
		if(request.get) {
			return [instance: new Location(), names: ""]
		}
		else if(request.post) {
			return save()
		}
	}

	def save() {
		def instance = new Location()
		def newInstance
		int nameCount = 0
		Location.withTransaction { status ->
			params.names.eachLine { line, i ->
				if(line.length() > 0) {
					nameCount++
					newInstance = new Location(name: line)
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
				flash.message = "Location ${newInstance.name} created"
				redirect(action: "show", id: newInstance.id)
			}
			else {
				flash.message = "${nameCount} locations created"
				redirect(action: "list")
			}
		}
	}

	def show() {
		if(request.get) {
			def instance = Location.get(params.id)
			if (!instance) {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'location.label', default: 'Location'), params.id])
				redirect(action: "list")
				return
			}
	
			[instance: instance]
		}
		else if(request.post) {
			return update()
		}
	}

	def edit() {
		def locationInstance = Location.get(params.id)
		if (!locationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'location.label', default: 'Location'), params.id])
			redirect(action: "list")
			return
		}

		[locationInstance: locationInstance]
	}

	def update() {
		def instance = Location.get(params.id)
		if (!instance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'location.label', default: 'Location'), params.id])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (instance.version > version) {
				instance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[message(code: 'location.label', default: 'Location')] as Object[],
						"Another user has updated this Location while you were editing")
				render(view: "show", model: [instance: instance])
				return
			}
		}

		instance.properties = params

		if (!instance.save(flush: true)) {
			render(view: "show", model: [instance: instance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'location.label', default: 'Location'), instance.id])
		redirect(action: "show", id: instance.id)
	}

	def delete() {
		def locationInstance = Location.get(params.id)
		if (!locationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'location.label', default: 'Location'), params.id])
			redirect(action: "list")
			return
		}

		try {
			locationInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'location.label', default: 'Location'), params.id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'location.label', default: 'Location'), params.id])
			redirect(action: "show", id: params.id)
		}
	}
}
