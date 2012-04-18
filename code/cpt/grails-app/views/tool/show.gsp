<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY show.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value='tool' var='className' />
    <g:set value="${message(code: className+'.label')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.show.label' />
    </title>
  </head>
  <body>
    <div class='subnav'>
      <ul>
        <li>
          <g:link action='list' class='jq-button' controller='activity'>
            <g:message code='activity.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='list' class='jq-button' controller='location'>
            <g:message code='location.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='list' class='jq-button jq-active-button' controller='tool'>
            <g:message code='tool.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='create' class='jq-button'>
            <g:message args='[entityName]' code='default.new.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        ${entityName}: ${fieldValue(bean: instanceR, field: "name")}
      </h1>
      <cpt:errors bean='${instanceW}'></cpt:errors>
      <g:form action='show' class="${instanceW?.errors?.hasErrors() ? 'write' : 'read'} ui-widget ui-widget-content ui-corner-all" id='${instanceW?.id}'>
        <g:hiddenField name='id' value='${instanceW?.id}' />
        <g:hiddenField name='version' value='${instanceW?.version}' />
        <fieldset class='table'>
          <div class="${hasErrors(bean: instanceW, field: 'name', 'error')} row required">
            <div class='cell'>
              <label for='name'>
                <g:message code='${className}.name.label' default='Name' />
              </label>
            </div>
            <div class='cell w'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell r'>
              <div>
                <g:fieldValue bean='${instanceR}' field='name' />
              </div>
            </div>
            <div class='cell w'>
              <g:textField name='name' required='' value='${instanceW?.name}' />
            </div>
          </div>
        </fieldset>
        <div class='buttons'>
          <cpt:rwButton />
          <g:submitButton class='jq-button w' name='update' value="${message(code: 'default.button.update.label', default: 'Update')}" />
          <cpt:deleteButton />
        </div>
      </g:form>
    </div>
  </body>
</html>