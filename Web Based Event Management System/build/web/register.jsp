<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="static/fonts/LatoLatin/latolatinfonts.css">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/main.css">
    <link rel="icon" type="image/ico" href="static/img/system/logo.ico">
    <script src="static/js/jquery-3.2.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
</head>

<body style="padding-top:0;">
    <section class="container login-form-section">
        <div class="row">
            <div class="col-xs-3 col-sm-4 col-md-4"></div>
            <div class="col-xs-6 col-sm-4 col-md-4">
                <br>
            <div class="col-md-2"></div>
                <div class="col-md-8">
                    <img class="img-responsive login-logo" src="static/img/system/logo1.png" alt="">
                </div>
                <div class="col-md-2"></div>
            </div>
            <div class="col-xs-3 col-sm-4 col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <h1 class="text-center">User Registration</h1>
                <form method="POST" action="register">
                    <div class="formgroup-">
                        
                        <input class="form-control" name="firstName" type="text" value="" placeholder="Firstname" autocomplete="off">
                        
                        <input class="form-control" name="lastName" type="text" value="" placeholder="Lastname" autocomplete="off">
                        
                        <input class="form-control" name="email" type="text" value="" placeholder="Email" autocomplete="off">
                        
                        <input class="form-control" name="userName" type="text" value="" placeholder="Username" autocomplete="off">
                        
                        <input class="form-control" name="password" type="password" value="" placeholder="Password">
                        
                        <select name="userType" class="form-control">
                            <option>Managing Staff</option>
                            <option>Sales representatives</option>
                            <option>Customers</option> 
                        </select>
                    </div>
                    <div class="gender">
                        
                        <label  for="login-username">Gender: </label>
                        <input class="male-gender" name="gender" type="radio" value="Male">Male</input>
                        <input class="female-gender" name="gender" type="radio" value="Female">Female</input>
                    </div>
                     
                    <div class="form-group">
                        ${message}
                        <input class="btn btn-primary btn-block" type="submit" value="Sign Up">
                    </div>
                </form>
                
            </div>
            <div class="col-md-4"></div>
        </div>
    </section>
</body>
</html>