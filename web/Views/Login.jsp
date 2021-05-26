<%-- 
    Document   : Login
    Created on : May 26, 2021, 6:37:08 PM
    Author     : thangquan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
  
        <title>Login Form</title>

    </head>
    <body>
        <div id="logreg-forms">
            <div><p id="AlertBox">
                    <c:choose>
                        <c:when test="${sessionScope.message==null}">
                        </c:when>
                        <c:when test="${sessionScope.message!=null}">
                            ${sessionScope.message}
                        </c:when>
                    </c:choose>
                </p></div>
            <form class="form-signin" action="LoginControl" method="post">

                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>

                <input name="user"  type="text" id="inputEmail" class="form-control" placeholder="Username" required="" autofocus="">
                <input name="pass"  type="password" id="inputPassword" class="form-control" placeholder="Password" required="">

               <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
 
            </form>

            <br>
        </div>
 
    </body>
</html>