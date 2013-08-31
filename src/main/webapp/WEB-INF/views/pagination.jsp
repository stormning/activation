<%@page import="org.springframework.data.domain.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>

<%
	Page<?> p = (Page<?>) request.getAttribute("page");
	if (p != null) {
		int totalPages = p.getTotalPages();
		if(totalPages>1){
		int currentPage = p.getNumber()+1;
		int size = p.getSize();
		//7 buttons
		int maxButton = 7;
		int half = maxButton/2;
		
		
		int startButton = Math.max(currentPage-half,1);
		int endButton = Math.min(startButton+maxButton-1, totalPages);
		%>
		<ul class="pagination">
				<%if(startButton>1){%>
				<li><a href="?page.page=0" page="1">第一页</a></li>
			    <%}
				for (int i = startButton;i<=endButton;i++) {
				%>
				<li <%if(i==currentPage){%>class="active"<%} %>>
					<a <%if(i!=currentPage){%>href="?page.page=<%=i%>"<%}%> page="<%=i%>"><%=i%></a>
				</li>
				<% }%>
				<%if(endButton<totalPages){%>
				<li><a href="?page.page=<%=totalPages%>" page="<%=totalPages%>">最后一页</a></li>
			    <%}%>	
		</ul>
		<%
	}
	}
%>