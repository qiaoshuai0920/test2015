$(document).ready(function() {
    $(".select_panel ul li").live("click",
            function() {
                var v = $(this).attr('startDate').split('-');
                $("#cal_mon").html(v[1] + '月');
                $("#wt_date_list").html(wtDays(v[0], v[1], 1));
                $("#_cyear").html(wtYears(v[1], 1));
                setWtJson($(this).attr('startDate'), $(this).attr('endDate'));
            });

    $(".select_panel2 ul li").live("click",
            function() {
                var v = $(this).attr('startDate').split('-');
                $("#cal_year").html(v[0] + '年');
                $("#wt_date_list").html(wtDays(v[0], v[1], 1));
                $("#_cmonth").html(wtMonths(v[0], 1));
                setWtJson($(this).attr('startDate'), $(this).attr('endDate'));
            });
    $(".wtyq_date tbody tr td a").live("click", function() {
        $(".wtyq_date tbody tr td a.selected").attr("className", "");
        $(this).attr("className", "selected");
        $("#playDate").val($(this).attr("id"));
        $("#playDateStr").html($(this).attr("id"));
        $("#mainPage").show();
    	$("#calendarPage").hide();
    });
    var myDate = new Date();
    var nowMonth =  (myDate.getMonth() + 1);

    $("#cal_mon").html(nowMonth + '月');
    $("#cal_year").html(myDate.getFullYear() + '年');
//    $("#wt_date_list").html(wtDays(myDate.getFullYear(), nowMonth, 1));
	$('#' + dateWtFormat(myDate)).attr("className", "selected");
});

/**
 * 年
 */
function wtYears(mmonth, isreturn) {
    var myDate = new Date();
    var nowyear = myDate.getFullYear();
    var nextyear = myDate.getFullYear() + 1;
    if (mmonth) {
        var nstartDate = new Date(nowyear, mmonth - 1, 1);
        nstartDate.setFullYear(nowyear, mmonth - 1, 1);
        var nendDate = new Date(nowyear, mmonth - 1, 1);
        nendDate.setFullYear(nowyear, mmonth - 1, 1);
        nendDate.setDate(getWtDaysCount(nendDate));

        var nestartDate = new Date(nextyear, mmonth - 1, 1);
        nestartDate.setFullYear(nextyear, mmonth - 1, 1);
        var neendDate = new Date(nextyear, mmonth - 1, 1);
        neendDate.setFullYear(nextyear, mmonth - 1, 1);
        neendDate.setDate(getWtDaysCount(neendDate));

    } else {
        var nstartDate = new Date(nowyear, myDate.getMonth(), 1);
        nstartDate.setFullYear(nowyear, myDate.getMonth(), 1);
        var nendDate = new Date(nowyear, myDate.getMonth(), 1);
        nendDate.setFullYear(nowyear, myDate.getMonth(), 1);
        nendDate.setDate(getWtDaysCount(nendDate));

        var nestartDate = new Date(nextyear, myDate.getMonth(), 1);
        nestartDate.setFullYear(nextyear, myDate.getMonth(), 1);
        var neendDate = new Date(nextyear, myDate.getMonth(), 1);
        neendDate.setFullYear(nextyear, myDate.getMonth(), 1);
        neendDate.setDate(getWtDaysCount(neendDate));

    }

    str = '<li startDate="' + dateWtFormat(nstartDate) + '" endDate="' + dateWtFormat(nendDate) + '"><a href="#" onclick="return false"  id="cal_year' + nowyear + '">' + nowyear + '年</a></li><li startDate="' + dateWtFormat(nestartDate) + '" endDate="' + dateWtFormat(neendDate) + '"><a href="#" onclick="return false"  id="cal_year' + nextyear + '">' + nextyear + '年</a></li>';
    if (isreturn) {
        return str
    } else {
        document.write(str);
    }
}

/**
 * 月
 */
function wtMonths(myear, isreturn) {
    var myDate = new Date();
    myDate.setDate(1);
    if (myear) {
        myear = myear;
    } else {
        myear = myDate.getFullYear();
    }
    var strMonth = '';
    for (var i = 0; i <= 11; i++) {
        var str = '';
        var index = i;
        var startDate = new Date(myDate.getFullYear(), i, 1);
        startDate.setFullYear(myear, i, 1);
        var endDate = new Date(myDate.getFullYear(), i, 1);
        endDate.setFullYear(myear, i, 1);
        endDate.setDate(getWtDaysCount(endDate));
        var nowMonth = i + 1;
        
            nowMonth = nowMonth;

        str += '<li startDate="' + dateWtFormat(startDate) + '" endDate="' + dateWtFormat(endDate) + '"><a href="#" onclick="return false"  id="cal_mon' + (i + 1) + '">' + nowMonth + '月</a></li>';
        strMonth += str;
    }
    /**
     * 当前选中月
     */
    var myEndDate = new Date(myDate.getFullYear(), myDate.getMonth(), 1);
    myEndDate.setMonth(myDate.getMonth());
    myEndDate.setDate(getWtDaysCount(myEndDate));
    setWtJson(dateWtFormat(myDate), dateWtFormat(myEndDate));

    if (isreturn) {
        return strMonth
    } else {
        document.write(strMonth);
    }
}

/**
 * 初始化所选中月
 */
