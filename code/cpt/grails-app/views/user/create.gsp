<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY create.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value='user' var='className' />
    <g:set value="${message(code: className+'.label')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.create.label' />
    </title>
  </head>
  <body>
    <div class='subnav'>
      <ul>
        <li>
          <g:link action='list' class='jq-button' controller='worker'>
            <g:message code='worker.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='list' class='jq-button' controller='user'>
            <g:message code='user.labels' />
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
        <g:message args='[entityName]' code='default.create.label' />
      </h1>
      <cpt:errors bean='${instance}'></cpt:errors>
      <g:form action='create' class='ui-widget ui-widget-content ui-corner-all'>
        <fieldset class='table'>
          <div class="${hasErrors(bean: instance, field: 'username', 'error')} row required">
            <div class='cell'>
              <label for='username'>
                <g:message code='user.username.label' default='Username' />
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:textField name='username' required='' value='${instance?.username}' />
            </div>
          </div>
          <div class="${hasErrors(bean: instance, field: 'password', 'error')} row required">
            <div class='cell'>
              <label for='password'>
                <g:message code='user.password.label' default='Password' />
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:passwordField name='password' required='' />
            </div>
          </div>
          <div class='row required'>
            <div class='cell'>
              <label for='password2'>
                Retype
                <g:message code='user.password.label' default='Password' />
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <input id='password2' name='password2' required='' type='password' />
            </div>
          </div>
          <div class="${hasErrors(bean: instance, field: 'type', 'error')} row">
            <div class='cell'>
              <label for='type'>
                <g:message code='user.type.label' default='Type' />
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:select from='${instance.constraints.type.inList}' name='type' value='${instance?.type}' valueMessagePrefix='user.type' />
            </div>
          </div>
        </fieldset>
        <cpt:fieldsetCreate />
      </g:form>
    </div>
  </body>
</html>