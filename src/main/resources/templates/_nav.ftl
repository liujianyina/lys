<header>
    <div id="logo">
        <span id="logo_span"></span><img src="/img/logo.png" id="logo_img"/>
    </div>
    <div id="nav">
        <div id="nav_ul">
            <span id="logo_span"></span>
            <ul id="nav_ul">
            <#if !USERNAME??>
                <li id="register_li">
                    <a href="/register">
                        注册
                    </a>
                </li>
                <li id="login_li">
                    <a href="/login">
                        登录
                    </a>
                </li>
            </#if>

                <li>
                    <a href="/index">主页</a>
                </li>

                <li>
                    <a href="#">文化</a>
                </li>
                <li>
                    <a href="#">联系</a>
                </li>
            <#if USERNAME??>
                <li id="user_name_li" onclick="show(this)">
                    <a style="cursor: pointer;">
                    ${USERNAME}
                    </a>
                </li>
                <div id="show_info_div">
                    <div>
                        <a href="/person/index"><img src="/img/user.jpg" id="user_img"/></a>
                    </div>
                    <ul id="show_info_ul">
                        <li><a href="/person/index">个人中心</a></li>
                        <li><a href="/person/order">我的订单</a></li>
                        <li><a href="/loginOut">安全退出</a></li>
                    </ul>
                </div>
            </#if>
            </ul>
        </div>
    </div>
    <script type="text/javascript">
        function show(elem) {
            var x = elem.offsetLeft;
            var y = elem.offsetTop;
            var show_info_div = document.getElementById('show_info_div');
            show_info_div.style.left = (x - 30) + "px";
            show_info_div.style.top = (y + 30) + "px";
            if (show_info_div.style.display == 'block') {
                show_info_div.style.display = "none";
            } else {
                show_info_div.style.display = "block";
            }
        }
    </script>
</header>
