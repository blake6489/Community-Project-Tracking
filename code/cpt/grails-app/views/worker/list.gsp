<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY list.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value='worker' var='className' />
    <g:set value="${message(code: className+'.label')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.list.label' />
    </title>
  </head>
  <body>
    <div class='subnav'>
      <ul>
        <li>
          <g:link action='list' class='jq-button jq-active-button' controller='worker'>
            <g:message code='worker.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='list' class='jq-button' controller='user'>
            <g:message code='user.labels' />
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
      <table class='list ui-widget ui-widget-content ui-corner-all'>
        <thead>
          <tr>
            <g:sortableColumn property='name' title="${message(code: 'worker.name.label', default: 'Name')}" />
          </tr>
        </thead>
        <tbody>
          <g:each in='${list}' status='i' var='instance'>
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
              <td>
                <g:link action='show' id='${instance.id}' params='[title:"${instance.name}"]'>${fieldValue(bean: instance, field: "name")}</g:link>
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