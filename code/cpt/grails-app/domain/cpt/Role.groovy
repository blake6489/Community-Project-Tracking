package cpt

class Role {

	String authority
	String type //printable representation of authority; e.g. a conventional ROLE_ADMIN authority will have type admin

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
