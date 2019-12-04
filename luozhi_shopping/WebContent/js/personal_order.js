//$('.person').mouseenter(function(){
//	$('.list').css('display','block');
//	$('.downchild').css('transform','rotate(180deg)')
//});
//
//$('.person').mouseleave(function(){
//	$('.list').css('display','none');
//	$('.downchild').css('transform','rotate(360deg)')
//});

var num=1;
var price=0;
var sum=0;
(function(){
	//回到顶部
$(document).scroll(function(){
 	
		if($(document).scrollTop() <500)
		{	
			if($('.totop').is(':animated'))
			{return;}
			$('.zTi-rigth').css('height','300px');
			$('.totop').fadeOut(1000);
		}else{
			if($('.totop').is(':animated'))
			{return;}
			$('.zTi-rigth').css('height','335px');
			$('.totop').fadeIn(1000);
		}		
	});
	//添加点击事件
	$('.totop').click(function(){
		$('body,html').animate({'scrollTop':0},1000);
	});
})();


var oLi =$('#tab>li');
var contents =$('.m-tab>div');
//alert(contents.length)
for(var i = 0;i< oLi.length;i++)
{	
	(function(x){
		oLi[x].onclick =function(){
			$('#dingdan_nopay').empty();
			$('#dingdan_pay').empty();
			$('#dingdan_send').empty();
			$('#dingdan_all').empty();
			$('.empty').empty();
			for(var j=0;j<oLi.length;j++)
			{
				$(this).css('font-weight','bold').siblings('li').css('font-weight','normal');
				$(this).children('a').css('color','#333');
			
			}
			for(var j=0;j<contents.length;j++)
			{
				contents[j].className='';
			}
			contents[x].className='current';
			//待支付
			if(oLi[x].className=='nopayorder'){
			
				$.post('UserOrderByUidAndSta',{
					status : 2
				},function(re){
					var arr = jQuery.parseJSON(re);
					if (arr=='') {
						$('#dingdan_nopay').css('display','none');
						var s=`
						<div class="empty">
							<i class="icn"></i>
							<p class="nogoodorder">您当前没有待支付的订单</p>
						</div>
						`;
						$('#nopay').append(s);
					}else{
						$('#dingdan_nopay').css('display','block');
						for(var i=0;i < arr.length;i++){
							var str=`<li class="lili">
										<p class="outgoodid">
											<span>订单号:<span>${arr[i].goname}</span></span>
										</p>`;
//							$('#dingdan_nopay').append(str);
//							console.log(str);
							for(var j=0;j<arr[i].gogoods.length;j++){
//								console.log(arr[i].gogoods.length);
//								console.log('2');
//								str=``;
								str =str+ `<div class="liheadmsg">
												<span><a href="IntroudceServlet?gid=`+arr[i].gogoods[j].gid+`"><img src="http://`+arr[i].gogoods[j].goodspicture+`"/></a></span>
												<div onclick="clickdb(this)" class="wjmsg">
													<span id="dingdan_nopay_name">`+arr[i].gogoods[j].gname+`</span>
													<span  id="dingdan_nopay_addr">价格：<span>${arr[i].gogoods[j].gprice }</span></span>
													<span id="dingdan_nopay_num">数量：<span>`+arr[i].gogoods[j].goodsnum+`</span></span>
													<span id="dingdan_nopay_color">颜色：<span>`+arr[i].gogoods[j].colortype+`</span></span>
												</div>
											</div>
											<div class="goodsdescri">
												<p>商品编号：<span>`+arr[i].gogoods[j].gid+`</span></p>
												<p>商品品牌：<span>`+arr[i].gogoods[j].gbrand+`</span></p>
												<p>商品详情：<span>`+arr[i].gogoods[j].gintroduce+`</span></p>
												<p>订单提交时间：<span>`+arr[i].godate+`</span></p>
												<p>
													<span>收货人：<span>`+arr[i].name+`</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<span>电话号码：<span>`+arr[i].tel+`</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<span>收货地址：<span>`+arr[i].province+arr[i].city+arr[i].village+arr[i].detail+`</span></span>
												</p>
											</div>
											<input type="hidden" value="${arr[i].gogoods[j].gprice }" class="prices">
											<input type="hidden" value="${arr[i].gogoods[j].goodsnum }" class="number">
											`;
							
//							$('.lili').append(str);
//							console.log(str);
//							var str1=$('.prices').eq(j).val();
//							var str2=$('.number').eq(j).val();
//							num= parseInt(str1);
//							price= parseFloat(str2);
//							sum+=num*price;
							}
//							str=``;
								str = str+`<span id="dingdan_cancel_btn" onclick="cancelclick('`+arr[i].goid+`')">
											<button class="btn btn-default">取消订单</button>
											</span>
											<span id="dingdan_nopay_btn" onclick="payclick('`+arr[i].goid+`',this)">
											<button class="btn btn-danger">立即付款</button>
											</span>
											</li>`;
//								$('.lili').append(str);
//								console.log(str);
								$('#dingdan_nopay').append(str);
						}
						$('div.goodsdescri').hide();
					}
				});
			}
			//待发货
			if(oLi[x].className=='sendorder'){
				$.post('UserOrderByUidAndSta',{
					status : 0
				},function(re){
					var arr = jQuery.parseJSON(re);
					if (arr=='') {
						$('#dingdan_pay').css('display','none');
						var str=`
						<div class="empty">
							<i class="icn"></i>
							<p class="nogoodorder">您当前没有待发货的订单</p>
						</div>
						`;
						$('#pay').append(str);
					}else{
						$('#dingdan_pay').css('display','block');
						for(var i=0;i < arr.length;i++){
							var str=`<li>
										<div class="outgoodid">
											<span>订单号:<span>${arr[i].goname}</span></span>
										</div>`;
							for(var j=0;j<arr[i].gogoods.length;j++){
								str = str + `<div class="liheadmsg">
												<span><a href="IntroudceServlet?gid=`+arr[i].gogoods[j].gid+`"><img src="http://`+arr[i].gogoods[j].goodspicture+`"/></a></span>
												<div onclick="clickdb(this)" class="wjmsg">
													<span id="dingdan_pay_name">`+arr[i].gogoods[j].gname+`</span>
													<span  id="dingdan_pay_addr">价格：<span>${arr[i].gogoods[j].gprice }</span></span>
													<span id="dingdan_pay_num">数量：<span>`+arr[i].gogoods[j].goodsnum+`</span></span>
													<span id="dingdan_pay_color">颜色：<span>`+arr[i].gogoods[j].colortype+`</span></span>
												</div>
												<span class="dropdown" style="float:right" id="reason">退货理由：
													<button data-toggle="dropdown" class="btn btn-default reasonendshow">七天无理由退货
														<span class="caret"></span>
													</button>
										            <ul class="dropdown-menu reasonend">
											             <li class="active" onclick="reason_li(this)"><a href="javascript:;">七天无理由退货</li>
											             <li onclick="reason_li(this)"><a href="javascript:;">不想买了</a></li>
											             <li onclick="reason_li(this)"><a href="javascript:;">拍错了</a></li>
											             <li onclick="reason_li(this)"><a href="javascript:;">长时间没有发货</a></li>
											             <li onclick="reason_li(this)"><a href="javascript:;">产品与描述不符</a></li>
										            </ul>
												</span>
											</div>
											<div class="goodsdescri">
												<p>商品编号：<span>`+arr[i].gogoods[j].gid+`</span></p>
												<p>商品品牌：<span>`+arr[i].gogoods[j].gbrand+`</span></p>
												<p>商品详情：<span>`+arr[i].gogoods[j].gintroduce+`</span></p>
												<p>订单提交时间：<span>`+arr[i].godate+`</span></p>
												<p>
													<span>收货人：<span>`+arr[i].name+`</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<span>电话号码：<span>`+arr[i].tel+`</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<span>收货地址：<span>`+arr[i].province+arr[i].city+arr[i].village+arr[i].detail+`</span></span>
												</p>
											</div>`;
							}
								str = str + `
											<span id="dingdan_pay_btn" onclick="backmoney(this)">
												<button class="btn btn-danger">申请退款</button>
											</span>
											<span id="dingdan_sure_btn" onclick="sure(this,`+arr[i].goid+`)">
												<button class="btn btn-danger">确定</button>
											</span>
											<span id="dingdan_noca_btn" onclick="noca(this)">
												<button class="btn btn-default">取消</button>
											</span>
										</li>`;
								$('#dingdan_pay').append(str);
							
						}
				
						$('div.goodsdescri').hide();
					}
				});
			}
			
			//待收货
			if(oLi[x].className=='sendokorder'){
				$.post('UserOrderByUidAndSta',{
					status : 1
				},function(re){
					var arr = jQuery.parseJSON(re);
					if (arr=='') {
						$('#dingdan_send').css('display','none');
						var str=`
						<div class="empty">
							<i class="icn"></i>
							<p class="nogoodorder">您当前没有待发货的订单</p>
						</div>
						`;
						$('#sendgood').append(str);
					}else{
						$('#dingdan_send').css('display','block');
						for(var i=0;i < arr.length;i++){
							var str=`<li>
										<div class="outgoodid">
											<span>订单号:<span>${arr[i].goname}</span></span>
										</div>`;
							for(var j=0;j<arr[i].gogoods.length;j++){
								str = str + `<div class="liheadmsg">
												<span><a href="IntroudceServlet?gid=`+arr[i].gogoods[j].gid+`"><img src="http://`+arr[i].gogoods[j].goodspicture+`"/></a></span>
												<span id="dingdan_send_name">`+arr[i].gogoods[j].gname+`</span>
												<span  id="dingdan_send_addr">价格：<span>${arr[i].gogoods[j].gprice }</span></span>
												<span id="dingdan_send_num">数量：<span>`+arr[i].gogoods[j].goodsnum+`</span></span>
												<span id="dingdan_send_color">颜色：<span>`+arr[i].gogoods[j].colortype+`</span></span>
											</div>`;
							}
								str = str + `<span id="dingdan_nopay_btn" onclick="suresh(this)"  data-toggle="modal" data-target='#paycount'>
											<button class="btn btn-danger">确定收货</button>
											</span>
											</span>
											</li>`;
								$('#dingdan_send').append(str);
						}
				
						
					}
				});
			}
			
			//全部订单
			if(oLi[x].className=='allorder'){
				$.post('UserOrderByUid',{
				},function(re){
					var arr = jQuery.parseJSON(re);
					if (arr=='') {
						$('#dingdan_all').css('display','none');
						var str=`
						<div class="empty">
							<i class="icn"></i>
							<p class="nogoodorder">您当前没有待发货的订单</p>
						</div>
						`;
						$('#allgoods').append(str);
					}else{
						$('#dingdan_all').css('display','block');
						for(var i=0;i < arr.length;i++){
							var str=`<li>
										<div class="outgoodid">
											<span>订单号:<span>${arr[i].goid}</span></span>
										</div>`;
							for(var j=0;j<arr[i].gogoods.length;j++){
								str = str + `<div class="liheadmsg">
												<span><a href="IntroudceServlet?gid=`+arr[i].gogoods[j].gid+`"><img src="http://`+arr[i].gogoods[j].goodspicture+`"/></a></span>
												<span id="dingdan_all_name">`+arr[i].gogoods[j].gname+`</span>
												<span  id="dingdan_all_addr">价格：<span>${arr[i].gogoods[j].gprice }</span></span>
												<span id="dingdan_all_num">数量：<span>`+arr[i].gogoods[j].goodsnum+`</span></span>
												<span id="dingdan_all_color">颜色：<span>`+arr[i].gogoods[j].colortype+`</span></span>
											</div>`;
							}
								str = str + `<span id="dingdan_all_btn"onclick="payclick('`+arr[i].goid+`')">`;
								if (arr[i].gostate==0) {
									str=str+`<span>未发货</span>
									</span>
									</li>`;
								}
								if (arr[i].gostate==1) {
									str=str+`<span>已发货</span>
									</span>
									</li>`;
								}
								if (arr[i].gostate==2) {
									str=str+`<a>待付款</a>
									</span>
									</li>`;
								}
								if (arr[i].gostate==7) {
									str=str+`<span>已取消订单</span>
									</span>
									</li>`;
								}
								if (arr[i].gostate==3) {
									str=str+`<span>已收货</span>
									</span>
									</li>`;
								}
								if (arr[i].gostate==4) {
									str=str+`<span>退货中</span>
									</span>
									</li>`;
								}
								if (arr[i].gostate==5) {
									str=str+`<span>退货成功</span>
									</span>
									</li>`;
								}
								if (arr[i].gostate==6) {
									str=str+`<span>退货失败</span>
									</span>
									</li>`;
								}
										
								$('#dingdan_all').append(str);
						}
				
						
					}
				});
			}
		}
		
	})(i);
}
//num=2;
//price=3;
//alert(num*price);
//点击支付
function payclick(orid,obj) {
	var that=obj;
	sum=0;
//	alert($(that).parent('li').children('.liheadmsg').length);
	$(that).parent('li').children('.liheadmsg').each(function(e) {
		var str1= $(this).children('.wjmsg').children('#dingdan_nopay_addr').children('span').text();
		var str2= $(this).children('.wjmsg').children('#dingdan_nopay_num').children('span').text();
//		alert(str);
		num= parseInt(str1);
		price= parseFloat(str2);
		sum+=num*price;
	});
	alert(sum);
//	var str= $(that).siblings('.liheadmsg').children('.wjmsg').children('#dingdan_nopay_addr').children('span').text();
//	alert(str);
//	alert(sum);
//	alert($('#number').val());
//	alert(sum);
//	if (confirm("是否立即支付")) {
//		$.post('SendBtnServlet',{
//			id : orid,
//			status : 0
//		},function(re){
//			var obj=JSON.parse(re);
//			if(obj){
//				alert("支付成功");
//				location.reload(true);
////				$(that).parent('li').remove();
//			}else{
//				alert("支付失败");
//			}
//		});
//	}
}
//取消订单
function cancelclick(orid) {
	if (confirm("小主真的不考虑下吗？")) {
		$.post('SendBtnServlet',{
			id : orid,
			status : 7
		},function(re){
			var obj=JSON.parse(re);
			if(obj){
				location.reload(true);
//				$(that).parent('li').remove();
//				alert(orid);
			}else{
				alert("请重新操作");
			}
		});
	}
}
//申请退款
function backmoney(that,orname){
		$(that).parent('li').children('.liheadmsg').children('#reason').css('display','block');
		$(that).siblings('#dingdan_noca_btn').css('display','block');
		$(that).siblings('#dingdan_sure_btn').css('display','block');
		$(that).css('display','none');
//		alert(orname);
}
var msg='';
function reason_li(that){
//	alert($(that).children('a').text());
	$(that).parent().siblings('.reasonendshow').html($(that).html() + '<span class="caret"></span>');
	$(that).addClass('active').siblings().removeClass('active');
//	$(that).parent('ul').parent('span').parent('.liheadmsg').siblings('#dingdan_pay_btn').css('display','none');
//	$(that).parent('ul').parent('span').parent('.liheadmsg').siblings('#dingdan_sure_btn').css('display','block');
//	$(that).parent('ul').parent('span').parent('.liheadmsg').siblings('#dingdan_noca_btn').css('display','block');
	msg=$(that).children('a').text();
}
//确定申请
function sure(that,goid) {
	if (msg=='') {
		msg="七天无理由退货"
	}
	if (confirm("确定退款吗？")) {
		$.post('SendBtnServlet',{
			id : goid,
			status : 4,
			msg : msg
		},function(re){
			var obj=JSON.parse(re);
			if(obj){
			$(that).parent().remove();
			}else{
				alert("请重新操作");
			}
		});
	}
}
//取消申请
function noca(that) {
	$(that).siblings('#dingdan_pay_btn').css('display','block');
	$(that).siblings('#dingdan_sure_btn').css('display','none');
	$(that).css('display','none');
	$(that).parent('li').children('.liheadmsg').children('#reason').css('display','none');
}
//确定收货
function suresh(that){
}

