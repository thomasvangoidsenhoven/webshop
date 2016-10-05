<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="nl">
    <head> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

		<!-- Website CSS style -->
		<link rel="stylesheet" type="text/css" href="css/stylesheet.css">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

		<title>Registratie Pagina | project ervaringsdeskundige</title>
	</head>
	<body>
		<div class="container">
			<div class="row form-main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Project ErvaringsDeskundigen</h1>
	               		<hr />
	               	</div>
	            </div> 
				<div class="form-login form-center">
					<form class="form-horizontal" id="form1" method="post" action="FrontController?action=doeregistreer">
					<ul>
						<%
							if(request.getAttribute("errormessage") != null)
							{
								ArrayList<String> errormessage = (ArrayList<String>) request.getAttribute("errormessage");
								
								for(String i : errormessage)
								{
						%>
								<%= "<li>" + i  + "</li>" %>	
						<%
								}
							}
						%>
						</ul>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Naam:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  placeholder="Vul hier uw naam in"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Emailadres:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email"  placeholder="Vul hier uw email in"/>
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Paswoord</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Vul hier uw paswoord in"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Bevestig Paswoord</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Vul hier uw paswoord opnieuw in"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="number" class="cols-sm-2 control-label">Telefoonnummer</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-phone fa-lg" aria-hidden="true"></i></span>
									<input type="tel" class="form-control" name="number" id="number" maxlength="10"  placeholder="Vul hier uw nummer in"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="code" class="cols-sm-2 control-label">Registratie Code</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-link fa-lg" aria-hidden="true"></i></span>
									<input type="text" class="form-control" maxlength="10" name="code" id="code"  placeholder="XXXXXXXXXX"/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button type="submit" form="form1" value="Submit" class="btn btn-primary btn-lg btn-block login-button">Registreer</button>
						</div>
						<div class="form-aftertext">
				            <a href="FrontController?action=login">Login</a>
				         </div>
					</form>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
	</body>
</html>