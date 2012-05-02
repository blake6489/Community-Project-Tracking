package cpt

class ReportController {

	def home() {
		if(request.get) {
			return
		}
		else if(request.post) {
			
			try {
				def dateFormat = new java.text.SimpleDateFormat('M/d/yyyy')
				dateFormat.setLenient(false)
				params.start = dateFormat.parse(params.start1)
				params.end = dateFormat.parse(params.end1)
			}
			catch(java.text.ParseException e) {
				instance.errors.rejectValue('date', 'Invalid date')
			}
			[model: params]
		}
	}
}
