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
        	<c:forEach items="${orders}" var="order">
				<div class="panel panel-info" style="margin-top: 10px">
			        <div class="panel-heading" role="tab" id="${order.getOrderId()}">
			            <h4 class="panel-title">
			                <a role="button" data-toggle="collapse" href="#${order.getOrderId()}-item" aria-expanded="true" aria-controls="${order.getOrderId()}-item"><b>订单编号：${order.getOrderSeq()}</b></a>
			            </h4>
			        </div>
			        <div id="${order.getOrderId()}-item" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="${order.getOrderId()}" aria-expanded="true">
		            		<div class="table table-responsive">
			                    <table class="table table-striped">
			                        <thead>
			                        <tr>
			                            <th> </th>
			                            <th>商品</th>
			                            <th>单价（元）</th>
			                            <th>数量</th>
			                            <th>小计</th>
			                        </tr>
			                        </thead>
			                        <tbody>
										<c:forEach items="${order.getOrderItems()}" var="orderItem">
				                            <tr>
				                                <th align="left" style="line-height:80px;"> </th>
				                                <td align="left">
				                                    <img src="upload/${orderItem.getBook().getImgUrlSmall()}" alt="">
				                                    <b>${orderItem.getBook().getName()}</b>
				                                </td>
				                                <td align="left" style="line-height:80px;">${orderItem.getBook().getPrice() * orderItem.getBook().getDiscount() * 0.1}</td>
				                                <td align="left" style="line-height:80px;">
				                                    <div class="btn-group">
				                                        <a href="#" class="btn btn-default btn-xs disabled">${orderItem.getAmount()}</a>
				                                    </div>
				                                </td>
				                                <td align="left" style="line-height:80px;">${orderItem.getBook().getPrice() * orderItem.getBook().getDiscount() * 0.1 * orderItem.getAmount()}</td>
				                            </tr>
			                            </c:forEach>
			                        </tbody>
			                    </table>
			                    <div style="border-top:1px dashed #999;">
		                            <div class="col-sm-6" style="margin-top:2px;">
		                            	<c:choose>
			                            	<c:when test="${order.getStatus() eq 1}">
			                            		<div align="left" style="line-height:40px;"><a class="btn btn-danger btn-xs" href="order.do?action=pay&orderSeq=${order.getOrderSeq()}">付款</a></div>
			                            	</c:when>
			                            	<c:when test="${order.getStatus() eq 2}">
			                            		<div align="left" style="line-height:40px;"><label class="label label-info">已付款，等待卖家发货</label></div>
			                            	</c:when>
			                            	<c:when test="${order.getStatus() eq 3}">
			                            		<div align="left" style="line-height:40px;"><a class="btn btn-warning btn-xs" href="order.do?action=sure&orderSeq=${order.getOrderSeq()}">确认</a></div>
			                            	</c:when>
			                            	<c:otherwise>
			                            		<div align="left" style="line-height:40px;"><label class="label label-success">交易成功</label></div>
			                            	</c:otherwise>
			                            </c:choose>
		                            </div>
			                    </div>
		                    </div>
			        </div>
			    </div>
			</c:forEach>
        </div>
        <jsp:include page="public/footer.jsp" />
    </div>
</div>
</body>
</html>