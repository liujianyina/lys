<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>订单</title>
    <#include "../_header.ftl">
    <link rel="stylesheet" type="text/css" href="../css/buySeatmeal.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
</head>

<body onload="caculatePrice()">
<#include "../_nav.ftl">
<div id="buySeatmeal_content">
    <div id="buySeatmeal_content_show">
        <div>
            <img src="../img/t1.jpg" class="buySeatmeal_content_img"/>
        </div>
        <div id="buySeatmeal_showinfo">
            <p style="margin: 20px;">餐名：${setmeal.cname}</p>
            <p style="margin: 20px;">单价：<span id="price">${setmeal.price}</span>元</p>
            <form style="margin: 20px;" action="/system/buy" method="post">
                <input type="hidden" value="${setmeal.sid}" name="sid">
                数量：
                <select id="buySeatmeal_content_select" onchange="caculatePrice()" name="count">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <input type="submit" value="确认下单" id="buySeatmeal_content_submit"/>
            </form>
            <p style="margin: 20px;">金额：<span id="money"></span>元</p>
        </div>
    </div>
</div>
<#include "../_footer.ftl">
<script type="text/x-javascript">
	function caculatePrice() {
		var price = parseFloat(document.getElementById('price').innerText);
		var count = parseInt(document.getElementById('buySeatmeal_content_select').value);
		document.getElementById('money').innerText = price * count;
	}
</script>
</body>
</html>