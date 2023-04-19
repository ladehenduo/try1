<%--
  Created by IntelliJ IDEA.
  User: TUF
  Date: 2022/12/9
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>个人信息</title>
  <meta name="description" content="Neat">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" user-scalable="no">
  <link rel="stylesheet" href="../css/profilestyle.css">
  <script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
  <script src="../js/profilestyle.js"></script>
</head>
<body>
<div class="main-group">
  <div class="box-group">
    <div class="left-group">
      <h3 class="title">个人信息登记</h3>
      <div class="icon-group">
        <img src = "../images/email.png" class="round_icon" alt=""></img>
      </div>
    </div>
    <div class="right-group">
      <h3 class="title">个人信息</h3>
      <form action="${pageContext.request.contextPath}/modifyProfile.do" class="form">
        <div class="form-group">
          <div class="input-group w50" >
            <input type="text" name="name" id="p_name" required>
            <span>姓名</span>
          </div>
          <div class="input-group w50">
            <input type="text" name="age" id="p_age" required>
            <span>年龄</span>
          </div>
          <div class="input-group w50">
            <input type="text" name="sex" id="p_sex" required>
            <span>性别</span>
          </div>
          <div class="input-group w50">
            <input type="text" name="IDcard" id="p_IDcard" required>
            <span>身份证号</span>
          </div>
          <div class="input-group w50">
            <input type="text" name="tel" id="p_tel" required>
            <span>手机号</span>
          </div>
          <div class="input-group w50">
            <input type="text" name="address" id="p_address" required>
            <span>房间号</span>
          </div>
          <div class="input-group w50">
            <input type="text" name="health" id="p_health" required >
            <span>健康状态</span>
          </div>
          <div class="input-group w100">
            <textarea name="data"></textarea>
            <span>备注</span>
          </div>
          <div class="input-group w100">
            <button type="submit">保存</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
<script type="text/javascript">

  $(document).ready(function (){
    var name= document.getElementById("p_name");
    var age= document.getElementById("p_age");
    var sex= document.getElementById("p_sex");
    var IDcard= document.getElementById("p_IDcard");
    var tel= document.getElementById("p_tel");
    var address= document.getElementById("p_address");
    var health= document.getElementById("p_health");

    $.ajax({
        url:"${pageContext.request.contextPath}/getSelfProfile.do",
        type: "get",
        dataType: "json",
        async: true,
    }).done(function (msg){
      console.log(msg);
      let profile = msg;
      console.log(profile.name);
      name.value = profile.name;
      age.value = profile.age;
      sex.value = profile.sex;
      IDcard.value = profile.IDcard;
      tel.value = profile.tel;
      address.value = profile.address;
      health.value = profile.health;
    }).error(function (e) {
      alert(e)
    })

  })

</script>
</html>

