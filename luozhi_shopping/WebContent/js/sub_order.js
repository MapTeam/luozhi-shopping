
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
	var goodprice=$('.promes_goodsprice').text();
	var address=$('.promes_useraddr').text();
	var tel=$('.promes_usertel').text();
	var username=$('.promes_username').text();
	$('.paybtn').click(function(){
		var buy_order_sure_infomation=`
					<h3>￥`+goodprice+`</h3>
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
		var detail=$('.promes_useraddr_detail').text();
		var updateAndadduserInformation=`
							<div><span>　收货人：</span><input id="InputName" type="text" placeholder="　　为了提高发货速度，请填写您的真实姓名" size=40 style="height: 35px;"  value="`+name+`"></input>
							</div>
							<div><span>手机号码：</span><input id="InputTel" type="text" maxlength="11" size=40 style="height:35px;" value="`+tel+`"></input>
							</div>							
		`;
		var modaldetail=`
		<textarea style="height: 60px;width:470px;resize: none;max-height:120px; max-width:470px;border: none;" id="InputAddr2" placeholder="无需重复填写省市区，小于120字" >`+detail+`</textarea>
		`;
		var modalfooterbtnp=`
		    <p id="modal-footer-btnp">
				<button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
			    <button type="button" class="btn btn-primary"  style="width: 120px;">确认修改</button>
			</p>
		`;
		//收货人和电话号码依然显示
		$('#updateAndadduserInformation').empty();
		$('#updateAndadduserInformation').append(updateAndadduserInformation);
		//将脚部的按钮成页面显示的
		$('#footer_update').empty();
		$('#footer_update').append(modalfooterbtnp);
		//将是否为默认地址这一块去掉
		$('#moren-addr').empty();
		//将详细信息写入进去
		$('#addr-sure').empty();
		$('#addr-sure').append(modaldetail);
		
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
//添加地址
(function(){
	$('#addnewAddress').click(function() {
		var updateAndadduserInformation=`
							<div><span>　收货人：</span><input type="text" id="InputName" placeholder="　　为了提高发货速度，请填写您的真实姓名" size=40 style="height: 35px;"> </input>
							</div>
							<div><span>手机号码：</span><input type="text" id="InputTel" maxlength="11"  size=40 style="height:35px;"></input>
							</div>							
		`;
		var modaldetail=`
		<textarea style="height: 60px;width:470px;resize: none;max-height:120px; max-width:470px;border: none;" id="InputAddr2" placeholder="无需重复填写省市区，小于120字"></textarea>
		`;
		var modalfooterbtnp=`
		    <p id="modal-footer-btnp">
				<button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
			    <button type="button" class="btn btn-primary"  style="width: 120px;">添加新地址</button>
			</p>
		`;
		var modalmorenaddress=`
		<input type="checkbox" id="checkboxisdefault"></input><span>&nbsp;设为默认地址</span>
		`;
		//收货人和电话号码变空
		$('#updateAndadduserInformation').empty();
		$('#updateAndadduserInformation').append(updateAndadduserInformation);
		//将脚部的按钮成页面显示的
		$('#footer_update').empty();
		$('#footer_update').append(modalfooterbtnp);
		//将是否为默认地址添加上
		$('#moren-addr').empty();
		$('#moren-addr').append(modalmorenaddress);
		//将详细信息里的内容删掉进去
		$('#addr-sure').empty();
		$('#addr-sure').append(modaldetail);
		
		//获取一个是否为默认地址的值
		var isdefault=0;
		$('#checkboxisdefault').click(function(){
			if ($(this).is(':checked')) {
				isdefault=1;
			}else{
				isdefault=0;
			}
		});
		//电话号码判断正则
		var phoneTrue=/^1(3|4|5|6|7|8|9)\d{9}$/;
		$('.btn-primary').click(function() {
					
				if (""!=$('#InputName').val()&&""!=$('#InputTel').val()&&""!=$('#addr-show').val()&&""!=$('#InputAddr2').val()) {
					if (!phoneTrue.test($('#InputTel').val())) {
						alert("电话号码格式填写错误!");
					}else{
						$.post("AddNewAddressServlet",{
							'isdefault':isdefault,
							'name':$('#InputName').val(),
							'tel':$('#InputTel').val(),
							'addr1':$('#addr-show').val(),
							'addr2':$('#InputAddr2').val(),
						},function(val){
							var obj=JSON.parse(val);
							if (obj.ifAddAddrSuccess==true) {
								alert("添加成功")
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
//点击修改默认地址
(function() {
	$('.addDefaultAddr_display>ul>li').click(function() {
		var addrid=$(this).children('span').children('input').val();
		if (confirm("确定将该地址设为默认地址？")) {
			if (""!=addrid&&addrid!=null&&addrid!=undefined) {
				$.post("UpdateAddressIsdefaultServlet",{
					'addrid':addrid
				},function(val){
					var obj=JSON.parse(val);
					if (obj.ifUpdateDefaultAddrSuccess==true) {
						location.reload(true);
					}
				});
			}
		}
		
	});
})();
//取消订单
(function() {
	$('#cancel_buy').click(function() {
		var addrid=$('#AddressId').val();
		var gcolorid="";
		var goodscount="";
		$('.shangpingli').each(function(e) {
			gcolorid+=$(this).children('span').children('.promes').children('#hhgcolorid').val();
			goodscount+=$(this).children('.promes_goodsnum').text()+',';		
		});
		$.post("GetWaitPayServlet",{
			'addrid':addrid,
			'gcolorid':gcolorid,
			'goodscount':goodscount,
		},function(val){
			var obj=JSON.parse(val);
			if (obj.ifgetwaitpaysuccess==true) {
				window.location.href="LikeSelectServlet?val=";
			}
		});
		
	});
})();
