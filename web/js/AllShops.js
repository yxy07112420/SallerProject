$(function () {
    //对图片设置鼠标经过效果
    $(".shop_img").each(function () {
        $(this).hover(
            function () {
                console.log("鼠标经过");
                $(this).next().show();
            },
            function () {
                console.log("鼠标滑出");
                $(this).next().hide();
            }
        )
    })
})