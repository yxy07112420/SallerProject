<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/2
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增商品信息</title>
    <link rel="stylesheet" href="css/insertShops.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/getImges.js"></script>
    <script src="js/insertShops.js"></script>
    <script src="js/SelectCates.js"></script>
</head>
<body>
<div id="insert">
    <form action="AddShopsServlet" method="post" enctype="multipart/form-data">
        <table id="insertTbale">
            <tr>
                <td class="name">商品编号</td>
                <td class="input"><input type="text" name="shop_id" id="shop_id" placeholder="商品编号"></td>
                <td class="waring"><span id="shop_id_waring">必填</span></td>
            </tr>
            <tr>
                <td class="name">商品名称</td>
                <td class="input"><input type="text" name="shop_name" id="shop_name" placeholder="商品名称"></td>
                <td class="waring"><span>必填</span></td>
            </tr>
            <tr>
                <td class="name">商品价格</td>
                <td class="input"><input type="text" name="shop_price" id="shop_price" placeholder="商品价格"></td>
                <td class="waring"><span>必填</span></td>
            </tr>
            <tr>
                <td class="name">商品库存</td>
                <td class="input"><input type="number" name="shop_stock" id="shop_stock" placeholder="商品库存"></td>
                <td class="waring"><span>必填</span></td>
            </tr>
            <tr>
                <td class="name">商品类型</td>
                <td class="input">

                        <select name = "cate_name" id="firstName">
                            <option value="choose">---请选择商品类别----</option>
                            <%--<c:forEach items="${ParCate}" var="pc">--%>
                                <%--<option value="${pc.cate_id}">${pc.cate_Name}</option>--%>
                            <%--</c:forEach>--%>
                        </select>

                    <select name="cate_child_name" id="secondName">
                            <option value="choose">---请选择商品类别----</option>
                    </select>
                </td>
                <td class="waring"><span id="shop_type">必选</span></td>
            </tr>
            <tr>
                <td class="name">商品介绍</td>
                <td class="input">
                    <textarea name="shop_des" id="shop_des" rows="5" cols="20"></textarea>
                </td>
                <td class="waring"><span></span></td>
            </tr>
            <tr>
                <td class="name">商品图片</td>
                <td class="input">
                    <input type="file" name="shop_img" id="shop_img" accept="image/*">
                    <div id="imgsdiv">
                        <img src="" id="imgs">
                    </div>
                </td>
                <td class="waring"><span></span></td>
            </tr>
        </table>
        <div style="text-align: center">
            <input type="submit" value="新增商品" id="addShops">
        </div>
    </form>
</div>
</body>
</html>
