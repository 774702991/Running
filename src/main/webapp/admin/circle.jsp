<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ZXH
  Date: 2018/1/29
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link href="/admin/css/bootstrap.min.css" rel="stylesheet">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/admin/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<c:if test="${empty mess}">

</c:if>
<table class="table table-hover">
    <tr>
        <td>编号</td>
        <td>缩略图</td>
        <td>标题</td>
        <td>城市</td>
        <td>内容</td>
        <td>发布时间</td>
        <td>发布人</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="item">
    <tr>
        <td>${item.id}</td>
        <td><img width="122px" height="86px" src="${item.img}"></td>
        <td>${item.title}</td>
        <td>${item.city}</td>
        <td>${item.summary}</td>
        <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
        <td>${item.userInfo.nickname}</td>
        <td><a href="/api/circle/del?id=${item.id}">删除</a></td>
    </tr>
    </c:forEach>
</table>
<script src="/admin/js/bootstrap.min.js"></script>
