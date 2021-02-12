<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <i class="fa fa-user-circle" aria-hidden="true"></i>&nbsp;
                            <span id="currentlyLoggedInUserFullName">
                           
                                ${user.getUserName()}
                          
                            </span></span></a>
                        
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <section class="container login-form-section">
        <div class="row">
            <div class="col-xs-3 col-sm-4 col-md-4"></div>
            <div class="col-xs-6 col-sm-4 col-md-4">
                <br>
                <div class="col-md-2"></div>
                <br><br><br>
                <div class="col-md-2"></div>
            </div>
            <div class="col-xs-3 col-sm-4 col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <h1 class="text-center">Change Password</h1>
                <br>
                <form method="POST">
                    <div class="formgroup-">
                        <label class="control-label" for="login-password">Current Password:</label>
                        <input class="form-control" name="currentPassword" id="login-password" type="password" value="" placeholder="Password">
                    
                    </div>
                    <div class="form-group">
                       
                        <label class="control-label" for="login-password">New Password:</label>
                        <input class="form-control" name="newPassword" id="login-password" type="password" value="" placeholder="Password">
                    
                    </div>
                    
                     <div class="form-group">
                        <label class="control-label" for="login-password">Confirm Password:</label>
                        <input class="form-control" name="confirmPassword" id="login-password" type="password" value="" placeholder="Password">
                    </div>
                
                    
                    <div class="form-group">
                        <input class="btn btn-primary btn-block" type="submit" value="Update" formaction="Management?action=updatepass">  
                    </div>
                     
                        ${passMessage}
                    
                </form>
            </div>
            <div class="col-md-4"></div>
        </div>
    </section>

</body>
</html>