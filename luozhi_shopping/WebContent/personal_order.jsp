<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的订单</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/personal_order.css" />
		<link rel="stylesheet" href="css/login.css" />
	</head>
<%
Cookie[] cookie = request.getCookies();
String uname = null;
String upwd = null;
boolean check = false;
if(cookie!=null){
	for(Cookie c:cookie){
		if("uname".equals(c.getName())){
			uname = URLDecoder.decode(c.getValue(),"UTF-8");
			check = true;
		}
		if("upwd".equals(c.getName())){
			upwd = URLDecoder.decode(c.getValue(),"UTF-8");
		}
	}
}
	pageContext.setAttribute("uname", uname);
	pageContext.setAttribute("upwd", upwd);
	pageContext.setAttribute("check", check);
%>
	<body>
		<!--头部-->
				<header>
			<nav class="navbar navbar-default">
				<div class="container">
					<div class="navbar-head navbar-left">
						<a href="HomeServlet" class="navbar-brand">
							<img src="img/logo.png " class="logo"/>
							<!--<span id="logo-font">
								洛枳商城
							</span>-->
						</a>
						<!--折叠按钮-->
				        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myNav">
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					    </button>
					</div>
					
					<div class="col-md-4 col-sm-3 col-lg-3  searchbox col-lg-offset-3 col-md-offset-2 col-sm-offset-2 col-xs-offset-5 div-from">
						<form method="" class="">
							<span class="search-tubiao glyphicon glyphicon-search"></span>
							<input type="txt" class="search" autocomplete="off" placeholder="1020发烧节">
						</form>
						<div class="form-heid">
							<ul>
								<li class="title1">热门搜索</li>
								<li><a style="cursor: pointer;">真无线</a></li>
								<li><a style="cursor: pointer;">潮流系列</a></li>
								<li><a style="cursor: pointer;">乐器</a></li>
								<li><a style="cursor: pointer;">蓝牙</a></li>
							</ul>
						</div>
					</div>
					
					<div class="col-xs-12 col-lg-4 col-md-8 col-sm-8 navbar-right">
						<div class="collapse navbar-collapse navbar-right" id="myNav">
							<ul class="nav navbar-nav">
								<c:if test="${userinfo!=null}">
								<li><a href="ShoppingCarServlet" class="shoppingCat"><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">${userinfo.shopcargoodsnum}</span></a></li>							
								</c:if>
								<c:if test="${userinfo==null }">
									<li><a href="javascript:;" class="shoppingCat"><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">0</span></a></li>							
									<li class="login-li"><a class="login-a" data-toggle="modal" data-target='#login'>登录</a></li>
									<li class="regist-li"><a href="regist.jsp">注册</a></li>
								</c:if>
							</ul>
							<c:if test="${userinfo!=null }">
									<div class="person">
										<img class="avatar" src="http://p3.music.126.net/RLeBJe4D1ZzUtltxfoKDMg==/109951163250239066.jpg?param=36y36">
										<span class="glyphicon glyphicon-triangle-bottom downchild"></span>
										<div class="list">
											<ul>
												<!--Regular list-->
												<li>
													<a href="personal_order.html">
														<span class="glyphicon glyphicon-list-alt myorder"></span>
														<span class="list-text">我的订单</span>
													</a>
												</li>
		
												<li>
													<a>
														<span class="glyphicon glyphicon-yen coupon"></span>
														<span class="list-text">我的优惠券</span>
													</a>
												</li>
		
												<li>
													<a>
														<span class="glyphicon glyphicon-map-marker address"></span>
														<span class="list-text">我的收货地址</span>
													</a>
												</li>
		
												<li>
													<a href="HomeServlet">
														<span class="glyphicon glyphicon-music mainside"></span>
														<span class="list-text">洛枳商城首页</span>
													</a>
												</li>
												<hr class="hr"/>
												<li class="exitlogin-li hidd">
													<a href="javascript:;">
														<span class="glyphicon glyphicon-off logout"></span>
														<span class="list-text" id="exitlogin">退出</span>
													</a>
												</li>
											</ul>
										</div>
									</div>
								</c:if>
						</div>
					</div>
					
				</div>
			</nav>
		</header>
		
		<!--隐藏登录后被挤的信息-->	
		<input id="SingletStateLoginListenerMsg" type="hidden" value="${SingletStateLoginListenerMsg }" />
		<!--身体-->
		<div class="banner">
			<div class="container">
				<!--导航条-->
				<div class="m-bread">
					<div class="block">
						<span>
							<a href="home.html">首页</a>
						</span>
						<span class="pointer"><i>></i> 
							我的订单
						</span>
					</div>
				</div>
				<!--身体左-->
				<div class="sd sd-order">
					<ul class="m-snav m-snav-order">
						<li class="z-sel"><a href="personal_order.html"><i></i><span>我的订单</span></a></li>
						<li><a href="javaScript:;"><i></i><span>我的优惠券</span></a></li>
						<li><a href="my_address.html"><i></i><span>我的收货地址</span></a></li>
						<li><a target="_blank" href="javaScript:;"><i></i><span>在线客服</span></a></li>
					</ul>
				</div>	
				
				<!--身体右-->
				<div id="g-main" class="mn mn-order">
					<div class="n-myorder" id="module-root">
						<div>
							<div class="m-tab">
								<ul class="s-brdb1" id="tab">
									<!--Regular list-->
									<li class="active"><a href="javascript:;" title="待支付" class="z-sel">待支付</a></li>
									
									<li><a href="javascript:;" title="待发货">待发货</a></li>
									
									<li><a href="javascript:;" title="待收货">待收货</a></li>
									
									<li><a href="javascript:;" title="全 部">全 部</a></li>
								</ul>
								<!--<div id="content">-->
									<ul id="content">
										<li class="current">
											<!--Regular if0-->
											<!--<div class="empty">
											<i class="icn"></i>
											<p class="f-tc f-fs20 s-fc666">您当前没有待支付的订单</p>
											</div>-->
											<div class="empty">
												<i class="icn"></i>
												<p class="f-tc f-fs20 s-fc666">您当前没有代发货的订单</p>
											</div>
											<div class="haempty">
												<table class="tb" >
										        <!--标题栏-->
										            <tr class="tr-h" style="height: 50px ">
										                <td >商品图片</td>
										                <td >商品详情</td>
										                <td>金额</td>
										                <td >数量</td>
										                <td>小计</td>
										                <td>操作</td>
										            </tr>
										        </table>
												
												
												
												
												
											</div>
										</li>
										<li>
											<div class="empty">
											<i class="icn"></i>
											<p class="f-tc f-fs20 s-fc666">您当前没有代发货的订单</p>
											</div>
										</li>
										<li>
											<div class="empty">
											<i class="icn"></i>
											<p class="f-tc f-fs20 s-fc666">您当前没有待收获的订单</p>
											</div>
											
										</li>
										<li>
											<div class="empty">
											<i class="icn"></i>
											<p class="f-tc f-fs20 s-fc666">您当前没有订单</p>
											</div>
											
										</li>
									</ul>
								<!--</div>-->
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		<!--右边浮动竖条-->
		<div class="zTi-rigth">
			<ul>
				<li><a href="#">查看<br/>营业执照</a></li>
				<li>100%<br/>正品</li>
				<li>七天无理由退货</li>
				<li>
					<a href="#">
						<span class="ding-cat"></span>
						<span class="">购物车</span>
					</a>
				</li>
				<li>
					<a href="#">
						<span class="kefu"></span>
						<span class="">客服</span>
					</a>
				</li>
				<li class="totop" style="margin-top: 0px;">
					<!--<a href="javascript:;" class="totop-a">
						<span class="totop-span"></span>
					</a>-->
				</li>
			</ul>
		</div>
	
		
		
		<!--底部-->
		<footer>
			<div class="container">
				<div class="footer-left col-md-6">
					<p class="footer-left-p1">
						<a href="#">关于洛枳</a>
						<span>|</span>
						<a href="#">客户服务</a>
						<span>|</span>
						<a href="#">服务条款</a>
						<span>|</span>
						<a href="#">网站导航</a>
						<span>|</span>
						<a href="#">意见反馈</a>
					</p>
					<p>
						<span>网易公司版权所有©1997-2019　杭州乐读科技有限公司运营：浙网文[2015] 0415-135号</span>
					</p>
				</div>
				
				<div class="footer-right col-md-6">
					<ul>
						<li><a href="#" class="a4"></a></li>
						<li><a href="#" class="a3"></a></li>
						<li><a href="#" class="a2"></a></li>
						<li><a href="#" class="a1"></a></li>
					</ul>
				</div>
			</div>
		</footer>
		
		
		
		
		<!--login-->
		<div class="modal fade" id="login" data-backdrop="static">
	        <div class="modal-dialog">
		        <div class="modal-content">
			        <div class="modal-header">
			            <div class="text-success modal-title">账号登录</div>
			            <span class="close" data-dismiss="modal"></span>
			        </div>
			        <div class="modal-body">
			            <div class="row1">
		                    <div class="form-inline">
				                <div class="form-group">
					                <label>用户：</label>
					                <input type="text" class="form-control user" id="username" placeholder="请输入账号"/>
				            	</div>
				          	</div>
			                <div class="form-inline password">
					            <div class="form-group">
					                <label>密码：</label>
					                <input type="password" class="form-control loginpass" id="pwd" placeholder="请输入密码"/>
					            </div>
						    </div>
						    <div class="auto">
						    	<label class="lab">
					        		<input type="checkbox" id="autologin"/>
					        		<span>自动登录</span>
					        	</label>
					        	<a href="#" class="forget">忘记密码？</a>
				            </div>
				            <div class="login_btn">
				            	<button class="btn btn-primary" id="login-btn">登录</button>
				            </div>
				        </div>
			        </div>
		        
			        <div class="modal-footer">
				        <button class="btn btn-danger" data-dismiss="modal">取消</button>
				        <a target="_blank" href="regist.html">没有帐号？免费注册  ></a>
			        </div>
	        
		    	</div>
	   		</div>
	    </div>
		
		
	</body>

</html>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/personal_order.js"></script>
