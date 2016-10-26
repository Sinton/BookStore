<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>后台管理系统</title>
	<link rel="shortcut icon" href="../images/favicon.png">
	<link rel='stylesheet' type='text/css' href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800' />
	<link rel='stylesheet' type='text/css' href='http://fonts.googleapis.com/css?family=Raleway:300,200,100' />
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" type='text/css' href="../js/bootstrap/dist/css/bootstrap.css">
	<link rel="stylesheet" type='text/css' href="../fonts/font-awesome-4/css/font-awesome.min.css">
	<!-- Custom styles for this template -->
	<link rel="stylesheet" type='text/css' href="../css/style.css" />
</head>

<body class="texture">
	<div id="cl-wrapper" class="login-container">
		<div class="middle-login">
			<div class="block-flat">
				<div class="header">
					<h3 class="text-center"><img class="logo-img" src="../images/logo.png" alt="logo"/>后台管理系统</h3>
				</div>
				<div>
					<form style="margin-bottom: 0px !important;" class="form-horizontal" action="/BookStore/admin/login.do" method="post">
						<div class="content">
							<h5 class="title text-center"><strong>登录</strong></h5>
							<hr/>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="email" name="email" placeholder="邮箱" id="email" class="form-control">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock"></i></span>
										<input type="password" name="password" placeholder="密码" id="password" class="form-control">
									</div>
								</div>
							</div>
						</div>
						<div class="foot">
							<a href="../../admin/index.jsp" class="btn btn-primary" >登录</a>
							<a href="#" class="btn btn-warning">忘记密码</a>
						</div>
					</form>
				</div>
			</div>
			<div class="text-center out-links">
				<a href="#">计算不了机 &copy; 2016 All Rights Reserved.</a>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/behaviour/general.js"></script>
	<!-- Bootstrap core JavaScript -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="../js/behaviour/voice-commands.js"></script>
	<script type="text/javascript" src="../js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/jquery.flot/jquery.flot.js"></script>
	<script type="text/javascript" src="../js/jquery.flot/jquery.flot.pie.js"></script>
	<script type="text/javascript" src="../js/jquery.flot/jquery.flot.resize.js"></script>
	<script type="text/javascript" src="../js/jquery.flot/jquery.flot.labels.js"></script>
</body>
</html>