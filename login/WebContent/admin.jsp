<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>Bootstrap基本模板</title>

		<!-- 引入Bootstrap核心样式文件 -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- 引入jQuery核心js文件 -->
		<script src="js/jquery-1.11.0.min.js"></script>
		<!-- 引入BootStrap核心js文件 -->
		<script src="js/bootstrap.min.js"></script>
	  
	</head>

<body background="img/regist_bg.jpg">
    
	<div>	
	<span style="color: red">${loginInfo }</span>
	</div>
   
	<form class="form-horizontal" 
	action="${pageContext.request.contextPath }/adminLogin" method="post" >
    <h3>&nbsp;&nbsp;&nbsp;管理员登录</h3>
  <div class="form-group">
    <label for="username" class="col-sm-3 control-label">用户名</label>
    <div class="col-sm-3">
     <input type="text" class="form-control" id="username" 
     	placeholder="请输入用户名" name="username"/>
 
   </div>  
  </div>
  
  
  <div class="form-group" >
    <label for="password" class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
    <div class="col-sm-3"> 
    <input type="password" class="form-control" id="password" placeholder="请输入密码"
    	name="password"/>
    	
    </div>
  </div>
  
  
  <div class="form-group">
    <div class="col-sm-offset-3 col-sm-10">
      <button type="submit" class="btn btn-default">提交</button>
    </div>
  </div>

</form>		


</body>
</html>
