<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY _login.haml --%>
Please Login
<form action='${request.contextPath}/j_spring_security_check' id='loginForm' method='POST' name='loginForm'>
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
    <input id='rememberMe' name='_spring_security_remember_me' type='checkbox' />
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
    		else if (data.success) location.reload()
    	})
    }
  //]]>
</script>