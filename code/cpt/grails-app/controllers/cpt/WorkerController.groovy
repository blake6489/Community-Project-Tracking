package cpt

import org.springframework.dao.DataIntegrityViolationException

class WorkerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [workerInstanceList: Worker.list(params), workerInstanceTotal: Worker.count()]
    }

    def create() {
        [workerInstance: new Worker(params)]
    }

    def save() {
        def workerInstance = new Worker(params)
        if (!workerInstance.save(flush: true)) {
            render(view: "create", model: [workerInstance: workerInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'worker.label', default: 'Worker'), workerInstance.id])
        redirect(action: "show", id: workerInstance.id)
    }

    def show() {
        def workerInstance = Worker.get(params.id)
        if (!workerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'worker.label', default: 'Worker'), params.id])
            redirect(action: "list")
            return
        }

        [workerInstance: workerInstance]
    }

    def edit() {
        def workerInstance = Worker.get(params.id)
        if (!workerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'worker.label', default: 'Worker'), params.id])
            redirect(action: "list")
            return
        }

        [workerInstance: workerInstance]
    }

    def update() {
        def workerInstance = Worker.get(params.id)
        if (!workerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'worker.label', default: 'Worker'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (workerInstance.version > version) {
                workerInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'worker.label', default: 'Worker')] as Object[],
                          "Another user has updated this Worker while you were editing")
                render(view: "edit", model: [workerInstance: workerInstance])
                return
            }
        }

        workerInstance.properties = params

        if (!workerInstance.save(flush: true)) {
            render(view: "edit", model: [workerInstance: workerInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'worker.label', default: 'Worker'), workerInstance.id])
        redirect(action: "show", id: workerInstance.id)
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
