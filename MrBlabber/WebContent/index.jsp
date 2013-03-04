<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="uk.ac.dundee.computing.yek.model.*"%>
<%@ page import="uk.ac.dundee.computing.yek.controller.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<title>Mr Blabber - Index</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/layout.css" rel="stylesheet" media="screen">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<!-- Header  -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Mr Blabber</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="./Profile">HOME</a></li>
						<li><a href="./Tweets">NEWS</a></li>
						<li><a href="./Search">CONNECT</a></li>
					</ul>
					<form class="navbar-form pull-right" method="post" action="./Login">
						<input class="span2" type="text" placeholder="Username" name="Username"> <input
							class="span2" type="password" placeholder="Password" name="Password">
						<button type="submit" class="btn">Sign in</button>
					</form>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- end Header -->
	<!-- Content -->
	<div class="container">
		<!-- SIDE MENU -->
		<div class="span3">
			<div class="well sidebar-nav affix span2">
				<ul class="nav nav-list">
					<li class="nav-header">HOT LINKS</li>
					<li><a href="./Profile">Profile</a></li>
					<li><a href="./Tweets">NEWS</a></li>
					<li><a href="./MyTweets">My Tweets</a></li>
					<li><a href="#">My Messages</a></li>
					<li><a href="./Search">CONNECT</a></li>
				</ul>
			</div>
		</div>
		<!-- END SIDE MENU -->
		<!-- MAIN MODULE -->
		<div class="span8">
			<div class="hero-unit">
				<h1>Mr Blabber!</h1>
				<p>Welcome Info</p>
				<p>
					<a href="#" class="btn btn-primary btn-large">Learn more</a>
				</p>
			</div>
			<form class="form-horizontal well span6" method="post"
				action="./Register">
				<legend>Register Now!</legend>
				<div class="control-group">
					<label class="control-label" for="inputFirstName">First
						Name:</label>
					<div class="controls">
						<input type="text" id="first_name" name="first_name"
							placeholder="First Name">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputLastName">Last Name:</label>
					<div class="controls">
						<input type="text" id="last_name" name="last_name"
							placeholder="Last Name">
					</div>
				</div>
				<fieldset class="control-group">
					<label class="control-label" for="inputUsername">Username:</label>
					<div class="controls">
						<div class="input-prepend">
							<label class="add-on">@</label>
							<input class="input-medium" type="text" id="username" name="username" placeholder="Username" required>
						</div>
					</div>
				</fieldset>
				<div class="control-group">
					<label class="control-label" for="inputEmail">Email:</label>
					<div class="controls">
						<input type="email" id="email" name="email" placeholder="Email" required>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword" required>Password:</label>
					<div class="controls">
						<input type="password" id="password" name="password"
							placeholder="Password">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputRePassword">Confirm
						Password:</label>
					<div class="controls">
						<input type="password" id="confirm_pass" name="confirm_pass"
							placeholder="Re-Password" required>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="Country">Country:</label>
					<div class="controls">
						<select name="country">
							<%
								LinkedList<CountryStore> list = country
										.getAllCountries(DBconnection.getConnectionInstance());
								if (list != null) {
									for (int i = 0; i < list.size(); i++) {
							%>
							<option value="<%=list.get(i).getCountryID()%>">
								<%=list.get(i).getCountryName()%>
							</option>
							<%
								}
								} else
							%>
							<option value="0">United Kingdom</option>
							<%
								;
							%>
						</select>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn btn-large btn-primary">Register</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- end Content-->
	<!-- JS Files -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>