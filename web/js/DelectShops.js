$(function () {
    //对删除操作进行相关的事件处理
    deleteNew();
    function deleteNew()
    {
        $(".delete").each(function () {
            $(this).click(function () {
                if(confirm("请确认是否要删除，删除后你可以从回收站中查看")){
                    return true;
                }else {
                    return false;
                }
            })
        })
    }
})