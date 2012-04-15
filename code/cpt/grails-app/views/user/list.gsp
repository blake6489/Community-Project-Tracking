<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY list.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'user.label', default: 'User')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.list.label' />
    </title>
  </head>
  <body>
    <div class='subnav'>
      <ul>
        <li>
          <g:link action='list' class='jq-button jq-active-button'>
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
        <g:message args='[entityName]' code='default.list.label' />
      </h1>
      <table class='list ui-widget ui-widget-content ui-corner-all'>
        <thead>
          <tr>
            <g:sortableColumn property='username' title="${message(code: 'user.username.label', default: 'User')}" />
            <g:sortableColumn property='type' title="${message(code: 'user.type.label', default: 'Type')}" />
          </tr>
        </thead>
        <tbody>
          <g:each in='${list}' status='i' var='instance'>
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
              <td>
                <g:link action='show' id='${instance.id}' params='[title:"${instance.username}"]'>${fieldValue(bean: instance, field: "username")}</g:link>
              </td>
              <td>
                ${instance.type}
              </td>
            </tr>
          </g:each>
        </tbody>
      </table>
      <div class='pagination'>
        <g:paginate total='${total}' />
      </div>
    </div>
  </body>
</html>