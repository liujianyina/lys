<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
<#include "../_header.ftl">
</head>
<body>
<#include "../_nav.ftl">
<div id="personal_index_content">
<#include "../_person_index.ftl">
    <div id="personal_index_content_right">
        <div id="personal_index_content_right_title_div">
            <span id="personal_index_content_right_title">
                尊敬的会员，欢迎您
            </span>
            <hr/>
        </div>
        <div id="personal_index_content_right_content_div">
            <form action="/person/update_user_info" method="post">
                <p>用户名：<input type="text" name="username" value="${user.username}" class="show_info_input"/></p>
                <p>密　码：<input type="password" name="password" placeholder="输入新密码" class="show_info_input"/></p>
                <p>电　话：<input type="text" name="phoneNum" value="${user.phoneNum}" class="show_info_input"/></p>
                <p>余　额：<input type="text" name="balance" value="${user.balance?string('0.00')}"
                              class="show_info_input"/></p>
                <p>
                    <input type="submit" value="保存" class="show_info_submit"/>
                </p>
            </form>
        </div>
    </div>
</div>
<#include "../_footer.ftl">
</body>
</html>