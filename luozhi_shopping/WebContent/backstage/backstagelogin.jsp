<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>后台登录</title>	
		<link rel="stylesheet" href="/luozhi_shopping/css/bootstrap.css" />
		<link rel="stylesheet" href="/luozhi_shopping/css/animate.css" />
		<link rel="stylesheet" href="/luozhi_shopping/css/base.css" />
		<link rel="stylesheet" href="/luozhi_shopping/css/backstagelogin.css" />
</head>
<body>
	<!--头部-->
	<header>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-head navbar-left">
					<a href="HomeServlet" class="navbar-brand">
						<img src="/luozhi_shopping/img/logo.png" class="logo"/>
						<!--<span id="logo-font">
							洛枳商城
						</span>-->
					</a>					
				</div>					
			</div>
		</nav>
	</header>
	<section>
			<div class="container animated bounceOut wow fadeInDown" data-wow-delay="1s">
				<center class="row col-lg-offset-3 content">
					<form action="BackstageLoginServlet" method="post">
					<h1>后台登录</h1>
					用户名：<input type="text" name="username"/>
					<br />
					密　码：<input type="password" name="password"/>
					<br />
					<input id="hhlogin"  type="submit" value="登　录"/>
					</form>
				</center>
				<img class="waitlogin" src="/luozhi_shopping/img/waitlogin.jpg" />
			</div>
		</section>
</body>
</html>
<script type="text/javascript" src="/luozhi_shopping/js/jquery.min.js" ></script>
<script type="text/javascript" src="/luozhi_shopping/js/bootstrap.js" ></script>
<script type="text/javascript" src="/luozhi_shopping/js/wow.min.js" ></script>
<script>
	$('#hhlogin').click(function(){
		$('.waitlogin').css('display','block');
	});
</script>