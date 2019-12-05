<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>后台管理</title>	
		<link rel="stylesheet" href="/luozhi_shopping/css/bootstrap.css" />
		<link rel="stylesheet" href="/luozhi_shopping/css/base.css" />
		<link rel="stylesheet" href="/luozhi_shopping/css/backstageindex.css" />
	</head>
	<body>
		<!--头部-->
		<header>
			<nav class="navbar navbar-default">
				<div class="container">
					<div class="navbar-head navbar-left">
						<a href="HomeServlet" class="navbar-brand">
							<img src="/luozhi_shopping/img/logo.png " class="logo"/>
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
						<form action="#" method="" class="">
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
		
		
		
		<!--顶部-->		
		<section>
			<div class="container">
				<div class="row" id="top">
					<h4>
					<a style="font-size: 25px;font-weight: bold;color: black;top: 16px;" href="../home.html" class="col-md-1">首页</a>
					<span class="top_title">
						<span style="color: #8C8C8C;left: -20px;top: 20px;" class="col-md-8">&gt;后台管理</span>
					</span>
				    </h4>
				</div>
				 <hr  class="row"/>
			</div>
		</section>
	</body>
	
	
	
	<!--左边选择块：-->
	<section>
		<div class="container">
		<div class="col-lg-4 back_left">
			<ul>
				<li style="border-radius: 10px;background: #FFFFCC;">订单管理</li>
				<li>客户中心</li>
				<li>产品管理</li>
				<li>财务管理</li>
				<li>统计分析</li>
			</ul>
		</div>
		<!--隐藏登录后被挤的信息-->	
		<input id="SingletStateLoginListenerMsg" type="hidden" value="${SingletStateLoginListenerMsg }" />
		<div class="col-lg-8 back_right" >
			<!--这是订单管理块-->
			<div class="nowclick" id="dingdan_control">
				<ul id="dingdan_title" class="row">
					<li class="nosendgoodsorder" style="font-weight: bold;">未发货</li>
					<li class="sendgoodsandok">已发货</li>
					<li class="requesttoback">申请退货</li>
					<li class="okback">已退货</li>
				</ul>
				<hr class="row" />
				<div class="dingdan_show">
				<!--未发货块-->
					<ul id="dingdan_noput" class="row">
						<c:forEach items="${list }" var="orderlist" >
						<li class="dingdan_li">
						<div class="outgoodid">
							<span>订单号:<span>${orderlist.goname}</span></span>
						</div>
						 <c:forEach items="${orderlist.gogoods }" var="good">
								<div class="liheadmsg" onclick="clickdb(this)">
									<span><img src="http://${good.goodspicture}"/></span>
									<span id="dingdan_noput_name">${good.gname }</span>
									<span  id="dingdan_noput_addr">用户：<span>${orderlist.uname }</span></span>
									<span id="dingdan_noput_num">数量：<span>${good.goodsnum }</span></span>
									<span id="dingdan_noput_color">颜色：<span>${good.colortype }</span></span>
								</div>
								<div class="goodsdescri">
									<p>商品编号：<span>${good.gid }</span></p>
									<p>商品品牌：<span>${good.gbrand }</span></p>
									<p>商品详情：<span>${good.gintroduce }</span></p>
									<p>商品库存：<span>${good.goodscount }</span></p>
									<p>订单提交时间：<span>${orderlist.godate }</span></p>
									<p>
										<span>收货人：<span>${orderlist.name }</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<span>电话号码：<span>${orderlist.tel }</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										 <span class="myaddress">收货地址：<span>${orderlist.province }${orderlist.city }${orderlist.village }${orderlist.detail }</span></span>
										<span class="editaddress">收货地址：<input type="text" name="address" value="${orderlist.province }${orderlist.city }${orderlist.village }${orderlist.detail }"></span>
										
									</p>
								</div>
							</c:forEach>
							<span id="dingdan_update_btn" onclick="updateaddress(this,'${orderlist.goid}')">
								<button class="btn btn-default">更改地址</button>
							</span>
							<span id="dingdan_noput_btn" onclick="sendclick(this,'${orderlist.goid}','${orderlist.tel }','${orderlist.uid }')">
									<button class="btn btn-default">发货</button>
							</span>
							</li>
					 	</c:forEach>
					</ul>
				</div>
				
				<!--已发货块-->
				<div>
				  <ul id="dingdan_put" class="row">
				  
				  </ul>
				</div>
					
						
				<!--申请退款块-->
				<div>
				  <ul id="dingdan_waitback" class="row">
				  </ul>
				</div>
				<!--已退款快-->
				<div>
			 	  <ul id="dingdan_back" class="row">
					
					<li>
						<span><img src=""/></span>
						<span id="dingdan_back_name">
							商品
						</span>
						<span  id="dingdan_back_result">原因：<span>不想买了</span></span>
						<span id="dingdan_back_yes">退款成功</span>
						<!--<span id="dingdan_back_no"><button class="btn btn-danger">拒绝</button></span>
						<span id="dingdan_back_no_result">
						    <textarea style="resize: none" value placeholder="拒绝原因："></textarea>
						</span>-->
					</li>
				  </ul>
				</div>
			</div>
			<!--这是客户中心块-->
			<div>
				<p>这是客户中心块</p>
			</div>
			<!--这是产品管理块-->
			<div>
				<p>这是产品管理块</p>
			</div>
			<!--这是财务管理块-->
			<div>
				<p>这是财务管理块</p>
			</div>
			<!--这是统计分析块-->
			<div>
				<p>这是统计分析块</p>
			</div>
		</div>
		</div>
	</section>
	
</html>
<script type="text/javascript" src="/luozhi_shopping/js/jquery.min.js" ></script>
<script type="text/javascript" src="/luozhi_shopping/js/bootstrap.js" ></script>
<script type="text/javascript" src="/luozhi_shopping/js/base.js" ></script>
<script type="text/javascript" src="/luozhi_shopping/js/backstageindex.js" ></script>