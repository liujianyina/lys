<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
<#include "../_header.ftl">
</head>
<body>
<#include "../_nav.ftl">
<div id="personal_index_content">
<#include "../_person_index.ftl">
    <div id="personal_index_content_right">
        <div id="personal_index_content_right_title_div">
            <span id="personal_index_content_right_title">
                个人中心
            </span>
        </div>
        <div>
            <span id="marquee_title">今日菜式</span>
            <marquee direction="right" onmouseover=(this.stop()) onmouseout=(this.start()) behavior="alternate">
                <img src="../img/jardiniere1.jpg" class="marquee_img"/>
                <img src="../img/jardiniere2.jpg" class="marquee_img"/>
                <img src="../img/jardiniere3.jpg" class="marquee_img"/>
                <img src="../img/jardiniere4.jpg" class="marquee_img"/>
                <img src="../img/jardiniere5.jpg" class="marquee_img"/>
                <img src="../img/jardiniere6.jpg" class="marquee_img"/>
            </marquee>
        </div>
    </div>
</div>
<#include "../_footer.ftl">
</body>
</html>