<%-- 
    Document   : createType
    Created on : Aug 25, 2025, 7:25:35 PM
    Author     : 84904
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background: #f6f9fc;
            margin: 0;
            padding: 0;
        }

        form {
            border: 1px solid #ccc;
            border-radius: 10px;
            max-width: 500px;
            margin: 40px auto;
            background: #fff;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
        }

        .container {
            padding: 25px 30px;
        }

        h1 {
            text-align: center;
            margin-bottom: 15px;
            color: #333;
        }

        p {
            text-align: center;
            margin-bottom: 20px;
            color: #555;
        }

        input[type=text],
        input[type=password],
        input[type=number],
        input[type=date] {
            width: 100%;
            padding: 12px 15px;
            margin: 8px 0 20px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 6px;
            background: #f9f9f9;
            transition: all 0.3s;
        }

        input:focus {
            background-color: #fff;
            border-color: #04AA6D;
            outline: none;
            box-shadow: 0 0 4px rgba(4,170,109,0.3);
        }

        label {
            font-weight: bold;
            color: #333;
            display: block;
            margin-bottom: 6px;
        }

        hr {
            border: 1px solid #eee;
            margin-bottom: 25px;
        }

        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            width: 48%;
            opacity: 0.9;
            font-size: 16px;
            transition: 0.3s;
        }

        button:hover {
            opacity: 1;
            transform: scale(1.03);
        }

        .cancelbtn {
            background-color: #f44336;
        }

        .clearfix {
            display: flex;
            justify-content: space-between;
        }

        .terms {
            font-size: 14px;
            text-align: center;
            margin-top: 10px;
            color: #555;
        }

        .terms a {
            color: dodgerblue;
            text-decoration: none;
        }
        .cancelbtn {
            width: auto;        
            flex: 0 0 auto;    
            padding: 14px 24px; 
        }
    </style>
    <body>
        <jsp:include page="header.jsp"/>
        <form action="MainController" style="border:1px solid #ccc">
            <div class="container">
                <h1>Create Type</h1>
                <p>Please fill in this form to create new type.</p>
                <hr>
                <div>
                    <label for="typeId"><b>Type ID</b></label>
                    <input type="number" placeholder="Enter Type ID" name="typeId" required>
                    <p style="color: red">${requestScope.TYPE_ERROR.typeIdError}</p>
                </div>

                <div>
                    <label for="typeName"><b>Type Name</b></label>
                    <input type="text" placeholder="Enter type name" name="typeName" required>
                </div>

                <div class="clearfix">
                    <a href="searchTypeController">
                        <button type="button" class="cancelbtn">Cancel</button>
                    </a>
                    <button type="submit" name="action" value="createType" class="signupbtn">Confirm</button>
                </div>
            </div>
        </form>

    </body>
</html>
