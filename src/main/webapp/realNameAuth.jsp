<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../base/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <title>酷宝支付-实名认证</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Le styles -->
        <script src="${ctx}/assets/js/wizard/lib/modernizr-2.6.2.min.js"></script>
        <script type="text/javascript" src="${ctx}/assets/js/jquery.js"></script>
        <script type="text/javascript" src="${ctx}/assets/js/common.js"></script>
        <script type="text/javascript" src="${ctx}/assets/js/ajax_info.js"></script>
        <script type="text/javascript" src="${ctx}/assets/js/preloader.js"></script>
        <script type="text/javascript" src="${ctx}/assets/js/bootstrap.js"></script>

        <script type="text/javascript" src="${ctx}/assets/js/jquery-ui-1.10.0.custom.min.js"></script>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=GXG6tOFOGWO1eZHfeCzWkkio"></script>
        <link rel="stylesheet" href="${ctx}/assets/css/style.css">
        <link rel="stylesheet" href="${ctx}/assets/css/loader-style.css">
        <link rel="stylesheet" href="${ctx}/assets/css/bootstrap.css">
        <link rel="stylesheet" href="${ctx}/assets/js/wizard/css/jquery.steps.css">
        <link type="text/css" rel="stylesheet" href="${ctx}/assets/js/wizard/jquery.stepy.css">
        <link href="${ctx}/assets/js/tabs/acc-wizard.min.css" rel="stylesheet">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
                    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
                    <![endif]-->
        <!-- Fav and touch icons -->
        <link rel="shortcut icon" href="${ctx}/assets/ico/minus.png">
    </head>
    <link type="text/css" href="${ctx}/assets/css/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
    <style>
        .col-lg-8 {
            width: 66.666667%;
        }
    </style>
    <body>
    <jsp:include page="../menu/head20141118.jsp" />
    <jsp:include page="../menu/leftMenu20141118.jsp" />
        <!--  右侧主界面 -->
        <div style="width: auto; margin-left: 250px;" class="wrap-fluid">
            <div class="container-fluid paper-wrap bevel tlbr" style="height: auto;">
                <!-- CONTENT -->
                <!--标题 -->
                <div class="row">
                    <div id="paper-top">
                        <div class="col-sm-3">
                            <h2 class="tittle-content-header"> <i class="icon-folder"></i> <span>实名认证</span> </h2>
                        </div>
                        <div class="col-sm-9">
                            <div class="devider-vertical visible-lg"></div>
                            <div class="tittle-middle-header">
                                <div class="alert">
                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                    <span class="tittle-alert entypo-info-circled"></span> 公告：&nbsp;掌柜的！&nbsp;&nbsp;欢迎前来管理店铺基本信息！ </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/ 标题结束 -->
                <!--详细内容-->
                <div class="content-wrap">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="nest" id="basicClose">
                                <div class="title-alt">
                                    <h6> 实名认证</h6>
                                    <div class="titleToggle"> <a class="nav-toggle-alt" href="#basic1"> <span class="entypo-up-open"></span> </a> </div>
                                </div>
                                <div class="body-nest" id="basic1" style="height:auto;color: dimgray;">
                                    <p class="lead well">实名认证能让您的账户和财产更安全，并能享受更多网站功能，较高的安全等级，较高的交易限额。</p>
                                    <hr style="margin-bottom:0;">
                                    <div class="row">
                                        <div class="content clearfix">
                                           <div class="col-md-6 center-block" style="text-align: center;">
									            <a href="${ctx}/user/${userId}/auth/bindbank" title="立即开通" data-toggle="popover">
									            	<img alt="开通快捷" src="${ctx}/assets/img/bankcard.png" title="开通快捷" class="img-responsive center-block" style="width: 97px;height: 97px;cursor: pointer;" />
									            </a>
									            <p class="">开通快捷支付，同时完成实名认证。</p>
									            <div>
									            	<a class="btn btn-primary" href="${ctx}/user/${userId}/auth/bindbank">立即开通</a>
									            </div>
									        </div>
                                           <div class="col-md-6 center-block" style="text-align: center;">
									            <a href="${ctx}/user/${userId}/auth/uploadidcard" title="选择上传" data-toggle="popover">
									            	<img alt="上传身份证" src="${ctx}/assets/img/vcard.png" title="上传身份证" class="img-responsive center-block" style="width: 97px;height: 97px;cursor: pointer;" />
									            </a>
									            <p class="">通过上传身份证正反面照片完成实名认证，审核需要三到五个工作日才能完成。</p>
									            <div>
									            	<a class="btn btn-primary" href="${ctx}/user/${userId}/auth/uploadidcard">选择上传</a>
									            </div>
									        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /END OF CONTENT -->
                <!-- FOOTER -->
                    <jsp:include page="../menu/footer20141118.jsp" />
                <!-- / END OF FOOTER -->
            </div>
        </div>
        <!--  END OF PAPER WRAP -->
        <!-- END OF RIGHT SLIDER CONTENT-->
        <!-- MAIN EFFECT -->

    </div>
</body>
</html>
