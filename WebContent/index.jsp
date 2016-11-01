<%@page import="edu.zjut.model.Book"%>
<%@page import="edu.zjut.model.SecondCategory"%>
<%@page import="edu.zjut.model.Category"%>
<%@page import="edu.zjut.dao.impl.BookDaoImpl"%>
<%@page import="edu.zjut.dao.SecondCategoryDao"%>
<%@page import="edu.zjut.dao.CategoryDao"%>
<%@page import="edu.zjut.dao.impl.CategoryDaoImpl"%>
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
        	<%
        		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        		ArrayList<Category> categories = new ArrayList<Category>();
        		categories = categoryDao.getAllCategories();
        		request.getSession().setAttribute("categories", categories);
        	%>
        	<c:forEach items="${categories}" var="category">
        		<div class="panel panel-info nav-sidebar">
	                <div class="panel-heading" role="tab" id="${category.getDesc()}">
	                    <h4 class="panel-title">
	                        <a role="button" data-toggle="collapse" href="#${category.getDesc()}-item" aria-expanded="true" aria-controls="${category.getDesc()}-item"><b>${category.getName()}</b></a>
	                    </h4>
	                </div>
	                <div id="${category.getDesc()}-item" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="${category.getDesc()}" aria-expanded="true">
	                    <ul class="list-group">
	                    	<c:forEach items="${category.getSecondCategories()}" var="secondCategory">
	                    		<li class="list-group-item"><a href="category.do?${secondCategory.getSecondCategoryName()}">${secondCategory.getSecondCategoryName()}</a></li>
	                    	</c:forEach>
	                    </ul>
	                </div>
	            </div>
        	</c:forEach>
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
                                <p> </p>
                                <p><a class="btn btn-lg btn-primary" href="#" role="button">点击查看</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img class="second-slide" src="img/baner_02.jpg" alt="Second slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1><label class="label label-success">新书推荐:二</label></h1>
                                <p> </p>
                                <p><a class="btn btn-lg btn-primary" href="#" role="button">点击查看</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item active">
                        <img class="third-slide" src="img/baner_03.jpg" alt="Third slide">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1><label class="label label-success">新书推荐:三</label></h1>
                                <p> <%-- <code>内容: XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX XXXXX XXXXXXXXXX XXXXXXXXXXXXXX</code> --%></p>
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
            
            <%
            BookDaoImpl bookDao = new BookDaoImpl();
            ArrayList<Book> randbooks_1 = bookDao.getRandBooks();
            request.getSession().setAttribute("randbooks_1", randbooks_1);
            %>
            <h3 class="page-header">1F 新书速递</h3>
            <div class="row">
                <c:forEach items="${randbooks_1}" var="randbook">
	                <div class="col-sm-3">
	                    <div class="thumbnail">
	                    	<a href="item.do?bid=${randbook.getBid()}"><img src="upload/${randbook.getImgUrlMid()}" alt=""></a>
	                        <div class="caption">
	                            <h5><a href="item.do?bid=${randbook.getBid()}">${randbook.getName()}</a></h5>
	                            <p><label class="label label-danger">¥${randbook.getPrice()* randbook.getDiscount() * 0.1 }</label></p>
	                            <span>${randbook.getAuthor()}</span><br>
	                            <span>${randbook.getPublishing()}</span><br>
	                            <span>${randbook.getPublishTime()}</span>
	                        </div>
	                    </div>
	                </div>
	            </c:forEach>
            </div>
            <%
            ArrayList<Book> randbooks_2 = bookDao.getRandBooks();
            request.getSession().setAttribute("randbooks_2", randbooks_2);
            %>
            <h3 class="page-header">2F 丛书推荐</h3>
            <div class="row">
                <c:forEach items="${randbooks_2}" var="randbook">
	                <div class="col-sm-3">
	                    <div class="thumbnail">
	                    	<a href="item.do?bid=${randbook.getBid()}"><img src="upload/${randbook.getImgUrlMid()}" alt=""></a>
	                        <div class="caption">
	                            <h5><a href="item.do?bid=${randbook.getBid()}">${randbook.getName()}</a></h5>
	                            <p><label class="label label-danger">¥${randbook.getPrice()* randbook.getDiscount() * 0.1 }</label></p>
	                            <span>${randbook.getAuthor()}</span><br>
	                            <span>${randbook.getPublishing()}</span><br>
	                            <span>${randbook.getPublishTime()}</span>
	                        </div>
	                    </div>
	                </div>
	            </c:forEach>
            </div>
            
            <%
            ArrayList<Book> randbooks_3 = bookDao.getRandBooks();
            request.getSession().setAttribute("randbooks_3", randbooks_3);
            %>
            <h3 class="page-header">3F 畅销经典</h3>
            <div class="row">
            	<c:forEach items="${randbooks_3}" var="randbook">
	                <div class="col-sm-3">
	                    <div class="thumbnail">
	                    	<a href="item.do?bid=${randbook.getBid()}"><img src="upload/${randbook.getImgUrlMid()}" alt=""></a>
	                        <div class="caption">
	                            <h5><a href="item.do?bid=${randbook.getBid()}">${randbook.getName()}</a></h5>
	                            <p><label class="label label-danger">¥${randbook.getPrice()* randbook.getDiscount() * 0.1 }</label></p>
	                            <span>${randbook.getAuthor()}</span><br>
	                            <span>${randbook.getPublishing()}</span><br>
	                            <span>${randbook.getPublishTime()}</span>
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