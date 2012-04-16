package cpt

class Activity {
	String name
	String uniqueName

	static constraints = {
		uniqueName maxSize: 250, blank: true, nullable: true//, bindable: false
		name maxSize: 250, blank: false, validator: { val, obj ->
			def other = Activity.findByUniqueName(obj.uniqueName)
			if(other && other.id != obj.id) {
				if(other.name.equals(obj.name)) return 'default.not.unique.message'
				else return ['default.too.similar.message', other.name]
			} 
		}
	}
	
	void setName(String value) {
		uniqueName = value.replaceAll("[^A-Za-z0-9]+", " ").toLowerCase()
		name = value
	}
}
