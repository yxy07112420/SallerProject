$(function () {
    //图片预览效果的实现
    $("#shop_img").on(
        "change",function () {
            //获取文件信息
            var img =  getImage(this.files[0]);
            console.log("图片名称1:"+img);
            if(img){
                $("#imgs").attr("src",img);
            }
        }
    )
    //创建方法
    function getImage(file) {
        var util = null;
        if(window.createObjectURL!=undefined){
            util = window.createObjectURL(file);
        }else if(window.URL!=undefined){
            util = window.URL.createObjectURL(file) ;// mozilla(firefox)
        }else if(window.webkitURL!=undefined){
            util = window.webkitURL.createObjectURL(file);// webkit or chrome
        }
        return util;
    }
})