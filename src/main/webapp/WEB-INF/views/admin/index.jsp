<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include.jsp"%>
<c:set var="js" value="admin" scope="request"/>
<div class="page-header text-center">
  <h2>激活系统</h2>
</div>
<div class="alert alert-info fade in">
	<strong>提示:</strong> 卡号、密码、机器码必填
</div>
<div class="alert alert-danger fade in" style="display: none;">
	<strong>错误:</strong> <span class="msg"></span>
</div>
<div class="alert alert-success fade in" style="display: none;">
	<strong>成功:</strong> 激活学习卡成功!
</div>
<div class="well activation-form">
	<div class="row">
		<form class="bs-example-form" action="${ctx}/admin/requestActivation" method="post" autocomplete="off">
			<div class="col-sm-8 col-xs-12">
				<div class="row">
					<div class="col-sm-4 col-xs-12"><div class="input-group"><span class="input-group-addon">课程卡号</span><input type="text" class="form-control" name="cardNo" autocomplete="off"></div></div>
					<div class="col-sm-4 col-xs-12"><div class="input-group"><span class="input-group-addon">密码</span><input type="password" class="form-control" name="password" autocomplete="off"></div></div>
					<div class="col-sm-4 col-xs-12"><div class="input-group"><span class="input-group-addon">机器码</span><input type="text" class="form-control" name="hardCode" autocomplete="off"></div></div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-xs-12"><div class="input-group"><span class="input-group-addon">销售姓名</span><input type="text" class="form-control" name="seller" autocomplete="off"></div></div>
					<div class="col-sm-6 col-xs-12"><div class="input-group"><span class="input-group-addon">学生姓名</span><input type="text" class="form-control" name="studentName" autocomplete="off"></div></div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-xs-12"><div class="input-group"><span class="input-group-addon">家长姓名</span><input type="text" class="form-control" name="parentName" autocomplete="off"></div></div>
					<div class="col-sm-6 col-xs-12"><div class="input-group"><span class="input-group-addon">家长手机</span><input type="text" class="form-control" name="parentMobile" autocomplete="off"></div></div>
				</div>
			</div>
		</form>
		<div class="col-sm-2 col-xs-12 text-center visible-md visible-lg">
			<button type="button" class="btn btn-success btn-lg requestBtn" data-loading-text="请求中......" data-complete-text="获取激活码" style="height: 80px;margin-top: 20px;">获取激活码</button>
		</div>
		<div class="col-sm-2 col-xs-12 text-center visible-xs visible-sm">
			<button type="button" class="btn btn-success btn-lg requestBtn" data-loading-text="请求中......"  data-complete-text="获取激活码">获取激活码</button>
		</div>
		<div class="col-sm-2 col-xs-12 text-center visible-md visible-lg">
			<h1 class="mb0">授权码</h1>
			<h2 class="text-primary mt0 verifycode"></h2>
		</div>
		<div class="col-sm-2 col-xs-12 text-center visible-xs visible-sm">
			<h3 class="mb0">授权码</h3>
			<h4 class="text-primary mt0 verifycode"></h4>
		</div>
	</div>
</div>
<div id="recordHolder"></div>

<script>
	var param = {};
	<shiro:hasRole name="sa">
		param.superadmin = true;
		param.recordUrl = "${ctx}/admin/record";
	</shiro:hasRole>
</script>