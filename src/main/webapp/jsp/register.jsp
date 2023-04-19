<%--
  Created by IntelliJ IDEA.
  User: TUF
  Date: 2022/11/19
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 重置文件 -->
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../css/style.css">
    <title>注册</title>
</head>
<body>

<div class="reg_div">
    <p>注册</p>
    <form action="${pageContext.request.contextPath}/register.do">
        <ul class="reg_ul">
            <li>
                <span>用户名：</span>
                <label>
                    <input type="text" name="username" placeholder="4-8位用户名" class="reg_user">
                </label>
                <span class="user_hint"></span>
            </li>
            <li>
                <span>密码：</span>
                <label>
                    <input type="password" name="password" placeholder="6-16位密码" class="reg_password">
                </label>
                <span class="password_hint"></span>
            </li>
            <li>
                <span>确认密码：</span>
                <label>
                    <input type="password" name="cfpassword" value="" placeholder="确认密码" class="reg_confirm">
                </label>
                <span class="confirm_hint"></span>
            </li>

            <li>
                <span>手机号：</span>
                <label>
                    <input type="text" name="tel" placeholder="手机号" class="reg_mobile">
                </label>
                <span class="mobile_hint"></span>
            </li>
            <li>
                <span>身份证号：</span>
                <label>
                    <input type="text" name="IDcard" placeholder="身份证号" class="reg_id_number" id="reg_id_input">
                </label>
                <span class="id_number_hint"></span>
            </li>
            <li>
                <button type="submit" name="button" class="red_button">注册</button>
            </li>
        </ul>
    </form>
</div>

<script src="../js/jquery.js"></script>
<script src="../js/JavaScript.js"></script>
<script charset="UTF-8"></script>
</body>
</html>

