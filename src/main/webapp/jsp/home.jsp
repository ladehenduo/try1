<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html dir="ltr" lang="zh-CN" xml:lang="zh-CN">
<head>
	<meta charset="utf-8" />
	<title>首页</title>
	<base target="_blank">
	<link rel="stylesheet" type="text/css" href="../css/home-base.css" />
	<link rel="stylesheet" type="text/css" href="../css/home-main.css" />
	<style>
		.block{
			width: 20%;
			height: 8%;
			border-radius: 5px;
			margin-top: 100px;
			position: absolute;
		}
		.label-i{
			margin-left: 15px;
			font-size: 18px;
			color: white;
		}
		.label-i-i{
			margin-left: 15px;
			font-size: 15px;
			color: whitesmoke;
		}
	</style>
</head>
<body style="background-color: #ecf0f6; overflow: hidden">
<div class="focus-wrap">
	<div class="focus seven" id="focus">
		<div class="lbox copy-1"></div>
		<div class="rbox copy-2"></div>
		<div class="lbox mask focus-prev"></div>
		<div class="rbox mask focus-next"></div>
		<ul class="focus-container" id="panle">
			<li><a href=""><img src="../images/a1.jpg"></a> <span class="cover"></span>
				<div class="info">
					<div class="title"><a href="">JQuery是继prototype之后又一个优秀的Javascript库</a></div>
					<div class="desc">它是轻量级的js库 ，它兼容CSS3，还兼容各种浏览器（IE 6.0+, FF 1.5+, Safari 2.0+, Opera 9.0+），jQuery2.0及后续版本将不再支持IE6/7/8浏览器。...</div>
				</div>
			</li>
			<li><a href=""><img src="../images/a2.jpg"></a> <span class="cover"></span>
				<div class="info">
					<div class="title"><a href="">jQuery是一个兼容多浏览器的javascript库</a></div>
					<div class="desc">核心理念是write less,do more(写得更少,做得更多)。jQuery在2006年1月由美国人John Resig在纽约的barcamp发布...</div>
				</div>
			</li>
			<li><a href=""><img src="../images/a3.jpg"></a> <span class="cover"></span>
				<div class="info">
					<div class="title"><a href="">Ajax重写</a></div>
					<div class="desc">jQuery的语法设计可以使开发者更加便捷，例如操作文档对象...</div>
				</div>
			</li>
			<li><a href=""><img src="../images/a1.jpg"></a> <span class="cover"></span>
				<div class="info">
					<div class="title"><a href="">JQuery是继prototype之后又一个优秀的Javascript库</a></div>
					<div class="desc">它是轻量级的js库 ，它兼容CSS3，还兼容各种浏览器（IE 6.0+, FF 1.5+, Safari 2.0+, Opera 9.0+），jQuery2.0及后续版本将不再支持IE6/7/8浏览器。...</div>
				</div>
			</li>
			<li><a href=""><img src="../images/a2.jpg"></a> <span class="cover"></span>
				<div class="info">
					<div class="title"><a href="">jQuery是一个兼容多浏览器的javascript库</a></div>
					<div class="desc">核心理念是write less,do more(写得更少,做得更多)。jQuery在2006年1月由美国人John Resig在纽约的barcamp发布...</div>
				</div>
			</li>
			<li><a href=""><img src="../images/a3.jpg"></a> <span class="cover"></span>
				<div class="info">
					<div class="title"><a href="">Ajax重写</a></div>
					<div class="desc">jQuery的语法设计可以使开发者更加便捷，例如操作文档对象...</div>
				</div>
			</li>
			<li><a href=""><img src="../images/a1.jpg"></a> <span class="cover"></span>
				<div class="info">
					<div class="title"><a href="">jQuery是一个兼容多浏览器的javascript库</a></div>
					<div class="desc">核心理念是write less,do more(写得更少,做得更多)。jQuery在2006年1月由美国人John Resig在纽约的barcamp发布...</div>
				</div>
			</li>
		</ul>
		<a href="javascript:;" rel="nofollow" class="prev focus-prev png" id="focus-prev" target="_self">Prev</a> <a href="javascript:;" rel="nofollow" class="next focus-next png" id="focus-next" target="_self">Next</a><span class="pn-line png"></span>
		<div class="trigger" id="focus-trigger"> <span><i></i></span> <span><i></i></span> <span><i></i></span> <span><i></i></span> <span><i></i></span> <span><i></i></span> <span><i></i></span> </div>
		<div class="trigger-cover"></div>
	</div>
	<div style="height: 100%">
		<div class="block" style="background-color: #129cc3; margin-left: 4%">
			<br>
			<i class="label-i">目前确诊人数：</i> <i class="label-i">12</i>
			<br>
			<i class="label-i-i">累计确诊人数：</i> <i class="label-i-i">103</i>
		</div>
		<div class="block" style="background-color: green; margin-left: 28%">
			<br>
			<i class="label-i">治愈率：<i class="label-i">99.9</i>%</i>
			<br>
			<i class="label-i-i">治愈人数：</i> <i class="label-i-i">91</i>
		</div>
		<div class="block" style="background-color: #e19b0b; margin-left: 52%">
			<br>
			<i class="label-i">现存隔离人数：</i> <i class="label-i">12</i>
			<br>
			<i class="label-i-i">累计隔离人数：</i> <i class="label-i-i">103</i>
		</div>
		<div class="block" style="background-color: #da0000; margin-left: 76%">
			<br>
			<i class="label-i">死亡率：<i class="label-i">0.1</i>%</i>
			<br>
			<i class="label-i-i">死亡人数：</i> <i class="label-i-i">1</i>
		</div>
	</div>
</div>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script src="../js/missamy.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript">

</script>
</body>
</html>