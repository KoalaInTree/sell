<html>
    <head></head>
    <body>
        <button onclick="sendMessage()"   >发送</button>
    </body>
<script type="application/javascript">
    var websocket = null;
    if ('WebSocket' in window){
        websocket = new WebSocket('ws://localhost:8080/websocekt')
    }else {
        alert("该浏览器不支持websocket！");
    }

    websocket.onopen = function (event) {
        console.log("建立连接");
    }
    websocket.onclose = function (event) {
        console.log("关闭连接");
    }

    websocket.onmessage = function (event) {
        console.log('收到:'+event.data);
    }

    function sendMessage() {
        websocket.send("hi,i'm client");
    }

</script>
</html>