<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY resetPassword.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'user.label', default: 'User')}" var='entityName' />
    <title>
      Reset password for ${instance.username}
    </title>
  </head>
  <body>
    <h1 class='ui-widget-header ui-corner-all'>
      Reset Password
    </h1>
    <cpt:errors bean='${instance}'></cpt:errors>
    <g:form action='resetPassword' class='ui-widget ui-widget-content ui-corner-all' id='${instance.id}'>
      <g:hiddenField name='id' value='${instance?.id}' />
      <g:hiddenField name='version' value='${instance?.version}' />
      <fieldset class='table'>
        <div class='row'>
          <div class='cell'>
            <g:message code='user.username.label' default='Username' />
          </div>
          <div class='cell'>
            <g:fieldValue bean='${instance}' field='username' />
          </div>
        </div>
        <div class="${hasErrors(bean: instance, field: 'password', 'error')} row required">
          <div class='cell'>
            <label for='password'>
              <g:message code='user.password.label' default='Password' />
              <span class='required-indicator'>*</span>
            </label>
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
              <span class='required-indicator'>*</span>
            </label>
          </div>
          <div class='cell'>
            <input id='password2' name='password2' required='' type='password' />
          </div>
        </div>
      </fieldset>
      <fieldset class='buttons'>
        <input class='jq-button' type='submit' value='Reset Password' />
      </fieldset>
    </g:form>
  </body>
</html>