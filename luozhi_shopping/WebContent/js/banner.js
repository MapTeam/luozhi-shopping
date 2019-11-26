var n = 0;
	
$('.next').click(fNext);

$('.prev').click(function(){
	if($('.banner>ul>li').eq(n).is(':animated')){return;};
	$('.banner>ul>li').eq(n).animate({'opacity':0},600);
	n--;
	if(n<0){
		n = $('.banner>ul>li').length-1;
	};
	$('.banner>ul>li').eq(n).animate({'opacity':1},600);
	$('.number>span').attr('class','');
	$('.number>span').eq(n).attr('class','active');
});

$('.number>span').each(function(i){
	$(this).click(function(){
		if($('.banner>ul>li').eq(n).is(':animated')){return;};
		$('.number>span').attr('class','');
		$('.number>span').eq(i).attr('class','active');
		$('.banner>ul>li').eq(n).animate({'opacity':0},600);
		n = i;
		$('.banner>ul>li').eq(n).animate({'opacity':1},600);
	});
});

var timer = null;

timer = setInterval(fNext,2000);

$('.banner').mouseover(function(){
	clearInterval(timer);
});

$('.banner').mouseout(function(){
	timer = setInterval(fNext,2000);
});

function fNext(){
	if($('.banner>ul>li').eq(n).is(':animated')){return;};
	$('.banner>ul>li').eq(n).animate({'opacity':0},600);
	n++;
	if(n>($('.banner>ul>li').length-1)){
		n = 0;
	};
	$('.banner>ul>li').eq(n).animate({'opacity':1},600);
	$('.number>span').attr('class','');
	$('.number>span').eq(n).attr('class','active');
}