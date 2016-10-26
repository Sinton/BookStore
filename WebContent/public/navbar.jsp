<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">菜单</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="nav navbar-brand" href="./index.jsp"><p style="color: #e3e3e3"><img src="favicon.ico" alt="" width="25px"> 工大E书城</p></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.jsp">主页</a></li>
                <c:if test="${empty user}">
	                <li><a href="login.jsp">登录</a></li>
	                <li><a href="register.jsp">注册</a></li>
                </c:if>
                <c:if test="${!empty user}">
				<li role="presentation" class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						${user.getEmail()}<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="cart.jsp"><i class="glyphicon glyphicon-shopping-cart"></i> 我的购物车</a></li>
						<li><a href="order.do"><i class="glyphicon glyphicon-bookmark"></i> 我的订单</a></li>
						<li><a href="logout.do"><i class="glyphicon glyphicon-log-out"></i> 退出</a></li>
					</ul>
				</li>
				</c:if>
                <li><a href="about.jsp">关于</a></li>
            </ul>
            <form class="navbar-form navbar-right" action="search.do" method="post">
                <input type="text" class="form-control" placeholder="搜索书籍" name="search">
            </form>
        </div>
    </div>
</nav>