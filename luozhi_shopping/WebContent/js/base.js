$('.search').focus(function() {
	$('.form-heid').show();
});
$('.search').blur(function() {
	$('.form-heid').hide();
});

//检查是否登录
function checkLogin() {
	//获取localStorage  username  token
	var userName = localStorage.getItem('username');
	var token = localStorage.getItem('token');
	//验证
	if(token) {
		$('.login-li, .regist-li').hide();
		//  $('.username-li, .exitlogin-li').show();
		//  $('.username-li').html('欢迎：'+userName);
		$('.person').css('display', 'block');
		//登陆成功
		$('.person').mouseenter(function() {
			$('.list').css('display', 'block');
			$('.downchild').css('transform', 'rotate(180deg)')
		});

		$('.person').mouseleave(function() {
			$('.list').css('display', 'none');
			$('.downchild').css('transform', 'rotate(360deg)')
		});
	} else {
		$('.login-li, .regist-li').show();
		//  $('.username-li, .exitlogin-li').hide();
		$('.username-li').html('');
	};
};
checkLogin();
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
//		console.log(val);
		if(code==13&&val!=""){
			window.location.href="LikeSelectServlet?val="+val;
		}
	});
})();

//登录
(function() {
	$('#login-btn').click(function() {
		//拿到账号和密码
		var userName = $('#username').val();
		var pwd = $('#pwd').val();
		//验证
		if(userName == '' || pwd == '') {
			alert('不能为空');
			return;
		};
		//请求登录
		$.post('http://www.wjian.top/shop/api_user.php', {
			status: 'login',
			username: userName,
			password: pwd,
		}, function(re) {
			var obj = JSON.parse(re);
			//分三种情况 2002 1000 1001  0
			if(obj.code == 2002) {
				alert('用户名不存在');
				return;
			};
			if(obj.code == 1001) {
				alert('密码错误');
				return;
			};
			if(obj.code == 1000) {
				alert('用户名不合法，请填写3-20位的英文数字下划线');
				return;
			}
			//成功  分两种，如果从详情来的就要又跳回详情
			//成功  第二种 正常首页登录
			alert('登录成功');
			//怎么样才能知道是登录状态   localStorage  cookie
			localStorage.setItem('username', obj.data.username);
			localStorage.setItem('token', obj.data.token);
			checkLogin();
			//让模态框隐藏
			$('#login, .modal-backdrop').modal('hide');
		});
	});
})();

//点击退出
(function() {
	$('.exitlogin-li').click(function() {
		//清空本地存储
		localStorage.removeItem('username');
		localStorage.removeItem('token');
		//调用交互方法
		checkLogin();
		$('.person').css('display', 'none');
	});
})();

