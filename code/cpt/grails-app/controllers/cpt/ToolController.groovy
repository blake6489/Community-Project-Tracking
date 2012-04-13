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
		[toolInstance: new Tool(params)]
	}

	def save() {
		def toolInstance = new Tool(params)
		if (!toolInstance.save(flush: true)) {
			render(view: "create", model: [toolInstance: toolInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'tool.label', default: 'Tool'), toolInstance.id])
		redirect(action: "show", id: toolInstance.id)
	}

	def show() {
		def toolInstance = Tool.get(params.id)
		if (!toolInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tool.label', default: 'Tool'), params.id])
			redirect(action: "list")
			return
		}

		[toolInstance: toolInstance]
	}

	def edit() {
		def toolInstance = Tool.get(params.id)
		if (!toolInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tool.label', default: 'Tool'), params.id])
			redirect(action: "list")
			return
		}

		[toolInstance: toolInstance]
	}

	def update() {
		def toolInstance = Tool.get(params.id)
		if (!toolInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tool.label', default: 'Tool'), params.id])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (toolInstance.version > version) {
				toolInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[message(code: 'tool.label', default: 'Tool')] as Object[],
						"Another user has updated this Tool while you were editing")
				render(view: "edit", model: [toolInstance: toolInstance])
				return
			}
		}

		toolInstance.properties = params

		if (!toolInstance.save(flush: true)) {
			render(view: "edit", model: [toolInstance: toolInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'tool.label', default: 'Tool'), toolInstance.id])
		redirect(action: "show", id: toolInstance.id)
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
