<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="public/head.jsp" />
<link rel="stylesheet" href="css/carousel.css">
</head>
<body>
<jsp:include page="public/navbar.jsp" />
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="panel panel-info nav-sidebar">
                <div class="panel-heading" role="tab" id="programing">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" href="#programing-item" aria-expanded="true" aria-controls="programing-item"><b>编程语言与程序设计</b></a>
                    </h4>
                </div>
                <div id="programing-item" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="programing" aria-expanded="true">
                    <ul class="list-group">
                        <li class="list-group-item">C语言</li>
                        <li class="list-group-item">C++</li>
                        <li class="list-group-item">C#</li>
                        <li class="list-group-item">Java</li>
                        <li class="list-group-item">JavaScript</li>
                        <li class="list-group-item">PHP</li>
                        <li class="list-group-item">Python</li>
                        <li class="list-group-item">Html</li>
                    </ul>
                </div>
            </div>

            <div class="panel panel-info nav-sidebar">
                <div class="panel-heading" role="tab" id="os">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" href="#os-item" aria-expanded="true" aria-controls="os-item"><b>操作系统</b></a>
                    </h4>
                </div>
                <div id="os-item" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="os" aria-expanded="true">
                    <ul class="list-group">
                        <li class="list-group-item">Windows</li>
                        <li class="list-group-item">Linux</li>
                    </ul>
                </div>
            </div>

            <div class="panel panel-info nav-sidebar">
                <div class="panel-heading" role="tab" id="database">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" href="#database-item" aria-expanded="true" aria-controls="database-item"><b>数据库</b></a>
                    </h4>
                </div>
                <div id="database-item" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="database" aria-expanded="true">
                    <ul class="list-group">
                        <li class="list-group-item">数据挖掘</li>
                        <li class="list-group-item">SQL语言</li>
                        <li class="list-group-item">MySQL</li>
                        <li class="list-group-item">Oracle</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class=""></li>
                    <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                    <li data-target="#myCarousel" data-slide-to="2" class="active"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item">
                        <img class="first-slide" src="img/baner_01.jpg" alt="First slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1><label class="label label-success">新书推荐:一</label></h1>
                                <p><code>内容: XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX</code></p>
                                <p><a class="btn btn-lg btn-primary" href="#" role="button">点击查看</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img class="second-slide" src="img/baner_02.jpg" alt="Second slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1><label class="label label-success">新书推荐:二</label></h1>
                                <p><code>内容: XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX</code></p>
                                <p><a class="btn btn-lg btn-primary" href="#" role="button">点击查看</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item active">
                        <img class="third-slide" src="img/baner_03.jpg" alt="Third slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1><label class="label label-success">新书推荐:三</label></h1>
                                <p><code>内容: XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX</code></p>
                                <p><a class="btn btn-lg btn-primary" href="#" role="button">点击查看</a></p>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <h3 class="page-header">1F 新书速递</h3>
            <div class="row">
                <c:forEach var="i" begin="1" end="6">
            		<div class="col-sm-3">
	                    <div class="thumbnail">
	                        <a href="item.jsp"><img src="img/item.jpg" alt=""></a>
	                        <div class="caption">
	                            <h5><a href="item.jsp">深入理解Java虚拟机：JVM高级特性与最佳实践（第2版）</a></h5>
	                            <p><label class="label label-danger">¥68.10</label></p>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
            </div>

            <h3 class="page-header">2F 丛书推荐</h3>
            <div class="row">
                <c:forEach var="i" begin="1" end="8">
            		<div class="col-sm-3">
	                    <div class="thumbnail">
	                    	<a href="item.jsp"><img src="img/item.jpg" alt=""></a>
	                        <div class="caption">
	                            <h5><a href="item.jsp">深入理解Java虚拟机：JVM高级特性与最佳实践（第2版）</a></h5>
	                            <p><label class="label label-danger">¥68.10</label></p>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
            </div>

            <h3 class="page-header">3F 畅销经典</h3>
            <div class="row">
            	<c:forEach var="i" begin="1" end="3">
            		<div class="col-sm-3">
	                    <div class="thumbnail">
	                        <a href="item.jsp"><img src="img/item.jpg" alt=""></a>
	                        <div class="caption">
	                            <h5><a href="item.jsp">深入理解Java虚拟机：JVM高级特性与最佳实践（第2版）</a></h5>
	                            <p><label class="label label-danger">¥68.10</label></p>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
            </div>
        </div>
        <jsp:include page="public/footer.jsp" />
    </div>
</div>
</body>
</html>