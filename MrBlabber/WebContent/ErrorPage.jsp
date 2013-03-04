<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="uk.ac.dundee.computing.yek.model.*" %>
     <%@ page import="uk.ac.dundee.computing.yek.controller.*" %>
     <%@ page import="java.util.*" %>
     
<!DOCTYPE html>
<html>
  <head>
    <title>Mr Blabber - Error</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/layout.css" rel="stylesheet" media="screen">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
  </head>
  <body>
    <!-- Header  -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Mr Blabber</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="./Profile">HOME</a></li>
              <li class="active"><a href="#">Search</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    <!-- end Header -->
    <!-- Content -->
    <div class="container">
      <div class="hero-unit">
          <br/><br/>
          <h1>Mr Blabber Error</h1>
          <br/><br/><br/>
          <p>Sorry about the inconvenience. Our collegues are working very hard to make Mr Blabber available to you as soon as possible. </p>
          <br/><br/>
      </div>
    </div>
    <!-- end Content-->
    <!-- JS Files -->
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>