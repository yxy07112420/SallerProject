<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/30
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Login.css"/>
    <link rel="icon" href="${pageContext.request.contextPath}/image/logo.png" type="image/x-icon"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/Login.js"></script>
</head>
<body>
<c:if test="${error!=null}">
    <script>
        alert("${error}");
    </script>
</c:if>
<div id="all">
    <div id="login">
        <h1>管理员登录</h1>
        <div id="center">
            <form action="LoginSuccessServlet" method="post">
                <table cellspacing="10px" cellpadding="20px">
                    <tr>
                        <td><lable for="username">用户名：</lable></td>
                        <td><input type="text" id="username" name="username" class="userpass" value="${sessionScope.username}"/></td>
                        <td>
                            <div id="success">
                                <span style="color: green">✔</span>
                            </div>
                            <div id="error">
                                <span style="color: red">✘</span>
                                <span style="color: red" id="errorText"></span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>密&nbsp;&nbsp;&nbsp;码：</td>
                        <td><input type="password" id="password" name="password" class="userpass" value="${sessionScope.password}"/></td>
                        <td>
                            <div id="pswsuccess">
                                <span style="color: green">✔</span>
                            </div>
                            <div id="pswerror">
                                <span style="color: red">✘</span>
                                <span style="color: red" id="pswerrorText"></span>
                            </div>
                        </td>
                    </tr>
                </table>
                <div id="submit">
                    <input type="submit" value="登录" id="submitOk"/>
                </div>
            </form>
        </div>
        <div id="bottom">
            <div class="bottoms">
                <img src="image/forget.svg">
                <span>忘记密码</span>
            </div>
            <div class="bottoms">
                <img src="image/forget.svg">
                <span>忘记用户名</span>
            </div>
            <a href="addUsers.jsp">
                <div class="bottoms">
                    <img src="image/singin.svg">
                    <span>注册</span>
                </div>
            </a>
        </div>
    </div>
</div>
</body>
</html>
