<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="../bootstrap-assets/bootstrap/css/bootstrap/bootstrap.css" />
	<link rel="stylesheet" href="../bootstrap-assets/bootstrap-table/bootstrap-table.css" />

	<script src="../bootstrap-assets/jquery/jquery.min.js"></script>
	<script src="../bootstrap-assets/bootstrap/js/bootstrap.js"></script>
	<script src="../bootstrap-assets/bootstrap-table/bootstrap-table.js"></script>
	<script src="../bootstrap-assets/bootstrap-table/bootstrap-table-export.js"></script>
	<script src="../bootstrap-assets/extends/tableExport/jquery.base64.js"></script>
	<script src="../bootstrap-assets/extends/tableExport/tableExport.js"></script>
	<meta charset="UTF-8">
	<style>
		body{
			background-color: #ecf0f6;
		}
		.div_head h2{
			color: black;
			margin: 0px;
			height: 60px;
			padding-top: 30px;
			padding-left: 25px;
		}
		#content{
			margin-left: 30px;
			margin-right: 30px;
		}
	</style>
</head>

<body>
<div class="div_head">
	<h2>核酸统计</h2>
	<hr style="background-color: #4b8dbb; height: 5px;">
</div>
<div id="content">

	<div id="content-body">

		<div id="reportTableDiv" class="span10">
			<table id="reportTable">
			</table>
		</div>
	</div>
</div>

<%
	class Person {
		String name;
		String idNumber;
		String mobile;
		String address;
		String dateTime;
		String inOrOut;

		String userstatus_usertype;
		String userstatus_package_id;
		String userstatus_end_time;
	}
	Person person = new Person();
	person.idNumber="姓名";
	person.mobile="姓名";
	person.address="姓名";
	person.dateTime="姓名";
	person.inOrOut="姓名";
%>
<script type="text/javascript">

	$(function () {
		// var x = [{"姓名":"20dai.rikon@gmail.com","身份证号":"","日期-时间":"2014-10-13 13:35:51","联系方式":"0","住址":"0","进入/离开":"0","userstatus_usertype":"0","userstatus_package_id":"100014","userstatus_end_time":"NULL"}];
		<%--var x;--%>
		<%--$.ajax({--%>
		<%--	type:"post",--%>
		<%--	dataType:"text",--%>
		<%--	url:"${pageContext.request.contextPath}/inoutRecord.do",--%>
		<%--	success:function (data){--%>
		<%--		x = data;--%>
		<%--		console.log(data);--%>
		<%--	}--%>
		<%--})--%>

		$('#reportTable').bootstrapTable({
			url: '${pageContext.request.contextPath}/inoutRecordServelet.do',
			method: 'get',
			cache: false,
			height: window.outerHeight,
			striped: true,
			pagination: true,
			pageSize: 20,
			pageNumber:1,
			pageList: [10, 20, 50, 100, 200, 500],
			search: true,
			showColumns: true,
			showRefresh: true,
			showExport: true,
			exportTypes: ['csv','txt','xml'],
			search: true,
			clickToSelect: true,
			columns: [{field:"name",title:"姓名",align:"center",valign:"middle",sortable:"true"},
				{field:"IDcard",title:"身份证号",align:"center",valign:"middle",sortable:"true"},
				{field:"contact",title:"联系方式",align:"center",valign:"middle",sortable:"true"},
				{field:"inout_type",title:"进入/离开",align:"center",valign:"middle",sortable:"true"},
				{field:"time",title:"日期-时间",align:"center",valign:"middle",sortable:"true"}],

			onPageChange: function (size, number) {
				//$("#pageSizeInput").val(size);
				//$("#pageNumberInput").val(number);

				//var form = $('#tableForm');
				//form.action= '${base}/showReport';
				//form.submit();
			},
			//onSort: function (name, order) {
			// },
			//formatShowingRows: function (pageFrom, pageTo, totalRows) {
			//	return '';
			// },
			//formatRecordsPerPage: function () {
			//	return '';
			//  },
			formatNoMatches: function(){
				return '无符合条件的记录';
			}
		});
		// $("#reportTable:odd").css("background-color", "black");

		$(window).resize(function () {
			$('#reportTable').bootstrapTable('resetView');
		});
	});

</script>

<!--	<div style="margin-left:20px;">	<h4>-->
<!--			When resize the window, the table header does not adjust automatically, how to solve it?<br/>-->
<!--		When you set the height of bootstrap table, the fixed header feature is automatically enabled, <br/>-->
<!--		that is what cause the problem, you need to listen the resize event of window and use the <br/>-->
<!--		resetView method to solve this problem, code example:<br/>-->
<!--		<br/>-->
<!--		$(function () {<br/>-->
<!--		&nbsp;&nbsp;	$('#tableId').bootstrapTable(); // init via javascript<br/>-->
<!--		<br/>-->
<!--		&nbsp;&nbsp;	$(window).resize(function () {<br/>-->
<!--		&nbsp;&nbsp;&nbsp;&nbsp;		$('#tableId').bootstrapTable('resetView');<br/>-->
<!--		&nbsp;&nbsp;	});<br/>-->
<!--		});<br/>-->
<!--	</h4></div>-->

</body>

</html>>