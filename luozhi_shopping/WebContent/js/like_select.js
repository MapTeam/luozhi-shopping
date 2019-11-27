(function(){
	//回到顶部
$(document).scroll(function(){
 	
		if($(document).scrollTop() <800)
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
	//回到顶部添加点击事件
	$('.totop').click(function(){
		$('body,html').animate({'scrollTop':0},1000);
	});
})();
(function() {
	var num=1;
	$('#tiaozhuaninput').keyup(function() {
		var code=/[^\d.]/g;
		if(code.test($(this).val())==true){
			$('#tiaozhuaninput').val(num);
		}else{	
			num=$('#tiaozhuaninput').val();		
//			alert(num);
			var max=$('#maxpage').text();
			if (parseInt(num)>parseInt(max)) {
				$('#tiaozhuaninput').val(max);
				num=max;
			}	
		}
		if(event.keyCode==13){
			window.location.href="LikeSelectServlet?pageNo="+num+"&pageSize="+20+"&val="+$('#selecttitle').text();
		};
	});
//	$('#tiaozhuaninput').blur(function() {
//		window.location.href="LikeSelectServlet?pageNo="+num+"&pageSize="+20+"&val="+$('#selecttitle').text();
//	});
})();