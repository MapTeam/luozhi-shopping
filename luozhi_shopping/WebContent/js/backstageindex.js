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
//				alert(oLi.length+'===='+oDiv.length);
				$(this).css('font-weight','bold').siblings('li').css('font-weight','normal');				
				for (var k = 0; k < oLi.length; k++) {
					oDiv[k].className='';
				};
				oDiv[e].className='dingdan_show';
			};
		})(i);
	}
	
})();
//未发货块、
(function(){
	$('#dingdan_noput>li>span>button').click(function(){
		if (confirm("是否确定发货")) {
			alert("发货成功");
			$(this).parent('span').parent('li').remove();
		}
	});
	
})();
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
