if($('#SingletStateLoginListenerMsg').val()!=''){
	alert($('#SingletStateLoginListenerMsg').val());
	$.post('RemoveSingletStateLoginListenerMsgServlet', {
		value:'SingletStateLoginListenerMsg',
	});
}

$('.search').focus(function() {
	$('.form-heid').show();
	$('.search').mousemove(function(){
		$('.form-heid').show();
	});
});
$('.form-heid').mouseleave(function() {
	$('.form-heid').hide();
});


////检查是否登录
//function checkLogin() {
//	//获取localStorage  username  token
//	var userName = localStorage.getItem('username');
//	var token = localStorage.getItem('token');
//	//验证
//	if(token) {
//		$('.login-li, .regist-li').hide();
//		//  $('.username-li, .exitlogin-li').show();
//		//  $('.username-li').html('欢迎：'+userName);
//		$('.person').css('display', 'block');
//		//登陆成功
//		$('.person').mouseenter(function() {
//			$('.list').css('display', 'block');
//			$('.downchild').css('transform', 'rotate(180deg)')
//		});
//
//		$('.person').mouseleave(function() {
//			$('.list').css('display', 'none');
//			$('.downchild').css('transform', 'rotate(360deg)')
//		});
//	} else {
//		$('.login-li, .regist-li').show();
//		//  $('.username-li, .exitlogin-li').hide();
//		$('.username-li').html('');
//	};
//};
//checkLogin();


//模糊查询
(function() {
	$('.search-tubiao').click(function() {
		var val=$('.search').val();
		if (val!="") {
			window.location.href="LikeSelectServlet?val="+val;
		}
	});
	$('.search').keyup(function(){
		var code=event.keyCode;
		var val=$('.search').val();
		if(code==13&&val!=""){
			console.log('111');
			window.location.href="/luozhi_shopping/LikeSelectServlet?val="+val;
		}		
	});
	$('.title1').siblings('li').click(function(){	
		var val=$(this).text();
		window.location.href="LikeSelectServlet?val="+val;
	});
})();

//密码框获焦
$('#pwd').focus(function() {
	$('.loginmsg').hide();
});

//账号框获焦
$('#username').focus(function() {
	$('.loginmsg').hide();
});

var f2 = true;
//登录
(function() {
	$('#login-btn').click(function() {
		if(!f2){
			return;
		}
		f2 = false;
		//拿到账号和密码
		var savepassword = $('#savepassword').get(0).checked;
		var userName = $('#username').val();
		var pwd = $('#pwd').val();
		//验证
		if(userName == '' || pwd == '') {
			$('.loginmsg').show();
			$('.loginmsg').html("账号或密码不能为空！");
			return;
		};
		//请求登录
		$.post('LoginServlet', {
			username: userName,
			password: pwd,
			savepassword:savepassword,
		}, function(re) {
			var obj = JSON.parse(re);
			//分两种情况  1001失败  1000成功
			if(obj.code == 1001) {
				$('.loginmsg').show();
				$('.loginmsg').html("账号或密码错误！");
				return;
			};
			
			//成功  分两种，如果从详情来的就要又跳回详情
			//成功  第二种 正常首页登录
//			alert('登录成功');
			//怎么样才能知道是登录状态   localStorage  cookie
//			localStorage.setItem('username', obj.data.username);
//			localStorage.setItem('token', obj.data.token);
//			checkLogin();
			var text = "登录中";
			var interval = setInterval(function() {
				text = text + ".";
				$('.loginmsg').html(text);
			}, 1000);
			//让模态框隐藏
			setTimeout(function() {
				clearInterval(interval);
				$('#login, .modal-backdrop').modal('hide');
//				$('.person').css('display', 'block');
				location.reload(true);
			}, 3000);
		});
		f2 = true;
	});
})();

//点击退出
(function() {
	$('#exitlogin').click(function() {
		$.post('ExitLoginServlet');
		location.reload(true);
	});
})();

//person进入与移除
$('.person').mouseenter(function(){
	$('.list').css('display','block');
	$('.downchild').css('transform','rotate(180deg)')
});

$('.person').mouseleave(function(){
	$('.list').css('display','none');
	$('.downchild').css('transform','rotate(360deg)')
});



