<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/favicon.png">
    <title>Clean Zone</title>
    <!-- <link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?family=Raleway:300,200,100' rel='stylesheet' type='text/css'> -->
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="js/bootstrap/dist/css/bootstrap.css">
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
    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
    <!-- Fixed navbar -->
    <include file="Public/navbar" />
    <div id="cl-wrapper" class="fixed-menu">
        <!-- Fixed silder -->
        <include file="Public/sidebar" />
        <div class="container-fluid" id="pcont">
            <div class="page-head">
                <h2>站点管理</h2>
                <ol class="breadcrumb">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">用户管理</a></li>
                    <li class="active">用户列表</li>
                </ol>
            </div>
            <div class="cl-mcont">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="block-flat profile-info">
                            <div class="row">
                                <div class="col-sm-2">
                                    <div class="avatar">
                                        <img src="images/av.jpg" class="profile-avatar" />
                                    </div>
                                </div>
                                <div class="col-sm-7">
                                    <div class="personal">
                                        <h1 class="name">Johnny Depp</h1>
                                        <p class="description">I am a web developer and desginer based in Medellín - Colombia, I like read books, good music and nature.
                                        <p>
                                        <button class="btn btn-primary btn-flat btn-rad" data-modal="reply-ticket"><i class="fa fa-check"></i> Following</button>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <table class="no-border no-strip skills">
                                        <tbody class="no-border-x no-border-y">
                                            <tr>
                                                <td style="width:45%;">Photoshop</td>
                                                <td>
                                                    <div class="progress">
                                                        <div style="width: 80%" class="progress-bar progress-bar-info"></div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>JavaScript</td>
                                                <td>
                                                    <div class="progress">
                                                        <div style="width: 70%" class="progress-bar progress-bar-info"></div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>HTML</td>
                                                <td>
                                                    <div class="progress">
                                                        <div style="width: 50%" class="progress-bar progress-bar-info"></div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>CSS</td>
                                                <td>
                                                    <div class="progress">
                                                        <div style="width: 40%" class="progress-bar progress-bar-info"></div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-8">
                        <div class="tab-container">
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#home">Information</a>
                                </li>
                                <li><a data-toggle="tab" href="#friends">Friends</a>
                                </li>
                                <li><a data-toggle="tab" href="#settings">Settings</a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div id="home" class="tab-pane active cont">
                                    <table class="no-border no-strip information">
                                        <tbody class="no-border-x no-border-y">
                                            <tr>
                                                <td style="width:20%;" class="category"><strong>CONTACT</strong>
                                                </td>
                                                <td>
                                                    <table class="no-border no-strip skills">
                                                        <tbody class="no-border-x no-border-y">
                                                            <tr>
                                                                <td style="width:20%;"><b>Website</b>
                                                                </td>
                                                                <td>www.website.com</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="width:20%;"><b>E-mail</b>
                                                                </td>
                                                                <td>johnny@example.com</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="width:20%;"><b>Mobile</b>
                                                                </td>
                                                                <td>(999) 999-9999</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="width:20%;"><b>Location</b>
                                                                </td>
                                                                <td>Montreal, Canada</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="category"><strong>ABOUT ME</strong>
                                                </td>
                                                <td>
                                                    <p>I am a web developer and desginer based in Medellín - Colombia, I like read books, good music and nature.</p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="category"><strong>SOCIAL</strong>
                                                </td>
                                                <td>
                                                    <button class="btn btn-default btn-flat btn-facebook bg" type="button"><i class="fa fa-facebook"></i>  <span>Facebook</span>
                                                    </button>
                                                    <button class="btn btn-default btn-flat btn-twitter bg" type="button"><i class="fa fa-twitter"></i>  <span>Twitter</span>
                                                    </button>
                                                    <button class="btn btn-default btn-flat btn-google-plus bg" type="button"><i class="fa fa-google-plus"></i>  <span>Google+</span>
                                                    </button>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div id="friends" class="tab-pane cont">
                                    <div class="btn-group pull-right">
                                        <button type="button" class="btn btn-sm btn-flat btn-default"><i class="fa fa-angle-left"></i>
                                        </button>
                                        <button type="button" class="btn btn-sm btn-flat btn-default"><i class="fa fa-angle-right"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group pull-right">
                                        <button type="button" class="btn btn-sm btn-flat btn-default dropdown-toggle" data-toggle="dropdown">Order by <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Asc</a>
                                            </li>
                                            <li><a href="#">Desc</a>
                                            </li>
                                            <li><a href="#">Email</a>
                                            </li>
                                            <li class="divider"></li>
                                            <li><a href="#">Birthday</a>
                                            </li>
                                        </ul>
                                    </div>
                                    <h3 class="widget-title">My Friends</h3>
                                    <div class="row friends-list">
                                        <div class="col-sm-6 col-md-4">
                                            <div class="friend-widget">
                                                <img src="images/avatars/avatar1.jpg" />
                                                <h4>Andrea Smith</h4>
                                                <p>Work</p>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-4">
                                            <div class="friend-widget">
                                                <img src="images/avatars/avatar2.jpg" />
                                                <h4>Jeff Hanneman</h4>
                                                <p>Family</p>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-4">
                                            <div class="friend-widget">
                                                <img src="images/avatar1_50.jpg" />
                                                <h4>Jeff Hanneman</h4>
                                                <p>Friends</p>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-4">
                                            <div class="friend-widget">
                                                <img src="images/avatar3_50.jpg" />
                                                <h4>Andrea Smith</h4>
                                                <p>Work</p>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-4">
                                            <div class="friend-widget">
                                                <img src="images/avatar4_50.jpg" />
                                                <h4>Jeff Hanneman</h4>
                                                <p>Work</p>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-4">
                                            <div class="friend-widget">
                                                <img src="images/avatars/avatar2.jpg" />
                                                <h4>Jeff Hanneman</h4>
                                                <p>Work</p>
                                            </div>
                                        </div>
                                    </div>
                                    </p>
                                </div>
                                <div id="settings" class="tab-pane">
                                    <form role="form" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label" for="nick">Avatar</label>
                                            <div class="col-sm-9">
                                                <div class="avatar-upload">
                                                    <img src="images/av.jpg" class="profile-avatar img-thumbnail" />
                                                    <input id="fileupload" type="file" name="files[]">
                                                    <div id="progress" class="overlay"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label" for="nick">Nick</label>
                                            <div class="col-sm-9">
                                                <input type="email" placeholder="Your Nickname" id="nick" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label" for="name">Name</label>
                                            <div class="col-sm-9">
                                                <input type="email" placeholder="Your Name" id="name" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label" for="inputEmail3">Email</label>
                                            <div class="col-sm-9">
                                                <input type="email" placeholder="Email" id="inputEmail3" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group spacer2">
                                            <div class="col-sm-3"></div>
                                            <label class="col-sm-9" for="inputPassword3">Change Password</label>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label" for="inputPassword3">Password</label>
                                            <div class="col-sm-9">
                                                <input type="password" placeholder="Password" id="inputPassword3" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label" for="inputPassword4">Repeat Password</label>
                                            <div class="col-sm-9">
                                                <input type="password" placeholder="Password" id="inputPassword4" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <button class="btn btn-primary" type="submit">Update</button>
                                                <button class="btn btn-default">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                    <div id="crop-image" class="md-modal colored-header md-effect-1">
                                        <div class="md-content">
                                            <div class="modal-header">
                                                <h3>Crop Image</h3>
                                                <button aria-hidden="true" data-dismiss="modal" class="close md-close" type="button">×</button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="text-center crop-image"></div>
                                                <form action="http://condorthemes.com/cleanzone/crop.php" method="post" onsubmit="return checkCoords();">
                                                    <input type="hidden" id="x" name="x" />
                                                    <input type="hidden" id="y" name="y" />
                                                    <input type="hidden" id="w" name="w" />
                                                    <input type="hidden" id="h" name="h" />
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button data-dismiss="modal" class="btn btn-default btn-flat md-close" type="button">Cancel</button>
                                                <button id="save-image" class="btn btn-primary btn-flat" type="button">Save Image</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="md-overlay"></div>
                                </div>
                            </div>
                        </div>
                        <div class="block-transparent">
                            <div class="header">
                                <h4>Timeline</h4>
                            </div>
                            <ul class="timeline">
                                <li> <i class="fa fa-comment"></i>
                                    <span class="date">5 Jan</span>
                                    <div class="content">
                                        <p><strong>John</strong> has called Shenlong with <strong>You</strong>.</p> <small>A minute ago</small>
                                    </div>
                                </li>
                                <li> <i class="fa fa-envelope green"></i>
                                    <span class="date">5 Jan</span>
                                    <div class="content"> <i class="fa fa-paperclip pull-right"></i>
                                        <p><strong>Bob</strong>
                                            <br/>This is a message for you in your birthday.</p>
                                        <a class="image-zoom" href="images/gallery/img4.jpg">
                                            <img src="images/gallery/img4.jpg" class="img-thumbnail" style="height:64px;" />
                                        </a>
                                        <a class="image-zoom" href="images/gallery/img6.jpg">
                                            <img src="images/gallery/img6.jpg" class="img-thumbnail" style="height:64px;" />
                                        </a>
                                    </div>
                                </li>
                                <li> <i class="fa fa-file red"></i>
                                    <span class="date">5 Jan</span>
                                    <div class="content">
                                        <p><strong>Michael</strong> has wrote on your wall:</p>
                                        <blockquote>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p> <small>Some historic guy</small>
                                        </blockquote>
                                    </div>
                                </li>
                                <li><i class="fa fa-globe purple"></i><span class="date">5 Jan</span>
                                    <div class="content">
                                        <p><strong>María</strong> This is a message for you in your birthday.</p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-4 side-right">
                        <div class="block-flat bars-widget">
                            <div class="spk4 pull-right spk-widget"></div>
                            <h4>Total Sales</h4>
                            <p>Monthly summary</p>
                            <h3>545</h3>
                        </div>
                        <div class="block-flat bars-widget">
                            <div class="spk5 pull-right spk-widget"></div>
                            <h4>New Visitors</h4>
                            <p>Stat Description</p>
                            <h3>146</h3>
                        </div>
                        <div class="block-transparent">
                            <div class="header">
                                <h4>Events</h4>
                            </div>
                            <div class="list-group todo list-widget">
                                <li href="#" class="list-group-item"><span class="date"><i class="fa fa-clock-o"></i> 20 Dec</span> Dinner with my family</li>
                                <li href="#" class="list-group-item"><span class="date"><i class="fa fa-clock-o"></i> 13 Jan</span> Meeting with our partners</li>
                                <li href="#" class="list-group-item"><span class="date"><i class="fa fa-clock-o"></i> 18 Feb</span> Work in new project</li>
                                <li href="#" class="list-group-item"><span class="date"><i class="fa fa-clock-o"></i> 21 Feb</span> Go to the doctor</li>
                            </div>
                        </div>
                        <div class="block widget-notes">
                            <div class="header dark">
                                <h4>Notes</h4>
                            </div>
                            <div class="content">
                                <div contenteditable="true" class="paper">Send e-mails.
                                    <br> <s>meeting at 4 pm.</s>
                                    <br> <s>Buy some coffee.</s>
                                    <br>Feed my dog.</div>
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
    <script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
</body>

</html>