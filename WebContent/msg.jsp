<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="public/head.jsp" />
</head>
<body>
<jsp:include page="public/navbar.jsp" />
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
	        <div class="panel panel-info" style="margin-top: 10px">
                <div class="panel-heading text-center"><b>${msgHead}</b></div>
                <div class="panel-body">
		        	<div class="col-sm-offset-3 col-sm-6">
		        		<img src='img/${imgStyle}.png' height='50%' width='70%'>
		        		<p><label class="label label-${level}" style="margin-left: 110px;">${operate}</label></p>
		        		<a href="${jumpUrl}" class="btn btn-info" style="margin-left: 110px;">${jumpName}</a>
		        	</div>
	        	</div>
        	</div>
        </div>
        <jsp:include page="public/footer.jsp" />
    </div>
</div>
</body>
</html>