$('div.goodsdescri').hide();
function clickdb(that) {
	$(that).parent().next().slideToggle();
	
};



//订单操作
(function() {
	//定义一个锁
	var flagcardnam=false;
	var flagcardpass=false;
	//点击输入框样式消失
	$('#cardnum').focus(function() {
		$('#cardmsg').html("");
	});
	$('#cardpass').focus(function() {
		$('#cardpassmsg').html("");
	});
	var countname="";
	$('#paynext').click(function() {
		
		if (flagcardnam==true) {
			return;
		}
		countname=$('#cardnum').val();
		flagcardnam=true;
		
		if (""!=countname) {
			var text = "正在验证";
			$('#cardmsg').html(text);
			$.post("JudgeCardNumServlet",{
				'countname':countname,
				
			},function(val){
				var obj=JSON.parse(val);
//				console.log(obj);
				if (obj.flag) {
					$('#iftonext').empty();
					var str=`<button class="btn btn-success " id="paynext" data-dismiss="modal" data-toggle="modal" data-target="#paypass">下一步</button>`;
					$('#iftonext').append(str);
					$('#cardmsg').css('color','green');
					$('#cardmsg').html("账号存在，请点击下一步");
				}else{
					$('#cardmsg').html("   "+obj.msg);
				}
				flagcardnam=false;
			});
		}
		
	});
	$('#paynow').click(function() {
		if (flagcardpass==true) {
			return;
		}
		flagcardpass=true;
		var countpass= $('#cardpass').val();
		var money=$('.promes_goodsprice').text();
		if (""!=countpass) {
			var text = "正在支付";
			$('#cardpassmsg').html(text);
			$.post("JudgeCardpasswordServlet",{
				'countname':countname,
				'countpass':countpass,
				'money':money,
			},function(val){
			var obj=JSON.parse(val);
			if (obj.flag) {
				gowaitpay(0);
				flagcardpass=false;
			}else{
				$('#cardpassmsg').html("   "+obj.msg);
				flagcardpass=false;
			}
			});
		}
		
	});
	function gowaitpay(gostate){
		var addrid=$('#AddressId').val();
		var gcolorid="";
		var goodscount="";
		$('.shangpingli').each(function(e) {
			gcolorid+=$(this).children('span').children('.promes').children('#hhgcolorid').val();
			goodscount+=$(this).children('.promes_goodsnum').text()+',';		
		});
		var gcgid="";
		$('.gcgid').each(function(e) {
			gcgid+=$(this).val()+",";
		});
		
		$.post("OderPayFromoderServlet",{
			'addrid':addrid,
			'gcolorid':gcolorid,
			'goodscount':goodscount,
			'gcgid':gcgid,
			'gostate':gostate,
		},function(val){
			if((gostate==0)){
				$('.paysuccess').empty();
				var str=`
				<h1>支付成功<h1>
				<p class="sucesstohome">等待<span id="sucesstime">3</span>秒回到主页</p>
				`;
				$('.paysuccess').append(str);
				var time=2;
				var span=document.getElementById("sucesstime")
				setInterval(function(){
					span.innerHTML=time;
					time--;
					if(time<0){
						location.href="HomeServlet";
					}
				},1000);
			}
			
		});
		
	}
})();
