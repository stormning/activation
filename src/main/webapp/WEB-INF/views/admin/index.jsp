<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include.jsp"%>
<div class="page-header text-center">
  <h2>激活系统</h2>
</div>
<div class="well activation-form">
	<div class="row">
		<form class="bs-example-form" role="form">
			<div class="col-sm-8 col-xs-12">
				<div class="row">
					<div class="col-sm-4 col-xs-12"><div class="input-group"><span class="input-group-addon">课程卡号</span><input type="text" class="form-control"></div></div>
					<div class="col-sm-4 col-xs-12"><div class="input-group"><span class="input-group-addon">密码</span><input type="password" class="form-control"></div></div>
					<div class="col-sm-4 col-xs-12"><div class="input-group"><span class="input-group-addon">机器码</span><input type="text" class="form-control"></div></div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-xs-12"><div class="input-group"><span class="input-group-addon">销售姓名</span><input type="text" class="form-control"></div></div>
					<div class="col-sm-6 col-xs-12"><div class="input-group"><span class="input-group-addon">学生姓名</span><input type="text" class="form-control"></div></div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-xs-12"><div class="input-group"><span class="input-group-addon">家长姓名</span><input type="text" class="form-control"></div></div>
					<div class="col-sm-6 col-xs-12"><div class="input-group"><span class="input-group-addon">家长手机</span><input type="text" class="form-control"></div></div>
				</div>
			</div>
		</form>
		<div class="col-sm-2 col-xs-12 text-center visible-md visible-lg">
			<button type="button" class="btn btn-success btn-lg" data-loading-text="请求中..." style="height: 80px;margin-top: 20px;">获取激活码</button>
		</div>
		<div class="col-sm-2 col-xs-12 text-center visible-xs visible-sm">
			<button type="button" class="btn btn-success btn-lg" data-loading-text="请求中...">获取激活码</button>
		</div>
		<div class="col-sm-2 col-xs-12 text-center visible-md visible-lg">
			<h1 class="mb0">授权码</h1>
			<h2 class="text-primary mt0">X4K2F9</h2>
		</div>
		<div class="col-sm-2 col-xs-12 text-center visible-xs visible-sm">
			<h3 class="mb0">授权码</h3>
			<h4 class="text-primary mt0">X4K2F9</h4>
		</div>
	</div>
</div>

<h3>激活历史记录:</h3>
<hr />
<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>激活时间</th>
				<th>学年学期</th>
				<th>卡号</th>
				<th>学科</th>
				<th>机器码</th>
				<th>激活码</th>
				<th>销售员</th>
				<th>家长（手机）</th>
				<th>学生</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach begin="1" end="10" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>2013.08.28 18:20:28</td>
					<td>02B二年级下学期</td>
					<td>89312319</td>
					<td>数学</td>
					<td>3482</td>
					<td>h9rui4</td>
					<td>张三</td>
					<td>王熙凤(13813838888)</td>
					<td>王未来</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@include file="../pagination.jsp"%>