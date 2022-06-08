<%--
  Created by IntelliJ IDEA.
  User: hefan
  Date: 2022/4/29
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>lastName</td>
        <td>email</td>
        <td>gender</td>
    </tr>
    <c:forEach items="${allEmps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
