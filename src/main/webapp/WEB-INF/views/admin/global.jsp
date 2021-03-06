<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include.jsp"%>

<div class="navbar navbar-inverse navbar-fixed-top bs-docs-nav">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${ctx}/">kuxuepai.com</a>
		</div>
		
		<shiro:authenticated>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">首页</a></li>
					<li><a href="#about">关于</a></li>
					<li><a href="#contact">联系我们</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
		            <li><a href="${ctx}/logout">退出登录</a></li>
		        </ul>
		        <p class="navbar-text pull-right">身份:
					<shiro:hasAnyRoles name="a0,a1">
						超级管理员
						<c:set var="isSuperAdmin" value="true" scope="request"/>
					</shiro:hasAnyRoles>
					<c:if test="${!isSuperAdmin}">
						普通管理员
					</c:if>
				</p>
			</div>
		</shiro:authenticated>
		<!--/.nav-collapse -->
	</div>
</div>

<div class="container">
	<tiles:insertAttribute name="content" />
</div>