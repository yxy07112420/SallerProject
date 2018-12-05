$(function () {
    //设置正则表达式的验证
    function isTrue(rs,html1,id){
        $(id).blur(function () {
            if(rs.test($(this).val()) == false){
                // $(this).parents("td").next().children("span").html("<span style='color: greenyellow'>✔</span>").hide();
                $(this).parents("td").next().children("span").html(html1);
            }else {
                // $(this).parents("td").next().children("span").html(html1).hide();
                $(this).parents("td").next().children("span").html("<span style='color: greenyellow'>✔</span>");
            }
        })
    }
    //对密码、手机号、邮箱设置正则表达式的验证
    isTrue(/^([a-zA-Z\d]){6,20}$/,"<span style='color: red'>请输入6-20位以内的字母和数字</span>","#password");
    isTrue(/^(\d){11}$/,"<span style='color: red'>请输入11位的手机号</span>","#telPhone");
    isTrue(/^([\w\.\-]+)@([\w\.\-]+)\.([\w]{2,4})$/,"<span style='color: red'>请输入正确的邮箱格式</span>","#email");
    //对用户名设置正则表达式的验证
    var userIsOk = false;
    $("#username").blur(function () {
        if($(this).val().match(/^(\w){5,20}$/)!=null){
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
                    console.log(typeof(chageStr));
                    //获取文本框中的值
                    var username = document.getElementById("username").value;
                    console.log("username:"+username);
                    for(var i = 0;i < chageStr.length;i++){
                        //判断是否有相同的
                        console.log("User_name:"+chageStr[i].user_name);
                        console.log("判断："+(username == chageStr[i].user_Name));
                        if(username == chageStr[i].user_Name){
                            document.getElementById("shop_id_waring").style.color = "red";
                            document.getElementById("shop_id_waring").innerText = "当前用户已存在";
                            break;
                        }else {
                            document.getElementById("shop_id_waring").style.color = "greenyellow";
                            document.getElementById("shop_id_waring").innerText = "✔";
                            userIsOk = true;
                        }
                    }
                }else {
                    console.log("faild");
                }
            }
            //发送请求
            xmlHttpRequest.send();
        }else {
            $(this).parents("td").next().children("span").html("<span style='color: red'>5-20位的字母、数字和_</span>");
        }
    })
    var chackesIsOk = false;
    //验证两次密码是否一致
    $("#chackPass").blur(function () {
        if($(this).val() == null||$(this).val()==""){
            $(this).parents("td").next().children("span").html("<span style='color: red'>不能为空</span>");
        }else if($(this).val() != $("#password").val()) {
            $(this).parents("td").next().children("span").html("<span style='color: red'>两次密码不一致</span>");
        }else {
            $(this).parents("td").next().children("span").html("<span style='color: greenyellow'>✔</span>");
            chackesIsOk =true;
        }
    })
    //对注册按钮设置监听事件
    $("#addUser").click(function () {
        console.log(chackesIsOk);
        console.log(userIsOk);
        console.log($("#username").val().match(/^(\w){5,20}$/)!=null);
        console.log($("#password").val().match(/^([a-zA-Z\d]){6,20}$/)!=null);
        console.log($("#telPhone").val().match(/^(\d){11}$/)!=null);
        console.log($("#email").val().match(/^([\w\.\-]+)@([\w\.\-]+)\.([\w]{2,4})$/)!=null);
        if(chackesIsOk&&userIsOk&&$("#username").val().match(/^(\w){5,20}$/)!=null&&$("#password").val().match(/^([a-zA-Z\d]){6,20}$/)!=null
        &&$("#telPhone").val().match(/^(\d){11}$/)!=null&&$("#email").val().match(/^([\w\.\-]+)@([\w\.\-]+)\.([\w]{2,4})$/)!=null
        ){
            return true;
        }else {
            alert("请将数据都填写正确！！");
            return false;
        }

    })
})