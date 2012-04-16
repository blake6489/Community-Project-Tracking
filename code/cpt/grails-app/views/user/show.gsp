<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY show.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'user.label', default: 'User')}" var='entityName' />
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
          <g:link class='jq-button' mapping='user_create'>
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
      <div class='ui-widget ui-widget-content ui-corner-all'>
        <ul class='table'>
          <li class='row'>
            <div class='cell'>
              <label>
                <g:message code='user.username.label' default='Username' />
              </label>
            </div>
            <div class='cell r'>
              <div>
                <g:fieldValue bean='${instance}' field='username' />
              </div>
            </div>
          </li>
          <li class='row'>
            <div class='cell'>
              <label>
                <g:message code='user.type.label' default='Type' />
              </label>
            </div>
            <div class='cell r'>
              <div>
                <g:fieldValue bean='${instance}' field='type' />
              </div>
            </div>
          </li>
        </ul>
        <div class='buttons'>
          <button class='jq-button' onclick="location.href='${createLink(action: 'resetPassword', id: instance.id)}'">
            Reset Password
          </button>
        </div>
      </div>
    </div>
  </body>
</html>