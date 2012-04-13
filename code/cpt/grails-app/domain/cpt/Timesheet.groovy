package cpt

class Timesheet {
	Project project
	TimesheetTemplate template
	Worker worker
	Date date
	static hasMany = [records: WorkRecord]

	static constraints = {
	}
}
