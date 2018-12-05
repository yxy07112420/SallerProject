<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改类别信息</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/cateInsert.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/SelectCates.js"></script>
    <script src="js/SelectAllSecCate.js"></script>
</head>
<body>
<form action="SelectOneCateServlet" method="post">
    <div id="title" style="width: 100%;height: 80px;display: flex;justify-content: center;align-items: center;">
        请选择类别
        <select class="form-control" name="cate_id" id="secondName" style="width: 60%">
            <option value="chose">----请选择----</option>
        </select>
        <input type="submit" value="查询">
    </div>
</form>
<form action="UpdateCateServlet" method="post">
    <div id="cateInsert">
        <table style="color: white">
            <tr>
                <td width="100px">类别编号</td>
                <td width="200px">
                    <input class="form-control"  name="cate_id" type="text" value="${cate.cate_id}" readonly>
                </td>
            </tr>
            <tr>
                <td>类别名</td>
                <td>
                    <input class="form-control" name="cate_Name" type="text" value="${cate.cate_Name}">
                </td>
            </tr>
            <tr>
                <td>所属的一级类别</td>
                <td>
                    <select name="firstName" id="firstName" class="form-control">
                        <option value="${firstName.cate_id}">${firstName.cate_Name}</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" height="80px"><span id="error" style="color: red">${result}</span></td>
            </tr>
        </table>
        <div id="submits"style="margin-top: 20px">
            <input type="submit" value="修改商品类别信息" class="btn btn-success" id="submit">
        </div>
    </div>
</form>
</body>
</html>
