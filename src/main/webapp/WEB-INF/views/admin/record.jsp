<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include.jsp"%>
<c:set var="ctx" value="<%=request.getContextPath()%>" scope="request"/>
<c:set var="rs" value="${ctx}/static" scope="request"/>
<h3>激活历史记录:</h3>
<hr />
<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>激活时间</th>
				<th>课程名称</th>
				<th>卡号</th>
				<th>机器码</th>
				<th>激活码</th>
				<th>销售员</th>
				<th>家长（手机）</th>
				<th>学生</th>
				<th>操作员</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="record">
				<tr>
					<td>${record.id}</td>
					<td><fmt:formatDate value="${record.activateAt}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
					<td>${record.courseName}</td>
					<td>${record.cardNo}</td>
					<td>${record.hardCode}</td>
					<td>${record.verifyCode}</td>
					<td>${record.seller}</td>
					<td>${record.parentName}<c:if test="${not empty record.parentMobile}">(${record.parentMobile})</c:if></td>
					<td>${record.studentName}</td>
					<td>${record.opUser.email}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="text-center">
	<%@include file="../pagination.jsp"%>
</div>
<script src="${rs}/js/record.js"></script>