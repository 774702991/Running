<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZXH
  Date: 2018/1/29
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link href="/admin/css/bootstrap.min.css" rel="stylesheet">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/admin/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<table class="table table-hover">
    <tr>
        <td>编号</td>
        <td>手机号</td>
        <td>昵称</td>
        <td>所在城市</td>
    </tr>
    <c:forEach items="${list}" var="item">
    <tr>
        <td>${item.user.id}</td>
        <td>${item.user.username}</td>
        <td>${item.nickname}</td>
        <td>${item.city}</td>
    </tr>
    </c:forEach>
</table>
<script src="/admin/js/bootstrap.min.js"></script>