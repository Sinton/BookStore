<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="在线书城">
	<meta name="author" content="Sinton">
	<title>工大E书城</title>
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- <link rel="stylesheet" href="css/dashboard.css"> -->
	<link rel="stylesheet" href="css/style.css"/>
	<script src="js/jquery-1.9.1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/console.js"></script>
	<style type="text/css">body {font-family: "微软雅黑";padding-top: 50px;}</style>
</head>
<body>
<jsp:include page="public/navbar.jsp" />
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
            <div id="opt">
                <dl>
                    <dt>控制台</dt>
                    <dd id="view-cover" class="cur">封面</dd>
                    <dd id="view-back">背面</dd>
                    <dd id="open-book">打开/合上书本</dd>
                    <dd id="view-rotate">360°旋转</dd>
                </dl>
            </div>
            
            <h1 class="demo-title">关于</h1>
            <div id="book" class="view-cover">
                <div class="main">
                    <div class="book-font">
                        <div class="book-cover">
                            <h1 class="title">JavaWeb 大作业</h1>
                            <h2 class="author">颜孙通</h2>
                            <div class="publisher">浙江工业大学出版社</div>
                        </div>
                        <div class="book-cover-back"></div>
                    </div>
                    <div class="book-page">
                        <div id="page-1" class="page">
                            <h3>项目：工大 E 书城</h3>
                            <h4>姓名：颜孙通</h4>
                            <hr>
                            <p>前　端：Bootstrap 框架进行布局设计</p>
                            <p>　　|---- 前台：Bootstrap 3</p>
                            <p>　　|---- 后台：Bootstrap 模版框架</p>
                            <p>后　端：Servlet + JSP + JavaBean MVC模式架构</p>
                            <p>数据库：MySQL</p>
                            <p>开　源：已开源在Github上</p>
                            <p>地　址：<a href="https://github.com/Sinton/BookStore">https://github.com/Sinton/BookStore</a></p>
                        </div>
                        <div class="page-number">- 1 -</div>
                    </div>
                    <div class="book-back">
                        <div class="description">
                            <p>"在工大 E 书城 你买不了吃亏，买不了上当，买到就是赚到，快来买~"</p>
                            <p class="txt-right">-- 计算不了机</p>
                        </div>
                        <div class="isbn"><img src="images/isbn.png"></div>
                    </div>
                    <div class="book-bone"><h2></h2></div>
                    <div class="book-top"></div>
                    <div class="book-right"></div>
                    <div class="book-bottom"></div>
                </div>
            </div>
        </div>
        <jsp:include page="public/footer.jsp" />
    </div>
</div>
</body>
</html>