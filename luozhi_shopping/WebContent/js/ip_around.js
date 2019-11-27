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

//商品分类
//(function(){
//  //发起请求
//  $.get('http://www.wjian.top/shop/api_cat.php',{}, function(result){
//    var obj = JSON.parse(result);
//    console.log(obj);
//    //验证
//    if(obj.code != 0){
//      console.log(obj.message);
//      return;
//    };
//    //遍历数据
//    var str = '';
//    for(var i = 0; i < obj.data.length; i++){
//    	if(i==0){
//    		str += `<li id="active-li"><a target="_blank" onclick="getGoodsList(${obj.data[i].cat_id},'${obj.data[i].cat_name}')">${obj.data[i].cat_name}</a></li>`;
//    	}else{
//    		str += `<li><a target="_blank" onclick="getGoodsList(${obj.data[i].cat_id},'${obj.data[i].cat_name}')">${obj.data[i].cat_name}</a></li>`;
//    	};
//      
//    };
//    getGoodsList(obj.data[0].cat_id,obj.data[0].cat_name);
//    $('#table_type').append(str);
//  });
//})();
//
//
//////获得地址栏参数值?  cat_id=55&name=xiaoming
////function getUrlVal(property){
//////地址栏
////var urlStr = window.location.search.substring(1);
////var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
////var result = urlStr.match(re);
////if(result == null){return null};
////return result[2];
////};
//
////分类商品
//function getGoodsList(catId,type){
//  //分类ID
//  $("#table_type>li").each(function(i){
//  	if($(this).children().html() == type){
//  		$(this).attr('id','active-li');
//  	}else{
//  		$(this).attr('id','');
//  	};
//  	
//  });
//  $('#product').empty();
//  $.get('http://www.wjian.top/shop/api_goods.php',{
//    cat_id : catId,
//    page : 1,
//    pagesize : 20
//  },function(result){
//      var obj = JSON.parse(result);
//      console.log(obj);
//      //验证
//      if(obj.code != 0){
//        console.log(obj.message);
//        alert('商品稍后上架...');
//        return;
//      };
//      //渲染
//      for(var i = 0; i < obj.data.length; i++){
//        var str = `
//        <div class="col-md-3">
//          <div class="thumbnail">
//          <a href="product_particular.html?goods_id=${obj.data[i].goods_id}">
//            <img src="${obj.data[i].goods_thumb}"/>
//            <caption>
//              <p class="goods-name">${obj.data[i].goods_name}</p>
//              <p class="goods-desc">${obj.data[i].goods_desc}</p>
//              <p class="goods-price">${obj.data[i].price}</p>
//            </caption>
//            </a>
//          </div>
//        </div>
//        `;
//        //每遍历一次就要去添加一次
//        $('#product').append(str); 
//      };
//  });
//  
//};

//function getUrlVal(property){
////地址栏
//var urlStr = window.location.search.substring(1);
//var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
//var result = urlStr.match(re);
//if(result == null){return null};
//return result[2];
//};
//
//(function(){
//	var title = getUrlVal('title');
//	console.log(title);
//	$('title').html(title);
//})();

function getPage(val){
	console.log(val);
	$.ajax({
		type:"POST",
		url:"IpAroundServlet",
		data:"pageNo="+val,
		success:function(result){
			var re = JSON.parse(result);
			alert(re);
		}
	});
}
