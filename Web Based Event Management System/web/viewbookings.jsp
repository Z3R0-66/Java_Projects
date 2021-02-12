<%@page import="com.apu.ejb.dbs.DAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.apu.beans.BookHall"%>
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
    <title>Customer Feedbacks</title>
    <link rel="stylesheet" type="text/css" href="static/fonts/LatoLatin/latolatinfonts.css">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/main.css">
    <link rel="icon" type="image/ico" href="static/img/system/logo.ico">
    <script src="static/js/jquery-3.2.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
</head>

<body style="padding-top:0;">

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
                        <a href="#" data-toggle="dropdown" role="button" aria-expanded="false">
                            <i class="fa fa-user-circle" aria-hidden="true"></i>
                           
                                ${user.getUserName()}
                          
                            </span></a>
                        
                    </li>
                </ul>
            </div>
        </div>
    </nav>
<section class="container login-form-section">
        <div class="row"></div>
        <br><br><br>
        <div class="row">
            <div class="col-md-4"></div>
                <h1 class="text-center">My Bookings</h1>
        </div>
    </section>
    <section class="container login-form-section">
        <table style="width:100%;text-align: center;">
            <%
                User user=(User)session.getAttribute("user");
                DAO userDAO=new DAOImpl();
                if(user!=null)
                {
                    List<BookHall> listOfMyBookings=userDAO.getMyBookings(user.getUserId());
            %>
                    <tr>
                        <td style="width:20%;font-size:20px;border:solid"> Booking ID </td>
                        <td style="width:20%;font-size:20px;border:solid"> Hall ID </td>
                        <td style="width:20%;font-size:20px;border:solid"> Customer ID </td>
                        <td style="width:40%;font-size:20px;border:solid"> Booking Date </td>
                    </tr><br>
            <%
                    for (int i=0;i<listOfMyBookings.size();i++)
                    {
            %>
                        <tr>
                            <td style="width:20%;border:solid"><%=listOfMyBookings.get(i).getBookingId()%></td>
                            <td style="width:20%;border:solid"><%=listOfMyBookings.get(i).getHallId()%></td>
                            <td style="width:20%;border:solid"><%=listOfMyBookings.get(i).getBookerId()%></td>
                            <td style="width:40%;border:solid;padding-left: 15px; padding-right: 15px;"><%=listOfMyBookings.get(i).getBookingDate()%></td>
                        </tr><br>
            <%
                    }
                }
                else
                {
                    out.println("Session Expired");
                }
            %>
        </table><br>
    </section>

</body>
</html>