package cpt

class CptTagLib {
	
	static namespace = 'cpt'
	
	def errors = { attrs ->
		out << render(template: '/tags/errors', model: [bean: attrs.bean])
	}
	
	def fieldsetCreate = {
		out << "<fieldset class='buttons'><input type='submit' class='save jq-button' value='${message(code: 'default.button.create.label', default: 'Create')}' /></fieldset>"
	}
	
	def fieldsetEdit = {
		out << render(template: '/tags/fieldsetEdit')
	}
	
	def rwButton = {
		out << "<input class='jq-button r rwbutton' type='button' value='Edit' />"
		out << "<input class='jq-button w rwbutton' type='button' value='Cancel' />"
	}
	
	def deleteButton = { attrs ->
		out << g.actionSubmit(
				class: "deletebutton jq-button",
				action: attrs.action ?: "delete",
				controller: attrs.controller ?: null,
				value: "${message(code: 'default.button.delete.label', default: 'Delete')}",
				onclick: "return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"
		)
	}
	
	def timesheetR = { attrs ->
		out << render(template: '/tags/timesheetR', model: [model: attrs.model])
	}
	
	def timesheetW = { attrs ->
		//create a data structure in which [activity][tool][location] returns a corresponding work records
		def data = [:]
		attrs.data.records.each {record ->
			def activity = record.activity.id
			def location = record.location.id
			def tool = record.tool?.id ?: 'null'
			if (!data[activity]) data[activity] = [:]
			if (!data[activity][tool]) data[activity][tool] = [:]
			data[activity][tool][location] = record
		}
		out << render(template: '/tags/timesheetW', model: [template: attrs.template, data: data])
	}
	
	def report = { attrs ->
		def data = [:]
		//log.errors(attrs.activities)
		attrs.activities.each { activityId ->
			data[activityId] = [:]
			attrs.locations.each { locationId ->
					//log.error("a ${activityId}")
					//log.error("l ${locationId}")
				def query = WorkRecord.where {
					activity == Activity.get(activityId)
					location == Location.get(locationId)
					date >= attrs.start && date <= attrs.end
				}
				if(attrs.project) {
					query = query.where {
						project.id == project
					}
				}
				if(attrs.timesheet) {
					query = query.where {
						timesheet.template.id == timesheet
					}
				}
				if(attrs.workerId) {
					log.error(attrs.workerId)
					query = query.where {
						worker == Worker.get(attrs.workerId)
					}
				}
				def records = query.findAll()
				def minutes = 0
				records.each { record ->
					minutes += record.minutes
				}
				data[activityId][locationId] = minutes
			}
		}
		def locations = attrs.locations.clone()
		def activities = attrs.activities.clone()
		out << render(template: '/tags/report', model: ['activities': activities, 'locations': locations, 'data': data])
	}
}