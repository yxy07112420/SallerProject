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
    $("#firstName").on(
        "change",function () {
            // document.getElementById("secondName").options.length = 1;
            //创建xmlHttpRequest
            var secondXMLHttpRequest = new XMLHttpRequest();
            //open发送请求
            secondXMLHttpRequest.open("post","CategroysServlet?cate_Par_ID="+$(this).val(),true);
            secondXMLHttpRequest.onreadystatechange = function (ev) {
                if(secondXMLHttpRequest.readyState === 4 && secondXMLHttpRequest.status === 200){
                    // //响应的文本
                    var str = secondXMLHttpRequest.responseText;
                    if(str != null){
                        //将字符串转为js表达式
                        console.log(str);
                        var chageStr = eval(str);
                        if(chageStr.length != 0){
                            for(var i = 0;i < chageStr.length;i++){
                                //将option对象放在select下面
                                document.getElementById("secondName").appendChild(new Option(chageStr[i].cate_Name,chageStr[i].cate_id));
                            }
                        }
                    }
                }else {
                    console.log("获取商品类别信息faild");
                }
            }
            secondXMLHttpRequest.send();
        }
    )
})