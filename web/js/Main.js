/**
 * 对登录设置登录的相关验证
 */
$(function () {
	setInterval(getTime,1000);
    function getTime() {
        //获取当前时间
        var times = new Date();
        //获取当前时间的年数
        var year = times.getFullYear();
        //获取当前是案件的月份
        var month = times.getMonth()+1;
        //获取当前时间的日期
        var date = times.getDate();
        //获取当前时间的周期
        var day = times.getDay();
        //对获取的日期进行判断
        switch (day) {
            case 0:
                day = "星期日";
                break;
            case 1:
                day = "星期一";
                break;
            case 2:
                day = "星期二";
                break;
            case 3:
                day = "星期三";
                break;
            case 4:
                day = "星期四";
                break;
            case 5:
                day = "星期五";
                break;
            default:
                day = "星期六";
                break;
        }
        //获取小时数
        var hours = times.getHours();
        //获取分钟数
        var min = times.getMinutes();
        //获取秒数
        var sc = times.getSeconds();
        if(sc<10){
        	sc = "0"+sc;
        }
        if(min<10){
        	min = "0"+min;
        }
        if(hours<10){
        	hours = "0"+hours;
        }
        var nowTime = year+"年"+month+"月"+date+"日"+"      "+day+"       "+hours+":"+min+":"+sc;
        $("#mainAllTopTime span").text(nowTime);
    }    
	/**
	 * 对商品信息设置鼠标点击操作
	 */
	$(".infors_conter").hide();
	$(".infors").click(function () {
        if($(this).children(".infors_li").text().match(/\+/) ){
            $(this).children(".infors_li").text("-");
        }
        else if($(this).children(".infors_li").text().match(/\-/)){
            $(this).children(".infors_li").text("+");
        }
        $(this).next().toggle();
    })
})