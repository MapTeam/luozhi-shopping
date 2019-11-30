<%@page import="java.net.URLDecoder"%>
<%@page import="com.lz.pojo.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link rel="stylesheet" href="css/product_particular.css" />
<link rel="stylesheet" type="text/css" href="css/login.css"/>
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
<body data-spy="scroll" data-offset="100">
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
		<!--商品导航栏-->
		<div class="shopping_nav">
			<nav class="nav navbar-default navbar-fixed-top" id="shopping_nav" data-spy="affix" data-offset-top="700">
				<div class="container">
					<div class="navbar-header" id="nav_picture">
						<a href="" class="navbar-brand shopping_nav_information" >
						  <img src="${goods.zpicture}"/ class="logo">
							<span style="float: left;">
								<p>${goods.gname}</p>
								<p style="color: #C9302C;">￥${goods.gprice}</p>
							</span>
						</a>
						 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myShopping">
		                	<span class="icon-bar"></span>
		                	<span class="icon-bar"></span>
		                	<span class="icon-bar"></span>
		                 </button>
					</div>
					<div class="navbar-collapse collapse navbar-right" id="myShopping">
						<c:if test="${userinfo==null }">
				    			<button  style="margin-top:10px ; width: 150px; height: 36px; background: white;border: #C9302C solid 3px;color: #C9302C;font-size: 20px;float: left;" id="shop_current_little" data-toggle="modal" data-target="#login">立即购买</button>
				    		    <button style="margin-top:10px ; width: 150px; height: 36px;background: #C9302C;border: none;color: white;font-size: 20px;margin-left: 10px;" data-toggle="modal" data-target="#login"><span  class="glyphicon glyphicon-shopping-cart" >加入购物车</span></button>
				    	</c:if>
				    	<c:if test="${userinfo!=null }">
				    			<input type="hidden" value="${userinfo.user.uid }" id="uid"/>
				    			<button  style="margin-top:10px ; width: 150px; height: 36px; background: white;border: #C9302C solid 3px;color: #C9302C;font-size: 20px;float: left;" id="shop_current_little" data-toggle="modal" data-target="#buy_order">立即购买</button>
				    		    <button style="margin-top:10px ; width: 150px; height: 36px;background: #C9302C;border: none;color: white;font-size: 20px;margin-left: 10px;" id="add_shopping_car_little"><span  class="glyphicon glyphicon-shopping-cart" >加入购物车</span></button>
				    	</c:if>
					</div>
				</div>
			</nav>
		</div>
		<!--顶部-->
		<section>
			<div class="container">
				<div class="row" id="top">
					<h4>
					<a style="font-size: 25px;font-weight: bold;color: black;top: 16px;" href="HomeServlet" class="col-md-1">首页</a>
					<span class="top_title">
						<c:if test="${hhcategory1 != null }">
							<c:if test="${hhcategory1==101001 }">
								<span style="color: #8C8C8C;left: -20px;top: 20px; " class="col-md-8">&gt;<a style="color: black;font-size: 18px;font-weight: bold;" href="HotServlet">${classifytitle}</a>&gt;${goods.gname }</span>
							</c:if>
							<c:if test="${hhcategory1!=101001 }">
								<span style="color: #8C8C8C;left: -20px;top: 20px; " class="col-md-8">&gt;<a style="color: black;font-size: 18px;font-weight: bold;" href="ClassifyServlet?category1=${hhcategory1}">${classifytitle}</a>&gt;${goods.gname }</span>
							</c:if>
						</c:if>
						<c:if test="${hhcategory1 == null }">
						<span style="color: #8C8C8C;left: -20px;top: 20px;" class="col-md-8">&gt;${goods.gname }</span>
						</c:if>
					</span>
					
					<span class="glyphicon glyphicon-new-window right" style="font-size: 20px;float: right;color: #333333;top: 16px;" class="col-md-2"><a style="color: #333333;font-weight: bold;" href="#">分享</a></span>
				    </h4>
				</div>
				 <hr  class="row"/>
			</div>
		</section>
		<!--图片价格快-->
		<section>
			<div class="container">
				<div class="row" id="product_banner">
				<div class="col-md-5 center" id="product_picture">
					<div class="row">
						<div id="product_big_picture">
							<img src=""/>
							<!--<ul>
								<li class="active"><a><img src="img/1.jpg"/></a></li>
								<li><a><img src="img/2.jpg" /></a></li>
								<li><a><img src="img/3.jpg" /></a></li>
								<li><a><img src="img/2.jpg" /></a></li>
							</ul>-->
							<!--放大镜-->
							<div></div>
							<a href="javascript:;" id="next"></a>
		 					<a href="javascript:;" id="prev"></a>
					    </div>
					</div>
					<div class="center product_little_picture" id="product_little_picture">
					<!--<span class="current"><img src="img/particular1.jpg"/></span>
					<span><img src="img/particular6.jpg"/></span>
					<span><img src="img/particular3.jpg"/></span>
					<span><img src="img/particular4.jpg"/></span>-->
					<span class="current"><img src="${lpimg.get(0) }"/></span>
						<c:forEach items="${lpimg }" begin="1" end="${lpimg.size() }" var="l">
							<span><img src="${l }"/></span>
						</c:forEach>
					</div>																							
				</div>
				<!--放大镜显示-->
				<div id="margnify_show"></div>
				
				
				<div class="col-md-7 col-sm-7" id="product_content">					  				    
				    <ul class="product_content_title">
						 <li><h3>${goods.gname}</h3></li>
						<li><p id="product_content_slogan">${goods.gintroduce}</p></li>
						<li><h3 id="price">￥${goods.gprice}</h3></li>
				    	<!--<li><h3>伯朗 i9S蓝牙5.0真无线耳机双耳通话苹果安卓通用</h3></li>
				    	<li><p id="product_content_slogan">1020音乐发烧节震撼来袭，2019年度最爆狂欢，10月20日0点正式开启！</p></li>
				    	<li><h3 id="price">￥89</h3></li>-->
				    </ul>
				    <ul>
				    	<li style="margin-top: 20px; padding-top: 5px;">
				    		<span>
				    			<div class="row product_content_sellquick" id="content_sellquick">
				    				<p  id="product_content_sellquick">促销 :</p>
				    				<ul id="product_content_sellquick_btn">
				    					<li class="show">
				    						<span class="redbounds_label">手慢无</span>
				    						<span> 30元  1020数码钜惠,无门槛</span>
				    						<span><a href="">领券</a></span>
				    						<a id="content_sellquick_updown"><span class="glyphicon glyphicon-chevron-down"></span></a>
				    						<a>全部优惠券(4) </a>
				    					</li>				    									    					<li>
				    						<span class="redbounds_label">全场通用</span>
				    						<span> 20元  1020返场通用券,满99元可用</span>
				    						<span><a href="">领券</a></span>
				    						
				    					</li>				    									    					<li>
				    						<span class="redbounds_label">全场通用</span>
				    						<span> 40元  1020返场通用券,满199元可用</span>
				    						<span><a href="">领券</a></span>
				    						
				    					</li>				    									    					<li>
				    						<span class="redbounds_label">全场通用</span>
				    						<span> 60元  1020返场通用券,满299元可用</span>
				    						<span><a href="">领券</a></span>
				    						
				    					</li>
				    				</ul>
				    			</div>
				    		</span>
				    		
					
				    	</li>
				    	<li style="margin-top: 20px;">
				    		<span>
				    			<div class="row">
				    				<p  id="product_content_type">颜色 :</p>
				    		      <div id="product_content_type_btn">
				    		      	<ul>
				    		      		<c:forEach items="${gcolors }" var="gcolor">
				    		      			<li><button class="btn btn-default" id="type_button" type="button" value="${gcolor.goodspicture}">${gcolor.colortype }</button>
				    		      				<!-- 传一个隐藏的库存值和id  -->
				    		      				<input type="hidden" value="${gcolor.goodscount}" id="goodscount"/>
				    		      				<input type="hidden" value="${gcolor.gcolorid}" id="gcolorid"/>
				    		      			</li>
				    		      		</c:forEach>
				    		      	</ul>
				    			    <!--<button class="btn btn-default" id="type_button" type="button">白色</button>-->
				    		      </div>
				    			</div>
				    			
				    		</span>				    		
				    	</li>
				    	<li style="margin-top: 20px;">
				    		<span>
				    			<div class="row">
				    			   <p  id="product_content_number">数量 :</p>
				    		       <div id="product_content_number_btn">
				    			      <i id="product_num_decbtn"><span style="line-height: 25px" class="glyphicon glyphicon-minus"></span></i>
				    			      <input id="product_num_text" type="text" value="1"/>
				    			      <i id="product_num_addbtn"><span style="line-height: 25px" class="glyphicon glyphicon-plus"></span></i>
				    		        </div>
				    		    </div>
				    		</span>
				    		
				    		
				    	</li>
				    	<li style="margin-top: 20px; padding-top: 5px;">
				    		<span>
				    			<div class="row">
				    				<p  id="product_content_service">服务 :</p>
				    			    <div  id="product_content_service_btn" style="top: 5px;">
				    			    	<a href="" style="height: 34px;">&bull;7天无理由退货　　&bull;15天无忧换货　　&bull;满119包邮　　&bull;商家发货网易自营</a>
				    			    </div>	
				    			</div>
				    		</span>			    		
				    	</li>
				    	<li style="margin-top: 20px;">
				    		<span>
				    			<div class="row">
				    				<c:if test="${userinfo==null }">
				    					<button  style="width: 172px; height: 50px;font-size: 20px;float: left;" id="shop_current" data-toggle="modal" data-target="#login">立即购买</button>
				    		        	<button style="width: 172px; height: 50px;background: #C9302C;border: none;color: white;font-size: 20px;margin-left: 10px;" data-toggle="modal" data-target="#login"><span  class="glyphicon glyphicon-shopping-cart" >加入购物车</span></button>
				    				</c:if>
				    				<c:if test="${userinfo!=null }">
				    					<input type="hidden" value="${userinfo.user.uid }" id="uid"/>
				    					<button  style="width: 172px; height: 50px;font-size: 20px;float: left;" id="shop_current" data-toggle="modal" data-target="#buy_order">立即购买</button>
				    		        	<button style="width: 172px; height: 50px;background: #C9302C;border: none;color: white;font-size: 20px;margin-left: 10px;" id="add_shopping_car"><span  class="glyphicon glyphicon-shopping-cart" >加入购物车</span></button>
				    				</c:if>
				    			</div>
				    		</span>
				    		
				    		
				    	</li>
				    </ul>
				    
				</div>
				</div>
				
			</div>
		</section>
		<!-- 图片介绍块 -->
		<section style="margin-top: 50px;">
			<div class="container">
				<div class="row">
					<div class="col-md-8" id="particular_picture">
							<h4 style="font-size: 30px;font-weight: bold;">商品详情</h4>
							<hr/>
							<c:forEach items="${inimg }" var="p">
								<img src="${p }"/>
							</c:forEach>
							
							<!-- <img src="img/particular2.jpg"/>
							<img src="img/particular3.jpg"/>
							<img src="img/particular4.jpg"/>
							<img src="img/particular5.jpg"/>
							<img src="img/particular6.jpg"/> -->
					</div>
					<div class="col-md-4" style="margin-top: 6px;">
							<h5 style="font-size: 25px;font-weight: bold;">热门商品</h5>
							<hr />
							<c:forEach items="${hotgoods }" var="good">
								<div class="row" id="hot_commodity">
									<span>									
									  <img src="${good.zpicture }"/>
									  <p><a href="IntroudceServlet?gid=${good.gid }"> ${good.gname }</a></p>
									  <p>￥${good.gprice }</p>
									</span>			
								</div>
							</c:forEach>
					</div>
				</div>
			</div>
		</section>
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
				        <a target="_blank" href="regist.html">没有帐号？免费注册  ></a>
			        </div>
	        
		    	</div>
	   		</div>
	    </div>
	    
	    <!--立即购买块-->
	    <div class="modal" id="buy_order" data-backdrop="static">
			<div class="buy_order_show">
				<h1>您真的要购买吗？</h1>
				<p style="color: #FFCE44;"><span class="glyphicon glyphicon-question-sign"></span></p>
				<span>
					<button class="btn btn-success yes" data-dismiss="modal">是</button>
					<button class="btn btn-danger no" data-dismiss="modal">否</button>
				</span>
			</div>
		</div>
		
	</body>
</html>
<script  src="js/jquery.min.js" ></script>
<script  src="js/bootstrap.js" ></script>
<script src="js/base.js"></script>
<script src="js/product_particular.js" ></script>