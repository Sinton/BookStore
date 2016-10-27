<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
    <!-- Fixed navbar -->
    <jsp:include page="common/navbar.jsp" />
    <div id="cl-wrapper" class="fixed-menu">
	    <!-- Fixed silder -->
	    <jsp:include page="common/sidebar.jsp" />
        <div class="container-fluid" id="pcont">
            <div class="cl-mcont">
                <div class="row">
                    <div class="col-sm-12 col-md-12">
                        <div class="block-flat">
                            <div class="header">
                                <h3>系统信息</h3>
                            </div>
                            <div class="content">
                                <table class="no-border">
                                    <tbody class="no-border-x no-border-y">
                                        <tr>
                                            <td style="width:30%;">管理系统版本</td>
                                            <td>v_1.0</td>
                                        </tr>
                                        <tr>
                                            <td style="width:30%;">服务器操作系统</td>
                                            <td>WINNT</td>
                                        </tr>
                                        <tr>
                                            <td style="width:30%;">运行环境</td>
                                            <td>Tomcat</td>
                                        </tr>
                                        <tr>
                                            <td style="width:30%;">数据库版本</td>
                                            <td>{$system_info_mysql.0.version}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-6">
                        <div class="block-flat">
                            <div class="header">
                                <h3>产品团队</h3>
                            </div>
                            <div class="content">
                                <table class="no-border">
                                    <tbody class="no-border-x no-border-y">
                                        <tr>
                                            <td style="width:30%;">总策划</td>
                                            <td>测试</td>
                                        </tr>
                                        <tr>
                                            <td style="width:30%;">产品设计及研发团队</td>
                                            <td>测试</td>
                                        </tr>
                                        <tr>
                                            <td style="width:30%;">界面及用户体验团队</td>
                                            <td>测试</td>
                                        </tr>
                                        <tr>
                                            <td style="width:30%;">官方网址</td>
                                            <td><a href="http://www.iwang.com" target="_blank">www.iwang.com</a></td>
                                        </tr>
                                        <tr>
                                            <td style="width:30%;">官方QQ群</td>
                                            <td>
                                            	<a href="http://wp.qq.com/wpa/qunwpa?idkey=#" target="_blank">
                                            		<img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="iwang游戏交流" title="iwang交流">
                                            	</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width:30%;">BUG反馈</td>
                                            <td><a href="http://www.iwang.com" target="_blank">iwang讨论区</a></td>
                                            <td>MySQL 5.5</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
    <script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
    <script type="text/javascript" src="js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
    <script type="text/javascript" src="js/behaviour/general.js"></script>
    <script type="text/javascript" src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
    <script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="js/jquery.select2/select2.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.slider/js/bootstrap-slider.js"></script>
    <script type="text/javascript" src="js/jquery.gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            //initialize the javascript
            App.init();
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