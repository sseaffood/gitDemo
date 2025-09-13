<%-- 
    Document   : user
    Created on : Aug 21, 2025, 7:39:42 AM
    Author     : 84904
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER PAGE</title>
    </head>
    <jsp:include page="header.jsp"/>
    <style>
        body, html {
            height: 100%;
            margin: 0;
        }

        .bgimg {
            background-image: url('imgs/br.png');
            height: 100%;
            background-position: center;
            background-size: cover;
            position: relative;
            color: white;
            font-family: "Courier New", Courier, monospace;
            font-size: 25px;
        }

        .topleft {
            position: absolute;
            top: 0;
            left: 16px;
        }

        .bottomleft {
            position: absolute;
            bottom: 0;
            left: 16px;
        }

        .middle {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }

        hr {
            margin: auto;
            width: 40%;
        }
    </style>
    <body>

        <div class="bgimg">
            <div class="middle">
                <h1>Greetings, ${sessionScope.DN.humanName}</h1>
                <hr>
                <p>Welcome to System Human. How was your day?</p>
            </div>
            <div class="bottomleft">
                <p>Source code: Web3School</p>
            </div>
        </div>

    </body>
</html>
