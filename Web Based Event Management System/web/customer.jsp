<%@page import="java.util.List"%>
<%@page import="com.apu.ejb.dbs.DAOImpl"%>
<%@page import="com.apu.beans.Hall"%>
<%@page import="com.apu.ejb.DAO"%>
<%@page import="com.apu.beans.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer</title>
    <link rel="stylesheet" type="text/css" href="static/fonts/LatoLatin/latolatinfonts.css">
    <link rel="stylesheet" type="text/css" href="static/css/main.css">
    <link rel="icon" type="image/ico" href="static/img/system/logo.ico">
    <link rel="stylesheet" type="text/css" href="static/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/font-awesome.min.css">
    <script src="static/js/jquery-3.2.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/jquery.dataTables.min.js"></script>
    <script src="static/js/dataTables.bootstrap.min.js"></script>
</head>

<body>

    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!--<div class="nav-logo-container">
                    <!-- <a href="/" class="nav-logo-link">
                        <img src="static/img/system/file.png" class="nav-logo-img" alt="">
                    </a>
                </div>-->
                <a class="navbar-brand nav-brand-name">
                    APU Event Management System
                </a>   
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <i class="fa fa-user-circle" aria-hidden="true"></i>&nbsp;
                            <span id="currentlyLoggedInUserFullName">
                           
                            ${user.getUserName()}
                          
                            </span> <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="Management?action=edit"><i class="fa fa-user-circle" aria-hidden="true"></i> Profile Management</a></li>
                           
                            <li><a href="Management?action=account"><i class="fa fa-paypal" aria-hidden="true"></i> Paymnet Management</a></li>
                          
                            <li><a href="logout"><i class="fa fa-sign-out nav-icon" aria-hidden="true"></i>Logout</a></li>
                        
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <section class="container login-form-section">
        <div class="row"></div>
        
        <div class="row">
            <div class="col-md-4"></div>
                <h1 class="text-center">All Halls</h1>
        </div>
    </section>
    <section class="container login-form-section">
        <table style="width:100%;text-align: center;border:solid;">
        <%
            User user=(User)session.getAttribute("user");
            DAO userDAO=new DAOImpl();
            if(user!=null)
            {
            
                List<Hall> listOfHalls=userDAO.getAllHalls();
        %>
                <tr style="border:solid">
                    <td style="width:15%;font-size:20px;border:solid"> Hall ID </td>
                    <td style="width:15%;font-size:20px;border:solid"> Hall Name </td>
                    <td style="width:15%;font-size:20px;border:solid"> Hall Place </td>
                    <td style="width:15%;font-size:20px;border:solid"> Hall Price </td>
                    <td style="width:40%;font-size:20px;border:solid"> Hall Details </td>
                </tr><br>
        <%
                for (int i=0;i<listOfHalls.size();i++)
                {
        %>
                    <tr>
                        <td style="width:15%;border:solid"><%=listOfHalls.get(i).getHallId()%></td>
                        <td style="width:15%;border:solid"><%=listOfHalls.get(i).getHallName()%></td>
                        <td style="width:15%;border:solid"><%=listOfHalls.get(i).getHallPlace()%></td>
                        <td style="width:15%;border:solid"><%=listOfHalls.get(i).getHallPrice()%></td>
                        <td style="width:40%;border:solid; padding-left: 15px; padding-right: 15px;"><%=listOfHalls.get(i).getHallDetails()%></td>
                    </tr>
                    <br>
        <%
                }
            }else
            {
                out.println("Session Expired");
            }
        %>
    </table><br>
    </section>
    <br>
    <section class="container login-form-section">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
            
                <form method="POST">
        
                    <input class="btn btn-primary btn-block" type="submit" value="Book Hall" formaction="Management?action=book">
                    <input class="btn btn-primary btn-block" type="submit" value="My Bookings" formaction="Management?action=mybook">
                    <input class="btn btn-primary btn-block" type="submit" value="Provide Feedback" formaction="Management?action=feedback">
                </form>
            </div>
        </div>            
    </section>                         
                            
     
</body>
</html>
