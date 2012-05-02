package cpt

class WorkRecord {
	Project project
	Timesheet timesheet
	Worker worker
	Date date
	long minutes
	Activity activity
	Location location
	Tool tool

	static constraints = {
		tool nullable: true
	}
	
	static mapping = {
		project index: 'Project_Idx'
		timesheet index: 'Timesheet_Idx'
		worker index: 'Worker_Idx'
		date index: 'Date_Idx'
	}
}
