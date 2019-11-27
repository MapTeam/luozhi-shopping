(function(){
	//回到顶部
$(document).scroll(function(){
 	
		if($(document).scrollTop() <400)
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
		// $(document).scrollTop(0);
		// $('#top').fadeOut(1000);
		$('body,html').animate({'scrollTop':0},1000);
	});
})();



//查看更多
(function(){
	var height=0;
	var n=0;
	if ($('#table_center').height()>90){
		height=$('#table_center').height();
		$('#table_center').css('height','90px');
		$('#table_center').css('overflow','hidden');
	}
	$('#table_right').click(function(){
	 if (n==0) {
	 	$('#table_center').css('height',height+'px');
	 	$('#table_right>span').css('transform','rotate(180deg)');
	 	n=1;
	 }else{
	 	$('#table_center').css('height','90px');
	 	n=0
	 	$('#table_right>span').css('transform','rotate(360deg)');
	 }
		
	});
})();

//自定义价格按钮
(function(){
	var low=0;
	$('#low_price').keyup(function(){
		var code=/[^\d.]/g;
		if(code.test($(this).val())==true){
			$('#low_price').val(low);
		}else{
			low=$('#low_price').val();
		}
//		console.log(code.test($(this).val()));
 	     
// 	     if (code>=48&&code<=57||code==8) {
// 	     	low=$('#low_price').val();
// 	     }else{
// 	     	$('#low_price').val(low);
// 	     }
   	     if (''!=$('#big_price').val()) {
   	     	$('#price_ok').css('background','#D43F3A');
   	     }
   	     if (''==$('#low_price').val()) {
   	     	$('#price_ok').css('background','#ADADAD');
   	     }
	});
	var big=0;
	$('#big_price').keyup(function(){
		var code=/[^\d.]/g;
		if(code.test($(this).val())==true){
			$('#big_price').val(big);
		}else{
			big=$('#big_price').val();
		}
 	     if (''!=$('#low_price').val()) {
 	     	$('#price_ok').css('background','#D43F3A');
 	     }
 	     if (''==$('#big_price').val()) {
 	     	$('#price_ok').css('background','#ADADAD');
 	     }
	});
	$('#price_ok').click(function(){
		if (''!=$('#low_price').val()&&''!=$('#big_price').val()) {
//			console.log(big);
//			console.log(low);
 	     	if (parseInt(big)<parseInt(low)){
 	     		$('#big_price').val(low);
 	     		$('#low_price').val(big);
 	     		big=$('#big_price').val();
 	     		low=$('#low_price').val()
 	     	}
 	    }
	});
	
})();
//价格从高到低点击
(function(){
	$('#another_title>p>span').click(function(){
		$(this).addClass('clilck').siblings().removeClass();
	});
}
)();


