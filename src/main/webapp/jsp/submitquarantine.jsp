<%--
  Created by IntelliJ IDEA.
  User: TUF
  Date: 2022/11/19
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html dir="ltr" lang="zh-CN" xml:lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>隔离信息提交</title>
	<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
</head>
<body style="background-color: #ecf0f6">
<div style="width: 70%; padding-left: 15%; padding-right: 15%; height: 100%; overflow: hidden;">
	<div class="form" style="height: 100%; background-color: #ecf0f6;">
		<form action="${pageContext.request.contextPath}/addQuarantine.do" method="get">
			<div class="item">
				<span>用户名：</span>
				<label><input type="text" name="username" class="width" placeholder="用户名" /></label>
			</div>
			<div class="item">
				<span>隔离房间：</span>
				<label><input type="text" name="room" class="width" placeholder="房间号" /></label>
			</div>
			<div class="item">
				<span>隔离时长：</span>
				<label><input type="text" name="day" class="width" placeholder="请输入隔离天数" /></label>
			</div>

			<div class="item">
				<span>备　注：</span>
				<label><textarea name="message" class="width" placeholder="备注"></textarea></label>
			</div>
			<div class="item">
				<span></span>
				<label><button type="submit" style="cursor: pointer">提交</button></label>
				<label><button type="reset" style="cursor: pointer">重置</button></label>
			</div>
		</form>
	</div>