function wtDays(myear, mmonth, isreturn) {
    var myDate = new Date();
    var strHtml = '';
    if (myear && mmonth) {
    	var dateStr = myear+"年"+mmonth+"月";
        var startDate = new Date(myear, mmonth - 1, 1);
        strHtml += getWtMonthHtml(startDate,dateStr);
    } else {
    	var dateStr = myDate.getFullYear()+"年"+myDate.getMonth()+"月";
        strHtml += getWtMonthHtml(myDate,dateStr);
    }
    if (isreturn) {
        return strHtml
    } else {
        document.write(strHtml);
    }
}
function wtDays1(n,startDate,endDate) {
    var myDate = new Date();
    var dateStr = myDate.getFullYear()+"年"+(myDate.getMonth()+n+1)+"月";
    var nowDate = new Date(myDate.getFullYear(), myDate.getMonth()+n, 1);
    var strHtml = getWtMonthHtml(nowDate,dateStr,startDate,endDate);
    document.write(strHtml);
}

/**
 * 拼接日期控件上一个月div的html
 * @param date
 */
function getWtMonthHtml(date,dateStr,startDate,endDate) {
    var divHtml = '<div class="panel_datepicker">\r';
    	divHtml += '<h3>'+dateStr+'</h3>'
    var tableHtml = '<table border="0" cellspacing="0" cellpadding="0" width="220" class="wtyq_date">\r';
    var headHtml = getWtHeadHtml();
    divHtml += tableHtml;
    divHtml += headHtml;
    divHtml += '<tbody>\r';
    var daysCount = getWtDaysCount(date);
    for (var j = 1; j <= daysCount; j++) {
        var dayHtml = '';
        var temp = new Date();
        temp.setTime(date.getTime());
        temp.setDate(j);
        divHtml += getWtDayTdHtml(temp, daysCount,startDate,endDate);
    }
    divHtml += '</tbody>\r';
    divHtml += '</table>\r';
    divHtml += '</div>\r';
    return divHtml;
}

/**
 * 拼接日期控件的head即星期
 */
function getWtHeadHtml() {
    var headHtml = '';
    headHtml += '<thead>\r';
    headHtml += '<tr>\r';
    headHtml += '<th class="reds" align="center">日</th>\r';
    headHtml += '<th align="center">一</th>\r';
    headHtml += '<th align="center">二</th>\r';
    headHtml += '<th align="center">三</th>\r';
    headHtml += '<th align="center">四</th>\r';
    headHtml += '<th align="center">五</th>\r';
    headHtml += '<th class="greens" align="center">六</th>\r';
    headHtml += '</thead>\r';
    headHtml += '</tr>\r';
    return headHtml;
}

/**
 * 拼接日期控件上某一天td的html
 * @param date
 * @param dayCount
 */
function getWtDayTdHtml(date, dayCount,startDate,endDate) {
    var strHtml = '';
    var dayTdHtml = '<td myDate="' + dateWtFormat(date) + '">';
    var flag = false;
    if(dateCompare(dateWtFormat(date),startDate)) {
    	flag = true;
    } else if(dateCompare(dateWtFormat(date),startDate)&&dateCompare(endDate,dateWtFormat(date))) {
    	flag = true;
    }
    if(flag) {
    	dayTdHtml += '<a href="javascript:void(0)" id="' + dateWtFormat(date) + '">';
        dayTdHtml += date.getDate();
        dayTdHtml += '</a>'
    } else {
    	 dayTdHtml += date.getDate();
    }
    dayTdHtml += '</td>';
    if (1 == date.getDate()) { //如果是月初第一天
        strHtml += '<tr>';
        for (var i = 0; i < date.getDay(); i++) {
            strHtml += '<td>&nbsp;</td>';
        }
        strHtml += dayTdHtml;
        if (6 == date.getDay()) { //如果是周六
            strHtml += '</tr>\r';
        }
    } else if (dayCount == date.getDate()) { //如果是月末最后一天
        strHtml += dayTdHtml;
        for (var i = date.getDay(); i < 6; i++) {
            strHtml += '<td>&nbsp;</td>';
        }
        strHtml += '</tr>\r';
    } else {
        if (0 == date.getDay()) { //如果是周一
            strHtml += '<tr>';
        }
        strHtml += dayTdHtml;
        if (6 == date.getDay()) { //如果是周六
            strHtml += '</tr>\r';
        }
    }
    return strHtml;
}
/**
 * 比较两个日期的大小
 * @param date1  date1>=date2返回true
 * @param date2  date2>date1返回false
 * @return
 */
function dateCompare(date1,date2)  {
	if(''==date1||''==date2||undefined==date2) {
		return true;  
	} else {
		var arr=date1.split("-");    
		var starttime=new Date(arr[0],arr[1],arr[2]);    
		var starttimes=starttime.getTime();   
	  
		var arrs=date2.split("-");    
		var lktime=new Date(arrs[0],arrs[1],arrs[2]);    
		var lktimes=lktime.getTime();   
	  
		if(starttimes>=lktimes) {   
			return true;   
		} 
		return false;	
	}
}
/**
 * 根据日期对象返回'yyyy-mm-dd'格式的字符串
 * @param date
 */
function dateWtFormat(date) {
    var strDate = date.getFullYear() + '-';
    	strDate += (date.getMonth() + 1) + '-';
        strDate += date.getDate();
    if (strDate.indexOf('111-04-30') != '-1') {
        alert(date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate());
    }
    return strDate;
}

/**
 * 获取当前日期所在月的总天数
 * @param date
 */
function getWtDaysCount(date) {
    var temp = new Date();
    temp.setTime(date.getTime());
    temp.setMonth(temp.getMonth() + 1);
    temp.setDate(0);
    return temp.getDate();
}
function closeDate() {
	$("#mainPage").show();
	$("#calendarPage").hide();
}
function chooseDate() {
	$("#calendarPage").show();
	$("#mainPage").hide();
}
