//$('.person').mouseenter(function(){
//	$('.list').css('display','block');
//	$('.downchild').css('transform','rotate(180deg)')
//});
//
//$('.person').mouseleave(function(){
//	$('.list').css('display','none');
//	$('.downchild').css('transform','rotate(360deg)')
//});


(function(){
	//回到顶部
$(document).scroll(function(){
 	
		if($(document).scrollTop() <500)
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

var oBanner =$('#tab');
var oTabs =$('#tab>li');
var contents =$('#content li');
var n =0;
for(var i = 0;i< oTabs.length;i++)
{	
	(function(x){
		oTabs[x].onclick =function(){
			n=x;
			for(var j=0;j<oTabs.length;j++)
			{
				oTabs[j].className='';
				
			}
			oTabs[n].className='active';
			for(var j=0;j<contents.length;j++)
			{
				contents[j].className='';
			}
			contents[n].className='current';
		}
	})(i);
}
function init () {
	$('.ontimepay .btn').click(function(){
	confirm("您是否立即支付？");
});
}








//订单
function goodsList(page, callback){
    var page = page ? page : 1;
    $.POST('http://www.wjian.top/shop/api_goods.php',{
      'pagesize':3,
      'page':page,
    }, function(result){
      var result = JSON.parse(result);
      if(result.code != 0){
        console.log('数据请求失败');
        return;
      };
      //调用
      callback(result);
    }); 
  };
  
  goodsList(1, function(result){
    var goodsList = result.data;
    for(var i = 0; i < goodsList.length; i++){
      var str = `
        <tr class="shoping">
          <td class="shangpin">
            <img class="img" src="${goodsList[i].goods_thumb}"/>
          </td>
          <td class="desc">
          	<p> ${goodsList[i].goods_desc}</p>
          </td>
          <td class="money">${goodsList[i].price}</td>
          <td>1</td>
          <td class="subtotal">${goodsList[i].price}</td>
           <td class="ontimepay"><button class="btn btn-danger">立即支付</button></td>
        </tr>
      `;
      $('table').append(str);
    };
    init ();
  });

  
