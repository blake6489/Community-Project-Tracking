package cpt

class TimesheetController {
	
	def list() {
		[list: Timesheet.list(params), total: Timesheet.count()]
	}
	
	def show() {
		def data = Timesheet.get(params.id)
		if (!data) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'timesheet.label'), params.id])
			redirect(action: "list")
			return
		}
		[data: data, template: data.template]
	}
	
	def save() {
		def instance = new Timesheet(params)
		try {
			def dateFormat = new java.text.SimpleDateFormat('M/d/yyyy')
			dateFormat.setLenient(false)
			instance.date = dateFormat.parse(params.dateString)
		}
		catch(java.text.ParseException e) {
			instance.errors.rejectValue('date', 'Invalid date')
		}
		params.cell.keySet().each { key ->
			def activityId = key.split('-')[0]
			def locationId = key.split('-')[1]
			def toolId = key.split('-')[2]
			if(toolId.equals('null')) toolId = null
			int minutes = 0
			try {
				if (params.cell[key].equals('')) minutes = 0
				else minutes = Integer.parseInt(params.cell[key])
			}
			catch(NumberFormatException e) {
				instance.errors.reject("Invalid value")
				log.error("number format")
			}
			if(minutes > 0) {
				instance.addToRecords(new WorkRecord(project: instance.project, worker: instance.worker, date: instance.date, activity: Activity.get(activityId), location: Location.get(locationId), tool: Tool.get(toolId), minutes: minutes))
			}
		}
		if (!instance.save(flush: true)) {
			log.error("failed to complete timesheet")
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'timesheetTemplate.label'), instance.id])
		redirect(controller: "timesheet", action: "show", id: instance.id)
	}
}
