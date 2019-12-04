<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的地址</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/personal_order.css" />
		<link rel="stylesheet" href="css/login.css" />
		<link rel="stylesheet" href="css/my_address.css" />
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
							<img src="img/logo.png " class="logo" />
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
								<li>
									<a style="cursor: pointer;">真无线</a>
								</li>
								<li>
									<a style="cursor: pointer;">潮流系列</a>
								</li>
								<li>
									<a style="cursor: pointer;">乐器</a>
								</li>
								<li>
									<a style="cursor: pointer;">蓝牙</a>
								</li>
							</ul>
						</div>
					</div>

					<div class="col-xs-12 col-lg-4 col-md-8 col-sm-8 navbar-right">
						<div class="collapse navbar-collapse navbar-right" id="myNav">
							<ul class="nav navbar-nav">
								<c:if test="${userinfo!=null}">
									<li>
										<a href="ShoppingCarServlet" class="shoppingCat"><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">${userinfo.shopcargoodsnum}</span></a>
									</li>
								</c:if>
								<c:if test="${userinfo==null }">
									<li>
										<a href="javascript:;" class="shoppingCat" data-toggle="modal" data-target='#login'><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">0</span></a>
									</li>
									<li class="login-li">
										<a class="login-a" data-toggle="modal" data-target='#login'>登录</a>
									</li>
									<li class="regist-li">
										<a href="regist.jsp">注册</a>
									</li>
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
											<hr class="hr" />
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
							我的收货地址
						</span>
					</div>
				</div>
				<!--身体左-->
				<div class="sd sd-order">
					<ul class="m-snav m-snav-order">
						<li>
							<a href="personal_order.html"><i></i><span>我的订单</span></a>
						</li>
						<li>
							<a href="javaScript:;"><i></i><span>我的优惠券</span></a>
						</li>
						<li class="z-sel">
							<a href="my_address.html"><i></i><span>我的收货地址</span></a>
						</li>
						<li>
							<a target="_blank" href="javaScript:;"><i></i><span>在线客服</span></a>
						</li>
					</ul>
				</div>

				<!--身体右-->
				<div class="n-address" id="module-root">
					<div class="n-address" id="my-address">
						<div class="address-title">
							<em>我的收货地址</em>
							<span>(共${addrlist.size()}条)</span>
							<div data-action="add" class="u-btn  u-btn-white n-address-btn">
								<a href="javascript:;" id="addnewAddress" data-toggle="modal" data-target="#myModal">
									<i>+</i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新建收货地址
								</a>
							</div>
						</div>
						<dl class="th">
							<dt class="dt1">收货人</dt>
							<dt class="dt2">收货地址</dt>
							<dt class="dt3">联系电话</dt>
							<dt class="dt4">操作</dt>
						</dl>
						<c:forEach items="${addrlist }" var="list">
							<c:if test="${list.isdefault==1 }">
							<div class="wjlist j-flag" id="addList">
								<dd class="dt1 f-brk">
									<span class="myname">${list.name }</span>
								</dd>
								<dd class="dt2 f-brk">
									<span class="f-pre">
									<input type="hidden" id="myaddressid" value="${list.addressid }" >
									<span class="province">${list.province }</span>
									<span class="city">${list.city }</span>
									<span class="village">${list.village }</span>
									<span class="detail">${list.detail }</span>
									</span>
								</dd>
								<dd class="dt3 f-brk mytel">${list.tel }</dd>
								<dd class="dt4 f-brk">
									<a href="javascript:;" data-action="edit" class="edit" data-toggle="modal" data-target="#myModal">修改</a>
									<i class="vline">|</i>
									<a href="javascript:;" data-action="delete" class="delete">删除</a>
									<span class="dftbtn f-fr j-dftbtn" data-action="default">默认地址</span>
	
								</dd>
							</div>
							</c:if>
							<c:if test="${list.isdefault==0 }">
							<div class="wjlist j-flag" id="addList">
								<dd class="dt1 f-brk">
									<span class="myname">${list.name }</span>
								</dd>
								<dd class="dt2 f-brk">
									<span class="f-pre">
									<input type="hidden" id="myaddressid" value="${list.addressid }" >
									<span class="province">${list.province }</span>
									<span class="city">${list.city }</span>
									<span class="village">${list.village }</span>
									<span class="detail">${list.detail }</span>
									</span>
								</dd>
								<dd class="dt3 f-brk mytel">${list.tel }</dd>
								<dd class="dt4 f-brk">
									<a href="javascript:;" data-action="edit" class="edit" data-toggle="modal" data-target="#myModal">修改</a>
									<i class="vline">|</i>
									<a href="javascript:;" data-action="delete" class="delete">删除</a>
									<span class="dftbtn f-fr " style="border: none;" data-action="default"><a class="setdefaultaddr">设为默认地址</a></span>
								</dd>
							</div>
							</c:if>
						</c:forEach>
						
					</div>
				</div>
			</div>
		</div>
		</div>
		</div>
		<!--点击地址添加-->
		<div class="modal fade" id="myModal" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<div class="modal-title" style="font-size: 16px;font-weight: bold;color:#666666;">
						填写收货地址
						</div>
						<!--<h4 class="modal-title" id="myModalLabel" style=" background-color:#666666;font-size: 16px;color:#666666;font-weight: bold;">
		填写收货地址
				</h4>-->
					</div>
					<div class="modal-body">
						<form class="address-form">
							<div id="updateAndadduserInformation">
								<div><span>　收货人：</span><input type="text" id="InputName" placeholder="　　为了提高发货速度，请填写您的真实姓名" size=40 style="height: 35px;"> </input>
								</div>
								<div><span>手机号码：</span><input type="text" id="InputTel" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')" size=40 style="height:35px;"></input>
								</div>
								<div><span>收货地区：</span></div>
							</div>
							<div>
								<fieldset>
									<form 　id="address-form-child"　action="#">
										<label id="addr-show-title" for="addr-show">您选择的是：
											<input type="text" value="" id="addr-show">
										</label>
										<br/>
										<p id="choose-addr">
										<!--省份选择-->
										<select id="prov" onchange="showCity(this)">
											<option>=请选择省份=</option>

										</select>

										<!--城市选择-->
										<select id="city" onchange="showCountry(this)">
											<option>=请选择城市=</option>
										</select>

										<!--县区选择-->
										<select id="country" onchange="selecCountry(this)">
											<option>=请选择县区=</option>
										</select>
										</p>
										<p id="address-form-child-p">
											<button type="button" class="btn met1" onClick="showAddr()" id="button-show">确定</button>
										</p>
										
									</form>
								</fieldset>
							</div>

							<div style="margin-left: 20px;">
								<span>详细地址：</span>
							</div>
							<div id="addr-sure">
								<textarea id="InputAddr2" style="height: 60px;width:470px;resize: none;max-height:120px; max-width:470px;border: none;" placeholder="无需重复填写省市区，小于120字"></textarea>
							</div>
							<div id="moren-addr"><input id="checkboxisdefault" type="checkbox"></input><span>&nbsp;设为默认地址</span></div>
						</form>
					</div>
					<div class="modal-footer">
						<p id="modal-footer-btnp">
							<button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
						    <button type="button" class="btn btn-primary primary" style="width: 120px;">保存地址</button>
						</p>
						
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
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
						<li>
							<a href="#" class="a4"></a>
						</li>
						<li>
							<a href="#" class="a3"></a>
						</li>
						<li>
							<a href="#" class="a2"></a>
						</li>
						<li>
							<a href="#" class="a1"></a>
						</li>
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
									<input type="text" class="form-control user" id="username" placeholder="请输入账号" />
								</div>
							</div>
							<div class="form-inline password">
								<div class="form-group">
									<label>密码：</label>
									<input type="password" class="form-control loginpass" id="pwd" placeholder="请输入密码" />
								</div>
							</div>
							<div class="auto">
								<label class="lab">
					        		<input type="checkbox" id="autologin"/>
					        		<span>记住密码</span>
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
						<a target="_blank" href="regist.html">没有帐号？免费注册 ></a>
					</div>

				</div>
			</div>
		</div>

	</body>

</html>
<script type="text/javascript" src="js/city.js"></script>
<script type="text/javascript" src="js/method.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/my_address.js"></script>
<script type="text/javascript" src="js/base.js"></script>
