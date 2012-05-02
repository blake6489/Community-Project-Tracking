import cpt.Role
import cpt.User
import cpt.UserRole

import cpt.Location
import cpt.Activity
import cpt.Worker
import cpt.Project
import cpt.TimesheetTemplate
import cpt.Timesheet
import cpt.WorkRecord

class BootStrap {

	def init = { servletContext ->
		//Create users
		if(!User.count()) {
			def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: 'ROLE_ADMIN', type: 'admin').save(flush: true)
			def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: 'ROLE_USER', type: 'user').save(flush: true)
			
			new User(type: 'admin', username: 'admin', enabled: true, password: 'a').createWithUserRole(true)
			new User(type: 'user', username: 'user', enabled: true, password: 'a').createWithUserRole(true)
		}
		new Location(name: '1st-3rd Core Area').save()
		new Location(name: '4th-7th').save()
		new Location(name: 'Lacey to Dunkle').save()
		new Location(name: 'Cushman to Wickersham & Bridge').save()
		new Location(name: 'Griffen to Wendell & Bridge').save()
		new Location(name: 'North Cushman').save()
		
		new Activity(name: 'Trash').save()
		new Activity(name: 'Snow Removal').save()
		new Activity(name: 'Ice Chipping').save()
		new Activity(name: 'Unsanitary Deposits').save()
		new Activity(name: 'Inebriate Activity').save()
		new Activity(name: 'Garage Maintenance').save()
		new Activity(name: 'Special Projects').save()
		new Activity(name: 'Sweeping').save()
		new Activity(name: 'Blowing').save()
		new Activity(name: 'Washing').save()
		
		new Project(name: 'Clean Team').save()
		def template = new TimesheetTemplate(name: 'Activity Report - Summer', project: Project.list()[0])
		Location.list().each { location ->
			template.addToLocations(location)
		}
		Activity.list().each { activity ->
			template.addToActivities(activity)
		}
		template.save()
		
		//random workers
		new Worker(name: 'Kristina H. Chung').save()
		new Worker(name: 'Paige H. Chen').save()
		new Worker(name: 'Sherri E. Melton').save()
		new Worker(name: 'Gretchen I. Hill').save()
		new Worker(name: 'Karen U. Puckett').save()
		new Worker(name: 'Patrick O. Song').save()
		new Worker(name: 'Elsie A. Hamilton').save()
		new Worker(name: 'Hazel E. Bender').save()
		new Worker(name: 'Malcolm A. Wagner').save()
		new Worker(name: 'Dolores C. McLaughlin').save()
		new Worker(name: 'Francis C. McNamara').save()
		new Worker(name: 'Sandy A. Raynor').save()
		new Worker(name: 'Marion O. Moon').save()
		new Worker(name: 'Beth O. Woodard').save()
		new Worker(name: 'Julia E. Desai').save()
		new Worker(name: 'Jerome A. Wallace').save()
		new Worker(name: 'Neal A. Lawrence').save()
		new Worker(name: 'Jean R. Griffin').save()
		new Worker(name: 'Kristine O. Dougherty').save()
		new Worker(name: 'Crystal O. Powers').save()
		new Worker(name: 'Alex A. May').save()
		new Worker(name: 'Eric T. Steele').save()
		new Worker(name: 'Wesley E. Teague').save()
		new Worker(name: 'Franklin I. Vick').save()
		new Worker(name: 'Claire A. Gallagher').save()
		new Worker(name: 'Marian O. Solomon').save()
		new Worker(name: 'Marcia A. Walsh').save()
		new Worker(name: 'Dwight O. Monroe').save()
		new Worker(name: 'Wayne O. Connolly').save()
		new Worker(name: 'Stephanie A. Hawkins').save()
		new Worker(name: 'Neal I. Middleton').save()
		new Worker(name: 'Gretchen O. Goldstein').save()
		new Worker(name: 'Tim A. Watts').save()
		new Worker(name: 'Jerome O. Johnston').save()
		new Worker(name: 'Shelley E. Weeks').save()
		new Worker(name: 'Priscilla I. Wilkerson').save()
		new Worker(name: 'Elsie A. Barton').save()
		new Worker(name: 'Beth A. Walton').save()
		new Worker(name: 'Erica A. Hall').save()
		new Worker(name: 'Douglas O. Ross').save()
		new Worker(name: 'Donald H. Chung').save()
		new Worker(name: 'Katherine E. Bender').save()
		new Worker(name: 'Paul O. Woods').save()
		new Worker(name: 'Patricia A. Mangum').save()
		new Worker(name: 'Lois O. Joseph').save()
		new Worker(name: 'Louis O. Rosenthal').save()
		new Worker(name: 'Christina O. Bowden').save()
		new Worker(name: 'Darlene A. Barton').save()
		new Worker(name: 'Harvey N. Underwood').save()
		new Worker(name: 'William O. Jones').save()
		new Worker(name: 'Frederick A. Baker').save()
		new Worker(name: 'Shirley E. Merritt').save()
		new Worker(name: 'Jason R. Cross').save()
		new Worker(name: 'Judith O. Cooper').save()
		new Worker(name: 'Gretchen O. Holmes').save()
		new Worker(name: 'Don H. Sharpe').save()
		new Worker(name: 'Glenda O. Morgan').save()
		new Worker(name: 'Scott O. Hoyle').save()
		new Worker(name: 'Pat L. Allen').save()
		new Worker(name: 'Michelle I. Rich').save()
		new Worker(name: 'Jessica I. Rich').save()
		new Worker(name: 'Evan R. Grant').save()
		new Worker(name: 'Melinda R. Proctor').save()
		new Worker(name: 'Calvin I. Diaz').save()
		new Worker(name: 'Eugene R. Graham').save()
		new Worker(name: 'Vickie A. Watkins').save()
		new Worker(name: 'Luis I. Hinton').save()
		new Worker(name: 'Allan A. Marsh').save()
		new Worker(name: 'Melanie E. Hewitt').save()
		new Worker(name: 'Marianne R. Branch').save()
		new Worker(name: 'Natalie A. Walton').save()
		new Worker(name: 'Scott O. Golden').save()
		new Worker(name: 'Arlene A. Case').save()
		new Worker(name: 'Kyle A. Watts').save()
		new Worker(name: 'Calvin H. Christensen').save()
		new Worker(name: 'Gary A. Parks').save()
		new Worker(name: 'Samantha A. Hardin').save()
		new Worker(name: 'Sara U. Lucas').save()
		new Worker(name: 'Stacy A. Eason').save()
		new Worker(name: 'Gladys A. Davidson').save()
		new Worker(name: 'Mike H. Whitehead').save()
		new Worker(name: 'Lynne O. Rose').save()
		new Worker(name: 'Faye P. Sparks').save()
		new Worker(name: 'Diana O. Moore').save()
		new Worker(name: 'Leon E. Pearson').save()
		new Worker(name: 'Ethel O. Rodgers').save()
		new Worker(name: 'Steve R. Graves').save()
		new Worker(name: 'Alison C. Scarborough').save()
		new Worker(name: 'Sherri U. Sutton').save()
		new Worker(name: 'Patsy I. Sinclair').save()
		new Worker(name: 'Kelly O. Bowman').save()
		new Worker(name: 'Stacy L. Olsen').save()
		new Worker(name: 'Curtis O. Love').save()
		new Worker(name: 'Dana C. McLean').save()
		new Worker(name: 'Jennifer H. Christian').save()
		new Worker(name: 'Brett A. Lamb').save()
		new Worker(name: 'Brandon A. James').save()
		new Worker(name: 'Keith H. Chandler').save()
		new Worker(name: 'Joann T. Stout').save()
		new Worker(name: 'Ronnie O. Cowan').save()
		
		//submit a timesheet for each worker for 20 years
		def rand = new Random()
		def start = new GregorianCalendar()
		//start.add(Calendar.YEAR, -20)
		start.add(Calendar.DAY_OF_YEAR, -3)
		def now = new GregorianCalendar()
			Worker.list().each { worker ->
			def cal = start.clone()
			while (cal.compareTo(now) < 0) {
				def timesheet = new Timesheet(worker: worker, template: template, project: template.project, date: cal.getTime())
				for(int i = 1; i <= Activity.count(); i++) {
					for(int j = 1; j <= Location.count(); j++) {
						if (rand.nextInt(4) %2 == 1) {
							def record = new WorkRecord(worker: worker, template: template, project: template.project, date: cal.getTime())
							record.location = Location.get(j)
							record.activity = Activity.get(i)
							record.minutes = rand.nextInt(4) + 1
							timesheet.addToRecords(record)
						}
					}
				}
				timesheet.save()
				cal.add(Calendar.DAY_OF_YEAR, 1)
				log.error("${cal.get(Calendar.YEAR)} : ${cal.get(Calendar.DAY_OF_YEAR)}")
				}
			}
		
	}

	def destroy = {
	}
}
