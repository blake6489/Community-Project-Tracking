<g:hasErrors bean="${bean}">
<div class ="ui-widget ui-state-error ui-corner-all" role="alert">
<ul>
<g:eachError bean="${bean}" var="error">
<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
</g:eachError>
</ul>
</div>
</g:hasErrors>