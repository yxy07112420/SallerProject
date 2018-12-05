<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/1
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看商品信息</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/SelectShop.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/DelectShops.js"></script>
    <script src="js/AllShops.js"></script>
</head>
<body>

    <table class="table table-hover">
        <tr>
            <th>商品编号</th>
            <th>商品名</th>
            <th>商品描述</th>
            <th>商品图片</th>
            <th>商品类别</th>
            <th>商品库存</th>
            <th>商品售价</th>
            <th>相关操作</th>
        </tr>
        <c:forEach items="${shops.shops}" var="maps">
            <tr>
            <c:forEach items="${maps.value}" var="name">
                <td>${maps.key.getShop_id()}</td>
                <td>${maps.key.getShop_Name()}</td>
                <td>${maps.key.getShop_des()}</td>
                <td>
                    <div class="shop_imgs">
                        <img src="http://10.25.148.198:8080/photo/${maps.key.getShop_img()}" class="shop_img">
                        <div class="chang_img">
                            <img src="http://10.25.148.198:8080/photo/${maps.key.getShop_img()}" class="chang_shop_img">
                        </div>
                    </div>
                </td>
                <td>${name}</td>
                <td>${maps.key.getShop_Stock()}</td>
                <td>${maps.key.getShop_price()}</td>
                <td class="imgs">
                    <a href="SelectOneShopServlet?shop_id=${maps.key.getShop_id()}"><img src="image/wirte.svg" title="修改" class="update"/></a>
                    <a href="DeleteShopsServlet?shop_id=${maps.key.getShop_id()}"><img src="image/delete.svg" title="删除" class="delete"/></a>
                </td>
            </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align: center">
        <nav aria-label="Page navigation navbar-fixed-bottom">
            <ul class="pagination" >
                <li>
                    <c:if test="${shops.pageNum > 1}">
                        <a href="${pageContext.request.contextPath}/ShopsServlet?pageNum=${shops.pageNum - 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach begin="${shops.startPage}" end="${shops.endPage}" step="1" var="i">
                    <li><a href="${pageContext.request.contextPath}/ShopsServlet?pageNum=${i}">${i}</a></li>
                </c:forEach>
                <li>
                    <c:if test="${shops.pageNum < shops.allPages}">
                        <a href="${pageContext.request.contextPath}/ShopsServlet?pageNum=${shops.pageNum + 1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                </li>
            </ul>
        </nav>
    </div>
</body>
</html>
