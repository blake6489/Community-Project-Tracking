<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY list.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'tool.label')}" var='entityName' />
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
          <g:link action='create' class='jq-button'>
            <g:message args='[entityName]' code='default.new.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='main'>
      <div class='content scaffold-list' role='main'>
        <h1 class='ui-widget-header ui-corner-all'>
          <g:message args='[entityName]' code='default.list.label' />
        </h1>
        <table class='list ui-widget ui-widget-content ui-corner-all'>
          <thead>
            <tr>
              <g:sortableColumn property='name' title="${message(code: 'tool.name.label', default: 'Name')}" />
            </tr>
          </thead>
          <tbody>
            <g:each in='${toolInstanceList}' status='i' var='toolInstance'>
              <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
                  <g:link action='show' id='${toolInstance.id}'>${fieldValue(bean: toolInstance, field: "name")}</g:link>
                </td>
              </tr>
            </g:each>
          </tbody>
        </table>
        <div class='pagination'>
          <g:paginate total='${toolInstanceTotal}' />
        </div>
      </div>
    </div>
  </body>
</html>