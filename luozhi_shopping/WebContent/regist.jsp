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
						<a href="home.html" class="navbar-brand">
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
						<form action="#" method="" class="">
							<span class="search-tubiao glyphicon glyphicon-search"></span>
							<input type="txt" class="search" autocomplete="off" placeholder="1020发烧节">
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
								<li><a href="shopcar.html" class="shoppingCat"><span class="glyphicon glyphicon-shopping-cart cat"></span> <span class="badge catfont">2</span></a></li>
								<li><a class="login-a" data-toggle="modal" data-target='#login'>登录</a></li>
								
							</ul>
							
						</div>
					</div>
					
				</div>
			</nav>
		</header>
		<!--内容-->
		<div class="container">
			<div class="main">
				<div class="breadcrumbs">
					<ul>
						<li class="home">
							<a href="home.html" title="Home">首页</a>
						</li>
						<li class="creat_account">
							<span>>创建新用户</span>
						</li>
					</ul>
				</div>
				<div class="col-main">
					<div class="account_creat">
						<div class="form">
								<div class="form_main">
									<!--用户名-->
									<div class="name">
										<div class="input-group">
											<span class="input-group-addon">
	                                            <span class="glyphicon glyphicon-user"></span>
											</span>
											<input type="text" class="form-control" id="name" placeholder="请设置用户名"  name="name"/>
									    </div>
									    <div class="name_hidden">
											<p>设置后不可更改</p>
											<p>英文数字均可</p>
									    </div>
									    <div class="name_hidden2">
									    	<span id="img"></span>
											<span id="text">用户名仅支持英文、数字和下划线</span>
									    </div>
									    <div class="name_hidden3">
									    	<span id="img"></span>
											<span id="text">用户名不能为空</span>
									    </div>
									    <div class="name_hidden4">
											<span id="img"></span>
										</div>
										<div class="name_hidden5">
											<span id="img"></span>
											<span id="text">用户名只能3-20位</span>
										</div>
										<div class="name_hidden6">
											<span id="img"></span>
											<span id="text">用户名不可用，已注册</span>
										</div>
										
									</div>	
										
									<!--手机号-->
									<div class="phone">
										<div class="input-group">
											<span class="input-group-addon">
	                                            <span class="glyphicon glyphicon-earphone"></span>
											</span>
											<input type="text" class="form-control tel" placeholder="请输入手机号" id="phone" name="phone"/>
										</div>
										<div class="phone_hidden">
											<span>请输入中国大陆手机号，其他用户不可见</span>
										</div>
										<div class="phone_hidden2">
											<span id="img"></span>
											<span id="text">手机号码格式不正确</span>
										</div>
										<div class="phone_hidden3">
											<span id="img">
											</span>
										</div>
										<div class="phone_hidden4">
											<span id="img"></span>
											<span id="text">请您输入手机号</span>
										</div>
									</div>
									
									<!--验证码-->
									<div class="code">
										<div class="input-group">
											<span class="input-group-addon">
												<label>验证码：</label>
											</span>
											<input type="text" class="code" placeholder="请输入验证码" name="code" style="height: 33px;width: 290px"/>
											<img src="ImageServlet" onclick="flushCode(this)"/>
										</div>
										<div class="code_hidden">
											<span id="img"></span>
										</div>
										<div class="code_hidden2">
											<span id="img"></span>
											<span id="text">验证码输入错误</span>
										</div>
										<div class="code_hidden3">
											<span id="img"></span>
											<span id="text">验证码不能为空</span>
										</div>
									</div>
									
									<!--电子邮件-->
									<div class="email">
										<div class="input-group">
											<span class="input-group-addon">
												<label>电子邮箱：</label>
										    </span>
											<input type="text" class="form-control mail" name="mail" id="mail"/>
											<span class="input-group-btn">
												<div class="dropdown">
		                                            <button data-toggle="dropdown" class="btn btn-danger email-end-show">@qq.com
		                                                 <span class="caret"></span>
												    </button>
													<!--项--> 
													<ul class="dropdown-menu email-end">
														<li class="active">@qq.com</li>
														<li>@163.com</li>
														<li>@sina.com</li>
														<li>@139.com</li>
												   		<li>@126.com</li>
													</ul>
											    </div>
										    </span>
									    </div>
									    <div class="email_hidden">
										    	<span id="img"></span>
											    <span id="text">邮箱格式不正确</span>
									    </div>
									    <div class="email_hidden2">
									    	<span id="img"></span>
									    </div>
									    <div class="email_hidden3">
									    	<span id="img"></span>
										    <span id="text">邮箱不能为空</span>
									    </div>
									    <div class="email_hidden4">
									    	<span id="img"></span>
										    <span id="text">该邮箱已注册</span>
									    </div>
									</div>
									
									<!--密码-->
									<div class="pass">
										<div class="input-group">
											<span class="input-group-addon">
					                            <span class="glyphicon glyphicon-lock" ></span>
											</span>
											<input type="password" class="form-control pass" placeholder="请设置密码" name="pass"/>
										</div>
										<div class="pass_hidden">
											<span id="img"></span>
										</div>
										<div class="pass_hidden3">
											<span>为长度6~16个数字和字母组成</span>
										</div>
										<div class="pass_hidden2">
											<span id="img"></span>
											<span id="text">密码必须由数字、字母组成</span>
										</div>
										<div class="pass_hidden4">
											<span id="img"></span>
											<span id="text">密码不能为空</span>
										</div>
									</div>
									<!--确认登陆密码-->
									<div class="surepass">
										<div class="input-group">
											<span class="input-group-addon">
												<label>确认密码：</label>
											</span>
											<input type="password" class="form-control surepass" placeholder="请再次输入密码" name="surepass"/>
										</div>
										<div class="surepass_hidden">
											<span id="img"></span>
										</div>
										<div class="surepass_hidden2">
											<span id="img"></span>
											<span id="text">密码不一致，请重新输入</span>
										</div>
										<div class="surepass_hidden3">
											<span id="img"></span>
											<span id="text">密码格式不对，请重新输入</span>
										</div>
										<div class="surepass_hidden4">
											<span id="img"></span>
											<span id="text">密码不能为空</span>
										</div>
									</div>
									<div class="agreement">
										<input type="checkbox" class="agree" />
										<i>我已阅读并同意网站的使用条件及隐私声明。</i>
									</div>
									<div class="register">
										<button id="register" class="btn btn-success">注册</button>
							            <button class="btn btn-danger">取消</button>
									</div>
				                </div>
			            </div>
			        </div>
		        </div>
		    </div>
		</div>
		
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
					        		<input type="checkbox" id="savepassword" checked="${pageScope.check }"/>
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
	
	</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/regist.js" ></script>