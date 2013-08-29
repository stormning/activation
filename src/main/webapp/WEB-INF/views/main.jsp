<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>激活系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:set var="ctx" value="<%=request.getContextPath()%>" scope="request"/>
	<c:set var="rs" value="${ctx}/static" scope="request"/>
    <!-- Bootstrap -->
    <link href="${rs}/thirdparty/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${rs}/thirdparty/bootstrap/assets/css/docs.css" rel="stylesheet">
	<link href="${rs}/thirdparty/bootstrap/assets/css/pygments-manni.css" rel="stylesheet">
	<link href="${rs}/css/base.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="${rs}/thirdparty/bootstrap/assets/js/html5shiv.js"></script>
      <script src="${rs}/thirdparty/bootstrap/assets/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <tiles:insertAttribute name="global" />

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${rs}/thirdparty/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>