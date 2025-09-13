<%-- 
    Document   : createHuman
    Created on : Aug 25, 2025, 3:50:51 PM
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
                <h1>Sign Up</h1>
                <p>Please fill in this form to create an account.</p>
                <p style="color: red">${requestScope.SUCCESS_CREATE}</p>
                <hr>
                <div>
                    <label for="humanId"><b>Human ID</b></label>
                    <input type="number" placeholder="Enter Human ID" name="humanId" required>
                    <p style="color: red">${requestScope.HUMAN_ERROR.humanIDError}</p>
                </div>

                <div>
                    <label for="uname"><b>User Name</b></label>
                    <input type="text" placeholder="Enter User name" name="uname" required>
                    <p style="color: red">${requestScope.HUMAN_ERROR.uHumanError}</p>
                </div>

                <div>
                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>
                    <p style="color: red">${requestScope.HUMAN_ERROR.passwordError}</p>
                </div>

                <div>
                    <label for="confirm"><b>Repeat Password</b></label>
                    <input type="password" placeholder="Repeat Password" name="confirm" required>
                    <p style="color: red">${requestScope.HUMAN_ERROR.confirmError}</p>
                </div>

                <div>
                    <label for="humanName"><b>Full name</b></label>
                    <input type="text" placeholder="Enter full name" name="humanName" required>
                    <p style="color: red">${requestScope.HUMAN_ERROR.humanNameError}</p>
                </div>
                <div class="mb-3">
                    <label for="humanName"><b>Gender</b></label>
                    <input type="number" class="form-control" name="gender" placeholder="Enter gender [0-Female | 1-Male]" required>
                    <p style="color: red">${requestScope.HUMAN_ERROR.genderError}</p>
                </div>
                <div>
                    <label for="dob"><b>BirthDay</b></label>
                    <input type="date" placeholder="Enter Date of Birth" name="dob" required>
                </div>

                <div>
                    <label for="typeId"><b>Type ID</b></label>
                    <input type="number" placeholder="Enter Type ID" name="typeId" required>
                </div>

                <div>
                    <label for="role"><b>Role</b></label>
                    <select name="role">
                </div>
                <option value="mem">Member</option>
                <option value="admin">Admin</option>
                </select>

                <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

                <div class="clearfix">
                    <a href="searchHumanController">
                        <button type="button" class="cancelbtn">Cancel</button>
                    </a>
                    <button type="submit" name="action" value="createHuman" class="signupbtn">Sign Up</button>
                </div>
            </div>
        </form>

    </body>
</html>
