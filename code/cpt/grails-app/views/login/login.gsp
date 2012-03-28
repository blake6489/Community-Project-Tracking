<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY login.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <meta content='application' name='layout' />
    <title>Login</title>
    <g:javascript library='jquery' />
    <r:layoutResources />
  </head>
  <body>
    Please Login
    <form action='${postUrl}' id='loginForm' method='POST' name='loginForm'>
      <input name='ajax' type='hidden' value='true' />
      <p>
        <label for='username'>Username:</label>
        <input autofocus='true' id='username' name='j_username' type='text' />
      </p>
      <p>
        <label for='password'>Password:</label>
        <input id='password' name='j_password' type='password' />
      </p>
      <p>
        <label for='rememberMe'>Remember me:</label>
        <input id='rememberMe' name='${rememberMeParameter}' type='checkbox' />
      </p>
      <p>
        <input onclick='ajaxLogin();return false' type='submit' value='Login' />
      </p>
    </form>
    <%-- allow ajax submit --%>
    <script type='text/javascript'>
      //<![CDATA[
        function ajaxLogin() {
        	var form = $('#loginForm')
        	$.post(form.attr('action'), form.serialize(), function(data, textStatus, jqXHR){
        		if (data.error) alert(data.error + '\nTODO: Get rid of this popup.')
        		else if (data.success) $(document).ajaxStop(function() { location.reload(true); });
        	})
        }
      //]]>
    </script>
    <r:layoutResources />
  </body>
</html>