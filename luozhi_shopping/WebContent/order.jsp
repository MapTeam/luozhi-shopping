<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单确认</title>
<link rel="stylesheet" type="text/css" href="css/order.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link rel="stylesheet" type="text/css" href="css/home.css"/>
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
						<form  method="" class="">
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
								<li><a href="ShoppingCarServlet" class="shoppingCat"><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">2</span></a></li>							
								</c:if>
								<c:if test="${userinfo==null }">
									<li><a href="javascript:;" class="shoppingCat"><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">2</span></a></li>							
									<li class="login-li"><a class="login-a" data-toggle="modal" data-target='#login'>登录</a></li>
									<li class="regist-li"><a href="regist.jsp">注册</a></li>
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
	<div class="container">
	   <!--上方购物车-->
        <div class="head" >
            <span>订单确认</span>
        </div>
        <hr style="border-top:1px solid black">
        <form class=address-form>
         <div class="address-form-header"><span>收货地址</span></div>
         <div class="address-form-content">
         <div>收&nbsp;货&nbsp;人&nbsp;:<input type="text" style="width:272px;" placeholder="为了提高发货速度，请填写您的真实姓名"/>&nbsp;&nbsp;&nbsp;手机号码:<input type="text" style="width:255px;"></div>
         <div class="address-selector">
           <fieldset>
           <form action="#">
            <label for="addr-show"><span style="font-size:16px;font-weight:normal;margin-right:-10px;">收货地区:</span>
                <input type="text" value="" id="addr-show" style="width:272px;font-size:14px;">
            </label>
            <br/>

            <!--省份选择-->
            <select id="prov" onchange="showCity(this)" style="border:1px solid rgb(204,204,204);">
                <option>请选择省份</option>
 
            </select>
 
            <!--城市选择-->
            <select id="city" onchange="showCountry(this)" style="border:1px solid rgb(204,204,204)">
                <option>请选择城市</option>
            </select>
 
            <!--县区选择-->
            <select id="country" onchange="selecCountry(this)" style="border:1px solid rgb(204,204,204)">
                <option>请选择县区</option>
            </select>

            <button type="button" class="btn met1" onClick="showAddr()" id="button-show" >确定</button>
        </form>
        </fieldset>
    </div> 
    <div class="detail-div"> <span class="detail-span">详细地址:</span><textarea class="detail" placeholder="无需重复填写省市区，小于120字"></textarea>
     <div class="setting"><input type="checkbox" class="setting-input"><span class="setting-span">设为默认地址</span></div>
    <div class="saving"><button class="saving-button">保存新地址</button></div>
    </div> 
   
    </div> 
    </form>
	</div>
</body>
</html>
<script src="js/city.js"></script>
<script src="js/method.js"></script>