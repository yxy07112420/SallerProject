<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/3
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>修改商品信息</title>
    <link rel="stylesheet" href="css/insertShops.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/SelectCates.js"></script>
    <script src="js/getImges.js"></script>
</head>
<body>
<div id="update_title" style="color: #1b6d85;">
    <form action="SelectOneShopServlet" method="post">
        请输入您要选择修改的商品信息：<input type="text" id="updateConter" name="shop_id" placeholder="商品编号"/>
        <input type="submit" id="select" value="查询">
    </form>
</div>
<c:if test="${shop != null }">
    <form action="updateShopsServlet?shop_id=${shop.shop_id}" method="post" enctype="multipart/form-data">
        <table id="insertTbale">
            <tr>
                <td class="name">商品编号</td>
                <td class="input"><input type="text" name="shop_id" id="shop_id" value="${shop.shop_id}" readonly="readonly"></td>
                <td class="waring"><span id="shop_id_waring"></span></td>
            </tr>
            <tr>
                <td class="name">商品名称</td>
                <td class="input"><input type="text" name="shop_name" id="shop_name" value="${shop.shop_Name}"></td>
                <td class="waring"><span></span></td>
            </tr>
            <tr>
                <td class="name">商品价格</td>
                <td class="input"><input type="text" name="shop_price" id="shop_price" value="${shop.shop_price}"></td>
                <td class="waring"><span></span></td>
            </tr>
            <tr>
                <td class="name">商品库存</td>
                <td class="input"><input type="number" name="shop_stock" id="shop_stock" value="${shop.shop_Stock}"></td>
                <td class="waring"><span></span></td>
            </tr>
            <tr>
                <td class="name">商品类型</td>
                <td class="input">
                    <select name = "cate_name" id="firstName">
                        <option value="${shop.shop_Cate_id}">${cate_name}</option>
                            <%--<c:forEach items="${ParCate}" var="pc">--%>
                                <%--<option value="${pc.cate_id}">${pc.cate_Name}</option>--%>
                            <%--</c:forEach>--%>
                    </select>
                    <select name="cate_child_name" id="secondName">
                    </select>
                </td>
                <td class="waring"><span></span></td>
            </tr>
            <tr>
                <td class="name">商品介绍</td>
                <td class="input">
                    <textarea name="shop_des" id="shop_des" rows="5" cols="20">${shop.shop_des}</textarea>
                </td>
                <td class="waring"><span></span></td>
            </tr>
            <tr>
                <td class="name">商品图片</td>
                <td class="input">
                    <input type="file" name="shop_img" id="shop_img" accept="image/*">
                    <div id="imgsdiv">
                        <img src="http://10.25.148.198:8080/photo/${shop.shop_img}" id="imgs">
                    </div>
                </td>
                <td class="waring"><span></span></td>
            </tr>
        </table>
        <div style="text-align: center">
            <input type="submit" value="修改商品" id="addShops">
        </div>
    </form>
</c:if>
</body>
</html>
