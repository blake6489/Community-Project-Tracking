<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY show.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'location.label', default: 'Location')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.show.label' />
    </title>
  </head>
  <body>
    <div class='nav' role='navigation'>
      <ul>
        <li>
          <a class='home' href="${createLink(uri: '/')}">
            <g:message code='default.home.label' />
          </a>
        </li>
        <li>
          <g:link action='list' class='list'>
            <g:message args='[entityName]' code='default.list.label' />
          </g:link>
        </li>
        <li>
          <g:link action='create' class='create'>
            <g:message args='[entityName]' code='default.new.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='content scaffold-show' id='show-location' role='main'>
      <h1>
        <g:message args='[entityName]' code='default.show.label' />
      </h1>
      <ol class='property-list location'>
        <g:if test='${locationInstance?.name}'>
          <li class='fieldcontain'>
            <span class='property-label' id='name-label'>
              <g:message code='location.name.label' default='Name' />
            </span>
            <span aria-labelledby='name-label' class='property-value'>
              <g:fieldValue bean='${locationInstance}' field='name' />
            </span>
          </li>
        </g:if>
      </ol>
      <g:form>
        <fieldset class='buttons'>
          <g:hiddenField name='id' value='${locationInstance?.id}' />
          <g:link action='edit' class='edit' id='${locationInstance?.id}'>
            <g:message code='default.button.edit.label' default='Edit' />
          </g:link>
          <g:actionSubmit action='delete' class='delete' onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
        </fieldset>
      </g:form>
    </div>
  </body>
</html>