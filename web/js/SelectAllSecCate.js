$(function () {
    //设置XMLHttpRequest对象
    var xmlHttpRequest = new XMLHttpRequest();
    //open发送请求
    xmlHttpRequest.open("post","SelectAllSecCateServlet",true);
    //判断响应码
    xmlHttpRequest.onreadystatechange = function (ev) {
        //响应状态为4并且为200，此时响应成功
        if(xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200){
            //获取响应文件
            var str = xmlHttpRequest.responseText;
            //将响应文件转为js对象
            var changStr = eval(str);
            //循环响应文件
            for(var i = 0;i < changStr.length;i++){
                document.getElementById("secondName").appendChild(new Option(changStr[i].cate_Name,changStr[i].cate_id));
            }
        }else {
            console.log("field");
        }
    }
    //响应
    xmlHttpRequest.send();
})