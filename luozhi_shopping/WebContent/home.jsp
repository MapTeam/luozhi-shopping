<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link rel="stylesheet" type="text/css" href="css/home.css"/>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<title>Home</title>  
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
								<li><a href="ShoppingCarServlet" class="shoppingCat"><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">${userinfo.shopcargoodsnum}</span></a></li>							
								</c:if>
								<c:if test="${userinfo==null }">
									<li><a href="javascript:;" class="shoppingCat" data-toggle="modal" data-target='#login'><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">0</span></a></li>							
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
		<!--轮播-->
		<div class="banner">
			<ul>
				<li class="active">
					<a href=""><img src="img/1.jpg"/></a>
				</li>
				<li>
					<a href=""><img src="img/2.jpg"/></a>
				</li>
				<li>
					<a href=""><img src="img/3.jpg"/></a>
				</li>
			</ul>
			<a href="javascipt:;" class="next" id="next"><img src="img/next.png"/></a>
			<a href="javascipt:;" class="prev" id="prev"><img src="img/prev.png"/></a>
			<div class="number">
				<span class="active"></span>
				<span></span>
				<span></span>
			</div>
		</div>
	
		<!--tab-->
		<div class="tab">
			<div class="container tab-content">
					<ul class="row">
						<li class="col-md-3">
							<a href="HotServlet">
								<img src="img/host.png" />
								<span class="">热销爆品</span>
							</a>
							<em class="line"></em>
						</li>
						<li class="col-md-3">
							<a href="ClassifyServlet?category1=1008002">
								<img src="img/gou.png" />
								<span class="">IP周边</span>
							</a>
							<em class="line"></em>
						</li>
						<li class="col-md-3">
							<a href="ClassifyServlet?category1=101000">
								<img src="img/shuma.png" />
								<span class="">数码影音</span>
							</a>
							<em class="line"></em>
						</li>
						<li class="col-md-3">
							<a href="">
								<img src="img/jifen.png" />
								<div class="fadein-right">
									<p>积分商城</p>
									<span class="count">0</span>
									<span class="jifen">积分</span>
								</div>
							</a>
						</li>
					</ul>
			</div>
		</div>
		
		<!--右边浮动竖条-->
		<div class="zTi">
			<div class="container">
				<div class="row text-center">
					<div class="col-md-6">
						<a href="">
							<img src="img/有音乐.jpg"/>
						</a>
					</div>
					<div class="col-md-6">
						<a href="">
							<img src="img/晚安.jpg" />
						</a>
					</div>
				</div>
				
			</div>
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
							<a href="javascript:;" class="totop-a">
								<span class="totop-span"></span>
							</a>
						</li>
					</ul>
			</div>
		</div>
		
		<!--推荐-->
		<div class="recommend">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<span class="recommend-f">
							推荐商品	
						</span>
					</div>
				</div>
				<!--商品-->
				<div class="row" id="recommend-goodsList">
					<c:forEach items="${RecommandGoodsList}" var="p">
						<div class="col-md-3">
						     <div class="thumbnail">
						        	<a href="IntroudceServlet?gid=${p.gid }">
								        <img src="${p.zpicture}"/>
								        <caption>
								          <p class="goods-name">${p.gname}</p>
								          <p style="font-weight:bold;font-size: 17px;color: #A94442; " class="goods-price">¥${p.gprice}</p>
								        </caption>
							        </a>
						      </div>
					    </div>
					</c:forEach>
					 <!--<div class="col-md-3">
					     <div class="thumbnail">
					        	<img src="${obj.data[i].goods_thumb}"/>
						        <caption>
						          <p class="goods-name">${obj.data[i].goods_name}</p>
						          <p class="goods-desc">${obj.data[i].goods_desc}</p>
						          <p>${obj.data[i].price}</p>
						          <p><span class="glyphicon  glyphicon-star"></span>${obj.data[i].star_number}</p>
						          <button class="btn btn-info">加入购物车</button>
						        </caption>
					      </div>
				    </div>-->
				</div>
			</div>
		</div>
		
		<!--热门商品-->
		<div class="hot">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<span class="hot-f">
							热门商品	
						</span>
					</div>
				</div>
				<!--商品-->
				<div class="row" id="hot-goodsList">
					<c:forEach items="${HotGoodsList}" var="p">
						<div class="col-md-3">
						     <div class="thumbnail">
						        	<a href="IntroudceServlet?gid=${p.gid }">
								        <img src="${p.zpicture}"/>
								        <caption>
								          <p class="goods-name">${p.gname}</p>
								          <p class="goods-price">¥${p.gprice}</p>
								        </caption>
							        </a>
						      </div>
					    </div>
					</c:forEach>
				</div>
				<!--加载   无更多商品-->
      			<div id="loading" class="text-center h2 alert alert-info loading">加载更多</div>
			</div>
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
					                <input type="text" class="form-control user" id="username" placeholder="请输入账号" value="${pageScope.uname }"/>
				            	</div>
				          	</div>
			                <div class="form-inline password">
					            <div class="form-group">
					                <label>密码：</label>
					                <input type="password" class="form-control loginpass" id="pwd" placeholder="请输入密码" value="${pageScope.upwd }"/>
					            </div>
						    </div>
					         <div class="loginmsg"></div>
						    <div class="auto">
						    	<label class="lab">
					        		<input type="checkbox" id="savepassword" ${pageScope.check?"checked":"" }/>
					        		<span>保存密码</span>
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
				        <a target="_blank" href="regist.jsp">没有帐号？免费注册  ></a>
			        </div>
	        
		    	</div>
	   		</div>
	    </div>
		
	</body>
</html>
<script src="js/jquery.min.js"></script>
<script src="js/base.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/home.js"></script>
<script src="js/banner.js"></script>