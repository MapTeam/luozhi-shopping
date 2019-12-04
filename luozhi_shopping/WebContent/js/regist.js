//用户名验证
(function() {
	//声明变量
	var userName=null;
//	var telphone=null;
	var email=null;
	var password=null;
	var surePassword=null;
	var code=null;
	var reg_user =/^[a-z0-9_]{3,20}$/;
//	var reg_phone=/^1[3456789]\d{9}$/; 
	var reg_email=/^[a-zA-Z0-9_-]+$/;
	var reg_pass= /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
	var userlock = false;
//	var tellock=false;
	var emaillock=false;
    var pwdlock = false;
    var surepwdlock=false;
    var sellock=false;
    var codelock=false;
	//禁用注册按钮
	$('#register').prop('disabled', true);
	$('.codebtn').prop('disabled', true);
	$('#name').focus();
	$('#name').focus(function(event){
           this.select();
		$('.name_hidden').css('display','block');
		$('.name_hidden2').css('display','none');
		$('.name_hidden3').css('display','none');
		$('.name_hidden4').css('display','none');
		$('.name_hidden5').css('display','none');
		$('.name_hidden6').css('display','none');
	})
	$('#name').blur(function(event){
		user();
	});
//	$('#phone').focus(function(event){
//		 this.select();
//		$('.phone_hidden2').css('display','none');
//		$('.phone_hidden3').css('display','none');
//		$('.phone_hidden').css('display','block');
//		$('.phone_hidden4').css('display','none');
//	});
//	$('#phone').blur(function(){
//		tel();
//		
//	});
//	$('.code').blur(function(){
//		code=$('input.code').val();
//	});
	$('.email .mail').focus(function(){
		this.select();
		$('.email_hidden2').css('display','none');
		$('.email_hidden').css('display','none');
		$('.email_hidden3').css('display','none');
	});
	$('.email .mail').blur(function(){
		mail();
		if(emaillock){
			$('.codebtn').prop('disabled', false);
		}else{
			$('.codebtn').prop('disabled', true);
		}
	});
	
	$('.email-end>li').click(function(){
		$(this).parent().siblings('.email-end-show').html($(this).html() + '<span class="caret"></span>');
		$(this).addClass('active').siblings().removeClass('active');
	});
	
	

	$('input.pass').focus(function(event){
		this.select();
		$('.pass_hidden2').css('display','none');
		$('.pass_hidden').css('display','none');
		$('.pass_hidden3').css('display','block');
		$('.pass_hidden4').css('display','none');
	});
	$('input.pass').keyup(function(event){
		pass();
	});
	$('input.pass').blur(function(event){
		pass();
	});
	$('input.surepass').focus(function(event){
		this.select();
		$('.surepass_hidden').css('display','none');
		$('.surepass_hidden2').css('display','none');
		$('.surepass_hidden3').css('display','none');
	});

	$('input.surepass').blur(function(event){
		surepass();
	});
	$('input.agree').click(function(){
		if ($('input.agree').prop('checked')) {
			sellock=true;
			lock();
			return;
		}else{
			sellock=false;
			lock();
			return;
		}
	});
	$('#register').mouseenter(function(){
		user();
//		tel();
		mail();
		pass();
		surepass();
	});
//用户名是否注册
	$('#name').blur(function() {
		if (reg_user.test(userName)) {
			$.ajax({
			type:"POST",
			url:"RegistUnameIsUse",
			data:"name="+userName,
			success:function(result){
				if(result){
					$('.name_hidden6').css('display','block');
					userlock=false;
				}else{
					$('.name_hidden4').css('display','block');
					userlock=true;
				}
			}
		});
		}
	});


	//email是否被注册
	$('#mail').blur(function() {
		if (email.match(reg_email)) {
		$.ajax({
			type:"POST",
			url:"EmailIsUsed",
			data:"mail="+email+$('.email-end>li.active').text(),
			success:function(re){
		        var obj = JSON.parse(re)
				if(obj.registed){
					$('.email_hidden4').css('display','block');
					emaillock=false;
				}else{
					$('.email_hidden2').css('display','block');
					emaillock=true;
				}
			}
		});
		}
	});
	
	
	
	$('#mail').focus(function(event) {
		$('.email_hidden').css('display','none');
		$('.email_hidden2').css('display','none');
		$('.email_hidden3').css('display','none');
		$('.email_hidden4').css('display','none');
	});
	//验证码
	
//	$('.code').blur(function() {
//		$.ajax({
//			type:"POST",
//			url:"RegistCode",
//			data:"code="+code,
//			success:function(result){
//				if(result=='msg'){
//					$('.code_hidden').css('display','block');
//					codelock=true;
//					return;
//				}else if(result=='ms'){
//					$('.code_hidden2').css('display','block');
//					codelock=false;
//					return;
//				}else{
//					$('.code_hidden').css('display','none');
//					$('.code_hidden2').css('display','none');
//					codelock=false;
//				}
//			}
//		});
//	});
	
	$('.yzmcode').focus(function() {
		$('.code_hidden3').css('display','none');
	});
	
	//点击注册  用户名和密码都要ok
$('#register').click(function(){
		if(''==userName){
				$('.name_hidden3').css('display','block');
			}
		if($('.yzmcode').val()==''){
			$('.code_hidden3').css('display','block');
		}
		if(''==email){
			$('.email_hidden3').css('display','block');
		}
		if(''==password){
			$('.pass_hidden4').css('display','block');
		}
		if(''==surePassword){
			$('.surepass_hidden4').css('display','block');
		}
		if(''==code){
			$('.code_hidden3').css('display','block');
		}
	
	if(userlock  && emaillock && pwdlock && surepwdlock && sellock){
			$.post('registServlet',{
				name : userName,
				pass : password,
				mail : email+$('.email-end>li.active').text(),
				code : $('.yzmcode').val()
		    }, function(re){
		        var obj = JSON.parse(re)
		      //用户名已注册
		        if(obj.registmsg == false){
		        	alert(obj.msg);
		        	return;
		        };
		         //注册成功跳转到登录页面
			      alert('注册成功，点击跳转首页登录页面');
			      $.post('RemoveSingletStateLoginListenerMsgServlet', {
			  		value:'Registcode',
			  	  });
			      //JS设置页面跳转
			      window.location.href = 'HomeServlet';

			    });
	}else{
		alert("注册失败，请重新注册");
	}
});
	
function lock(){
    //用户名和密码OK才放开注册按钮
    if(sellock){
      $('#register').prop('disabled', false);
    }else{
      $('#register').prop('disabled', true);     
    };
  }
function user(){
	userName=$('#name').val();
		$('.name_hidden').css('display','none');
		if(''!=userName){
			if (reg_user.test(userName)) {
         	$('.name_hidden4').css('display','block');
         	userlock=true;
         	lock();
         	return;
             }
	        if (!reg_user.test(userName)) {
	         	if ((number(userName)<3&&number(userName)>0)||number(userName)>20) {
	         		$('.name_hidden5').css('display','block');
	         		return;
	         	}
	         	if(''==userName){
	         		$('.name_hidden3').css('display','block');
	         	}else{
	         		$('.name_hidden2').css('display','block');
	         		return;
	         	}
	         	userlock=false;
	         	lock();
	        }
	    }
         userlock=false;
         lock();
}

//function tel(){
//	$('.phone_hidden').css('display','none');
//	telphone=$('#phone').val();
//	if(''!=telphone){
//			if (reg_phone.test(telphone)) {
//			$('.phone_hidden3').css('display','block');
//			tellock=true;
//			lock();
//			return;
//		}else{
//			$('.phone_hidden2').css('display','block');
//			tellock=false;
//			lock();
//			return;
//		}
//	}
//	tellock=false;
//			lock();
//			return;
//}
function mail(){
	email=$('.email .mail').val();
	if (''!=email) {
		if (email.match(reg_email)) {
			$('.email_hidden2').css('display','block');
			emaillock=true;
			lock();
			return;
		}else{
			$('.email_hidden').css('display','block');
			emaillock=false;
			lock();
			return;
		}
	}
	emaillock=false;
			lock();
			return;
}


function pass(){
	password=$('input.pass').val();
	$('.pass_hidden3').css('display','none');
	if (''!=password) {
		if (!reg_pass.test(password)) {
	$('.pass_hidden').css('display','none')
		$('.pass_hidden2').css('display','block')
		pwdlock=false;
		lock();
		return;
	}
	$('.pass_hidden2').css('display','none')
	$('.pass_hidden').css('display','block')
		 pwdlock=true;
		lock();
		return;
	}else{
		$('.pass_hidden2').css('display','none');
		$('.pass_hidden').css('display','none');
		$('.pass_hidden3').css('display','none');
		$('.pass_hidden4').css('display','none');
		pwdlock=false;
		lock();
		return;
	}
	 
}

function surepass(){
	surePassword=$('input.surepass').val();
	if (''!=surePassword) {
	   if (reg_pass.test(password)) {
    	if (surePassword==password&&''!=surePassword) {
		$('.surepass_hidden2').css('display','none');
	    $('.surepass_hidden3').css('display','none');
	    $('.surepass_hidden').css('display','block');
	    surepwdlock=true;
		lock();
		return;
		}else{
	    $('.surepass_hidden').css('display','none');
	    $('.surepass_hidden3').css('display','none');
		$('.surepass_hidden2').css('display','block');
		 surepwdlock=false;
		lock();
		return;
	    }
    }else{
	    $('.surepass_hidden').css('display','none');
    	$('.surepass_hidden2').css('display','none');
	    $('.surepass_hidden3').css('display','block');
	     surepwdlock=false;
		lock();
		return;
    }
	}
	 surepwdlock=false;
		lock();
		return;
}

})();

 function number(str){
  	var r = /\d/g;
  	var r1 = /[A-z]/g;
  	var r3 = /[_]/g;
  	var i = 0;
	while(r.test(str)){
		i++;
	};
	while(r1.test(str)){
		i++;
	};
	while(r3.test(str)){
		i++;
	};
  	return i;
  }
 function flushCode(obj) {
		obj.src = "ImageServlet?id="+new Date().getTime();
	}

 var f1 = true;
 //获取验证码
 $('.codebtn').click(function() {
	 if(!f1){
		 return;
	 }
	 f1=false;
	 var i = 60;
	 var interval = setInterval(function() {
			$('.codebtn').val(i+'秒后才能再次点击');
			i = i - 1;
		}, 1000);
	setTimeout(function() {
		clearInterval(interval);
		f1 = true;
		$('.codebtn').val('点击发送验证码');
	}, 60000);
	$.post('CreateCodeServlet', {
		email:$('#mail').val()+$('.email-end>li.active').text()
	}, function(re) {
			var obj = JSON.parse(re);
			console.log(obj);
		});
});
