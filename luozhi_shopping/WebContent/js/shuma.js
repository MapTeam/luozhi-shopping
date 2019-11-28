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
var low=0;
var big=0;
//判断是否点击确认自定义价格按钮
var flag=false;
//自定义价格按钮
(function(){
	$('#low_price').focus(function() {
		$('.table_center3').children('li').removeClass();
		flag=false;
	});
	$('#big_price').focus(function() {
		$('.table_center3').children('li').removeClass();
		flag=false;
	});
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
	$('#price_ok').click(function() {
		if (''!=$('#low_price').val()&&''!=$('#big_price').val()) {
			if (parseInt(big)<parseInt(low)){
 	     		$('#big_price').val(low);
 	     		$('#low_price').val(big);
 	     		big=$('#big_price').val();
 	     		low=$('#low_price').val();	     		
 	     	};
 	     	flag=true;
 	     	select(1);
		};
		
	});
})();

//小标题点击样式改变
(function() {
	var count=0;
	var count1=0;
	var count2=0;
	var text=null;
	var text1=null;
	var text2=null;
	$('.table_center1>li').click(function() {
		if($(this).attr('class')=='brand'){
			$(this).removeClass('brand');
		}else{
			$(this).addClass('brand').siblings().removeClass();
		}
		select(1);
//		if (count==0) {
//			$(this).addClass('brand').siblings().removeClass();
//			count=1;
//			text=$(this).text();			
//		}else if(count==1&&$(this).text()!=text) {
//			$(this).addClass('brand').siblings().removeClass();
//			text=$(this).text();
//		}else{
//			$(this).removeClass();
//			count=0;
//		};
		
	});
	$('.table_center2>li').click(function() {
		if($(this).attr('class')=='type'){
			$(this).removeClass('type');
		}else{
			$(this).addClass('type').siblings().removeClass();
		}
		select(1);
	});
	$('.table_center3>li').click(function() {
		if($(this).attr('class')=='scope'){
			$(this).removeClass('scope');
		}else{
			$(this).addClass('scope').siblings().removeClass();
		}
		flag=false;
		select(1);
	});
	//价格从高到低点击
	$('#another_title>p>span').click(function(){
		$(this).addClass('clilck').siblings().removeClass();
		select(1);
	});
})();
//跳转页面输入框限制
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
			select(num);
		};
	});
//	$('#tiaozhuaninput').blur(function() {
//		window.location.href="LikeSelectServlet?pageNo="+num+"&pageSize="+20+"&val="+$('#selecttitle').text();
//	});
})();


