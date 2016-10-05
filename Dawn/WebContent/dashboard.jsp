<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "domain.Account" %>
<!DOCTYPE html>
<html lang="nl">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Dashboard | project ervaringsdeskundigen </title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- custom css -->
    <link href="css/stylesheet.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%
	if(request.getAttribute("session") != null)
	{
		Account accountSession = (Account) request.getAttribute("session");
		request.setAttribute("session", accountSession);
	
%>
					
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="#">Project Ervaringsdeskundigen</a> </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Dashboard</a></li>
                    <li><a href="#FrontController?action=faq">F.A.Q.</a></li>
                    <li><a href="#FrontController?action=workshop">Workshops</a></li>
                    <li><a href="#FrontController?action=event">Evenementen</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Account <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="FrontController?action=DoSignOut">Afmelden</a></li>
                            <li><a href="FrontController?action=usersettings">Gebruiker Instellingen</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </nav>
    <div class="container start">
        <h2>Openstaande vragen</h2>
        <table>
            <tr>
                <th>vraag</th>
                <th>important</th>
                <th>ervaringsdeskundige</th>
                <th>status</th>
            </tr>
        </table>
        <a href="#" class="actionbutton">Vraag Stellen</a>
                    
        <h2>Aankomende workshops</h2>
        <table>
            <tr>
                <th>naam</th>
                <th>beschrijving</th>
                <th>datum</th>
                <th>plaats</th>
                <th>deelname</th>
            </tr>
        </table>
        
        <h2>Aankomende evenmenten</h2>
        <table>
            <tr>
                <th>naam</th>
                <th>beschrijving</th>
                <th>datum</th>
                <th>plaats</th>
                <th>deelname</th>
            </tr>
        </table>
    </div>
    <!-- /.container -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<%
	}
	%>
</body>

</html>