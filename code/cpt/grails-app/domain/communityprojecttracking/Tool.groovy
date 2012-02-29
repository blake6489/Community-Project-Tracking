package communityprojecttracking

class Tool {
	String name

	static constraints = {
		name maxSize: 250, blank: false
	}
}
