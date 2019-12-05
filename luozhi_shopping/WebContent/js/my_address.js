(function() {
	var oDiv=$('.wjlist');
	oDiv.each(function() {
		var name=$(this).children('dd').children('.myname').text();
		var tel=$(this).children('.mytel').text();
		var detail=$(this).children('dd').children('span').children('.detail').text();
		var addressid=$(this).children('dd').children('span').children('#myaddressid').val();
//		点击修改地址
		
		$(this).children('dd').children('.edit').click(function() {
			
				var updateAndadduserInformation=`
					<div><span>　收货人：</span><input id="InputName" type="text" placeholder="　　为了提高发货速度，请填写您的真实姓名" size=40 style="height: 35px;"  value="`+name+`"></input>
					</div>
					<div><span>手机号码：</span><input id="InputTel" type="text" maxlength="11" size=40 style="height:35px;" value="`+tel+`"></input>
					</div>							
					`;
				var modaldetail=`
					<textarea style="height: 60px;width:470px;resize: none;max-height:120px; max-width:470px;border: none;" id="InputAddr2" placeholder="无需重复填写省市区，小于120字" >`+detail+`</textarea>
					`;
				//将详细信息写入进去
				$('#addr-sure').empty();
				$('#addr-sure').append(modaldetail);
				//收货人和电话号码依然显示
				$('#updateAndadduserInformation').empty();
				$('#updateAndadduserInformation').append(updateAndadduserInformation);
				//将是否为默认地址这一块去掉
				$('#moren-addr').empty();
//				alert(name+"==="+tel+"==="+detail+"===="+addressid);
				//电话号码判断正则
				var phoneTrue=/^1(3|4|5|6|7|8|9)\d{9}$/;
				//定义修改地址的锁
				var flag=false;
				$('.btn-primary').click(function() {
						
					if (flag==false) {
						flag=true;	
						if (""!=$('#InputName').val()&&""!=$('#InputTel').val()&&""!=$('#addr-show').val()&&""!=$('#InputAddr2').val()) {
							if (!phoneTrue.test($('#InputTel').val())) {
								alert("电话号码格式填写错误!");
								flag=false;
							}else{
								$.post("UpdateAddressServlet",{
									'addressid':addressid,
									'isdefault':1,
									'name':$('#InputName').val(),
									'tel':$('#InputTel').val(),
									'addr1':$('#addr-show').val(),
									'addr2':$('#InputAddr2').val(),
								},function(val){
									var obj=JSON.parse(val);
									flag=false;
									if (obj.ifUpdateAddrSuccess==true) {
										alert("修改成功，已设为默认地址");
										location.reload(true);
									}
								});
							}
							
						}else{
							alert("请将信息填写完整");
							flag=false;
						}
					}
				});
			
			
			
			
		});
	//点击删除地址
		$(this).children('dd').children('.delete').click(function(){
			if (confirm("您确定要删除吗？")) {
				if (addressid!=null&&""!=addressid&&addressid!=undefined) {
					$.post("DeleteAddressServlet",{
						'addressid':addressid,
						
					},function(val){
						var obj=JSON.parse(val);
						if (obj.ifRemoveAddrSuccess==true) {
							var str=`
							<div>
							<h1 id="msgdeletsuccess">删除成功</h1>
							</div>
							`;
							$('body').append(str);
							location.reload(true);
						}
					});
				}
			}
			
		});
		//点击修改为默认地址
		$(this).children('dd').children('span').children('.setdefaultaddr').click(function(){
				if (addressid!=null&&""!=addressid&&addressid!=undefined) {
					$.post("UpdateAddressIsdefaultServlet",{
						'addrid':addressid
					},function(val){
						var obj=JSON.parse(val);
						if (obj.ifUpdateDefaultAddrSuccess==true) {
							location.reload(true);
						}
					});
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
				var modalmorenaddress=`
				<input type="checkbox" id="checkboxisdefault"></input><span>&nbsp;设为默认地址</span>
				`;
				//收货人和电话号码变空
				$('#updateAndadduserInformation').empty();
				$('#updateAndadduserInformation').append(updateAndadduserInformation);
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
				//添加一个添加地址的锁
				var flag=false;
				$('.primary').click(function() {
				if (flag==false) {
					flag=true;
					if (""!=$('#InputName').val()&&""!=$('#InputTel').val()&&""!=$('#addr-show').val()&&""!=$('#InputAddr2').val()) {
						if (!phoneTrue.test($('#InputTel').val())) {
							alert("电话号码格式填写错误!");
							flag=false;
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
								flag=false;
							});
						}
						
					}else{
						flag=false;
						alert("请将信息填写完整");
					}
				}
			});
			
		
		
	});
})();