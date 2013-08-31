<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include.jsp"%>
<c:set var="js" value="login" scope="request" />
<style>
.panel {
	margin-top: 20%;
}
.text-danger {
    color: #B94A48 !important;
}
</style>


<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="panel panel-info">
			<div class="panel-heading">登录</div>
			<div class="panel-body">
				<p class="text-danger" style="display: none;">
				</p>
				<form role="form" action="${ctx}/doAjaxLogin" method="post"
					id="loginForm" successUrl="${ctx}/">
					<div class="form-group">
						<label for="userNameInput">用户名</label> <input type="text"
							class="form-control" id="userNameInput" name="username"
							placeholder="请输入用户名">
					</div>
					<div class="form-group">
						<label for="passwordInput">密码</label> <input type="password"
							class="form-control" id="passwordInput" name="password"
							placeholder="请输入密码">
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" name="rememberMe"> 记住我
						</label>
					</div>
					<button type="submit" class="btn btn-primary" data-loading-text="登录中..." data-complete-text="获取激活码">登&nbsp;&nbsp;录</button>
				</form>
			</div>
		</div>
	</div>
</div>