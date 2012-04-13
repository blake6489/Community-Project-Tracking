package cpt

class CptTagLib {
	
	static namespace = 'cpt'
	
	def errors = { attrs ->
		out << render(template: '/tags/errors', model: [bean: attrs.bean])
	}
	
	def fieldsetCreate = {
		out << "<fieldset class='buttons'><input type='submit' class='save jq-button' value='${message(code: 'default.button.create.label', default: 'Create')}' /></fieldset>"
	}
	
	def fieldsetEdit = {
		out << render(template: '/tags/fieldsetEdit')
	}
}