<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<title>注册</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/regist.css" />
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
		<link rel="stylesheet" type="text/css" href="css/resetpassword.css">
		<style>
		.upper{
		background-color:#2894FF;
		}
		</style>
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
						<form action="LikeSelectServlet" method="get"  class="">
							<span class="search-tubiao glyphicon glyphicon-search"></span>
							<input type="text" class="search" autocomplete="off" name="val" autocomplete="off"  placeholder="1020发烧节">
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
					<!--隐藏登录后被挤的信息-->	
					<input id="SingletStateLoginListenerMsg" type="hidden" value="${SingletStateLoginListenerMsg }" />
					
					<div class="col-xs-12 col-lg-4 col-md-8 col-sm-8 navbar-right">
						<div class="collapse navbar-collapse navbar-right" id="myNav">
							<ul class="nav navbar-nav">
								<li><a href="shopcar.html" class="shoppingCat"><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">0</span></a></li>
								<li><a class="login-a" data-toggle="modal" data-target='#login'>登录</a></li>
								
							</ul>
							
						</div>
					</div>
					
				</div>
			</nav>
		</header>
		<!--内容-->
		<!-- 上方账号提示 -->
		<div class="container">
			<div class="main" style="width:100%;">
				 	<div class="main">
				<div class="breadcrumbs">
					<ul>
						<li class="home">
							<a href="#" title="Home">账号</a>
						</li>
							<li class="creat_account">
							<span>>设置完成</span>
						</li>
					</ul>
				</div>     
		    </div>
		</div>
		<!-- 上方账号提示-->
		<!-- 上方进展提示框 -->
		<div class="upper-div">
		<ul class="upper-list">
		<li>
		<div  class="upper">
		<p class="upper-p">1</p>
	    <p class="tip">身份验证</p>
		</div>
		<div>
		<hr style=" width:120px;height:2px;border:none;margin:15px 0px ; border-top:2px skyblue groove;" />
		</div>
		</li>
		<li><div  class="upper">
		<p class="upper-p">2</p>
		<p class="tip">设置密码</p>
		</div>
			<div>
		<hr style=" width:120px;height:2px;border:none;margin:15px 0px ; border-top:2px skyblue groove;" />
		</div>
		</li>
		<li><div  class="upper">
		<p class="upper-p">3</p>
		<p class="tip">完成</p>
		</div>

		</li>
		</ul>
		</div>
		<!-- 进展提示框 -->
		<!-- 内容填写 -->
		<center>
		<!-- 设置成功后的div -->
		<div class="setsuccess">
		<img src="img/setsuccess.png">
		<p class="settip">重置密码成功</p>
		</div>
		<!-- 设置成功后的div -->
		</center>
		<!-- 内容填写 -->
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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/regist.js" ></script>
<script type="text/javascript">
(function(){
	
	})();	
</script>
<script>
</script>