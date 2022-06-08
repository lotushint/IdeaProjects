<%--
  Created by IntelliJ IDEA.
  User: hefan
  Date: 2022/5/13
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- http://localhost:8080/crowdfunding02_admin_webui/test/ssm.html -->
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {

            //btn1
            //此方式可以在浏览器看到发送的请求体是Form Data(表单数据)
            $("#btn1").click(function () {
                $.ajax({
                    url: "send/array/one.html",
                    type: "post",
                    data: {"array": [5, 8, 12]},
                    dataType: "text",
                    success: function (response) {
                        alert(response);
                    },
                    error: function (response) {
                        alert(response);
                    }

                });
            });

            //btn2
            //此方式可以在浏览器看到发送的请求体是Request Payload(请求负载)
            $("#btn2").click(function () {
                //准备要发送的数据
                // var array = [5, 8, 12];
                // 将JSON数组转换成JSON字符串
                // var arrayStr = JSON.stringify(array);
                $.ajax({
                    url: "send/array/two.html",         //请求目标资源地址
                    type: "post",                       //请求方式
                    "data": {                           // 要发送的请求参数
                        "array[0]": 5,
                        "array[1]": 8,
                        "array[2]": 12,
                    },                     //发送的请求参数
                    dataType: "text",                   //表示如何对待服务器返回的数据
                    // contentType: "application/json;charset=UTF-8",  //告诉服务器端当前请求的请求体是JSON格式
                    success: function (response) {
                        alert(response);
                    },
                    error: function (response) {
                        alert(response);
                    }

                });
            });

            $("#btn3").click(function () {

                // 准备好要发送到服务器端的数组
                var array = [5, 8, 12];
                console.log(array.length);

                // 将JSON数组转换为JSON字符串
                var requestBody = JSON.stringify(array);
                // "['5','8','12']"
                console.log(requestBody.length);

                $.ajax({
                    "url": "send/array/three.html",         // 请求目标资源的地址
                    "type": "post",                         // 请求方式
                    "data": requestBody,                  // 请求体
                    "contentType": "application/json;charset=UTF-8",    // 设置请求体的内容类型，告诉服务器端本次请求的请求体是JSON数据
                    "dataType": "text",                 // 如何对待服务器端返回的数据
                    "success": function (response) {        // 服务器端成功处理请求后调用的回调函数，response是响应体数据
                        alert(response);
                    },
                    "error": function (response) {      // 服务器端处理请求失败后调用的回调函数，response是响应体数据
                        alert(response);
                    }
                });

            });

            $("#btn4").click(function () {
                // 准备要发送的数据,注意属性名和类中的一致
                var student = {
                    "stuId": 5,
                    "stuName": "tom",
                    "address": {
                        "province": "广东",
                        "city": "深圳",
                        "street": "后瑞"
                    },
                    "subjectList": [
                        {
                            "subjectName": "JavaSE",
                            "subjectScore": 100
                        }, {
                            "subjectName": "SSM",
                            "subjectScore": 99
                        }
                    ],
                    "map": {
                        "k1": "v1",
                        "k2": "v2"
                    }
                };

                // 将JSON对象转换为JSON字符串
                var requestBody = JSON.stringify(student);

                // 发送Ajax请求
                $.ajax({
                    "url": "send/compose/object.html",
                    "type": "post",
                    "data": requestBody,
                    "contentType": "application/json;charset=UTF-8",
                    "dataType": "text",
                    "success": function (response) {
                        console.log(response);
                    },
                    "error": function (response) {
                        console.log(response);
                    }
                });

            });

            $("#btn4json").click(function () {
                // 准备要发送的数据,注意属性名和类中的一致
                var student = {
                    "stuId": 5,
                    "stuName": "tom",
                    "address": {
                        "province": "广东",
                        "city": "深圳",
                        "street": "后瑞"
                    },
                    "subjectList": [
                        {
                            "subjectName": "JavaSE",
                            "subjectScore": 100
                        }, {
                            "subjectName": "SSM",
                            "subjectScore": 99
                        }
                    ],
                    "map": {
                        "k1": "v1",
                        "k2": "v2"
                    }
                };

                // 将JSON对象转换为JSON字符串
                var requestBody = JSON.stringify(student);

                // 发送Ajax请求
                $.ajax({
                    "url": "send/compose/object.json",
                    "contentType": "application/json;charset=UTF-8",
                    "type": "post",
                    "data": requestBody,
                    "dataType": "json",
                    "success": function (response) {
                        console.log(response);
                    },
                    "error": function (response) {
                        console.log(response);
                    }
                });

            });

            $("#btn5").click(function (){
                layer.msg("Layer的弹框");
            });
        });
    </script>
</head>
<body>
<a href="test/ssm.html">测试SSM整合环境</a><br>
<button id="btn1">Send [5,8,12] One</button>
<br>
<button id="btn2">Send [5,8,12] Two</button>
<br>
<button id="btn3">Send [5,8,12] Three</button>
<br>
<button id="btn4">Send Compose Object</button>
<br>
<button id="btn4json">Send Compose Object Json</button>
<br>
<button id="btn5">点我弹框</button>
</body>
</html>
