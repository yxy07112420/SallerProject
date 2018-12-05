<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/26
  Time: 14:58
  To change this template use File | Settings | File Templates.
  主界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>主界面</title>
  <link rel="stylesheet" href="css/Main.css" />
  <link rel="icon" href="img/logo.png" type="image/x-icon"/>
  <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" ></script>
  <script src="${pageContext.request.contextPath}/js/Main.js" ></script>
</head>
<body>
<c:if test="${sessionScope.username == null}">
  <script>
    alert("当前没有用户登录，请重新登录！！");
    window.location.href='Login.jsp';
  </script>
</c:if>
<div id="mainAll">
  <div id="mainAllTop">
    <div id="mainAllTopImg">
      <img src="image/logo.svg">
    </div>
    <div id="mainAllTopWec">
      <span>欢迎商家<span style="color: antiquewhite">${sessionScope.username}</span>登录</span>
    </div>
    <div id="mainAllTopTime">
      <span></span>
    </div>
    <div id="mainAllTopEsc">
      <a href="ExitServlet">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="Login.jsp">重新登录</a>
    </div>
  </div>
  <div id="mianAllBottom">
    <div id="mainAllUl">
      <ul class="uls">
        <li class="lis">
          <div class="infors">
            <div class="infors_li">
              <span>+</span>
            </div>
            <span>商品信息管理</span>
          </div>
          <div class="infors_conter">
            <div><a href="ShopsServlet" target="jumpGo">商品查询</a></div>
            <div><a href="InsertShops.jsp" target="jumpGo">新增商品</a></div>
            <div><a href="updateShops.jsp" target="jumpGo">修改商品信息</a></div>
          </div>
        </li>
        <li class="lis">
          <div class="infors">
            <div class="infors_li">
              <span>+</span>
            </div>
            <span>商品类别管理</span>
          </div>
          <div class="infors_conter">
            <div><a href="CategroysServlet" target="jumpGo">查看类别</a></div>
            <div><a href="insertCategroys.jsp"  target="jumpGo">新增类别</a></div>
            <div><a href="updateCategroys.jsp" target="jumpGo">修改类别信息</a></div>
          </div>
        </li>
        <li class="lis">
          <div class="infors">
            <div class="infors_li">
              <img src="image/Trash.svg" title="回收站">
            </div>
            <a href="GcShopsServlet" target="jumpGo"><span>回收站</span></a>
          </div>
        </li>
      </ul>
    </div>
    <div id="mainAllConter">
      <iframe name="jumpGo" style="border: none"></iframe>
    </div>
  </div>
</div>
</body>
</html>
