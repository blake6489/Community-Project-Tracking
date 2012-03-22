<g:hasErrors bean="${bean}">
<ul class="errors" role="alert">
<g:eachError bean="${bean}" var="error">
<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
</g:eachError>
</ul>
</g:hasErrors>