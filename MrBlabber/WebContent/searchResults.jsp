<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="uk.ac.dundee.computing.yek.model.*"%>
<%@ page import="uk.ac.dundee.computing.yek.controller.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<title>Mr Blabber - My Tweets</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/layout.css" rel="stylesheet" media="screen">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">
<link href="css/line.css" rel="stylesheet" media="screen">
</head>
<body>
	<!-- Header  -->
	<%
		String param = String.valueOf(request.getSession().getAttribute(
				"currentUser"));
	%>
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
						<li><a href="./Profile">HOME</a></li>
						<li><a href="./Tweets">NEWS</a></li>
						<li class="active"><a href="./Search">CONNECT</a></li>
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
					<li><a href="./Profile">Profile</a></li>
					<li><a href="./Tweets">News</a></li>
					<li><a href="./MyTweets">My Tweets</a></li>
					<li><a href="#">My Messages</a></li>
					<li class="active"><a class="active" href="./Search">Connect</a></li>
				</ul>
			</div>
			<!--/.well -->
		</div>
		<div class="span8">
			<div class="well span6 offset1">
				<div class="span5">
					<form class="input-append" method="post" action="./Search">
						<input class="input-large" id="appendedInputButtons" type="text" placeholder="Search" name="searchTerm">
						<button class="btn" type="submit">Search</button>
						<div class="span2 pull-right">
							<label class="checkbox controls"> <input type="checkbox" name="byUsername" checked>
								By Username
							</label>
							<label class="checkbox controls"> <input type="checkbox" name="byName">
								By Name
							</label>
						</div>
					</form>
				</div>
			</div>
			<div class="well span6 offset1">
				<ul class="unstyled">
					<li class="clearfix"></li>
					<%
							LinkedList<PersonStore> people;
							if(request.getParameter("byUsername")!=null) people = person.getSearchByUsername(DBconnection.getConnectionInstance(), request.getParameter("searchTerm"));
							else people = person.getSearchByName(DBconnection.getConnectionInstance(), request.getParameter("searchTerm"));
							if (people.size() != 0) {
								System.out.println("POSTS LOADED");
								for (int i = 0; i < people.size(); i++) {
						%>
					<li class="clearfix">
						<form name="follow<%=people.get(i).getPersonID()%>" method="post" action="./Follow">
							<input class="hide" name="myForm" value="follow<%=people.get(i).getPersonID()%>">
							<label class="float-left controls"><strong><%=people.get(i).getFirstName()%></strong></label> 
							<label class="float-left controls"><strong><%=people.get(i).getLastName()%></strong></label>
							<label class="float-left left-margin controls"><small>@<%=people.get(i).getUsername()%></small></label>
							<button class="btn btn-primary btn-medium left-margin pull-right" type="submit"><i class="icon-eye-open"></i><span class="left-margin">Follow</span></button> 
							<label	class="controls span5" name="tweet<%=people.get(i).getPersonID()%>"><%=people.get(i).getBio()%></label>
						</form>
					</li>
					<li class="clearfix"><hr class="line-divider"></li>
					<%
							}
							} else {
								System.out.println("POSTS NOOOOOOOOOOOOOOOOOOONE");
						%>
					<li><label class="controls">No Search Results.</label></li>
					<li class="clearfix"><hr class="line-divider"></li>
					<%
							}
						%>
				</ul>
			</div>
			<div class="span6 offset1">
				<div class="pagination pagination-centered span6">
					<ul>
						<li class="disabled"><a href="#">&laquo;</a></li>
						<li class="active"><a href="#">1</a></li>
						<li class="disabled"><a href="#">&raquo;</a></li>
					</ul>
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