<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>订单确认</title>
		<link rel="stylesheet" type="text/css" href="css/order.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/sub_order.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css" />

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
		
		
		<div class="container">
			<div class="sub_banner">
				<div class="sub_block">
					<span>订单确认</span>
				</div>
			</div>
			<div id="g-main" class="ma">
				<div class="n-order" id="module-root">
			<!-- 立即购买跳过来 -->
			<c:if test="${oi!=null }">
				<!-- 没有地址时 -->
				<c:if test="${oi.addresslist.size()==0}">
				<input type="hidden" value="false" id="judgeAddress"/>
				<form class="address-form">
					<div class="address-form-header "><span>收货地址</span></div>
					<div class="address-form-content">
						<div>收&nbsp;货&nbsp;人&nbsp;:<input id="shouhuorenText" type="text" style="width:272px;" placeholder="为了提高发货速度，请填写您的真实姓名" />&nbsp;&nbsp;&nbsp;手机号码:<input id="telText" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" style="width:255px;"></div>
						<div class="address-selector">
							<fieldset>
								<form>
									<label for="addr-show"><span style="font-size:16px;font-weight:normal;margin-right:-10px;">收货地区:</span>
	                					<input type="text" value="" id="addr-show" style="width:272px;font-size:14px;">
	           					 	</label>
									<br/>
	
									<!--省份选择-->
									<select id="prov" onchange="showCity(this)" style="border:1px solid rgb(204,204,204);margin-left: 86px;">
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
	
									<button type="button" class="btn met1" onClick="showAddr()" id="button-show">确定</button>
								</form>
							</fieldset>
						</div>
						<div class="detail-div"> <span class="detail-span">详细地址:</span><textarea class="detail" placeholder="无需重复填写省市区，小于120字"></textarea>
							<div class="saving">
								<input type="button" class="saving-button" value="保存新地址"/>
								<input type="hidden" id="uid" value="${userinfo.user.uid}"/>
							
							</div>
							
						</div>
	
					</div>
				</form>
				</c:if>
				<!-- 有地址时 -->
				<c:if test="${oi.addresslist.size()!=0}">
			<input type="hidden" value="true" id="judgeAddress"/>
					<div class="m-address-box">
						<div class="m-address-front">
							<c:forEach items="${oi.addresslist }" var="addresslist">
								<c:if test="${addresslist.isdefault==1 }">
							<div class="m-address f-pr">
								<div class="bggray">
									<span>收货信息</span>
								</div>
								
								<div class="head">
									<span class="f-ib">
										<i class="glyphicon glyphicon-map-marker"></i>
										<em>默认地址</em>
									</span>
									<a class="btn btn-b f-mgl20 f-ib f-fs12" data-toggle="modal" data-target="#myModal" id="updateAddress">修改</a>
								</div>
								
								<div class="msg">
									<span class="f-ib f-thide">
										<em style="letter-spacing: 6px;">收货人:</em>
										<em class="promes_username">${addresslist.name }</em>
									</span>
									<span class="phone f-ib f-thide">
										<em>联系方式&nbsp;:&nbsp;</em>
										<em class="promes_usertel">${addresslist.tel}</em>
										
									</span>
								</div>
								<div class="myaddress">
									<p class="txt f-thide">
										<em>收货地址&nbsp;:&nbsp;</em>
										<em class="promes_useraddr">
											<input type="hidden" id="AddressId" value="${addresslist.addressid }"/>
											<input type="hidden" id="IsDefault" value="${addresslist.isdefault }"/>
											<span class="promes_useraddr_province">${addresslist.province }</span>
											<span class="promes_useraddr_city">${addresslist.city }</span>
											<span class="promes_useraddr_village">${addresslist.village }</span>
											<span class="promes_useraddr_detail">${addresslist.detail }</span>
										</em>
									</p>
								</div>
								<div class="line f-pa"></div>
								<div class="modify f-pa">
									<p>
										<a style="cursor: pointer;" class="s-fcff f-blk" data-toggle="modal" data-target="#addDefaultAddr">更换默认地址</a>
									</p>
									<p>
										<a style="cursor: pointer;" class="btn-b f-mgt5 f-blk" id="addnewAddress"  data-toggle="modal" data-target="#myModal">新建地址</a>
									</p>
								</div>
							</div>
							</c:if>
							</c:forEach>
						</div>
					</div>
					</c:if>
				<!-- ----------------------------分割线---------------------------------------------------------------------------- -->
				<div class="m-msg">
						<div class="head"></div>
						<div class="body">
							<ul>
								<li class="bggray f-cb s-fc999">
									<span class="intro f-fl">商品信息</span>
									<span class="money f-fl">金额</span>
									<span class="number f-fl">数量</span>
									<span class="all f-fl">小计</span>
								</li>
								<li class="f-cb shangpingli">
									<span class="pic f-fl">
										<img src="http://${oi.orderinputgoods.goodscolor.goodspicture}" alt="商品图片">
									</span>
									<span class="msg f-fl">
										<div class="promes">
											<input type="hidden" value="${oi.orderinputgoods.goodscolor.gcolorid}," id="hhgcolorid"/>
											<p class="name f-thide promes_goodsname">${oi.orderinputgoods.goods.gname}</p>
											<p class="attr f-thide promes_goodscolor">${oi.orderinputgoods.goodscolor.colortype}</p>
										</div>
									</span>
									<span class="price f-fl">¥${oi.orderinputgoods.goods.gprice}</span>
									<span class="num f-fl promes_goodsnum">${oi.goodscount}</span>
									<span class="total f-fl">¥${oi.orderinputgoods.goods.gprice * oi.goodscount}</span>
								</li>
							</ul>
							<div class="line-bt"></div>
							<div class="u-price f-mgt30 f-mgr60">
								<div class="pr cp  f-pr" style="margin-left: 20px;">
									<span>全部优惠券(0) &gt;</span>
									<div class="m-coupon no-used"><span>无可用优惠券</span></div>
									<div class="protocol">
										<input type="checkbox" class="checkbox z-checked" checked="checked"/>
										<span class="de">我同意<a>《洛枳商城购买协议》</a></span>
									</div>
								</div>
								<div class="body-r">
									<div class="line f-cb f-pr f-all">
										<span class="f-fr">商品合计：</span>
										<span class="pr f-fr">${oi.goodscount}</span>
									</div>
									<div class="line f-cb f-pr send">
										<span class="f-fr">运费：</span>
										<span class="pr f-fr">￥<em>0</em></span>
									</div>
									<div class="line tot f-cb">
										<span class="f-fr">实付金额：</span>
					
										<span class="pr f-fr"><em><i class="f-fs20" style="color: #d33a31;">¥</i><em class="promes_goodsprice">${oi.orderinputgoods.goods.gprice * oi.goodscount}</em></em></span>
									</div>
									<div class="m-btmlay f-mgr60">
										<div class="f-cb hhfoot">
											<button class="paybtn btn-r f-fr" data-dismiss="modal" data-toggle="modal" data-target="#buy_order_sure">提交订单</button>
										</div>
									</div>
									<!--<div class="f-cb">
										<div class="inner f-fr">123&nbsp;&nbsp;13723812521&nbsp;&nbsp;
										湖南省长沙市芙蓉区&nbsp;&nbsp;
										五一广场
										</div>
									</div>-->
								</div>
							</div>
						</div>
					</div>
			</c:if>	
					
			<!-- 购物车跳过来 -->
			<c:if test="${oi==null }">
				<!-- 没有地址时 -->
				<c:if test="${addresslist.size()==0}">
				<input type="hidden" value="false" id="judgeAddress"/>
				<form class="address-form">
					<div class="address-form-header "><span>收货地址</span></div>
					<div class="address-form-content">
						<div>收&nbsp;货&nbsp;人&nbsp;:<input id="shouhuorenText" type="text" style="width:272px;" placeholder="为了提高发货速度，请填写您的真实姓名" />&nbsp;&nbsp;&nbsp;手机号码:<input id="telText" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" style="width:255px;"></div>
						<div class="address-selector">
							<fieldset>
								<form>
									<label for="addr-show"><span style="font-size:16px;font-weight:normal;margin-right:-10px;">收货地区:</span>
	                					<input type="text" value="" id="addr-show" style="width:272px;font-size:14px;">
	           					 	</label>
									<br/>
	
									<!--省份选择-->
									<select id="prov" onchange="showCity(this)" style="border:1px solid rgb(204,204,204);margin-left: 86px;">
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
	
									<button type="button" class="btn met1" onClick="showAddr()" id="button-show">确定</button>
								</form>
							</fieldset>
						</div>
						<div class="detail-div"> <span class="detail-span">详细地址:</span><textarea class="detail" placeholder="无需重复填写省市区，小于120字"></textarea>
							<div class="saving">
								<input type="button" class="saving-button" value="保存新地址"/>
								<input type="hidden" id="uid" value="${userinfo.user.uid}"/>
							
							</div>
							
						</div>
	
					</div>
				</form>
				</c:if>
				<!-- 有地址时 -->
				<c:if test="${addresslist.size()!=0}">
					<input type="hidden" value="true" id="judgeAddress"/>
					<div class="m-address-box">
						<div class="m-address-front">
							<c:forEach items="${addresslist }" var="address">
								<c:if test="${address.isdefault==1 }">
							<div class="m-address f-pr">
								<div class="bggray">
									<span>收货信息</span>
								</div>
								
								<div class="head">
									<span class="f-ib">
										<i class="glyphicon glyphicon-map-marker"></i>
										<em>默认地址</em>
									</span>
									<a class="btn btn-b f-mgl20 f-ib f-fs12" data-toggle="modal" data-target="#myModal" id="updateAddress">修改</a>
								</div>
								
								<div class="msg">
									<span class="f-ib f-thide">
										<em style="letter-spacing: 6px;">收货人:</em>
										<em class="promes_username">${address.name }</em>
									</span>
									<span class="phone f-ib f-thide">
										<em>联系方式&nbsp;:&nbsp;</em>
										<em class="promes_usertel">${address.tel}</em>
										
									</span>
								</div>
								<div class="myaddress">
									<p class="txt f-thide">
										<em>收货地址&nbsp;:&nbsp;</em>
										<em class="promes_useraddr">
											<input type="hidden" id="AddressId" value="${address.addressid }"/>
											<input type="hidden" id="IsDefault" value="${address.isdefault }"/>
											<span class="promes_useraddr_province">${address.province }</span>
											<span class="promes_useraddr_city">${address.city }</span>
											<span class="promes_useraddr_village">${address.village }</span>
											<span class="promes_useraddr_detail">${address.detail }</span>
										</em>
									</p>
								</div>
								<div class="line f-pa"></div>
								<div class="modify f-pa">
									<p>
										<a  class="s-fcff f-blk" style="cursor: pointer;" data-toggle="modal" data-target="#addDefaultAddr">更换默认地址</a>
									</p>
									<p>
										<a  class="btn-b f-mgt5 f-blk" id="addnewAddress" style="cursor: pointer;" data-toggle="modal" data-target="#myModal">新建地址</a>
									</p>
								</div>
							</div>
							</c:if>
							</c:forEach>
						</div>
					</div>
					</c:if>
				<!-- ----------------------------分割线---------------------------------------------------------------------------- -->
				<div class="m-msg">
						<div class="head"></div>
						<div class="body">
							<ul>
								<li class="bggray f-cb s-fc999">
									<span class="intro f-fl">商品信息</span>
									<span class="money f-fl">金额</span>
									<span class="number f-fl">数量</span>
									<span class="all f-fl">小计</span>
								</li>
								<c:forEach items="${coigs }" var="coig">
									<li class="f-cb shangpingli">
										<span class="pic f-fl">
											<img src="http://${coig.goodscolor.goodspicture}" alt="商品图片">
										</span>
										<span class="msg f-fl">
											<div class="promes">
												<input type="hidden" value="${coig.goodscolor.gcolorid}," id="hhgcolorid"/>
												<p class="name f-thide promes_goodsname">${coig.goods.gname}</p>
												<p class="attr f-thide promes_goodscolor">${coig.goodscolor.colortype}</p>
											</div>
										</span>
										<span class="price f-fl">¥${coig.goods.gprice}</span>
										<span class="num f-fl promes_goodsnum">${coig.goodscount}</span>
										<span class="total f-fl">¥${coig.goods.gprice * coig.goodscount}</span>
									</li>
								</c:forEach>
							</ul>
							<div class="line-bt"></div>
							<div class="u-price f-mgt30 f-mgr60">
								<div class="pr cp  f-pr" style="margin-left: 20px;">
									<span>全部优惠券(0) &gt;</span>
									<div class="m-coupon no-used"><span>无可用优惠券</span></div>
									<div class="protocol">
										<input type="checkbox" class="checkbox z-checked" checked="checked"/>
										<span class="de">我同意<a>《洛枳商城购买协议》</a></span>
									</div>
								</div>
								<div class="body-r">
									<div class="line f-cb f-pr f-all">
										<span class="f-fr">商品合计：</span>
										<span class="pr f-fr">${toalCount}</span>
									</div>
									<div class="line f-cb f-pr send">
										<span class="f-fr">运费：</span>
										<span class="pr f-fr">￥<em>0</em></span>
									</div>
									<div class="line tot f-cb">
										<span class="f-fr">实付金额：</span>
					
										<span class="pr f-fr"><em><i class="f-fs20" style="color: #d33a31;">¥</i><em class="promes_goodsprice">${toalPrice}</em></em></span>
									</div>
									<div class="m-btmlay f-mgr60">
										<div class="f-cb hhfoot">
											<button class="paybtn btn-r f-fr" data-dismiss="modal" data-toggle="modal" data-target="#buy_order_sure">提交订单</button>
										</div>
									</div>
									<!--<div class="f-cb">
										<div class="inner f-fr">123&nbsp;&nbsp;13723812521&nbsp;&nbsp;
										湖南省长沙市芙蓉区&nbsp;&nbsp;
										五一广场
										</div>
									</div>-->
								</div>
							</div>
						</div>
				</div>
			</c:if>	
					
				</div>
			</div>
		</div>
		
		
		<!-- --------------------------------------------------修改/新建地址分割线------------------------------------------------ -->
		<!--点击地址添加-->
		<div class="modal fade" id="myModal" data-backdrop="static">
		  	
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header md-header">
							<div class="modal-title" style="font-size: 16px;font-weight: bold;color:#666666;">
							填写收货地址
							</div>
						</div>
						<div class="modal-body">
							<form  id="address-form">
								<div id="updateAndadduserInformation">
								<div><span>　收货人：</span><input type="text" id="InputName" placeholder="　　为了提高发货速度，请填写您的真实姓名" size=40 style="height: 35px;"> </input>
								</div>
								<div><span>手机号码：</span><input type="text" id="InputTel" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')" size=40 style="height:35px;"></input>
								</div>
								</div>
								<div><span>收货地区：</span></div>
								<div>
									<fieldset>
										<form 　id="address-form-child"　action="#">
											<label id="addr-show-title" for="addr-show">您选择的是：
												<input type="text" value="" id="addr-show">
											</label>
											<br/>
											<p id="choose-addr">
											<!--省份选择-->
											<select id="prov" class="prov" onchange="showCity(this)">
												<option>=请选择省份=</option>
	
											</select>
	
											<!--城市选择-->
											<select id="city" class="city" onchange="showCountry(this)">
												<option>=请选择城市=</option>
											</select>
	
											<!--县区选择-->
											<select id="country" class="country" onchange="selecCountry(this)">
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
									<textarea style="height: 60px;width:470px;resize: none;max-height:120px; max-width:470px;border: none;" id="InputAddr2" placeholder="无需重复填写省市区，小于120字"></textarea>
								</div>
								<div id="moren-addr"><input type="checkbox"></input><span>&nbsp;设为默认地址</span></div>
							</form>
						</div>
						<div class="modal-footer" id="footer_update">
							<p id="modal-footer-btnp">
								<button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
							    <button type="button" class="btn btn-primary" data-dismiss="modal" style="width: 120px;">保存新地址</button>
							</p>
							
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
				
		</div>
		<!-- -------------------------------------------------------更改默认地址分割线-------------------------------------------------------- -->
		<div class="modal" id="addDefaultAddr" data-backdrop="static">
		  <!-- 从购物车  -->
		  <c:if test="${oi==null}">
			<div class="addDefaultAddr_display">
				<ul>
					<c:forEach items="${addresslist }" var="address">
					<c:if test="${address.isdefault==1 }">
						<li>
						<span>${address.name }</span>
						<span>${address.tel }</span>
						<span>
							<span>${address.province }</span>
							<span>${address.city }</span>
							<span>${address.village }</span>
							<span>${address.detail }</span>
						</span>
						<span style="color:#D84C29 ;border: #EB1C27 solid 1px;margin-left: 8px">默认地址</span>
					</li>
					</c:if>
					<c:if test="${address.isdefault==0 }">
						<li>
						<span>${address.name }</span>
						<span>${address.tel }</span>
						<span>
							<span>${address.province }</span>
							<span>${address.city }</span>
							<span>${address.village }</span>
							<span>${address.detail }</span>
							<input type="hidden" value="${address.addressid }" />
						</span>
					</li>
					</c:if>
					</c:forEach>
			    </ul>
			    <hr/>
				<span>
					<button class="btn btn-danger" data-dismiss="modal">取消</button>
				</span>
			</div>
			</c:if>
			<!-- 从商品详情  -->
		  <c:if test="${oi!=null}">
			<div class="addDefaultAddr_display">
				<ul>
					<c:forEach items="${oi.addresslist }" var="address">
					<c:if test="${address.isdefault==1 }">
						<li>
						<span>${address.name }</span>
						<span>${address.tel }</span>
						<span>
							<span>${address.province }</span>
							<span>${address.city }</span>
							<span>${address.village }</span>
							<span>${address.detail }</span>
							<input type="hidden" value="${address.addressid }" />
						</span>
						<span style="color:#D84C29 ;border: #EB1C27 solid 1px;margin-left: 8px">默认地址</span>
					</li>
					</c:if>
					<c:if test="${address.isdefault==0 }">
						<li>
						<span>${address.name }</span>
						<span>${address.tel }</span>
						<span>
							<span>${address.province }</span>
							<span>${address.city }</span>
							<span>${address.village }</span>
							<span>${address.detail }</span>
							<input type="hidden" value="${address.addressid }" />
						</span>
					</li>
					</c:if>
					</c:forEach>
			    </ul>
			    <hr/>
				<span>
					<button class="btn btn-danger" data-dismiss="modal">取消</button>
				</span>
			</div>
			</c:if>
		</div>
		<!-- --------------------------------------------------提交订单分割线------------------------------------------------ -->
		<!--点击提交订单-->
		<div class="modal" id="buy_order_sure" data-backdrop="static">
			<div class="buy_order_sure">
				<h1>请核对您的金额以及地址</h1>
				<div>
					
				</div>
				<span>
					<button class="btn btn-success buyit" data-dismiss="modal" data-toggle="modal" data-target="#paycount">朕收了</button>
					<button class="btn btn-danger cancelbuy" data-dismiss="modal">取消</button>
				</span>
			</div>
		</div>
		<!-- --------------------------------------------------支付分割线------------------------------------------------ -->
		<div class="modal" id="paycount" data-backdrop="static">
			<div class="pay_order_sure">
				<h1>请输入银行卡号</h1>
				<div>
					卡　号：<input type="text" id="cardnum" style="height: 30px" /><br/>
					<a id="cardmsg" style="color:red;margin-left: 40px"></a><br/>
				</div>
				<span>
					<span id="iftonext"><button class="btn btn-info " id="paynext">验证卡号</button></span>
					<button class="btn btn-danger " id="cancel_buy1" data-dismiss="modal">取消</button>
				</span>
			</div>
		</div>
		<div class="modal" id="paypass" data-backdrop="static">
			<div class="pay_order_sure paysuccess">
				<h1>请输入银行卡密码</h1>
				<div>
					密　码：<input type="password" id="cardpass" style="height: 30px"/><br/>
					<a id="cardpassmsg" style="color:red;margin-left: 40px"></a><br/>
				</div>
				<span>
					<button class="btn btn-success " id="paynow">确认支付</button>
					<button class="btn btn-danger " id="cancel_buy2" data-dismiss="modal">取消</button>
				</span>
			</div>
		</div>
		
		
		<!-- 得到选中的所有购物车id  -->
		<c:if test="${gcgids!=null }">
			<c:forEach items="${gcgids}" var="gcglist">
				<input type="hidden" value="${gcglist}" class="gcgid">
			</c:forEach>
		</c:if>
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
	</body>

</html>
<script src="js/city.js"></script>
<script src="js/method.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/sub_order.js"></script>
