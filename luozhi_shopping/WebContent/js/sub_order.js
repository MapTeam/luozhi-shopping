
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