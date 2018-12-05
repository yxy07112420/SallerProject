//创建获取类别的ajax
$(function () {
    //设置XMLHttpRequest对象
    var xmlHttpRequest = new XMLHttpRequest();
    //open发送请求
    xmlHttpRequest.open("post","SelectCateServlet",true);
    //判断响应码
    xmlHttpRequest.onreadystatechange = function (ev) {
        //响应状态为4并且为200，此时响应成功
        if(xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200){
            //获取响应文件
            var str = xmlHttpRequest.responseText;
            //将响应文件转为js对象
            changStr = eval(str);
            //循环响应文件
            for(var i = 0;i < changStr.length;i++){
                document.getElementById("firstName").appendChild(new Option(changStr[i].cate_Name,changStr[i].cate_id));
            }
        }else {
            console.log("field");
        }
    }
    //响应
    xmlHttpRequest.send();
    var  chageStr = null;
    $("#firstName").on(
        "change",function () {
            // document.getElementById("secondName").options.length = 1;
            //创建xmlHttpRequest
            var secondXMLHttpRequest = new XMLHttpRequest();
            //open发送请求
            console.log("this；"+$(this).val());
            secondXMLHttpRequest.open("post","SelectSecCateServlet?Cate_Par_Id="+$(this).val(),true);
            secondXMLHttpRequest.onreadystatechange = function (ev) {
                if(secondXMLHttpRequest.readyState === 4 && secondXMLHttpRequest.status === 200){
                    // //响应的文本
                    var str = secondXMLHttpRequest.responseText;
                    chageStr = eval(str);
                    console.log("响应成功");
                    console.log(chageStr);
                    return chageStr;
                }else {
                    console.log("获取商品类别信息faild");
                }
            }
            secondXMLHttpRequest.send();
        }
    )
    var nameIsTrue = false;
    //对添加二级标题设置焦点移除效果
    $("#secName").blur(function () {
        console.log("获取的二级类别："+chageStr);
        //循环二级标题
        if($("#secName").val()!=null&&$("#secName").val()!=""&&$("#secName").val().length<=20){
            for(var i = 0;i < chageStr.length;i++){
                //判断输入的类别名是否存在
                if($(this).val()==chageStr[i].cate_Name){
                    //设置样式
                    document.getElementById("error").innerText = "当前商品类型名以存在";
                    break;
                }else {
                    document.getElementById("error").innerText = "";
                    nameIsTrue = true;
                }
            }
        }else {
            document.getElementById("error").innerText = "输入1-20位的字符";
        }
    })
    $("#submit").click(function () {
        //对新增按钮进行判断
        console.log("以及类别名"+$("#firstName").val());
        console.log(nameIsTrue);
        if($("#firstName").val()!=""&&$("#firstName").val()!="chose"&&$("#firstName").val()!=null&&nameIsTrue == true&&$("#secName").val()!=null&&$("#secName").val()!=""&&$("#secName").val().length<=20){
            return true;
        }else {
            alert("请选择一级类别，并保证输入的字段正确");
            return false;
        }
    })
})