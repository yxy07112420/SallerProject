$(function () {
    //对删除操作进行相关的事件处理
    deleteNew();
    function deleteNew()
    {
        $(".delete").each(function () {
            $(this).click(function () {
                if(confirm("请确定是否要删除？")){
                    return true;
                }else {
                    return false;
                }
            })
        })
    }
})