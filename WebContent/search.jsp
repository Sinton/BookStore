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
            <ol class="breadcrumb" style="margin-top: 10px;">
                <li><a href="#">${search}</a></li>
            </ol>
        </div>
        <div class="col-sm-12 col-md-12">
            <div class="panel panel-success">
                <div class="panel-heading">　</div>
                <!-- <div class="panel-body">
                    <div class="bs-callout bs-callout-info" id="callout-scrollspy-needs-nav"></div>
                </div> -->
                <div class="table table-responsive">
                    <table class="table table-striped table-condensed">
                        <tr>
                            <th><label class="label label-success">出版社：</label></th>
                            <c:forEach items="${publishs}" var="publish">
                            	<td align="left"><label class="control-label"><a href="category.do?search=publish&publish=${publish}">${publish}</a></label></td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <th><label class="label label-success">价格：</label></th>
                            <c:forEach items="${priceRanges}" var="priceRange">
                            	<td align="left"><label class="control-label"><a href="category.do?search=priceRange&priceRange=${priceRange}">${priceRange}</a></label></td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <th><label class="label label-success">折扣：</label></th>
                            <c:forEach items="${discounts}" var="discount">
                            	<td align="left"><label class="control-label"><a href="category.do?search=discount&discount=${discount}">${discount}</a></label></td>
                            </c:forEach>
                            <td align="left" colspan="2"></td>
                        </tr>
                    </table>
                     <div style="text-align:center;margin-right:10px;border-top:1px dashed  #999;line-height:30px;">
                        <div class="text-warning">对书籍进行进一步筛选</div>
                    </div>
                </div>
            </div>
        </div><div class="col-sm-12 col-md-12">
        	<c:forEach items="${books}" var="book">
	            <div class="col-sm-3">
	                <div class="thumbnail">
	                    <a href="item.do?bid=${book.getBid()}"><img src="img/item.jpg" alt="${book.getName()}"></a>
	                    <div class="caption">
	                        <h4 style="color: #c9302c">¥${book.getPrice() * book.getDiscount() * 0.1}</h4>
	                        <!-- <h6>已有评价 <label class="label label-info">9140个</label></h6> -->
	                        <h5><a href="item.do?bid=${book.getBid()}">${book.getName()}</a></h5>
	                        <!-- <button class="btn btn-default" style="color: #c9302c"><span class="glyphicon glyphicon-star-empty"></span>关注</button> -->
	                        <a href="cart.do?bid=${book.getBid()}" class="btn btn-default" style="color: #c9302c"><span class="glyphicon glyphicon-shopping-cart"></span> 加入购物车</a><br>
	                        <span>${book.getAuthor()}</span><br>
	                        <span>${book.getPublishing()}</span><br>
	                        <span>${book.getPublishTime()}</span>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
        </div>
        <div class="col-sm-offset-4 col-sm-6">
            <ul class="pagination pagination-sm">
                <li class="first disabled"><a href="#"><span class="glyphicon glyphicon-step-backward"></span>首页</a></li>
                <li class="prev disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span> 上一页</a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li class="next"><a href="#">下一页 <span class="glyphicon glyphicon-chevron-right"></span></a></li>
                <li class="last"><a href="#">尾页 <span class="glyphicon glyphicon-step-forward"></span></a></li>
            </ul>
        </div>
        <jsp:include page="public/footer.jsp" />
    </div>
</div>
</body>
</html>