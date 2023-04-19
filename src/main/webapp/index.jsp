<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css"/>
</head>

<body style="background-image: url('images/beijing1.png');">
<div class="body" >
    <div style="width: 100%; height: 100%;">
<%--    <img src="images/maskgreen.png" style="width: 35px; height: 25px;" class="logo">--%>
    <p class="logo">社区进出管理系统</p>
    <div class="body_count">
        <div class="login_count">
            <div class="login_count_a">
                <div class="login_count_a_l">
                    <div class="login_a_l_t">扫码点击这里</div>
                    <div class="triangle"></div>
                    <img src="images/tubiao-02.png" class="icon_e" />
                </div>
                <div id="all">
                    <ul id="option">
                        <li class="active login_left">密码登录</li>
                        <li class="login_right">账号登录</li>
                    </ul>
                    <ul id="card">
                        <li class="active">
                            <!--输入框-->
                            <form action="${pageContext.request.contextPath}/login.do">
                                <div class="login_bot_count">
                                    <img src="images/tubiao-07.png" alt="" />
                                    <input type="text" name="username" id="uid" placeholder="请输入账号" />
                                </div>
                                <div class="login_bot_count">
                                    <img src="images/tubiao-06.png" alt="" />
                                    <input type="password" name="password" id="pwd" placeholder="请输入密码"/>
                                </div>
                                <div class="login_bot">
                                    <a>忘记密码?</a>
                                    <p><input type="checkbox" name="vehicle" value="Bike" />记住密码</p>
                                </div>
                                <!--登录按钮-->
                                <button class="login_button" type="submit">登录</button>
                            </form>
                                <button class="login_button" onclick="window.location.href='JSP/register.jsp'">注册</button>
                        </li>
                        <li class="login_account">
                            <!--输入框-->
                            <div class="login_account_count">
                                <img src="images/tubiao-05.png" alt="" />
                                <select class="account_select">
                                    <option value="+86">+86</option>
                                    <option value="+852">+852</option>
                                    <option value="+853">+853</option>
                                    <option value="+886">+886</option>
                                </select>
                                <img src="images/line-down.png" alt="" class="account_select_icon" />
                                <input type="" name="" class="mobile_input" placeholder="请输入手机号码"id="aa"  />
                            </div>
                            <div class="login_account_counts">
                                <img src="images/tubiao-06.png" alt="" />
                                <input type="" name="" id="" placeholder="请输入验证码" />
                                <input class="account_code" type="button" id="btn"value="获取验证码" />
                            </div>
                            <!--登录按钮-->
                            <button class="login_account_button" onclick="denglu()"><a href="html/firstpage.jsp">登录</a></button>
                        </li>
                    </ul>
                </div>

            </div>

            <div class="login_count_b">
                <div class="login_count_b_l">
                    <div class="login_b_l_t">账号登录点这里</div>
                    <div class="triangle"></div>
                    <img src="images/tubiao-03.png" class="icon_z" />
                </div>
                <div class="login_b_title">
                    <img src="images/tubiao-04.png" alt="" /> 微信扫码登录
                </div>
                <img src="images/ewm.png" class="libqr" />
                <p class="libqr_text">请使用微信扫描二维码登录</p>
            </div>

        </div>

    </div>
    </div>
</div>

<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/login.js" ></script>
</body>

</html>