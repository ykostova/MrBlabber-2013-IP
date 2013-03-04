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
					<li><a href="./Profile">Profile</a></li>
					<li><a href="./Tweets">News</a></li>
					<li class="active"><a href="./MyTweets">My Tweets</a></li>
					<li><a href="#">My Messages</a></li>
					<li><a href="./Search">Connect</a></li>
				</ul>
			</div>
			<!--/.well -->
		</div>
		<div class="span8">
			<div class="hero-unit span7">
				<h1>Mr Blabber!</h1>
				<p>Welcome Info</p>
				<p>
					<a href="#" class="btn btn-primary btn-large">Learn more</a> <br />
					<br />
				</p>
			</div>
			<form class="well span6 offset1" name="post-tweets" method="post"
				action="./MyTweets">
				<label class="control-label float-left right-margin"
					for="inputTweet"><strong>@<%=param%></strong></label> <br />
				<textarea rows="3" class="left-margin span5" name="inputTweet"
					placeholder="What's up?" maxlength="140"></textarea>
				<button type="submit"
					class="btn btn-medium btn-primary left-margin pull-right">TWEET</button>
			</form>
			<div class="well span6 offset1">
				<ul class="unstyled">
					<li class="clearfix"><p class="text-center"><strong>Your Tweets</strong></p><hr class="line-divider"/></li>
					<%
							LinkedList<PostStore> posts = post.getMyPosts(
									DBconnection.getConnectionInstance(), param);
							if (posts.size() != 0) {
								System.out.println("POSTS LOADED");
								for (int i = 0; i < posts.size(); i++) {
									String date = String.valueOf(new Timestamp((posts.get(i)).getPostDate()));
									   date = date.substring(0,date.lastIndexOf("."));
						%>
					<li class="clearfix">
							<label class="float-left controls"><strong><%=posts.get(i).getName() %></strong></label> 
							<label class="float-left left-margin controls"><small>@<%=posts.get(i).getUsername() %></small></label>
							<label class="left-margin pull-right"><%=date %></label>
							<label class="controls span5"
								name="tweet<%=posts.get(i).getPostID()%>"><%=posts.get(i).getPostText()%></label>
						<div class="pull-right tweet-controlls">
							<a class="controls" href="#"><i class="icon-share-alt"></i>
								Reply</a> <a class="controls" href="#"><i class="icon-retweet"></i>
								Retweet</a>
						</div>

					</li>
					<li class="clearfix"><hr class="line-divider"></li>
					<%
							}
							} else {
								System.out.println("POSTS NOOOOOOOOOOOOOOOOOOONE");
						%>
					<li><label class="controls"> You haven't tweeted yet.</label></li>
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