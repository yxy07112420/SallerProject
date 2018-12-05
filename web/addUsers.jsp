<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="css/addUsers.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/adduser.js"></script>
</head>
<body>
<c:if test="${requestScope.result != null}">
    <script>
        alert("${requestScope.result}");
    </script>
</c:if>
<form action="AddUsersServlet" method="post">
    <div id="allAddShops">
        <div id="addTop">
            <span>用  户  注  册</span>
        </div>
        <div id="addBottom">
            <table id="insertTbale">
                <tr>
                    <td class="name">用户名</td>
                    <td class="input">
                        <input type="text" class="form-control" name="username" id="username" placeholder="用户名">
                        <%--<input type="text" name="username" id="username" placeholder="用户名">--%>
                    </td>
                    <td class="waring"><span id="shop_id_waring">必填</span></td>
                </tr>
                <tr>
                    <td class="name">密码</td>
                    <td class="input">
                        <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                        <%--<input type="password" name="password" id="password" placeholder="密码">--%>
                    </td>
                    <td class="waring"><span>必填</span></td>
                </tr>
                <tr>
                    <td class="name">再次确认密码</td>
                    <td class="input">
                        <input type="password" class="form-control"  name="chackPass" id="chackPass" placeholder="再次确认密码">
                        <%--<input type="password" name="chackPass" id="chackPass" placeholder="再次确认密码">--%>
                    </td>
                    <td class="waring"><span>两次密码必须一致</span></td>
                </tr>
                <tr>
                    <td class="name">手机号</td>
                    <td class="input">
                        <input type="text" class="form-control"  name="telPhone" id="telPhone" placeholder="手机号">
                        <%--<input type="number" name="telPhone" id="telPhone" placeholder="手机号">--%>
                    </td>
                    <td class="waring"><span>必填</span></td>
                </tr>
                <tr>
                    <td class="name">邮箱</td>
                    <td class="input">
                        <input type="email" class="form-control" name="email" id="email" placeholder="123456@123.com">
                        <%--<input type="email" name="email" id="email" placeholder="123456@123.com">--%>
                    </td>
                    <td class="waring"><span id="shop_type">必填</span></td>
                </tr>
            </table>
            <div style="text-align: center;margin-top: 20px" id="addSubmit">
                <input type="submit" class="btn btn-info"  value="注    册" id="addUser">
                <%--<input type="submit" value="注    册" id="addUser">--%>
            </div>
        </div>

    </div>

</form>
</div>
</body>
</html>
