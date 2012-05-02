package cpt

import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ADMIN'])
class TimesheetTemplateController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		[list: TimesheetTemplate.list(params), total: TimesheetTemplate.count()]
	}

	def create() {
		if(request.get) {
			return [instance: new TimesheetTemplate()]
		}
		else if(request.post) {
			return save()
		}
	}

	def save() {
		def instance = new TimesheetTemplate(params)
		if (!instance.save(flush: true)) {
			return [instance: instance]
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'timesheetTemplate.label'), instance.id])
		redirect(action: "show", id: instance.id)
	}

	def show() {
		def template = TimesheetTemplate.get(params.id)
		if (!template) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'timesheetTemplate.label'), params.id])
			redirect(action: "list")
			return
		}
		def data = new Timesheet()

		[instance: data, template: template, data: data]
	}

	def edit() {
		def timesheetTemplateInstance = TimesheetTemplate.get(params.id)
		if (!timesheetTemplateInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'timesheetTemplate.label', default: 'TimesheetTemplate'), params.id])
			redirect(action: "list")
			return
		}

		[timesheetTemplateInstance: timesheetTemplateInstance]
	}

	def update() {
		def timesheetTemplateInstance = TimesheetTemplate.get(params.id)
		if (!timesheetTemplateInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'timesheetTemplate.label', default: 'TimesheetTemplate'), params.id])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (timesheetTemplateInstance.version > version) {
				timesheetTemplateInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[message(code: 'timesheetTemplate.label', default: 'TimesheetTemplate')] as Object[],
						"Another user has updated this TimesheetTemplate while you were editing")
				render(view: "edit", model: [timesheetTemplateInstance: timesheetTemplateInstance])
				return
			}
		}

		timesheetTemplateInstance.properties = params

		if (!timesheetTemplateInstance.save(flush: true)) {
			render(view: "edit", model: [timesheetTemplateInstance: timesheetTemplateInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'timesheetTemplate.label', default: 'TimesheetTemplate'), timesheetTemplateInstance.id])
		redirect(action: "show", id: timesheetTemplateInstance.id)
	}

	def delete() {
		def timesheetTemplateInstance = TimesheetTemplate.get(params.id)
		if (!timesheetTemplateInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'timesheetTemplate.label', default: 'TimesheetTemplate'), params.id])
			redirect(action: "list")
			return
		}

		try {
			timesheetTemplateInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'timesheetTemplate.label', default: 'TimesheetTemplate'), params.id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'timesheetTemplate.label', default: 'TimesheetTemplate'), params.id])
			redirect(action: "show", id: params.id)
		}
	}
}
