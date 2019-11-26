$(window).scroll(function(){
	if($(window).scrollTop()>200){
		$('.zTi-rigth').css({
			'position':'fixed',
			'right': '8%',
			'top': '37%'
		});
	}else{
		$('.zTi-rigth').css({
			'position':'absolute',
			'right': '8%',
			'top': '0'
		});
	};
})

$('.totop-a').click(function(){
	$('body,html').animate({'scrollTop':0},1000);
});


  

