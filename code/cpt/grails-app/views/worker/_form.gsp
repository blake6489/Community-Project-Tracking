<%@ page import="cpt.Worker" %>



<div class="fieldcontain ${hasErrors(bean: workerInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="worker.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${workerInstance?.name}"/>
</div>

