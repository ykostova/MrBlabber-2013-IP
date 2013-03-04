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
			<div class="well sidebar-nav">
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
			<form class="form-horizontal well span6" method="post" action="./Login">
				<legend>Login Now!</legend>
				<fieldset class="control-group">
					<label class="control-label" for="inputUsername">Username:</label>
					<div class="controls">
						<div class="input-prepend">
							<label class="add-on">@</label>
							<input class="input-medium" type="text" id="Username" name="Username" placeholder="Username" required>
						</div>
					</div>
				</fieldset>
				<div class="control-group">
					<label class="control-label" for="inputPassword" required>Password:</label>
					<div class="controls">
						<input type="password" id="Password" name="Password"
							placeholder="Password">
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn btn-large btn-primary">Login</button>
					</div>
				</div>
				<div class="span4 offset1">
					<span class="text-centered">You don't have a registration!</span><a class="left-margin" href="./Register">Register NOW</a>
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