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
    <div class='subnav'>
      <ul>
        <li>
          <g:link action='list' class='jq-button'>
            <g:message args='[entityName]' code='default.list.label' />
          </g:link>
        </li>
        <li>
          <g:link action='create' class='jq-button jq-active-button'>
            <g:message args='[entityName]' code='default.new.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        <g:message args='[entityName]' code='default.show.label' />
      </h1>
      <cpt:errors bean='${instance}'></cpt:errors>
      <g:form action='show' class="${instance?.errors.hasErrors() ? 'write' : 'read'} ui-widget ui-widget-content ui-corner-all" id='${instance.id}'>
        <g:hiddenField name='id' value='${instance?.id}' />
        <g:hiddenField name='version' value='${instance?.version}' />
        <fieldset class='table'>
          <div class='row'>
            <div class='cell'>
              <label for='name'>
                <g:message code='location.name.label' default='Name' />
                <span class='required-indicator'>*</span>
              </label>
            </div>
            <div class='cell r'>
              <g:fieldValue bean='${instance}' field='name' />
            </div>
            <div class='cell w'>
              <g:textField name='name' required='' value='${instance?.name}' />
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