<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<meta name="viewport"  content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="css/bootstrap.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="css/shopcar.css"/>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
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
        <div class="head">
            <p >购物车</p>
        </div>
        <c:if test="${goodscarIsNotNull==null}">
        <hr style="border-top:1px solid black">
         <div style="position:absolute;top:50%;left:50%;">
         <div>
         <img src="img/cart1.png">
         </div>
         <span style="font-size:18px;color:#666666;">购物车还是空的,</span><span><a href="HomeServlet" style="font-size:18px;color:#328AD4;">去逛逛></a></span>
         </div>
        </c:if>
       <c:if test="${goodscarIsNotNull=='yes'}">
        <hr style="border-top:1px solid black">
        <table class="tb" >
        <!--标题栏-->
            <tr class="tr-h" style="height: 50px ">
                <td ><input type="checkbox" class="allchecked"><span class="allchecked-span">全选</span></td>
                <td >商品</td>
                <td>金额</td>
                <td >数量</td>
                <td>小计</td>
                <td>操作</td>
            </tr>
        <!-- 商品统计栏-->
            <tr class="tongji">
                <td colspan="4" class="allgoods"><span style="margin-right: 75px;"></span>全部商品(<span class="allgoods">0</span>)</td>
                <td colspan="2"  class="quanchang"><span class="yh-img"></span>全场满<span style="color:rgb(211,58,49) ">¥</span><span class="free">0</span>免运费</td>
            </tr>
        <!--商品-->
          <c:forEach items="${goodscardto}" var="a">
         <tr class="shoping">
          <td class="shangpin">
          	<div>
          		<input type="checkbox" class="check"/>
          	</div>          
            <img class="img" src="${a.zpicture}"/>
          </td>
          <td class="desc">
          	<p> ${a.gname}</p>
          	<p style="color:#c0c0c0; "> ${a.colortype}</p>
          </td>
          <td class="money"><fmt:formatNumber type="number" value="${a.gprice}" pattern="0.00" maxFractionDigits="2"/></td>
          <td>
            <span class="add glyphicon glyphicon-plus" id="product_num_addbtn" ></span>
            <input id="product_num_text" type="button" value="${a.goodsnum}" class="count"/>
            <span class="reduce glyphicon glyphicon-minus" id="product_num_decbtn"></span>
          </td>
          <td class="subtotal"><fmt:formatNumber type="number" value="${a.gprice*a.goodsnum}" pattern="0.00" maxFractionDigits="2"/></td>
           <td class="delete"><input type="hidden" class="gcgid" value="${a.gcgid}"/><a href="javascript:;"><img class="del" src="img/ca.png"></a></td>
        </tr>
          </c:forEach>
        </table>
        <div class="jiesuan">
                <div class="jiesuan-font">
                    <a>结算</a>
                </div>
                <span class="jiesuan-count">0.00</span>
                <span style="font-size: 20px;">¥</span>
                <span style="color:#333333">合计 &nbsp;:&nbsp;&nbsp;</span>
        </div>
        </c:if>
       
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
					                <input type="text" class="form-control user" id="username" placeholder="请输入账号"/>
				            	</div>
				          	</div>
			                <div class="form-inline password">
					            <div class="form-group">
					                <label>密码：</label>
					                <input type="password" class="form-control loginpass" id="pwd" placeholder="请输入密码"/>
					            </div>
						    </div>
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
				        <a target="_blank" href="regist.jsp">没有帐号？免费注册  ></a>
			        </div>
	        
		    	</div>
	   		</div>
	   		
	    </div>
</body>
</html>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/base.js"></script>

