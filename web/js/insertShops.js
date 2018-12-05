$(function () {
    //新增商品信息验证
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
    //对商品名，商品价格、商品介绍、商品编号设置正则表达式的验证
    isTrue(/^(.){1,20}$/,"<span style='color: red'>请输入20位数以内的内容</span>","#shop_name");
    isTrue(/^([1-9]\d*|(\d+\.\d+))$/,"<span style='color: red'>请输入正确的金额格式</span>","#shop_price");
    isTrue(/^(.){0,50}$/,"<span style='color: red'>请输入50位数以内的内容</span>","#shop_des");
    isTrue(/^(.)+$/,"<span style='color: red'>库存不能为空</span>","#shop_stock");
    //商品编号格式正确，对商品编号设置唯一值验证
    //对商品编号进行验证
    var shop_idIsTrue = false;
    $("#shop_id").blur(function () {
        //正则表达式的验证
        if($("#shop_id").val() != null && $("#shop_id").val()!=""){
            //创建xmlHttpRequest
            var xmlHttpRequest = new XMLHttpRequest();
            //open发送请求
            xmlHttpRequest.open("post","AllShopsServlet",true);
            xmlHttpRequest.onreadystatechange = function (){
                if(xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200){
                    //响应的文本
                    var str = xmlHttpRequest.responseText;
                    //将字符串转为js表达式
                    var chageStr = eval(str);
                    for(var i = 0;i < chageStr.length;i++){
                        var shopId = $("#shop_id").val();
                        console.log("shopId"+shopId);
                        console.log("shujulu:"+chageStr[i].shop_id);
                        if(shopId == chageStr[i].shop_id){
                            var par = document.getElementById("shop_id").parentNode;
                            document.getElementById("shop_id_waring").style.color = "red";
                            document.getElementById("shop_id_waring").innerText = "当前商品编号已存在";
                            break;
                            // $(this).parents("td").next().children("span").html("<span style='color: red'>当前商品编号已存在</span>");
                        }else {
                            shop_idIsTrue = true;
                            document.getElementById("shop_id_waring").style.color = "greenyellow";
                            document.getElementById("shop_id_waring").innerText = "✔";
                            // $(this).parents("td").next().children("span").html("<span style='color: greenyellow'>✔</span>");
                        }
                    }
                }else {
                    console.log("获取商品编号faild");
                }
            }
            //提交请求
            xmlHttpRequest.send();
        }else {
            $(this).parents("td").next().children("span").html("<span style='color: red'>商品编码不能为空</span>");
        }
    })
    //对类别选项进行事件监听
    $("#firstName").blur(function () {
        //判断是否选择
        if($(this).val()!=null&&$(this).val()!="choose"&&$(this).val()!=""){
            document.getElementById("shop_type").style.color = "greenyellow";
            document.getElementById("shop_type").innerText = "✔";
        }else {
            document.getElementById("shop_type").style.color = "red";
            document.getElementById("shop_type").innerText = "类别不能为空";
        }
    })
    //对图片进行事件监听
    $("#shop_img").on(
        "change",function () {
            //获取文件信息
            var img =  this.files[0];
            console.log("图片名称"+img);
        }
    )
    // //对新增进行按钮监听事件
    $("#addShops").click(function () {
        if($("#shop_name").val().match(/^(.){1,20}$/)!=null&&$("#shop_price").val().match(/^(\d+|(\d+\.\d+))$/)!=null&&$("#shop_des").val().match(/^(.){0,50}$/)!=null&&
            $("#shop_stock").val().match(/^(.)+$/)!=null&&shop_idIsTrue&&$("#firstName").val()!=null&&$("#firstName").val()!="choose"&&$("#firstName").val()!=""
        ){
            return true;
        }else {
            alert("请确保所有的商品信息正确！！");
            return false;
        }
    })
})