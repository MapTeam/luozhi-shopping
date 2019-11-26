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


//默认要请求热门商品
(function(){
var page = 1;
var pagesize = 8;
//封装热门商品数据
function getHotGoodsList(){   
    //请求数据
    $.get('http://www.wjian.top/shop/api_goods.php',{
      page:page,
      pagesize:pagesize,
    }, function(result){
      var obj = JSON.parse(result);
      //验证
      if(obj.code != 0){
        return;
      };
      //渲染
  for(var i = 0; i < obj.data.length; i++){
    var str = `
    <div class="col-md-3">
      <div class="thumbnail">
	        <a href="product_particular.html?goods_id=${obj.data[i].goods_id}">
		        <img src="${obj.data[i].goods_thumb}"/>
		        <caption>
		          <p class="goods-name">${obj.data[i].goods_name}</p>
		          <p class="goods-desc">${obj.data[i].goods_desc}</p>
		        </caption>
	        </a>
	        <p class="goods-price">¥${obj.data[i].price}</p>
      </div>
    </div>
    `;
        //每遍历一次就要去添加一次
        $('#hot-goodsList').append(str); 
      };
      //放开锁
      lock = false;
    });
};
//刷新就要有商品
getHotGoodsList();
var lock = false;
	
$('#loading').click(function(){
	if(lock){return};
      lock = true;
      //加载下一页
      page++;
      getHotGoodsList();
});


})();


//封装推荐商品数据
function getRecommendGoodsList(){   
    //请求数据
  $.get('http://www.wjian.top/shop/api_goods.php',{
    page:2,
    pagesize:8,
  }, function(result){
  var obj = JSON.parse(result);
  console.log(obj);
  //验证
  if(obj.code != 0){
    console.log(obj.message);
    return;
  };
  //渲染
  for(var i = 0; i < obj.data.length; i++){
    var str = `
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="product_particular.html?goods_id=${obj.data[i].goods_id}">
	        <img src="${obj.data[i].goods_thumb}"/>
	        <caption>
	          <p class="goods-name">${obj.data[i].goods_name}</p>
	          <p class="goods-desc">${obj.data[i].goods_desc}</p>
	        </caption>
        </a>
        <p class="goods-price">¥${obj.data[i].price}</p>
      </div>
    </div>
    `;
    //每遍历一次就要去添加一次
    $('#recommend-goodsList').append(str); 
      };
    });
  };
  //刷新就要有商品
  getRecommendGoodsList();
  

