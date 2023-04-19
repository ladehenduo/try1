// user
var user_Boolean = false;
var password_Boolean = false;
var varconfirm_Boolean = false;
var mobile_Boolean = false;
var Id_Boolean = false;
let _IDRe18 = /^([1-6][1-9]|50)\d{4}(18|19|20)\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
let _IDre15 =  /^([1-6][1-9]|50)\d{4}\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\d{3}$/;

$('.reg_user').blur(function(){
  if ((/^[a-z0-9_-]{4,8}$/).test($(".reg_user").val())){
    $('.user_hint').html("✔").css("color","green");
    user_Boolean = true;
  }else {
    $('.user_hint').html("×").css("color","red");
    user_Boolean = false;
  }
});
// password
$('.reg_password').blur(function(){
  if ((/^[a-z0-9_-]{6,16}$/).test($(".reg_password").val())){
    $('.password_hint').html("✔").css("color","green");
    password_Boolean = true;
  }else {
    $('.password_hint').html("×").css("color","red");
    password_Boolean = false;
  }
});


// password_confirm
$('.reg_confirm').blur(function(){
  if (($(".reg_password").val())==($(".reg_confirm").val())){
    $('.confirm_hint').html("✔").css("color","green");
    varconfirm_Boolean = true;
  }else {
    $('.confirm_hint').html("×").css("color","red");
    varconfirm_Boolean = false;
  }
});


// 手机号验证
$('.reg_mobile').blur(function(){
  if ((/^1(3\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\d|9[0-35-9])\d{8}$/).test($(".reg_mobile").val())){
    $('.mobile_hint').html("✔").css("color","green");
    mobile_Boolean = true;
  }else {
    $('.mobile_hint').html("×").css("color","red");
    mobile_Boolean = false;
  }
});


// 身份证号验证
$('.reg_id_number').blur(function(){

  if (_IDRe18.test($(".reg_id_number").val()) || _IDre15.test($(".reg_id_number").val())){
    $('.id_number_hint').html("✔").css("color","green");
    Id_Boolean = true;
  }else {
    $('.id_number_hint').html("×").css("color","red");
    Id_Boolean = false;
  }
});

// click
$('.red_button').click(function(){
  if(user_Boolean && password_Boolean && varconfirm_Boolean && mobile_Boolean && Id_Boolean){
      location.href=register.do;
  }else {
    alert("请完善信息");
  }
});
