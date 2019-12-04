//$('.person').mouseenter(function(){
//	$('.list').css('display','block');
//	$('.downchild').css('transform','rotate(180deg)')
//});
//
//$('.person').mouseleave(function(){
//	$('.list').css('display','none');
//	$('.downchild').css('transform','rotate(360deg)')
//});


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
						var str=`
						<div class="empty">
							<i class="icn"></i>
							<p class="nogoodorder">您当前没有待支付的订单</p>
						</div>
						`;
						$('#nopay').append(str);
					}else{
						$('#dingdan_nopay').css('display','block');
						for(var i=0;i < arr.length;i++){
							var str=`<li>
										<p class="outgoodid">
											<span>订单号:<span>${arr[i].goname}</span></span>
										</p>`;
							for(var j=0;j<arr[i].gogoods.length;j++){
								
								str = str + `<div class="liheadmsg">
												<span><a href="IntroudceServlet?gid=`+arr[i].gogoods[j].gid+`"><img src="http://`+arr[i].gogoods[j].goodspicture+`"/></a></span>
												<div onclick="clickdb(this)" class="wjmsg">
													<span id="dingdan_nopay_name">`+arr[i].gogoods[j].gname+`</span>
													<span  id="dingdan_nopay_addr">用户：<span>${arr[i].uname }</span></span>
													<span id="dingdan_nopay_num">数量：<span>`+arr[i].gogoods[j].goodsnum+`</span></span>
													<span id="dingdan_nopay_color">颜色：<span>`+arr[i].gogoods[j].colortype+`</span></span>
												</div>
											</div>
												<div class="goodsdescri">
												<p>商品编号：<span>`+arr[i].gogoods[j].gid+`</span></p>
												<p>商品品牌：<span>`+arr[i].gogoods[j].gbrand+`</span></p>
												<p>商品详情：<span>`+arr[i].gogoods[j].gintroduce+`</span></p>
												<p>商品库存：<span>`+arr[i].gogoods[j].goodscount+`</span></p>
												<p>订单提交时间：<span>`+arr[i].godate+`</span></p>
												<p>
													<span>收货人：<span>`+arr[i].name+`</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<span>电话号码：<span>`+arr[i].tel+`</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<span>收货地址：<span>`+arr[i].province+arr[i].city+arr[i].village+arr[i].detail+`</span></span>
												</p>
											</div>`;
							}
								str = str + `<span id="dingdan_cancel_btn" onclick="payclick('`+arr[i].goid+`')">
											<button class="btn btn-default">取消订单</button>
											</span>
											<span id="dingdan_nopay_btn" onclick="cancelclick('`+arr[i].goid+`')">
											<button class="btn btn-danger">立即付款</button>
											</span>
											</li>`;
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
												<div class="wjmsg" onclick="clickdb(this)">
												<span id="dingdan_pay_name">`+arr[i].gogoods[j].gname+`</span>
												<span  id="dingdan_pay_addr">用户：<span>${arr[i].uname }</span></span>
												<span id="dingdan_pay_num">数量：<span>`+arr[i].gogoods[j].goodsnum+`</span></span>
												<span id="dingdan_pay_color">颜色：<span>`+arr[i].gogoods[j].colortype+`</span></span>
												</div>
											</div>
											<div class="goodsdescri">
												<p>商品编号：<span>`+arr[i].gogoods[j].gid+`</span></p>
												<p>商品品牌：<span>`+arr[i].gogoods[j].gbrand+`</span></p>
												<p>商品详情：<span>`+arr[i].gogoods[j].gintroduce+`</span></p>
												<p>商品库存：<span>`+arr[i].gogoods[j].goodscount+`</span></p>
												<p>订单提交时间：<span>`+arr[i].godate+`</span></p>
												<p>
													<span>收货人：<span>`+arr[i].name+`</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<span>电话号码：<span>`+arr[i].tel+`</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<span>收货地址：<span>`+arr[i].province+arr[i].city+arr[i].village+arr[i].detail+`</span></span>
												</p>
											</div>`;
							}
								str = str + `
								<span id="dingdan_pay_btn">
											<span>未发货</span>
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
												<span><img src="http://`+arr[i].gogoods[j].goodspicture+`"/></span>
												<span id="dingdan_send_name">`+arr[i].gogoods[j].gname+`</span>
												<span  id="dingdan_send_addr">用户：<span>${arr[i].uname }</span></span>
												<span id="dingdan_send_num">数量：<span>`+arr[i].gogoods[j].goodsnum+`</span></span>
												<span id="dingdan_send_color">颜色：<span>`+arr[i].gogoods[j].colortype+`</span></span>
											</div>`;
							}
								str = str + `<span id="dingdan_nopay_btn">
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
												<span><img src="http://`+arr[i].gogoods[j].goodspicture+`"/></span>
												<span id="dingdan_all_name">`+arr[i].gogoods[j].gname+`</span>
												<span  id="dingdan_all_addr">用户：<span>${arr[i].uname }</span></span>
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
//点击支付
function payclick(orid) {
	if (confirm("是否立即支付")) {
		$.post('SendBtnServlet',{
			id : orid,
			status : 0
		},function(re){
			var obj=JSON.parse(re);
			if(obj){
				alert("支付成功");
				$('#dingdan_nopay_btn').parent('li').remove();
			}else{
				alert("支付失败");
			}
		});
	}
	
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
				$('#dingdan_cancel_btn').parent('li').remove();
			}else{
				alert("请重新操作");
			}
		});
	}
}


$('div.goodsdescri').hide();
function clickdb(that) {
	$(that).parent().next().slideToggle();
	
};

