<%@ page import="cpt.TimesheetTemplate" %>



<div class="fieldcontain ${hasErrors(bean: timesheetTemplateInstance, field: 'activities', 'error')} ">
	<label for="activities">
		<g:message code="timesheetTemplate.activities.label" default="Activities" />
		
	</label>
	<g:select name="activities" from="${cpt.Activity.list()}" multiple="multiple" optionKey="id" size="5" value="${timesheetTemplateInstance?.activities*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: timesheetTemplateInstance, field: 'locations', 'error')} ">
	<label for="locations">
		<g:message code="timesheetTemplate.locations.label" default="Locations" />
		
	</label>
	<g:select name="locations" from="${cpt.Location.list()}" multiple="multiple" optionKey="id" size="5" value="${timesheetTemplateInstance?.locations*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: timesheetTemplateInstance, field: 'project', 'error')} required">
	<label for="project">
		<g:message code="timesheetTemplate.project.label" default="Project" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="project" name="project.id" from="${cpt.Project.list()}" optionKey="id" required="" value="${timesheetTemplateInstance?.project?.id}" class="many-to-one"/>
</div>

