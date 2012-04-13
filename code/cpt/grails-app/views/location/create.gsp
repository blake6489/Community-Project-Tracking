<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY create.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'location.label', default: 'Location')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.create.label' />
    </title>
  </head>
  <body>
    <div class='content scaffold-create' id='create-location' role='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        <g:message args='[entityName]' code='default.create.label' />
      </h1>
      <cpt:errors bean='${locationInstance}'></cpt:errors>
      <g:form action='save'>
        <fieldset class='form'>
          <g:render template='form' />
        </fieldset>
        <cpt:fieldsetCreate />
      </g:form>
    </div>
  </body>
</html>