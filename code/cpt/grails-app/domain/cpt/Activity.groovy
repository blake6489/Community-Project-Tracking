package cpt

class Activity {
	String name
	
	static constraints = {
		name maxSize: 250, blank: false
	}
}