function select(pageNo) {
	var brand = $('.brand').text();
	var type = $('.type>a>input').val();
	var sort = $('.clilck').text();
	var scope = $('.scope').text();
	var category1 = $('#category1').val();
	var min;
	var max;
	if ($('.scope>a>input').val()=="nomal") {
		var scopec = scope.split('~');
		min = scopec[0];
		max = scopec[1];
		
	}
	if(flag==true){
		min = low;
		max = big;
	}
	$.post('ClassifyGetGoodsServlet',{
		'brand':brand,
		'type':type,
		'category1':category1,
		'sort':sort,
		'min':min,
		'max':max,
		'pageNo':pageNo
	},function(rs) {
		var obj = JSON.parse(rs);
		var goods = obj.goods;
		var str =``;
		var string = ``;
		if (obj.pageNo==1&&obj.pageCount!=1) {
			string = `<a onclick="select(1)" class="pagefirst">首页</a>
	    		 <a style="color: #CDCDCD;border: #CDCDCD solid 1px;border-radius: 3px;" class="pageprev">上一页</a>
	    		  <a  onclick="select(${obj.pageNo+1})" class="pagenext">下一页</a>
	    		  <a onclick="select(${obj.pageCount})" class="pagelast">尾页</a>
	    		  <a>当前页：${obj.pageNo}</a>
				  <a>共<span id="maxpage">${obj.pageCount}</span>页</a>
				  <a>跳转<input id="tiaozhuaninput" type="text"/>页</a>
	    			`;
		}else if(obj.pageNo==obj.pageCount&&obj.pageCount!=1){
			string = `<a onclick="select(1)" class="pagefirst">首页</a>
	    		  <a onclick="select(${obj.pageNo-1})" class="pageprev">上一页</a>
	    		 <a style="color: #CDCDCD;border: #CDCDCD solid 1px;border-radius: 3px;" class="pageprev">下一页</a>
	    		  <a onclick="select(${obj.pageCount})" class="pagelast">尾页</a>
	    		  <a>当前页：${obj.pageNo}</a>
				  <a>共<span id="maxpage">${obj.pageCount}</span>页</a>
				  <a>跳转<input id="tiaozhuaninput" type="text"/>页</a>
	    			`;
		}else if(obj.pageCount==1&&obj.pageNo==1){
			string = `<a onclick="select(1)" class="pagefirst">首页</a>
	    		    <a style="color: #CDCDCD;border: #CDCDCD solid 1px;border-radius: 3px;" class="pageprev">上一页</a>
	    		    <a style="color: #CDCDCD;border: #CDCDCD solid 1px;border-radius: 3px;" class="pageprev">下一页</a>
	    		  <a onclick="select(${obj.pageCount})" class="pagelast">尾页</a>
	    		  <a>当前页：${obj.pageNo}</a>
				  <a>共<span id="maxpage">${obj.pageCount}</span>页</a>
				  <a>跳转<input id="tiaozhuaninput" type="text"/>页</a>
	    			`;
		}else{
			 string = `<a onclick="select(1)" class="pagefirst">首页</a>
	    		  <a onclick="select(${obj.pageNo-1})" class="pageprev">上一页</a>
	    		  <a  onclick="select(${obj.pageNo+1})" class="pagenext">下一页</a>
	    		  <a onclick="select(${obj.pageCount})" class="pagelast">尾页</a>
	    		  <a>当前页：${obj.pageNo}</a>
				  <a>共<span id="maxpage">${obj.pageCount}</span>页</a>
				  <a>跳转<input id="tiaozhuaninput" type="text"/>页</a>
	    			`;
		}
	    $('#fy').empty();
	    $('#fy').append(string);
		if(obj.pageCount==0){
			 $('#product').empty();
			 $('#fy').empty();
			 str=`<div style="height: 300px; width: 100%">
				 <img style="margin-left: 500px" src="https://s2.music.126.net/store/web/img/nofind.png?4bcb36ed1265fe7b408c5bfbb850cbc8">
				 </div>`;
			 $('#product').append(str);
			 
		}else{
			for(var i = 0; i < goods.length; i++){
		    	str = str +`<div class="col-md-3">
						     <div class="thumbnail">
						        	<a href="IntroudceServlet?gid=${goods[i].gid}&category1=${goods[i].category1}">
								        <img src="${goods[i].zpicture}"/>
								        <caption>
								          <p class="goods-name">${goods[i].gname}</p>
								          <p style="font-weight:bold;font-size: 17px;color: #A94442;" class="goods-price">¥${goods[i].gprice}</p>
								        </caption>
							        </a>
						      </div>
		    				</div>`;
		    };
		    $('#product').empty();
		    $('#product').append(str);
		    	var num=1;
		    	$('#tiaozhuaninput').keyup(function() {
		    		var code=/[^\d.]/g;
		    		if(code.test($(this).val())==true){
		    			$('#tiaozhuaninput').val(num);
		    		}else{	
		    			num=$('#tiaozhuaninput').val();		
//		    			alert(num);
		    			var max=obj.pageCount;
		    			if (parseInt(num)>parseInt(max)) {
		    				$('#tiaozhuaninput').val(max);
		    				num=max;
		    			}	
		    		}
		    		if(event.keyCode==13){
		    			select(num);
		    		};
		    	});
		}
	    
	});
}

select(1);



