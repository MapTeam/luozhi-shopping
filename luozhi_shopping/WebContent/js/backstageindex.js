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
				$('#dingdan_waitback').empty();
				$('#dingdan_back').empty();
//				alert(oLi.length+'===='+oDiv.length);
				$(this).css('font-weight','bold').siblings('li').css('font-weight','normal');				
				for (var k = 0; k < oLi.length; k++) {
					oDiv[k].className='';
				};
				oDiv[e].className='dingdan_show';
				//未发货
				if (oLi[e].className=='nosendgoodsorder') {
//					alert("aaa");
					$.post('OrderServlet',{
						status : 0
					},function(re){
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
				if (oLi[e].className=='sendgoodsandok') {
//					alert('aa');
					$.post('OrderServlet',{
						status : 1
					},function(re){
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
				//申请退货
				if (oLi[e].className=='requesttoback') {
					$.post('ReqBackServlet',{
						status : 4
					},function(re){
						var arr = jQuery.parseJSON(re);
						for(var i=0;i<arr.length;i++){
							var str=`
							<li>
							<span><img src="http://${arr[i].goodspicture}"/></span>
							<span id="dingdan_waitback_name">
								${arr[i].gname}
							</span>
							<span id="dingdan_waitback_num">
								✖&nbsp;${arr[i].goodsnum}
							</span>
							<span  id="dingdan_waitback_result">原因：
								<span>${arr[i].reason}</span>
							</span>                   
							<span id="dingdan_waitback_yes" onclick="agree('${arr[i].goid}')"><button class="btn btn-success">同意</button></span>
							<span id="dingdan_waitback_no" onclick="refuse('${arr[i].goid}')"><button class="btn btn-danger">拒绝</button></span>
							<span id="dingdan_waitback_no_result">
							    <textarea style="resize: none" value placeholder="拒绝原因："></textarea>
							</span>
						</li>
							`;
						$('#dingdan_waitback').append(str);
						}
					});
					
				};
				
				//已退货
				if (oLi[e].className=='okback') {
					$.post('ReqBackServlet',{
						status : 5
					},function(re){
						var arr = jQuery.parseJSON(re);
						for (var i = 0; i < arr.length; i++) {
							var str=`
							<li>
								<span><img src="http://${arr[i].goodspicture}"/></span>
								<span id="dingdan_back_name">
									${arr[i].gname}
								</span>
								<span id="dingdan_back_num">
										✖&nbsp;&nbsp;${arr[i].goodsnum}
								</span>
								<span  id="dingdan_back_result">原因：<span>${arr[i].reason}</span></span>
								<span id="dingdan_back_yes">退款成功</span>
							</li>
							`;
							$('#dingdan_back').append(str);
						}
					});
				};
			};
		})(i);
	}
	
})();

//未发货块、
function sendclick(orid) {
	if (confirm("是否确定发货")) {
		$.post('SendBtnServlet',{
			id : orid,
			status : 1
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

//申请退货同意
	function agree(orid){
		if (confirm("确定同意申请？")) {
			$.post('SendBtnServlet',{
				id : orid,
				status : 5
			},function(re){
				var obj=JSON.parse(re);
				if(obj){
					alert("退款成功！");
					$('#dingdan_waitback_yes').parent('li').remove();
				}else{
					alert("退款失败！");
				}
			})
		}
	};
//  申请退货拒绝
	function refuse(orid){
//		alert($(this).parent('span').siblings('span').children('textarea').val());
		if ($('#dingdan_waitback_no').siblings('span').children('textarea').val()=="") {
			alert("请填写拒绝理由！");
		}else {
			var str=$('#dingdan_waitback_no').siblings('span').children('textarea').val();
			if(confirm("确定拒绝申请？")) {
				$.post('InsertRefuseServlet',{
					id : orid,
					msg : str
				},function(re){
					if (re) {
						alert("已拒绝申请！");
					}else{
						alert("拒绝失败！")
					}
				});
			}
		}
	};

//手风琴
$('div.goodsdescri').hide();
function clickdb(that) {
	$(that).next().slideToggle();
	
};




