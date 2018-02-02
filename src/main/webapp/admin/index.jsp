<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZXH
  Date: 2018/1/29
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>奔跑App后台管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:if test="${empty admin.username}">
    <script>
        window.location = "/login.jsp";
    </script>
</c:if>
<div class="header">
    <div class="dl-title"><span class="">后台管理</span></div>
    <div class="dl-log">欢迎您，<span class="dl-log-user">${admin.username}</span>
        <a href="/admin/logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-storage">首页</div></li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>

</div>
<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{
            id:'menu',
            menu:[{
                text:'信息管理',
                items:[
                    {id:'main-menu',text:'用户列表',href:'/api/user/list'},
                    {id:'second-menu',text:'圈子管理',href:'/api/circle/find'},
                    {id:'Third-menu',text:'更新新闻',href:'/crawler'}
                ]
            }]
        }];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });

</script>
</body>
</html>
