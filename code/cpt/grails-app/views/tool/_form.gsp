<%@ page import="cpt.Tool" %>



<div class="fieldcontain ${hasErrors(bean: toolInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="tool.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="250" required="" value="${toolInstance?.name}"/>
</div>

