<%@page import="edu.zjut.model.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../images/favicon.png">
    <title>Clean Zone</title>
    <link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800'>
    <link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?family=Raleway:300,200,100'>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="js/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4/css/font-awesome.min.css">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
    <link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
    <link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
    <link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery.niftymodals/css/component.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery.icheck/skins/square/blue.css" />
    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
    <!-- Fixed navbar -->
    <jsp:include page="../common/navbar.jsp" />
    <div id="cl-wrapper" class="fixed-menu">
        <!-- Fixed silder -->
        <jsp:include page="../common/sidebar.jsp" />
        <div class="container-fluid" id="pcont">
            <div class="cl-mcont">
                <div class="row">
                    <div class="col-sm-12 col-md-12">
                        <div class="block-flat">
                            <div class="header">
                            	<div class="row">
	                            	<div class="col-sm-12 col-md-12">
		                            	<div class="pull-left"><h3>订单列表</h3></div>
	                            	</div>
                            	</div>
	                        </div>
                            <div class="content">
                                <table class="no-border">
                                    <thead class="no-border">
                                        <tr>
                                            <th style="width:2%;">
                                                <input class="icheck" id="check-all" type="checkbox" name="checkall">
                                            </th>
                                            <th class="text-center" style="width:3%;"><strong>订单ID</strong></th>
                                            <th class="text-center" style="width:9%;"><strong>订单序列号</strong></th>
                                            <th class="text-center" style="width:8%;"><strong>下单时间</strong></th>
                                            <th class="text-center" style="width:8%;"><strong>总价</strong></th>
                                            <th class="text-center" style="width:8%;"><strong>交易状态</strong></th>
                                            <th class="text-center" style="width:5%;"><strong>操作</strong></th>
                                        </tr>
                                    </thead>
                                    <tbody class="no-border-y">
                                    	<c:forEach items="${orders}" var="order">
	                                        <tr>
	                                            <td><input type="checkbox" class="icheck"></td>
	                                            <td class="text-center">${order.getOrderId()}</td>
	                                            <td class="text-center">${order.getOrderSeq()}</td>
	                                            <td class="text-center">${order.getDate()}</td>
	                                            <td class="text-center">${order.getTotalPrice()}</td>
	                                            <td class="text-center">
	                                            	<c:choose>
						                            	<c:when test="${order.getStatus() eq 1}">
						                            		<span class="badge badge-defalut">未付款，等待用户付款</span>
						                            	</c:when>
						                            	<c:when test="${order.getStatus() eq 2}">
						                            		<span class="badge badge-info">已付款，准备发货</span>
						                            	</c:when>
						                            	<c:when test="${order.getStatus() eq 3}">
						                            		<span class="badge badge-primary">已发货，等待用户确认</span>
						                            	</c:when>
						                            	<c:otherwise>
						                            		<span class="badge badge-success">交易成功</span>
						                            	</c:otherwise>
						                            </c:choose>
	                                            </td>
	                                            <td class="text-center">
	                                                <div class="btn-group">
	                                                    <button type="button" class="btn btn-primary dropdown-toggle btn-xs" data-toggle="dropdown">
	                                                    	<i class="fa fa-pencil fa-lg"></i>编辑
	                                                    	<span class="caret"></span>
	                                                        <span class="sr-only"></span>
	                                                    </button>
	                                                    <ul class="dropdown-menu" role="menu">
	                                                        <li><a href="order.do?action=detail&orderSeq=${order.getOrderSeq()}"><i class="fa fa-eye"></i>查看并修改订单</a></li>
	                                                        <li class="divider"></li>
	                                                        <li class="delete" data-modal="colored-danger"><a href="order.do?action=delete&orderId=${order.getOrderId()}"><i class="fa fa-times"></i>删除该订单</a></li>
	                                                    </ul>
	                                                </div>
	                                            </td>
	                                        </tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<jsp:include page="../common/modal.jsp" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
    <script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
    <script type="text/javascript" src="js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
    <script type="text/javascript" src="js/behaviour/general.js"></script>
    <script type="text/javascript" src="js/jquery.ui/jquery-ui.js"></script>
    <script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
    <script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="js/jquery.select2/select2.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.slider/js/bootstrap-slider.js"></script>
    <script type="text/javascript" src="js/jquery.gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
    <script type="text/javascript" src="js/jquery.niftymodals/js/jquery.modalEffects.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            //initialize the javascript
            App.init();
            $("#check-all").on('ifChanged', function() {
                var checkboxes = $(".no-border-y").find(':checkbox');
                if ($(this).is(':checked')) {
                    checkboxes.iCheck('check');
                } else {
                    checkboxes.iCheck('uncheck');
                }
            });
            // ajax异步删除指定书籍
            var id, cols;
            $('.delete').click( function() {
            	id = $(this).closest('tr').children(':eq(1)').text();
            });
            
            $('.modal-footer>button.btn-danger').click( function() {
            	console.log($('tbody>tr:eq(' + (id-1) + ') :eq(5)'));
            	/* $.ajax({
            		url: 'book.do?action=ajaxDeleteBook',
            		type: 'POST',
            		dataType: 'json',
            		data: {'id' : id}
            	})
            	.done(function(result) {
            		if(1 == result.code) {
	        			console.log("删除成功");
            		}
            		else
            			console.log(result.data);
        		})
        		.fail(function() {
        			console.log("error");
        		}); */
            });
        });
    </script>
    <!-- Bootstrap core JavaScript -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="js/behaviour/voice-commands.js"></script>
    <script type="text/javascript" src="js/bootstrap/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
    <script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
    <script type="text/javascript" src="js/jquery.flot/jquery.flot.resize.js"></script>
    <script type="text/javascript" src="js/jquery.flot/jquery.flot.labels.js"></script>
</body>

</html>