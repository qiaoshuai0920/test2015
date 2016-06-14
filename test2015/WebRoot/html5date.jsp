<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>aa</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js"></script>
 	<script src="${pageContext.request.contextPath}/js/wt_date.js"></script>
  </head>
  <body>
  	<div id='mainPage'>
  	<div class="mp-main">
  					<div class="mp-row-value" onclick="chooseDate();">
  						<span id="playDateStr">请选择日期</span>
  						<em class="icon-right"></em>
  						<input type='hidden' name="playDate" id='playDate'/>
  					</div>
  				
  	</div>
  	</div>
  	<div class="calendarPage" id="calendarPage">
  		<header>
	  		<a class="return" onclick="closeDate();">close</a>
			<h2>选择日期</h2>
	  	</header>
  		<div class="event_calendar_combo">
			<div style="position: relative; _z-index: -1;">
				<div class="wt_date_hidden">
					<div class="wt_date_list" id="wt_date_list">
						<script>wtDays1(0,'${startDate}','${endDate}');</script>
					</div>
				</div>
			</div>
			<div style="position: relative; _z-index: -1;">
				<div class="wt_date_hidden">
					<div class="wt_date_list" id="wt_date_list">
						<script>wtDays1(1,'${startDate}','${endDate}');</script>
					</div>
				</div>
			</div>
			<div style="position: relative; _z-index: -1;">
				<div class="wt_date_hidden">
					<div class="wt_date_list" id="wt_date_list">
						<script>wtDays1(2,'${startDate}','${endDate}');</script>
					</div>
				</div>
			</div>
		</div>
  	</div>
  </body>
</html>