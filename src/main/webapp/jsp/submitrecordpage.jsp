<%--
  Created by IntelliJ IDEA.
  User: TUF
  Date: 2022/11/19
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zn-CH">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>出入登记</title>
    <style>
        body{
            background-color: #ecf0f6;
        }
        .div_head h2{
            color: black;
            margin: 0px;
            height:45px;
            padding-top: 20px;
            padding-left: 25px;
        }
        .center-div{
            width: 80%;
            height: 70%;
            border: 1px;
            margin-left: 10%;
            margin-top: 5%;
            border-radius: 5px;
            background: rgba(0,0,0,0);
        }
        #inout{
            width: 10%;
            height: 30px;
            font-size: 25px;
            margin-left: 30%;
            position: absolute;
            margin-top: 400px;
        }
        .submit{
            font-size: 20px;
            width: 100px;
            background-color: #2aabd2;
            position: absolute;
            margin-top: 400px;
            border: 0px;
            border-radius: 4px;
            margin-left: 41%;
            padding: 2px;
            color: white;
        }
        .ewm{
            width: 25%;
            height: 40%;
            position: absolute;
        }
    </style>
</head>
<body style="background-color: #ecf0f6">
<div class="div_head">
    <h2>出入登记</h2>
    <hr style="background: #4b8dbb; height: 5px;">
</div>

<div class="center-div">
    <div class="img-div">
        <img class="ewm" style="margin-left: 11%" src="../images/qiandao.jpg" alt="离开登记二维码">
        <img class="ewm" style="margin-left: 42%" src="../images/qiandao.jpg" alt="进入登记二维码">
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/addInoutRecord.do">
            <input list="inout_type" name="choice" id="inout">
            <datalist id="inout_type">
                <option value="进入" selected>进入</option>
                <option value="离开">离开</option>
            </datalist>
        <button class="submit" id="btn" type="submit" style="cursor: pointer">提 交</button>
        </form>
    </div>
</div>
<script src="../js/jquery.js"></script>
</body>
</html>

