<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>洛枳商城搜索字段：${title}</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		<link rel="stylesheet" href="css/like_select.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
	</head>
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
						<form action="LikeSelectServlet?val="+$('.search').val(); method="" class="">
							<span class="search-tubiao glyphicon glyphicon-search"></span>
							<input type="txt" class="search" autocomplete="off" placeholder="${title}">
						</form>
						<div class="form-heid">
							<ul>
								<li class="title1">热门搜索</li>
								<li><a href="">真无线</a></li>
								<li><a href="">潮流系列</a></li>
								<li><a href="">乐器</a></li>
								<li><a href="">蓝牙</a></li>
							</ul>
						</div>
					</div>
					
					<div class="col-xs-12 col-lg-4 col-md-8 col-sm-8 navbar-right">
						<div class="collapse navbar-collapse navbar-right" id="myNav">
							<ul class="nav navbar-nav">
								<li><a href="shopcar.html" class="shoppingCat"><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">2</span></a></li>
								<c:if test="${userinfo==null }">
									<li class="login-li"><a class="login-a" data-toggle="modal" data-target='#login'>登录</a></li>
									<li class="regist-li"><a href="regist.html">注册</a></li>
								</c:if>
								
								<!--<li class="username-li hidd"></li>
								<li class="exitlogin-li hidd"><a href="#">退出登录</a></li>-->
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
													<a href="home.html">
														<span class="glyphicon glyphicon-music mainside"></span>
														<span class="list-text">洛枳商城首页</span>
													</a>
												</li>
												<hr class="hr"/>
												<li class="exitlogin-li hidd">
													<a href="#">
														<span class="glyphicon glyphicon-off logout"></span>
														<span class="list-text">退出</span>
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
		<!--顶部-->		
		<section>
			<div class="container">
				<div class="row" id="top">
					<h4>
					<a style="font-size: 25px;font-weight: bold;color: black;top: 16px;" href="HomeServlet" class="col-md-1">首页</a>
					<span class="top_title">
						<span style="color: #8C8C8C;left: -20px;top: 20px;" class="col-md-8">&gt;<span id="selecttitle">${title}</span></span>
					</span>
				    </h4>
				</div>
				 <hr  class="row"/>
			</div>
		</section>
		<section  style="margin-top: 30px;">
			<div class="container">
					<c:if test="${msg eq 0}">
					<div style="height: 300px; width: 100%">
						<img style="margin-left: 500px" src="https://s2.music.126.net/store/web/img/nofind.png?4bcb36ed1265fe7b408c5bfbb850cbc8">
					</div>					  
					</c:if>
				<c:forEach items="${list}" var="s">
					<a style="color: black" href="IntroudceServlet?gid=${s.gid }">
						<div class="col-md-3" style="height: 400px">
						<div id="product">								
							<img src="${s.zpicture}"/>
								<p style="font-size: 18px;font-weight: bold;text-align: center;">${s.gname}</p>
								<p style="font-size: 15px;color: #A94442;text-align: center;font-weight: bold;">¥${s.gprice}</p>
						</div>	
						</div>
					</a>
				</c:forEach>
					
			</div>
		</section>
		<c:if test="${msg != 0}">
			<section style="margin-top: 80px">
				<div class="row">
					<center>
					<a  href="LikeSelectServlet?pageNo=1&pageSize=${pageSize}&val=${title}" class="pagefirst">首页</a>
					<c:if test="${pageNo lt 2}">
						<a style="color: #CDCDCD;border: #CDCDCD solid 1px;border-radius: 3px;" class="pageprev">上一页</a>
					</c:if>
					<c:if test="${pageNo gt 1}">
						<a  href="LikeSelectServlet?pageNo=${pageNo-1}&pageSize=${pageSize}&val=${title}" class="pageprev">上一页</a>
					</c:if>
					<c:if test="${pageNo gt maxPageNo-1}">
						<a style="color: #CDCDCD;border: #CDCDCD solid 1px;border-radius: 3px;" class="pageprev">下一页</a>
					</c:if>
					<c:if test="${pageNo lt maxPageNo}">
						<a  href="LikeSelectServlet?pageNo=${pageNo+1}&pageSize=${pageSize}&val=${title}" class="pagenext">下一页</a>
					</c:if>								
					<a  href="LikeSelectServlet?pageNo=${maxPageNo}&pageSize=${pageSize}&val=${title}" class="pagelast">尾页</a>
					<a>当前页：${pageNo}</a>
					<a>共<span id="maxpage">${maxPageNo}</span>页</a>
					<a>跳转<input id="tiaozhuaninput" type="text"/>页</a>
					</center>
				</div>
			</section>
		</c:if>
		
		
		<!--回到顶部块-->
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
						<span>网易公司版权所有?1997-2019　杭州乐读科技有限公司运营：浙网文[2015] 0415-135号</span>
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
						    <div class="loginmsg"></div>
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
<script  src="js/jquery.min.js" ></script>
<script  src="js/bootstrap.js" ></script>
<script src="js/base.js"></script>
<script src="js/like_select.js"></script>