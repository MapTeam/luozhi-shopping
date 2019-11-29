function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};
//定义全局，目的是传数据。
//    //商品颜色；
	var choosecolor=null;
    //商品数量
	var goodnum=1;
		//商品名
	var goodname=null;
		//商品价格
	var goodprice=null;
	   //选择颜色的id
	var gcolorid=null;
//(function(){
//var goodsId = getUrlVal('goods_id');
////发起请求
//$.get('http://www.wjian.top/shop/api_goods.php', {
//    goods_id : goodsId,
//}, function(result){
//    var obj = JSON.parse(result);
//    var goods = obj.data[0];
//    goodname=goods.goods_name;
//    goodprice=goods.price;
//   var product_content_title=`
//   		<li><h3>${goods.goods_name}</h3></li>
//		<li><p id="product_content_slogan">${goods.goods_desc}</p></li>
//		<li><h3 id="price">￥${goods.price}</h3></li>
//   `;
//   $('.product_content_title').html(product_content_title);
//   var top_title=`
//   <span style="color: #8C8C8C;left: -20px;top: 20px;" class="col-md-8">&gt;${goods.goods_name}</span>
//   `;
//   $('.top_title').html(top_title);
//   var shopping_nav_information=`
//   	<img src="${goods.zpicture}"/ class="logo">
//	<span style="float: left;">
//		<p>${goods.gname}</p>
//		<p style="color: #C9302C;">￥${goods.gprice}</p>
//	</span>
//   `;
//   $('.shopping_nav_information').html(shopping_nav_information);
//   var product_little_picture=`
//   <span class="current"><img src="${goods.goods_thumb}"/></span>
//   `;
//   $('#product_little_picture').html(product_little_picture);
//   var type_button=`
//   <li><button class="btn btn-default" id="type_button" type="button">白色</button></li>
//   <li><button class="btn btn-default" id="type_button" type="button">红色</button><li>
//   `;
//   $('#product_content_type_btn>ul').html(type_button);
//   init();
//});
//})();
	init();
