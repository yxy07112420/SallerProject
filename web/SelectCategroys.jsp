<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/3
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询所有的类别信息</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/Categroy.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/getCategroys.js"></script>
    <script src="js/delectCate.js"></script>
</head>
<body>
<div id="all">
    <c:if test="${result != null}">
        <script>
            alert("${requestScope.result}");
        </script>
    </c:if>
    <form action="CategroysServlet" method="post">
        <div id="title">
                请选择一级类别：
                <select class="form-control" name="firstName" id="firstName">
                    <option value="chose">----请选择----</option>
                    <option value="0">查看全部的一级类别</option>
                </select>
                <input type="submit" value="查询">
        </div>
    </form>
    <div id="top">
        <table class="table table-hover">
            <tr>
                <th>类别编号</th>
                <th>类别名</th>
                <th>一级类别名</th>
                <th>相关操作</th>
            </tr>
            <c:forEach items="${cates.cates}" var="maps">
                <tr>
                    <td>${maps.key.getCate_id()}</td>
                    <td>${maps.key.cate_Name}</td>
                    <td>${maps.value}</td>
                    <c:if test="${maps.key.cate_Parent_Id !=0}">
                        <td class="imgs">
                            <a href="SelectOneCateServlet?cate_id=${maps.key.cate_id}"><img src="image/wirte.svg" title="修改" class="update"/></a>
                            <a href="DeleteCateServlet?cate_id=${maps.key.cate_id}"><img src="image/delete.svg" title="删除" class="delete"/></a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="bottom">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <c:if test="${cates.pageNum > 1}">
                        <a href="${pageContext.request.contextPath}/CategroysServlet?pageNum=${cates.pageNum - 1}&firstName=${firstName}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:forEach begin="${cates.startPage}" end="${cates.endPage}" step="1" var="i">
                    <li><a href="${pageContext.request.contextPath}/CategroysServlet?pageNum=${i}&firstName=${firstName}">${i}</a></li>
                </c:forEach>
                <li>
                    <c:if test="${cates.pageNum < cates.allPages}">
                        <a href="${pageContext.request.contextPath}/CategroysServlet?pageNum=${cates.pageNum + 1}&firstName=${firstName}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
