<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
            <div class="panel panel-info" style="margin-top: 10px">
                <div class="panel-heading text-center"><b>登录</b></div>
                <div class="panel-body">
                    <div class="col-sm-7">
                        <img src="img/login_baner.png" alt="">
                    </div>
                    <div class="col-sm-5" style="margin-top: 10%;">
                        <form class="form-horizontal" action="login.do" method="post">
                            <div class="form-group">
                                <label for="email" class="col-sm-3 control-label">邮箱</label>
                                <div class="col-sm-9">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="邮箱" required autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-3 control-label">密码</label>

                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="password" name="password" placeholder="密码" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-9">
                                    <label>没有帐号？<a href="register.jsp">立即注册</a></label>
                                    <div class="checkbox">
                                        <label><input type="checkbox">记住密码</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-9">
                                    <button type="submit" class="btn btn-lg btn-primary">立即登录</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="public/footer.jsp" />
    </div>
</div>
</body>
</html>