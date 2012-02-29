package cpt

class Location {
	String name

	static constraints = {
		name maxSize: 250, blank: false
	}
}
