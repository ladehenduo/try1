<%--
  Created by IntelliJ IDEA.
  User: TUF
  Date: 2022/11/19
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 重置文件 -->
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../css/style.css">
    <title>打卡</title>
</head>
<body style="background-color: whitesmoke">
<div class="reg_div">
    <p>核酸打卡</p>
    <ul class="reg_ul">
        <li>
            <span>User：</span>
            <input type="text" name="" value="" placeholder="4-8位用户名" class="reg_user">
            <span class="user_hint"></span>
        </li>
        <li>
            <span>Password：</span>
            <input type="password" name="" value="" placeholder="6-16位密码" class="reg_password">
            <span class="password_hint"></span>
        </li>
        <li>
            <span>Confirm：</span>
            <input type="password" name="" value="" placeholder="确认密码" class="reg_confirm">
            <span class="confirm_hint"></span>
        </li>
        <li>
            <span>Email：</span>
            <input type="text" name="" value="" placeholder="邮箱" class="reg_email">
            <span class="email_hint"></span>
        </li>
        <li>
            <span>Mobile：</span>
            <input type="email" name="" value="" placeholder="手机号" class="reg_mobile">
            <span class="mobile_hint"></span>
        </li>
        <li>
            <button type="button" name="button" class="red_button">注册</button>
        </li>
    </ul>
</div>
<script src="../js/jquery.js"></script>
<script src="../js/JavaScript.js"></script>
</body>
</html>

