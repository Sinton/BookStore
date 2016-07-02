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
	<link rel="stylesheet" href="../js/bootstrap/dist/css/bootstrap.css" />
	<link rel="stylesheet" href="../fonts/font-awesome-4/css/font-awesome.min.css">
	<!-- Custom styles for this template -->
	<link rel="stylesheet" type='text/css' href="../css/style.css" />
</head>

<body class="texture">
	<div id="cl-wrapper" class="sign-up-container">
		<div class="middle-sign-up">
			<div class="block-flat">
				<div class="header">
					<h3 class="text-center"><img class="logo-img" src="../images/logo.png" alt="logo"/>后台管理系统</h3>
				</div>
				<div>
					<form style="margin-bottom: 0px !important;" class="form-horizontal" action="__ACTION__" method="POST">
						<div class="content">
							<h5 class="title text-center"><strong>用户注册</strong></h5>
							<hr/>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="text" name="nickname" parsley-trigger="change" parsley-error-container="#nick-error" required placeholder="用户名" class="form-control">
									</div>
									<div id="nick-error"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
										<input type="email" name="email" parsley-trigger="change" parsley-error-container="#email-error" required placeholder="邮箱" class="form-control">
									</div>
									<div id="email-error"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-6 col-xs-6">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock"></i></span>
										<input id="pass1" type="password" name="password" parsley-error-container="#password-error" required placeholder="密码" class="form-control">
									</div>
									<div id="password-error"></div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock"></i></span>
										<input parsley-equalto="#pass1" type="password" name="confirmat_password" parsley-error-container="#confirmation-error" required placeholder="确认密码" class="form-control">
									</div>
									<div id="confirmation-error"></div>
								</div>
							</div>
							<p class="spacer">我已经有帐号了<a href="{:U('User/login')}">立即登录</a></p>
							<button class="btn btn-block btn-success btn-rad btn-lg" type="submit">注册</button>
						</div>
					</form>
				</div>
			</div>
			<div class="text-center out-links">
				<a href="#">&copy; 2015 iwang.com CopyRight</a>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/jquery.parsley/dist/parsley.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/behaviour/general.js" type="text/javascript"></script>
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