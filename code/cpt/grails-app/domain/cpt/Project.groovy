package cpt

class Project {
	String name
	
	static hasMany = [templates: TimesheetTemplate]

	static constraints = {
	}
}
