<%@ page import="cpt.Project" %>



<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="project.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${projectInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'templates', 'error')} ">
	<label for="templates">
		<g:message code="project.templates.label" default="Templates" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${projectInstance?.templates?}" var="t">
    <li><g:link controller="timesheetTemplate" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="timesheetTemplate" action="create" params="['project.id': projectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'timesheetTemplate.label', default: 'TimesheetTemplate')])}</g:link>
</li>
</ul>

</div>