<script>
  //点击加减数量变   小计变  总价变
  //点击全选        总价变
  //点击单选        总价变
  //点击删除        当前元素tr删除 
  //点击整个表格
  var flag = false;
  $('table').click(function(event){
    if($(event.target)[0].className == 'check'){
    	sumAll();
    }
    //全选
    if($(event.target)[0].className == 'allchecked'){
    	if($(event.target).is(':checked')){
    		$('.check').each(function (i){
    			$(this).prop("checked", true);
    		});
    		sumAll();
    	}else{
    		$('.check').each(function (i){
    			$(this).prop("checked", false);
    		});
    		sumAll();
    	};
    };
    //AddOrReduceCarGoodsServlet
    //加
    if($(event.target)[0].className == 'add glyphicon glyphicon-plus'&&flag==false){
    	flag = true;
    	var spanDom = $(event.target).siblings('.count');
	    var spanDomVal = parseInt(spanDom.val());
	    $.post('AddOrReduceCarGoodsServlet', {
			gcgid : $(event.target).parent().next().next().children('.gcgid').val(),
			type : 1,
		},function (rs){
			var obj = JSON.parse(rs);
			if(obj.AddOrReduceMsg){
				console.log(obj);
				spanDomVal++;
			    if (spanDomVal>1) {
			    	$(event.target).siblings('#product_num_decbtn').css('color','#333333');
			    }
			    var num = parseFloat($(event.target).parent().siblings('.money').html())*spanDomVal;
			    $(event.target).parent().siblings('.subtotal').html(name(num));
			    spanDom.val(spanDomVal);
			    sumAll();
			}
			flag = false;
		});
    };
    //减
     if($(event.target)[0].className == 'reduce glyphicon glyphicon-minus'&&flag==false){
    	 flag = true;
    	 var spanDom = $(event.target).siblings('.count');
	    var spanDomVal = parseInt(spanDom.val());
	   // console.log($(event.target).parent().next().next().children('.gcgid').val());
	    $.post('AddOrReduceCarGoodsServlet', {
			gcgid : $(event.target).parent().next().next().children('.gcgid').val(),
			type : 2,
		},function (rs){
			var obj = JSON.parse(rs);
			if(obj.AddOrReduceMsg){
				console.log(obj);
				spanDomVal--;
			    if (spanDomVal==1) {
			    	$(event.target).css('color','#C0C0C0');
			    }
			    if(spanDomVal<1){
			    	spanDomVal = 1;
			    };
			    var num = parseFloat($(event.target).parent().siblings('.money').html())*spanDomVal;
			    $(event.target).parent().siblings('.subtotal').html(name(num));
			    spanDom.val(spanDomVal);
			    sumAll();
			 }
			flag = false;
		});
    };
    //删除
    if($(event.target)[0].className == 'del'){
    	if(confirm("您真的要删除吗？")){
    		$.post('CarGoodsRemoveServlet', {
    			gcgid : $(event.target).parent().siblings('.gcgid').val(),
    		},function (rs){
    			var obj = JSON.parse(rs);
    			if(obj.CarGoodsRemove){
    				$(event.target).parent().parent().parent().remove();
    	    		sumAll();
    				$('.catfont').html(parseInt($('.catfont').text())-1);
    				if (parseInt($('.catfont').text())==0) {
    					location.reload(true);
					}
    			}
    		});
    	}
    };
    
  });
  
  function sumAll(){
  	var sum = 0.00;
  	$('.check').each(function (i){
  		if($(this).is(':checked')){
  			sum+=parseFloat($(this).parent().parent().siblings('.subtotal').html());
  		};
  	});
  	
  	$('.jiesuan-count').html(name(sum));
  };
  
  $('.jiesuan-font').mouseover(function(){
  	if($('.jiesuan-count').html()!=0){
  		$('.jiesuan-font').css('background','red');
  	};
  });
  
  $('.jiesuan-font').mouseout(function(){
  	if($('.jiesuan-count').html()!=0){
  		$('.jiesuan-font').css('background','#aaaaaa');
  	}
  });
  
  //取两位小数
  function name(num) {
	  if(num.toString().match(/\d+\.\d+/g)){
		  if(num.toString().match(/^\d+\.\d{1}$/)){
			  return (num+'0');
		  }else{
			  return Number(num.toString().match(/^\d+(?:\.\d{0,2})?/));
		  }
	  }else {
		  return (num+'.00');
	  }
  }
  
  
</script>