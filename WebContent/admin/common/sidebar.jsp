<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="cl-sidebar" data-position="right" data-step="1" data-intro="管理菜单">
    <div class="cl-toggle"><i class="fa fa-bars"></i></div>
    <div class="cl-navblock">
        <div class="menu-space">
            <div class="content">
                <div class="side-user">
                    <div class="avatar">
                        <img src="images/avatar1_50.jpg" alt="头像" />
                    </div>
                    <div class="info">
                    	<a href="#">计算不了机</a>
                        <img src="images/state_online.png" alt="状态" /><span>在线</span>
                    </div>
                </div>
                <ul class="cl-vnavigation">
                	<li>
                    	<a href=""><i class="fa fa-home"></i><span>站点管理</span></a>
                        <ul class="sub-menu">
                            <li><a href="">基本信息</a></li>
                            <li><a href="#">服务管理</a></li>
                        </ul>
                    </li>
                    <li>
                    	<a href=""><i class="fa fa-bar-chart-o"></i><span>统计分析</span></a>
                        <ul class="sub-menu">
                            <li><a href="#">统计<span class="label label-success pull-right">以后开发</span></a></li>
                            <li><a href="#">分析<span class="label label-success pull-right">以后开发</span></a></li>
                        </ul>
                    </li>
                    <li>
                    	<a href=""><i class="fa fa-users"></i><span>用户管理</span></a>
                        <ul class="sub-menu">
                        	<li><a href="{:U('User/user')}">用户列表<span class="label label-success pull-right">正在开发</span></a></li>
                        	<li><a href="{:U('User/admin')}">管理员列表<span class="label label-success pull-right">正在开发</span></a></li>
                            <li><a href="user.do">用户列表</a></li>
                        </ul>
                    </li>
                    <li>
                    	<a href=""><i class="fa fa-book"></i><span>书籍管理</span></a>
                        <ul class="sub-menu">
                        	<li><a href="book.do">书籍列表</a></li>
                            <li><a href="category.do">书籍类别</a></li>
                        </ul>
                    </li>
                    <li>
                    	<a href=""><i class="fa fa-file-text"></i><span>专题管理</span></a>
                        <ul class="sub-menu">
                            <li><a href="subject.do')}">专题管理</a></li>
                        </ul>
                    </li>
                    <li>
                    	<a href=""><i class="fa fa-flask"></i><span>运营管理</span></a>
                        <ul class="sub-menu">
                            <li><a href="#">运营管理</a></li>
                        </ul>
                    </li>
                    <li>
                    	<a href=""><i class="fa fa-link"></i><span>友链管理</span></a>
                        <ul class="sub-menu">
                            <li><a href="#">友链管理</a></li>
                        </ul>
                    </li>
                    <li>
                    	<a href=""><i class="fa fa-bullhorn"></i><span>消息公告</span></a>
                    	<a href=""><i class="fa fa-flask"></i><span>订单管理</span></a>
                        <ul class="sub-menu">
                        	<li><a href="#">公告列表</a></li>
                        	<li><a href="#">发布公告</a></li>
                            <li><a href="order.do">订单列表</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="text-right collapse-button" style="padding:7px 9px;">
            <button id="sidebar-collapse" class="btn btn-default">
            	<i style="color:#fff;" class="fa fa-angle-left"></i>
            </button>
        </div>
    </div>
</div>