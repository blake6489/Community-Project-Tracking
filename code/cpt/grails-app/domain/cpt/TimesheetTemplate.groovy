package cpt

class TimesheetTemplate {
	String name
	List activities
	List locations
	static hasMany = [activities: Activity, locations: Location]
	static belongsTo = [project:Project]

	static constraints = {
	}
}
