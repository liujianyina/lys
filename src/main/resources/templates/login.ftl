<!DOCTYPE html>
<html>
<head>
<#include "_header.ftl">
    <meta charset="UTF-8">
    <title>用户登录</title>
<body>
<#include  "_nav.ftl">
<div id="login_register_content">
    <div id="login_body">
        <form method="post" action="/login">
            <p id="login_title">用户登录</p>
            <div class="login_component">
                <label class="hint">用户名：</label>
                <p style="display: inline-block;"><input value="admin" type="text" class="login_input" name="username"/></p>
            </div>
            <div class="login_component">
                <label class="hint">密　码：</label>
                <p style="display: inline-block;"><input value="admin" type="password" class="login_input" name="password"/></p>
            </div>
            <div class="login_component" style="margin-top: 20px;">
                <label class="hint">验证码：</label>
                <input type="text" class="login_input" style="width: 115px;" name="code"/>
                <img src="/captcha" style="cursor: pointer;vertical-align: middle;height: 40px;width: 110px;margin-left: 10px;"
                     onclick="this.src='/captcha?' + Math.random();"
                />
            </div>
            <button type="submit" id="login_button"></button>
            <div class="login_component">
                <p>
                <#import "/spring.ftl" as spring />
                <#if ERROR_MESSAGE??>
                    <span id="error_messsage">
                        <@spring.messageText ERROR_MESSAGE, ERROR_MESSAGE />
                    </span>
                </#if>
                </p>
            </div>
        </form>
    </div>
</div>
<#include  "_footer.ftl">
<script type="text/javascript">


    window.onload = function () {

        var content_os = document.getElementById('login_register_content').style;

        function BgChenge() {
            content_os.backgroundImage = 'url(img/bg' + (parseInt(Math.random() * 3) + 1) + '.jpg)';
        };

        function clear() {

            var elem = document.getElementById('error_messsage');

            if (elem) {
                elem.style.display = "none";
            }


        };

        setInterval(BgChenge, 3000);
        setInterval(clear, 2000);
    };
</script>
</body>
</html>