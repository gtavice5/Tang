<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css"
	rel="stylesheet">
<style type="text/css">
body {
	font-size: 12px;
	font-family: Arial, Georgia, "Times New Roman", Times, serif;
	color: #555;
	text-align: center;
	background-color: #e2e2e2;
}

li {
	line-height: 32px;
	font-size: 20px;
	background-color: #eaeaea;
}

select {
	font-size: 30px;
}

#logo {
	margin-bottom: 20px;
}

#content {
	font-size: 30px;
	margin-bottom: 20px;
}

#search {
	font-size: 25px;
}

p {
	font-size: 60px;
	margin: 5px;
}

h1 {
	font-size: 80px;
}
</style>
<title>唐诗搜索</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<img src="<%=path %>/img/logotang.png" id="logo" />
			</div>
		</div>

		<div class="row clearfix">
			<form action="${pageContext.request.contextPath }/tang/listAction"
				method="post">
				<div class="col-md-12 column">
					<select name="action">
						<option value="getAllByName">诗人</option>
						<option value="getByTitle">诗名</option>
						<option value="getByContent">诗句</option>
					</select> <input id="content" name="content" type="text" size="40" /> <input
						type="submit" class="btn btn-default" id="search" value="查询" />
				</div>
			</form>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<c:if test="${poetry1!=null}">
					<p>${poetry1.content }</p>
				</c:if>
				<c:if test="${poetry2!=null}">
					<h1>${poetry2.title}</h1>
					<p>${poetry2.name}</p>
					<p>${poetry2.content}</p>
				</c:if>
				<ol>
					<c:if test="${pList!=null}">
						<c:forEach items="${pList}" var="poetry">
							<li>${poetry.title}</li>
						</c:forEach>
					</c:if>
				</ol>
			</div>
		</div>
	</div>
</body>
</html>