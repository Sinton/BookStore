<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="head-nav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            	<span class="fa fa-gear"></span>
            </button>
            <a class="navbar-brand" href="__ACTION__"><span>{$Think.const.IWANG_ADMIN_NAME}</span></a>
        </div>
        <div class="navbar-collapse collapse">
            <!-- <ul class="nav navbar-nav">
                <li class="active"><a href="__ACTION__">首页</a></li>
                <li><a href="#about">关于</a></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">联系<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="dropdown-submenu"><a href="#">Sub menu</a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                	<a href="#" class="dropdown-toggle" data-toggle="dropdown">XXXX<b class="caret"></b></a>
                    <ul class="dropdown-menu col-menu-2">
                        <li class="col-sm-6 no-padding">
                            <ul>
                                <li class="dropdown-header"><i class="fa fa-group"></i>XXXX</li>
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="dropdown-header"><i class="fa fa-gear"></i>XXXXX</li>
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li class="col-sm-6 no-padding">
                            <ul>
                                <li class="dropdown-header"><i class="fa fa-legal"></i>XXXX</li>
                                <li><a href="#">New sale</a></li>
                                <li><a href="#">Register a product</a></li>
                                <li><a href="#">Register a client</a></li>
                                <li><a href="#">Month sales</a></li>
                                <li><a href="#">Delivered orders</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul> -->
            <ul class="nav navbar-nav navbar-right user-nav">
                <li class="dropdown profile_menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img alt="Avatar" src="images/avatar2.jpg" />
                        <span>计算不了机</span><b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><i class="fa fa-user"></i> 我的资料</a></li>
                        <li><a href="#"><i class="fa fa-cog"></i> 设置</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-power-off"></i> 注销</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>