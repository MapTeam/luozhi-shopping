
(function(){
	//回到顶部
$(document).scroll(function(){
 	
		if($(document).scrollTop() <200)
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
(function(){
	var goodname=$('.promes_goodsname').text();
	var goodcolor=$('.promes_goodscolor').text();
	var goodnum=$('.promes_goodsnum').text();
	var goodprice=$('.promes_goodsprice').text();
	var address=$('.promes_useraddr').text();
	var tel=$('.promes_usertel').text();
	var username=$('.promes_username').text();
	$('.paybtn').click(function(){
		var buy_order_sure_infomation=`
 					<h2>`+goodname+`</h2>
					<h3>￥`+goodprice+`</h3>
					<h4>颜色:`+goodcolor+`　　数量:`+goodnum+`</h4>
					<span>`+address+`</span><br/>
					<span>姓名:`+username+`</span>
					<h5>电话:`+tel+`</h5>
 		`;
 		$('.buy_order_sure>div').html(buy_order_sure_infomation);
		$('.buy_order_sure').css('display','block');
	});
})();
//没有地址时点击提交
(function() {
	//电话号码判断正则
	var phoneTrue=/^1(3|4|5|6|7|8|9)\d{9}$/;
	$('.saving-button').click(function() {
		
		if (""!=$('#shouhuorenText').val()&&""!=$('#telText').val()&&""!=$('#addr-show').val()&&""!=$('.detail').val()) {
			if (!phoneTrue.test($('#telText').val())) {
				alert("电话号码格式填写错误!");
				
				
			}else{
				$.post("InsertAddressServlet",{
					'uid':$('#uid').val(),
					'name':$('#shouhuorenText').val(),
					'tel':$('#telText').val(),
					'addr1':$('#addr-show').val(),
					'addr2':$('.detail').val(),
				},function(val){
					var obj=JSON.parse(val);
					if (obj.ifInsertAddrSuccess==true) {
						alert("添加成功，已经设为默认地址！")
						location.reload(true);
					}
				});
			}
			
		}else{
			alert("请将信息填写完整");
		}
	});
})();

//修改地址
(function() {
	$('#updateAddress').click(function() {
		var name=$('.promes_username').text();
		var tel=$('.promes_usertel').text();
//		var province=$('.promes_useraddr_province').text();
//		var city=$('.promes_useraddr_city').text();
//		var village=$('.promes_useraddr_village').text();
//		var detail=$('.promes_useraddr_detail').text();
		var updateAndadduserInformation=`
							<div><span>　收货人：</span><input id="InputName" type="text" placeholder="　　为了提高发货速度，请填写您的真实姓名" size=40 style="height: 35px;"  value="`+name+`"></input>
							</div>
							<div><span>手机号码：</span><input id="InputTel" type="text" maxlength="11" size=40 style="height:35px;" value="`+tel+`"></input>
							</div>							
		`;
		var modalfooterbtnp=`
		    <p id="modal-footer-btnp">
				<button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
			    <button type="button" class="btn btn-primary"  style="width: 120px;">确认修改</button>
			</p>
		`;
		$('#updateAndadduserInformation').empty();
		$('#updateAndadduserInformation').append(updateAndadduserInformation);
		$('#moren-addr').empty();
		$('#footer_update').empty();
		$('#footer_update').append(modalfooterbtnp);
		
		//电话号码判断正则
		var phoneTrue=/^1(3|4|5|6|7|8|9)\d{9}$/;
		$('.btn-primary').click(function() {
					
				if (""!=$('#InputName').val()&&""!=$('#InputTel').val()&&""!=$('#addr-show').val()&&""!=$('#InputAddr2').val()) {
					if (!phoneTrue.test($('#InputTel').val())) {
						alert("电话号码格式填写错误!");
						
						
					}else{
						$.post("UpdateAddressServlet",{
							'addressid':$('#AddressId').val(),
							'isdefault':$('#IsDefault').val(),
							'name':$('#InputName').val(),
							'tel':$('#InputTel').val(),
							'addr1':$('#addr-show').val(),
							'addr2':$('#InputAddr2').val(),
						},function(val){
							var obj=JSON.parse(val);
							if (obj.ifUpdateAddrSuccess==true) {
								alert("修改成功，已经设为默认地址！")
								location.reload(true);
							}
						});
					}
					
				}else{
					alert("请将信息填写完整");
				}
			
		});
		
	});
})();


