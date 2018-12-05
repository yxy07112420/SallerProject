<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增类别</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/cateInsert.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/insertCate.js"></script>
</head>
<body>
<form action="InsertCateServlet" method="post">
    <div id="cateInsert">
        <table id="tables">
            <tr>
                <td width="100px">一级类别</td>
                <td width="250px">
                    <select class="form-control" id="firstName" name="firstName">
                        <option value="chose">---请选择----</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td  width="100px">增加二级类别</td>
                <td width="250px"><input type="text" class="form-control" id="secName" placeholder="二级类表标题" name="secName"></td>
            </tr>
            <tr>
                <td colspan="2" height="80px"><span id="error" style="color: red">${result}</span></td>
            </tr>
        </table>
        <div id="submits"style="margin-top: 20px">
            <input type="submit" value="新增商品类别" class="btn btn-success" id="submit">
        </div>
    </div>
</form>
</body>
</html>
