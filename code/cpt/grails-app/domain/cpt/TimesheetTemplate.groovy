package cpt

class TimesheetTemplate {
	static hasMany = [activities: Activity, locations: Location]
	Project project

	static constraints = {
	}
}
