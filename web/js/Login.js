/**
 * 对登录设置登录的相关验证
 */
$(function () {
    $("#success").hide();
    $("#error").hide();
    $("#pswsuccess").hide();
    $("#pswerror").hide();
    //对用户名设置鼠标经过事件
    var userIsSucc = false;
    $("#username").blur(function () {
        //创建xmlHttpRequest
        var xmlHttpRequest = new XMLHttpRequest();
        //open发送请求
        xmlHttpRequest.open("post","LoginServlet",true);
        xmlHttpRequest.onreadystatechange = function () {
            console.log("响应码："+xmlHttpRequest.readyState);
            if(xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200){
                //响应的文本
                var str = xmlHttpRequest.responseText;
                //将字符串转为js表达式
                var chageStr = eval(str);
                //获取文本框中的值
                var username = document.getElementById("username").value;
                if(username =="" || username == undefined){
                    document.getElementById("success").style.display = "none";
                    document.getElementById("error").style.display = "block";
                    document.getElementById("errorText").innerText="用户名不能为空";
                }else {
                    for(var i = 0;i < chageStr.length;i++){
                        //判断是否有相同的
                        if(username == chageStr[i].user_Name){
                            document.getElementById("success").style.display = "block";
                            document.getElementById("error").style.display = "none";
                            userIsSucc = true;
                            account = i;
                            break;
                        }else {
                            document.getElementById("success").style.display = "none";
                            document.getElementById("error").style.display = "block";
                            document.getElementById("errorText").innerText="用户名不存在";
                        }
                    }
                }
            }else {
                console.log("faild");
            }
        }
        //发送请求
        xmlHttpRequest.send();
    })
    var pasIsSucc = false;
    var changLog = false;
    //对密码进行验证
    $("#password").blur(function () {
        //创建xmlHttpRequest
        var xmlHttpRequest = new XMLHttpRequest();
        //open发送请求
        xmlHttpRequest.open("post","LoginServlet",true);
        xmlHttpRequest.onreadystatechange = function () {
            console.log("响应码："+xmlHttpRequest.readyState);
            if(xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200){
                //响应的文本
                var str = xmlHttpRequest.responseText;
                //将字符串转为js表达式
                var chageStr = eval(str);
                //获取文本框中的值
                var password = document.getElementById("password").value;
                console.log("username:"+username);
                if(password =="" || password == undefined){
                    document.getElementById("pswsuccess").style.display = "none";
                    document.getElementById("pswerror").style.display = "block";
                    document.getElementById("pswerrorText").innerText="密码不能为空";
                }else {
                        //判断是否有相同的
                        if(password == chageStr[account].user_psw){
                            document.getElementById("pswsuccess").style.display = "block";
                            document.getElementById("pswerror").style.display = "none";
                            pasIsSucc = true;
                        }else {
                            document.getElementById("pswsuccess").style.display = "none";
                            document.getElementById("pswerror").style.display = "block";
                            document.getElementById("pswerrorText").innerText="密码不正确";
                        }
                }
            }else {
                console.log("faild");
            }
        }
        //发送请求
        xmlHttpRequest.send();
    })

    //创建查询方法
    function login(){
        //创建xmlHttpRequest
        var xmlHttpRequest = new XMLHttpRequest();
        //open发送请求
        xmlHttpRequest.open("post","LoginIsSuccServlet?username="+$("#username").val()+"&password="+$("#username").val(),true);
        xmlHttpRequest.onreadystatechange = function () {
            if(xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200){
                //响应的文本
                var str = xmlHttpRequest.responseText;
                console.log("str"+str);
                if(str == "success"){
                    changLog = true;
                }else {
                    changLog = false;
                }
                //获取文本框中的值
                // var username = document.getElementById("username").value;
                // var password = document.getElementById("password").value;
                // console.log("username:"+username);
                // for(var i = 0;i < chageStr.length;i++){
                //     console.log("username == chageStr[i].user_Name:"+username == chageStr[i].user_Name)
                //     //判断是否有相同的
                //     if(username == chageStr[i].user_Name && password == chageStr[i].user_psw) {
                //         changLog = true;
                //         break;
                //     }else {
                //         changLog = false;
                //         break;
                //     }
                // }
            }else {
                console.log("faile");
            }
        }
        //发送请求
        xmlHttpRequest.send();
    }
    //对登录按钮进行点击事件的处理
    $("#submitOk").click(function () {
        // login();
        // console.log("changLog"+changLog);
        if($("#username").val()!=null&&$("#username").val()!=null&&$("#username").val()!=""&&$("#username").val()!=""){
            return true;
        }else {
            alert("请输入正确的用户名和密码");
            return false;
        }
    })
})