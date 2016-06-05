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
            <div class="panel panel-success" style="margin-top: 10px">
                <div class="panel-heading text-center"><b>购物车列表清单</b></div>
                <div class="alert-warning text-center" style="line-height: 40px;">
                    您还没有登录！登录后购物车的商品将保存到您账号中
                    <a href="login.jsp" class="btn btn-danger btn-xs">立即登录</a>
                </div>
                <!--<div class="panel-body">
                    <div class="bs-callout bs-callout-info" id="callout-scrollspy-needs-nav"></div>
                </div>-->
                <div class="table table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th><input type="checkbox"> 全选</th>
                            <th>商品</th>
                            <th>单价（元）</th>
                            <th>数量</th>
                            <th>小计</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="i" begin="1" end="3">
	                            <tr>
	                                <th align="left" style="line-height:80px;"><input type="checkbox"></th>
	                                <td align="left">
	                                    <img src="img/item_cart.jpg" alt="">
	                                    <b>深入理解Java虚拟机：JVM高级特性与最佳实践（第2版）</b>
	                                </td>
	                                <td align="left" style="line-height:80px;">68.10</td>
	                                <td align="left" style="line-height:80px;">
	                                    <div class="btn-group">
	                                        <a href="#" class="btn btn-default btn-xs disabled"><i class="glyphicon glyphicon-arrow-down"></i></a>
	                                        <a href="#" class="btn btn-default btn-xs disabled">1</a>
	                                        <a href="#" class="btn btn-default btn-xs"><i class="glyphicon glyphicon-arrow-up"></i></a>
	                                    </div>
	                                </td>
	                                <td align="left" style="line-height:80px;">68.10</td>
	                                <td align="left" style="line-height:80px;"><a class="btn btn-danger btn-xs" href="#">删除</a></td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div style="border-top:1px dashed #999;">
                        <div style="line-height: 45px;">
                            <div class="col-sm-5">
                                <a href="#">删除选中的商品</a>
                            </div>
                            <div class="col-sm-5">
                                <div class="col-sm-6">
                                    已选择<b class="text-danger"> 3 </b>件商品
                                </div>
                                <div class="col-sm-6">
                                    总价（不含运费）：<b class="text-danger">￥136.20</b>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <button class="btn btn-danger btn-lg btn-block">去结算</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <h3 class="page-header">猜你喜欢</h3>
            <div class="row">
            	<c:forEach var="i" begin="1" end="4">
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