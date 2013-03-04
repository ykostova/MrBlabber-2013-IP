<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="uk.ac.dundee.computing.yek.model.*"%>
<%@ page import="uk.ac.dundee.computing.yek.controller.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<title>Mr Blabber - Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/layout.css" rel="stylesheet" media="screen">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<%
		String param = String.valueOf(request.getSession().getAttribute(
				"currentUser"));
	%>
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
				<div class="btn-group  pull-right">
					<a class="btn btn-info" href="./Profile"> <i
						class="icon-user icon-white"></i>@<%=param%></a> <a
						class="btn btn-info dropdown-toggle" data-toggle="dropdown"
						href="#"><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="./Profile"><i class="icon-pencil"></i> Edit</a></li>
						<li><a href="#"><i class="icon-envelope"></i>
								Message</a></li>
						<li><a href="./MyTweets"><i class="icon-pencil"></i>
								Tweet</a></li>
						<li><a href="./Search"><i class="icon-search"></i> Search</a></li>
						<li class="divider"></li>
						<li><a href="./Logout"><i class="icon-off"></i> Logout</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- end Header -->
	<!-- Content -->
	<div class="container">
		<div class="span3">
			<div class="well sidebar-nav affix span2">
				<ul class="nav nav-list">
					<li class="nav-header">HOT LINKS</li>
					<li class="active"><a href="./Profile">Profile</a></li>
					<li><a href="./Tweets">News</a></li>
					<li><a href="./MyTweets">My Tweets</a></li>
					<li><a href="#">My Messages</a></li>
					<li><a href="./Search">Connect</a></li>
				</ul>
			</div>
			<!--/.well -->
		</div>
		<div class="tabbable span8">
			<!-- Only required for left/right tabs -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="./Account" class="active">Edit Account</a></li>
					<li><a href="./Profile">Edit Profile</a></li>
					<li><a href="./Followers">Followers</a></li>
					<li><a href="./Following">Following</a></li>
				</ul>
				<div class="tab-content">
					<div class="hero-unit">
						<h1>Mr Blabber!</h1>
						<p>Welcome Info</p>
						<p>
							<a href="#" class="btn btn-primary btn-large">Learn more</a> <br />
							<br />
						</p>
					</div>
				
					<div class="tab-pane active span7" id="tab1">
						<form class="form-horizontal well span6" method="post" action="./Account">
							<%
									UserStore thisPerson = user.getUser(
											DBconnection.getConnectionInstance(), param);
								%>
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail:</label>
								<div class="controls">
									<input type="email" id="email" name="email"
										placeholder="E-mail" value="<%=thisPerson.getEmail()%>">
								</div>
							</div>
							<hr class="line-divider">
							<div class="control-group">
								<label class="control-label" for="inputPassword">Old Password:</label>
								<div class="controls">
									<input type="password" id="city" name="password" placeholder="Old Password">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Confirm Old Password:</label>
								<div class="controls">
									<input type="password" id="city" name="con_password" placeholder="Old Password">
								</div>
							</div>
							<hr class="line-divider">
							<div class="control-group">
								<label class="control-label" for="inputPassword">New Password:</label>
								<div class="controls">
									<input type="password" id="city" name="pass" placeholder="New Password">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Confirm New Password:</label>
								<div class="controls">
									<input type="password" id="city" name="con_pass" placeholder="New Password">
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn btn-large btn-primary">Update</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end Content-->
	<!-- JS Files -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>