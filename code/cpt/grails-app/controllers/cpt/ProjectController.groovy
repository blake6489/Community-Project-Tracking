package cpt

import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ADMIN'])
class ProjectController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		[list: Project.list(params), total: Project.count()]
	}

	def create() {
		if(request.get) {
			return [instance: new Project()]
		}
		else if(request.post) {
			return save()
		}
	}

	def save() {
		def instance = new Project(params)
		if (!instance.save(flush: true)) {
			return [instance: instance]
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'project.label'), instance.id])
		redirect(action: "show", id: instance.id)
	}

	def show() {
		if(request.get) {
			def instance = Project.get(params.id)
			if (!instance) {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label'), params.id])
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
		def projectInstance = Project.get(params.id)
		if (!projectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (projectInstance.version > version) {
				projectInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[message(code: 'project.label', default: 'Project')] as Object[],
						"Another user has updated this Project while you were editing")
				render(view: "edit", model: [projectInstance: projectInstance])
				return
			}
		}

		projectInstance.properties = params

		if (!projectInstance.save(flush: true)) {
			render(view: "edit", model: [projectInstance: projectInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'project.label', default: 'Project'), projectInstance.id])
		redirect(action: "show", id: projectInstance.id)
	}

	def delete() {
		def projectInstance = Project.get(params.id)
		if (!projectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
			redirect(action: "list")
			return
		}

		try {
			projectInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'project.label', default: 'Project'), params.id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'project.label', default: 'Project'), params.id])
			redirect(action: "show", id: params.id)
		}
	}
}
