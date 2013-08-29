<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include.jsp"%>
<div class="page-header text-center">
  <h1>激活系统</h1>
</div>
<div class="row">
	<div class="col-xs-6">
		<div class="row">
			<div class="col-xs-4">课程卡号</div>
			<div class="col-xs-4">密码</div>
			<div class="col-xs-4">机器码</div>
		</div>
		<div class="row">
			<div class="col-xs-6">销售姓名</div>
			<div class="col-xs-6">学生姓名</div>
		</div>
		<div class="row">
			<div class="col-xs-6">学生姓名</div>
			<div class="col-xs-6">家长手机</div>
		</div>
	</div>
	<div class="col-xs-3 text-center">
		<button type="button" class="btn btn-success btn-lg"
			data-loading-text="请求中...">获取激活码</button>
		<button type="button" data-loading-text="Loading..."
			class="btn btn-primary">Loading state</button>
	</div>
	<div class="col-xs-3">嘻嘻嘻嘻嘻嘻嘻嘻嘻</div>
</div>

<h2>激活历史记录:</h2>
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