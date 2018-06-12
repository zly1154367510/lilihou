<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/6/11
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script type="text/javascript">
    var websocket = null;

    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://127.0.0.1:8089/taotao/marco");
        console.log(websocket)
    }
    else {
        alert("对不起！你的浏览器不支持webSocket")
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {

        alert("error")
    };

    //连接成功建立的回调方法
    websocket.onopen = function (event) {

        alert("successs")
    };

    //接收到消息的回调方法
    websocket.onmessage = function (event) {

    };

    //连接关闭的回调方法
    websocket.onclose = function () {

    };

</script>
</body>
</html>
