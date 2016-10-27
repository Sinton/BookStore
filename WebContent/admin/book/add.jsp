<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>后台管理系统</title>
    <link rel="shortcut icon" href="images/favicon.png" />
    <link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800' />
    <link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?family=Raleway:300,200,100' />
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="js/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4/css/font-awesome.min.css" />
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
    <link rel="stylesheet" type="text/css" href="js/jquery.icheck/skins/square/blue.css" />
    <link rel="stylesheet" type="text/css" href="js/bootstrap.multiselect/css/bootstrap-multiselect.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery.multiselect/css/multi-select.css" />
    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="js/jquery.uploadify/uploadify.css"/>
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
					    		<h3>添加新书籍</h3>
						    </div>
						    <div class="content">
						        <form class="form-horizontal group-border-dashed" action="book.do?action=create" method="post">
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">书籍名称</label>
						                <div class="col-sm-6 col-md-6">
						                    <input type="text" name="name" class="form-control">
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">书籍作者</label>
						                <div class="col-sm-6 col-md-6">
						                    <input type="text" name="author" class="form-control">
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">价格</label>
						                <div class="col-sm-6 col-md-6">
						                    <input type="text" name="price" class="form-control">
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">折扣</label>
						                <div class="col-sm-6 col-md-6">
						                    <input type="text" name="discount" class="form-control">
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">出版社</label>
						                <div class="col-sm-6 col-md-6">
						                    <input type="text" name="publishing" class="form-control">
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">出版时间</label>
						                <div class="col-sm-6 col-md-6">
						                    <input type="text" name="poublishtime" class="form-control">
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">版次</label>
						                <div class="col-sm-6 col-md-6">
						                    <input type="text" name="edition" class="form-control">
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">页数</label>
						                <div class="col-sm-6 col-md-6">
						                    <input type="text" name="pagenum" class="form-control">
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">ISNB</label>
						                <div class="col-sm-6 col-md-6">
						                    <input type="text" name="isnb" class="form-control">
						                </div>
						            </div>
						            <!-- <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">小图</label>
						                <div class="col-sm-6 col-md-6">
						                	<input type="file" class="form-control" name="imgUrlSmall" id="imgUrlSmall" >
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">中图</label>
						                <div class="col-sm-6 col-md-6">
						                	<input type="file" class="form-control" name="imgUrlMid" id="imgUrlMid" >
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">大图</label>
						                <div class="col-sm-6 col-md-6">
						                	<input type="file" class="form-control" name="imgUrlBig" id="imgUrlBig" >
						                </div>
						            </div> -->
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">书籍一级类别</label>
						                <div class="col-sm-6 col-md-6">
						                    <div class="input-group btn-group">	<span class="input-group-addon"><i class="fa fa-tag"></i></span>
						                        <select id="categories" class="form-control" name="category">
						                            <c:forEach items="${categories}" var="category">
						                                <option value="${category.getCategoryId()}">${category.getName()}</option>
						                            </c:forEach>
						                        </select>
						                    </div>
						                </div>
						            </div>
						            <div class="form-group">
						                <label class="col-sm-2 col-md-2 control-label">书籍二级类别</label>
						                <div class="col-sm-6 col-md-6">
						                    <div class="input-group btn-group">	<span class="input-group-addon"><i class="fa fa-tag"></i></span>
						                        <select id="secondCategories" class="form-control" name="secondCategory">
						                            <c:forEach items="${secondCategories}" var="secondCategory">
						                                <option value="${secondCategory.getSecondCategoryId()}">${secondCategory.getSecondCategoryName()}</option>
						                            </c:forEach>
						                        </select>
						                    </div>
						                </div>
						            </div>
						            <div class="form-group">
						                <div class="pull-right">
						                    <button type="submit" class="btn btn-success">添加</button>
						                    <button type="reset" class="btn btn-default">重置</button>
						                </div>
						            </div>
						        </form>
						    </div>
						</div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.select2/select2.min.js"></script>
    <script type="text/javascript" src="js/jquery.parsley/dist/parsley.js"></script>
    <script type="text/javascript" src="js/bootstrap.slider/js/bootstrap-slider.js"></script>
    <script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
    <script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
    <script type="text/javascript" src="js/behaviour/general.js"></script>
    <script type="text/javascript" src="js/jquery.ui/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.multiselect/js/bootstrap-multiselect.js"></script>
    <script type="text/javascript" src="js/jquery.multiselect/js/jquery.multi-select.js"></script>
    <script type="text/javascript" src="js/jquery.uploadify/jquery.uploadify.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            //initialize the javascript
            App.init();
            $('#categories').multiselect({
                enableFiltering: true,
                maxHeight: 200,
                filterPlaceholder: '搜索',
            });
            $('#secondCategories').multiselect({
                enableFiltering: true,
                maxHeight: 200,
                filterPlaceholder: '搜索',
            });
        });
    </script>
    <!-- Bootstrap core JavaScript -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="js/behaviour/voice-commands.js"></script>
    <script type="text/javascript" src="js/bootstrap/dist/js/bootstrap.min.js"></script>
</body>

</html>