</div>
</body>
<style>
	input,select,textarea,button { outline:0; font-size: 16px; }
	.form { border:1px solid #DDD; font-size:12px; padding:20px; overflow:hidden; margin:20px; }
	.item { padding:20px 0; border-bottom:1px solid #EEE; line-height:38px; }
	.item span { display:inline-block; vertical-align:top; font-size: 16px;}
	.item select { width:50%; }
	.item .width { width:500px; }

	.inElement { display:inline-block; _zoom:1; *display:inline; }
	.inElement label { transition:all .5s; }
	.inElement label:focus { background:#eee; }
	.inRadio label { display:block; background:url(../imagess/form-radio-check-normal.png) no-repeat left center; padding-left:22px; cursor:pointer; }
	.inRadio label.hover { background-image:url(../imagess/form-radio-checke-hover.png); }
	.inRadio label.checked { background-image:url(../imagess/form-radio-checked-normal.png); }
	.inRadio label.focus { background-image:url(../imagess/form-radio-checked-hover.png); }
	.inRadio label.full { background-image:url(../imagess/form-radio-full.png); }
	.inRadio label.disabled { background-image:url(../imagess/form-radio-disabled.png); color:#999; cursor:not-allowed; }
	.inRadio.checked label.hover { background-image:url(../imagess/form-radio-checked-hover.png); }
	.inRadio.checked label.focus { background-image:url(../imagess/form-radio-checked-hover.png); }
	.inCheckbox label { display:block; background:url(../imagess/form-check-check-normal.png) no-repeat left center; padding-left:22px; cursor:pointer; }
	.inCheckbox label.hover { background-image:url(../imagess/form-check-check-hover.png); }
	.inCheckbox label.checked { background-image:url(../imagess/form-check-checked-normal.png); }
	.inCheckbox label.focus { background-image:url(../imagess/form-check-check-hover.png); }
	.inCheckbox label.full { background-image:url(../imagess/form-check-full.png); }
	.inCheckbox label.disabled { background-image:url(../imagess/form-check-disabled.png); color:#999; cursor:not-allowed; }
	.inCheckbox.checked label.hover { background-image:url(../imagess/form-check-checked-hover.png); }
	.inCheckbox.checked label.focus { background-image:url(../imagess/form-check-checked-hover.png); }
	.inText label { display:block; _zoom:1; *display:inline; border:1px solid #DDD; }
	.inText label.hover { border-color:#1E5EBF; }
	.inText label.focus { border-color:#1E5EBF; box-shadow:0 0 5px 0 rgba(30,94,191,.5); }
	.inText input { border:0; margin:0; padding:10px; box-sizing:border-box; }
	.inTextarea label { display:block; border:1px solid #DDD; }
	.inTextarea label.hover { border-color:#1E5EBF; }
	.inTextarea label.focus { border-color:#1E5EBF; box-shadow:0 0 5px 0 rgba(30,94,191,.5); }
	.inTextarea label textarea { border:0; margin:0; padding:10px; box-sizing:border-box; }
	.inSelect label { display:block; width:100%; border:1px solid #DDD; font-weight:normal; color:#353535; vertical-align:top; overflow:hidden;  margin:0; padding:0; z-index:2; position:relative; box-sizing:border-box; }
	.inSelect label span,
	.inSelect label em { height:36px; line-height:36px; display:inline-block; vertical-align:top;}
	.inSelect label span { float:left; padding:0 10px; left:0; }
	.inSelect label em { float:right; width:30px; background:url(../imagess/form-select-arrow-down.png) no-repeat center center; transition:all .5s; }
	.inSelect label em.open { background-image:url(../imagess/form-select-arrow-up.png); }
	.inSelect label.hover { border-color:#1E5EBF; }
	.inSelect label.hover em { background-image:url(../imagess/form-select-arrow-down-on.png); }
	.inSelect label.hover em.open { background-image:url(../imagess/form-select-arrow-up-on.png); }
	.inSelect label.focus { border-color:#1E5EBF; box-shadow:0 0 5px 0 rgba(30,94,191,.5); }
	.inSelect label.focus em { background-image:url(../imagess/form-select-arrow-down-on.png); }
	.inSelect label.focus em.open { background-image:url(../imagess/form-select-arrow-up-on.png); }
	.inSelect label.disabled { background:#F5F5F5; color:#999; cursor:not-allowed; }
	.inSelect .dropbox { width:100%; margin:0; padding:0; border:1px solid #DDD; clear:both; background:#FFF; z-index:1; left:0; box-sizing:border-box; border-top:0; z-index:-1; }
	.inSelect .dropbox .listbox dl,
	.inSelect .dropbox .listbox .option,
	.inSelect .dropbox .listbox .optgroup { list-style:none; margin:0; padding:0;}
	.inSelect .dropbox .listbox .option a,
	.inSelect .dropbox .listbox .optgroup a { display:block; text-decoration:none; color:#353535; margin:0px; cursor:default; }
	.inSelect .dropbox .listbox .option a span,
	.inSelect .dropbox .listbox .optgroup a span { display:block; margin-left:10px; line-height:25px; }
	.inSelect .dropbox .listbox .optgroup dt a { color:#000; font-weight:bold; margin:0px; }
	.inSelect .dropbox .listbox .selected { background-color:#F3F3F3; }
	.inSelect .dropbox .listbox .hover a { background-color:#1E5EBF; color:#FFF; }
	.inSelect .dropbox .listbox .option a:hover { background-color:#1E5EBF; color:#FFF; }
	.inSelect .dropbox .listbox .option a:hover span.selected { background-color:#1E5EBF; color:#FFF; }
	.inSelect .dropbox .listbox dd.disabled a { background-color:#FFF; color:#999; cursor:not-allowed; }
	.inSelect .dropbox .listbox dd.disabled a:hover { background-color:#FFF; color:#999; }
	.inSelect .dropbox .listbox dd.disabled a span.selected { background-color:#FFF; }
	.inSelect .dropbox .listbox dd.disabled a:hover span.selected { background-color:#FFF; color:#999; }
	.inSelect .dropbox .listbox dd.option { overflow:hidden; }
	.inSelect .dropbox .listbox dd.option a span { display:inline-block; }
	.inSelect .dropbox .listbox dd .option a span { margin-left:20px; }
	.inSelect .dropbox .multiple dd.option a span { background:url(../imagess/form-select-check-normal.png) no-repeat left center; padding-left:22px; }
	.inSelect .dropbox .multiple dd.option a:hover span { background-image:url(../imagess/form-select-check-hover.png); }
	.inSelect .dropbox .multiple dd.selected a span { background-image:url(../imagess/form-select-checked-normal.png); }
	.inSelect .dropbox .multiple dd.selected a:hover span { background-image:url(../imagess/form-select-checked-hover.png); }
	.inSelect .dropbox .multiple dd.disabled a span { background-image:url(../imagess/form-select-check-disabled.png); }
	.inSelect .dropbox .multiple dd.disabled a:hover span { background-image:url(../imagess/form-select-check-disabled.png); }
	.inSelect .dropbox .multiple dd.disabled a span.selected { background-image:url(../imagess/form-select-checked-disabled.png); }
	.inSelect .dropbox .multiple dd.disabled dt a span { background-image:none; }
	.inSelect .dropbox .multiple dd.disabled dt a:hover span { background-image:none; }
</style>
</html>