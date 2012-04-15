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
	
	def rwButton = {
		out << "<input class='jq-button r rwbutton' type='button' value='Edit' />"
		out << "<input class='jq-button w rwbutton' type='button' value='Cancel' />"
	}
	
	def deleteButton = { attrs ->
		out << g.actionSubmit(
				class: "deletebutton jq-button",
				action: attrs.action ?: "delete",
				controller: attrs.controller ?: null,
				value: "${message(code: 'default.button.delete.label', default: 'Delete')}",
				onclick: "return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"
		)
	}
}