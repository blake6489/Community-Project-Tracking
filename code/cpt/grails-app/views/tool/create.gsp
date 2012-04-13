<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY create.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'tool.label', default: 'Tool')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.create.label' />
    </title>
  </head>
  <body>
    <div class='content scaffold-create' id='create-tool' role='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        <g:message args='[entityName]' code='default.create.label' />
      </h1>
      <cpt:errors bean='${toolInstance}'></cpt:errors>
      <g:form action='save'>
        <fieldset class='form'>
          <g:render template='form' />
        </fieldset>
        <cpt:fieldsetCreate />
      </g:form>
    </div>
  </body>
</html>