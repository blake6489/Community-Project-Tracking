<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY list.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'activity.label', default: 'Activity')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.list.label' />
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
          <g:link action='create' class='create'>
            <g:message args='[entityName]' code='default.new.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='content scaffold-list' role='main'>
      <h1>
        <g:message args='[entityName]' code='default.list.label' />
      </h1>
      <table>
        <thead>
          <tr>
            <g:sortableColumn property='name' title="${message(code: 'activity.name.label', default: 'Name')}" />
          </tr>
        </thead>
        <tbody>
          <g:each in='${activityInstanceList}' status='i' var='activityInstance'>
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
              <td>
                <g:link action='show' id='${activityInstance.id}'>${fieldValue(bean: activityInstance, field: "name")}</g:link>
              </td>
            </tr>
          </g:each>
        </tbody>
      </table>
      <div class='pagination'>
        <g:paginate total='${activityInstanceTotal}' />
      </div>
    </div>
  </body>
</html>