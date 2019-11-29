(function(){
	var oLi=$('.back_left>ul>li');
	var oDiv=$('.back_right>div');
	for (var i = 0; i < oLi.length; i++) {
		(function(e){
			oLi[e].onclick=function(){
//				alert(oLi.length+'===='+oDiv.length);
				$(this).css('border-radius','10px');
				$(this).css('background','#FFFFCC').siblings('li').css('background','#FFFFFF');				
				for (var k = 0; k < oLi.length; k++) {
					oDiv[k].className='';
				};
				oDiv[e].className='nowclick';
			};
		})(i);
	}
	
})();
(function(){
	var oLi=$('#dingdan_title>li');
	var oDiv=$('#dingdan_control>div');
	for (var i = 0; i < oLi.length; i++) {
		(function(e){
			oLi[e].onclick=function(){
				$('#dingdan_noput').empty();
				$('#dingdan_put').empty();
//				alert(oLi.length+'===='+oDiv.length);
				$(this).css('font-weight','bold').siblings('li').css('font-weight','normal');				
				for (var k = 0; k < oLi.length; k++) {
					oDiv[k].className='';
				};
				oDiv[e].className='dingdan_show';
				//未发货
				if (oLi[e].className='nosendgoodsorder') {
//					alert("aaa");
					$.post('OrderServlet',{},function(re){
						var arr = jQuery.parseJSON(re);
//						console.log(arr);
						for(var i=0;i<arr.length;i++){
							var str=`
								<li>
								<div class="liheadmsg" onclick="clickdb(this)">
									<span><img src="http://${arr[i].goodspicture}"/></span>
									<span id="dingdan_noput_name">${arr[i].gname }</span>
									<span  id="dingdan_noput_addr">用户：<span>${arr[i].uname }</span></span>
									<span id="dingdan_noput_num">数量：<span>${arr[i].goodsnum }</span></span>
									<span id="dingdan_noput_color">颜色：<span>${arr[i].colortype }</span></span>
								</div>
								<div class="goodsdescri">
									<p>商品编号：<span>${arr[i].gid }</span></p>
									<p>商品品牌：<span>${arr[i].gbrand }</span></p>
									<p>商品详情：<span>${arr[i].gintroduce }</span></p>
									<p>商品库存：<span>${arr[i].goodscount }</span></p>
									<p>订单提交时间：<span>${arr[i].godate }</span></p>
									<p>
										<span>收货人：<span>${arr[i].name }</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<span>电话号码：<span>${arr[i].tel }</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<span>收货地址：<span>${arr[i].province }${arr[i].city }${arr[i].village }${arr[i].detail }</span></span>
									</p>
								</div>
								<span id="dingdan_noput_btn" onclick="sendclick('${arr[i].goid}')">
										<button class="btn btn-default">发货</button>
								</span>
							</li>
								`;
							
							$('#dingdan_noput').append(str);
						}
						$('div.goodsdescri').hide();
						
					});
				}
				//已发货
				if (oLi[e].className='sendgoodsandok') {
//					alert('aa');
					$.post('OkOrderServlet',{},function(re){
						var arr = jQuery.parseJSON(re);
						for(var i=0;i<arr.length;i++){
							var str=`
								<li>
								<div class="liheadmsg" onclick="clickdb(this)">
								<span><img src="http://${arr[i].goodspicture}"/></span>
								<span id="dingdan_put_name">
								${arr[i].gname }
								</span>
								<span  id="dingdan_put_addr">用户：<span>${arr[i].uname }</span></span>
								<span id="dingdan_put_num">数量：<span>${arr[i].goodsnum }</span></span>
								<span id="dingdan_put_color">颜色：<span>${arr[i].colortype }</span></span>
								<span id="dingdan_put_condition">
								状态：<sapn>已发货</span>
								</span>
								</div>
								<div class="goodsdescrib">
								<p>商品编号：<span>${arr[i].gid }</span></p>
								<p>商品品牌：<span>${arr[i].gbrand }</span></p>
								<p>商品详情：<span>${arr[i].gintroduce }</span></p>
								<p>商品库存：<span>${arr[i].goodscount }</span></p>
								<p>订单提交时间：<span>${arr[i].godate }</span></p>
								<p>
								<span>收货人：<span>${arr[i].name }</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span>电话号码：<span>${arr[i].tel }</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span>收货地址：<span>${arr[i].province }${arr[i].city }${arr[i].village }${arr[i].detail }</span></span>
								</p>
								</div>
								</li>
								`;
							
							$('#dingdan_put').append(str);
						}
						$('div.goodsdescrib').hide();
						
//					console.log(arr);
					});
				}
			};
		})(i);
	}
	
})();
//未发货块、
function sendclick(orid) {
	if (confirm("是否确定发货")) {
		$.post('SendBtnServlet',{
			id : orid
		},function(re){
			var obj=JSON.parse(re);
			if(obj){
				alert("发货成功");
				$('#dingdan_noput_btn').parent('li').remove();
			}else{
				alert("发货失败");
			}
		});
	}
	
}


//(function(){
//	$('span#dingdan_noput_btn>button').click(function(){
//		if (confirm("是否确定发货")) {
//			alert("发货成功");
//			$(this).parent('span').parent('li').remove();
//		}
//	});
//})();
//申请退货
(function(){
	$('#dingdan_waitback_yes>button').click(function(){
		if (confirm("确定提交申请？")) {
			alert("退款成功！");
			var oLi=$(this).parent('span').parent('li');
			var img=oLi.children('span').children('img');
			var goodsname=oLi.children('#dingdan_waitback_name').text();
			var result=oLi.children('#dingdan_waitback_result').children('span').text();			
			oLi.remove();
		}
	});
	$('#dingdan_waitback_no>button').click(function(){
//		alert($(this).parent('span').siblings('span').children('textarea').val());
		if ($(this).parent('span').siblings().children('textarea').val()=="") {
			alert("请填写拒绝理由！");
		}else if(confirm("确定提交申请？")) {
			alert("已拒绝退款！");
			$(this).parent('span').parent('li').remove();
		};
	});
})();
//手风琴
$('div.goodsdescri').hide();
function clickdb(that) {
	$(that).next().slideToggle();
	
};
//function clickdb(that) {
//	$(that).next().slideToggle();
//	
//};



