<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>LexerOutput</title>
    <script src="../static/script/jquery-1.7.2.js"></script>
</head>
<body>
<!--<script>-->
<!--    window.onload(function requestData() {-->
<!--        $.ajax({-->
<!--            url: "http://localhost:8080/Compiler/inputServlet",-->
<!--            type: "post",-->
<!--            dataType: "json",-->
<!--            success: function (data) {-->
<!--                /*这个方法里是ajax发送请求成功之后执行的代码*/-->
<!--                showData(data);//我们仅做数据展示-->
<!--            }, error: function (msg) {-->
<!--                alert("ajax连接异常：" + msg);-->
<!--            }-->
<!--        });-->
<!--    });-->

<!--    //展示数据-->
<!--    function showData(data) {-->
<!--        $("#textInput").append(data);-->
<!--    }-->
<!--</script>-->
代码:<br>
<div style="display: inline-block;margin-left: 50px">
    <textarea name="textInput" rows="10" cols="40" width="100%" height="100%" placeholder="${requestScope.text}"></textarea>
</div>
<br>
词法分析结果如下：<br>
<div style="display: inline-block;margin-left: 50px">
    ${requestScope.data}
</div>

<br>
标识符表<br>
编号 行号 名称
<span class="text"></span>
<div style="margin-left: 10px">
    ${requestScope.table}
</div>
<%--<textarea id="textInput" name="textInput" rows="10" cols="20" width="100%" height="100%" placeholder="${requestScope.data}"></textarea>--%>
</body>
</html>