function init(){
(function(){
	//左边轮播图
	var n=0;
	var aSpan=$('#product_little_picture>span');
	var img=aSpan.eq(n).children().attr('src');
//	console.log(img);
	$('#product_big_picture>img').attr('src',img);
			$('#margnify_show').css({
        'background-image':'url('+ img +')'
        });
    $('#next').click(function(){	
		n++;
		if(n>aSpan.length-1){
			n=0;
		}
		aSpan.eq(n).addClass('current').siblings().removeClass('current');
		var img=aSpan.eq(n).children().attr('src');
		$('#product_big_picture>img').attr('src',img);
		$('#margnify_show').css({
        'background-image':'url('+ img +')'
        });
    });
    $('#prev').click(function(){
 		n--;
 		if (n<0) {
 			n=aSpan.length-1;
 		}
 		aSpan.eq(n).addClass('current').siblings().removeClass('current');
		var img=aSpan.eq(n).children().attr('src');
		$('#product_big_picture>img').attr('src',img);
		//console.log(img);
		$('#margnify_show').css({
        'background-image':'url('+ img +')'
        });
 	});
 	aSpan.each(function(e){
 	$(this).click(function(){
 		n=e;
 		aSpan.eq(n).addClass('current').siblings().removeClass('current');
		var img=aSpan.eq(n).children().attr('src');
		$('#product_big_picture>img').attr('src',img);
		console.log(img);
		$('#margnify_show').css({
        'background-image':'url('+ img +')'
        });
 	});
 });
})();

//定义一个限制的库存数字
var kucuncount=500;
(function(){

 //右边加减块
 var x=$('#product_num_text').val();
 
  //点击减
 $('#product_num_decbtn').click(function(){
	 //设置最小的
	if (x>kucuncount) {
		x=kucuncount;
	}
 	if (x>1) {
 		x--;
 		$('#product_num_text').val(x);
 		$('#product_num_addbtn').css('color','#080808');
 	} 
 	if(x<=1){
 		$('#product_num_decbtn').css('color','#C0C0C0');
 	}
 	   //相应商品数量
       goodnum=$('#product_num_text').val();
 });
 //点击加
 $('#product_num_addbtn').click(function(){
 		x++;
 		//设置最大数限制
 		 if (x>=kucuncount) {
 			alert("商品数量已达上限");		
 			x=kucuncount;
 			$('#product_num_addbtn').css('color','#C0C0C0');
 		}else{
 			$('#product_num_text').val(x);
 	 		$('#product_num_addbtn').css('color','#080808');
 	 		$('#product_num_decbtn').css('color','#080808');
 		}		
 		   //相应商品数量
       goodnum=$('#product_num_text').val();
 });
 //输入框
 $('#product_num_text').keyup(function(event){ 
// 	    var num=/[0-9]/;
 	     var code=/[^\d.]/g;;
// 	     console.log(code);
 	     if (code.test($(this).val())==false) {
 	     	x=parseInt($('#product_num_text').val());
 	     }else{
 	     	$('#product_num_text').val(x);
 	     }
 	     
   	    if (x>1&&x<kucuncount) {
   	    	$('#product_num_decbtn').css('color','#080808');
   	    	$('#product_num_addbtn').css('color','#080808');
   	    }else if(x>=kucuncount){
   	    	alert("商品数量已达上限");
   	    	x=kucuncount;
   	    	$('#product_num_text').val(x);
 		    $('#product_num_decbtn').css('color','#080808');
 		    $('#product_num_addbtn').css('color','#C0C0C0');
   	    }else{
   	    	x=1;
   	    	$('#product_num_text').val(x);
 		    $('#product_num_decbtn').css('color','#C0C0C0');
 		   $('#product_num_addbtn').css('color','#080808');
   	    }
   	 //相应商品数量
   goodnum=$('#product_num_text').val();
});
})();
//点击促销标签
(function(){
	var n=1;
	$('#product_content_sellquick_btn .show').mouseenter(function(){		
		
		$('#product_content_sellquick_btn>li').css('display','block');
		$('#content_sellquick_updown').css('transform','rotate(180deg)');
		n=0;

	});
	$('#product_content_sellquick_btn').mouseleave(function(){		
//		console.log('啊啊啊');
	$('#product_content_sellquick_btn>li').css('display','none');
	$('#product_content_sellquick_btn .show').css('display','block');
	$('#content_sellquick_updown').css('transform','rotate(360deg)');
	n=1;
	});
	
	$('#content_sellquick_updown').click(function(){
		if (n==1) {
			$('#product_content_sellquick_btn>li').css('display','block');
			$(this).css('transform','rotate(180deg)');
			n=0;
		}else{
			$('#product_content_sellquick_btn>li').css('display','none');
	        $('#product_content_sellquick_btn .show').css('display','block');
	        $(this).css('transform','rotate(360deg)');
	        n=1;
		}
	});
})();
//点击多个按钮只选择一个
(function(){
	$('#product_content_type_btn>ul>li>button').click(function(){
		//将库存设置为数据库显示的那个库存
		kucuncount=$(this).siblings('#goodscount').val();
		if (parseInt($('#product_num_text').val())>kucuncount) {
			alert("商品数量已达上限");
			$('#product_num_text').val(kucuncount);
			goodnum=kucuncount;
		}else{
			
			$('#product_num_addbtn').css('color','#080808');
		}
		gcolorid=$(this).siblings('#gcolorid').val();
		
		
		
		
		$(this).css('background','#F35518').parent('li').siblings('li').children('button').css('background','#FFFFFF');
		$(this).css('color','white').parent('li').siblings('li').children('button').css('color','#333333');
		choosecolor=$(this).text();
		//购买按钮亮起
		$('#shop_current').attr('disabled',false);
 		$('#shop_current_little').attr('disabled',false);
 		$('#shop_current').css({
 			background: 'white',
 			border: '#C9302C solid 3px',
			color: '#C9302C',
 		});
 		$('#shop_current_little').css({
 			background: 'white',
 			border: '#C9302C solid 3px',
			color: '#C9302C',
 		});
 		$('#product_little_picture').empty().html('<span class="current"><img src="http://'+$(this).val()+'"/></span>');
 		$('#product_big_picture>img').attr('src','http://'+$(this).val());
 		$('#margnify_show').css({
 	        'background-image':'url(http://'+ $(this).val() +')'
 	        });
 		$('#prev').css("display","none");
 		$('#next').css("display","none");
//		alert(choosecolor);
//		if(choose==0){
//			$('#type_button').css('background','#F35518');
//			$('#type_button').css('color','white');
//			choose=1;
//		}
//		else{
//			$('#type_button').css('background','#FFFFFF');
//			$('#type_button').css('color','#333333');
//			choose=0;
//		}
	  });
	
	
})();
(function(){
//	放大镜
 //鼠标移入
 $('#product_big_picture').mouseenter(function(event){
 	$('#product_big_picture').mousemove(function(event){
 	  var x = event.clientX - $('#product_big_picture').offset().left - $('#product_big_picture>div').outerWidth()/2;
      var y = event.clientY - $('#product_big_picture').offset().top - $('#product_big_picture>div').outerHeight()/2 + $(document).scrollTop();
      //验证控制范围
      if(x <= 0){x = 0};
      if(y <= 0){y = 0};
      if(x >= $('#product_big_picture').width() - $('#product_big_picture>div').outerWidth()){
        x = $('#product_big_picture').width() - $('#product_big_picture>div').outerWidth();
      }
      if(y >= $('#product_big_picture').height() - $('#product_big_picture>div').outerHeight()){
        y = $('#product_big_picture').height() - $('#product_big_picture>div').outerHeight();
       }
      $('#product_big_picture>div').css({
        left : x,
        top : y,
      });
      //设置大图背景
      var str = -x*2 + 'px ' + -y*2+ 'px';
      $('#margnify_show').css('backgroundPosition', str);
      
 	});
 });
 //鼠标移入移出
 //鼠标移入移出
  $('#product_big_picture').hover(function(){
    $('#product_big_picture>div, #margnify_show').show();
  }, function(){
    $('#product_big_picture>div, #margnify_show').hide();   
  });

})();
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

 //点击立即购买
 	if (choosecolor==null) {
 		$('#shop_current').attr('disabled',true);
 		$('#shop_current_little').attr('disabled',true);
 		$('#shop_current').css({
 			background: 'white',
 			border: '#7F7F7F solid 3px',
			color: '#7F7F7F',
 		});
 		$('#shop_current_little').css({
 			background: 'white',
 			border: '#7F7F7F solid 3px',
			color: '#7F7F7F',
 		});
 	}
    $('#shop_current').click(shopCurrent);
 	$('#shop_current_little').click(shopCurrent);
 function shopCurrent(){
// 		var buy_order_sure_infomation=`
// 					<h2>`+goodname+`</h2>
//					<h3>￥`+parseFloat(goodprice*goodnum)+`</h3>
//					<h4>颜色:`+choosecolor+`　　数量:`+goodnum+`</h4>
//					<span>收获地址:XX省XX市XX县XX村XX号</span><br/>
//					<span>姓名:胡辉</span>
//					<h5>电话:15697386842</h5>
//					<a>点击修改电话地址</a>
// 		`;
// 		$('.buy_order_sure>div').html(buy_order_sure_infomation);
   	$('.buy_order_show').css('display','block');
		var count=0;
		function rotat(){
				count++;		
				$('.buy_order_show>p>span').css('transform','rotate('+count+'deg)');
		};
		var time = setInterval(rotat,50);
		$('.no').click(function(){
			$('.buy_order_show').css('display','none');
			clearInterval(time);
		});
		$('.yes').click(function(){
//			alert(gcolorid+"==="+$('#uid').val());
			window.location.href="ShopCurrentServlet?gcolorid="+gcolorid+"&userid="+$('#uid').val()+"&goodscount="+goodnum;
			clearInterval(time);
		});	
	};

 //点击加入购物车 
	$('#add_shopping_car').click(function(){
		if (choosecolor==null) {
 			alert('请选择颜色');
 	}else{
//		alert("选择的商品颜色："+choosecolor+"   选择的商品数量："+goodnum);
		addGoodsCard();
 	 }
	});
	$('#add_shopping_car_little').click(function(){
		if (choosecolor==null) {
 			alert('请选择颜色');
 	}else{
//		alert("选择的商品颜色："+choosecolor+"   选择的商品数量："+goodnum);
		addGoodsCard();
 	 }
		
	});
	
	function addGoodsCard(){
		$.post("AddGoodcardByGoodsParticularServlet",{
			'gcolorid':gcolorid,
			'userid':$('#uid').val(),
			'goodnum':goodnum,
		},function(rs){
			var obj=JSON.parse(rs);
			if (obj.addgoodscatflag) {
				alert("购物车添加成功");
				
			}
		});
	};
	
}




 
   

