<!DOCTYPE html>
<html>
<head>
<#include "../_header.ftl">
    <title>会员管理</title>
</head>
<body>
<#include "../_nav.ftl">
<div id="admin_index_content">
<#include "_nav.ftl">
    <div id="admin_index_content_right">
        <div id="admin_index_content_right_title_div">
            <span id="admin_index_content_right_title">
				商品上架
			</span>
            <hr/>
        </div>
        <div style="width: 100%;height: 35px;"></div>
        <div id="admin_index_content_table">
            <form action="/admin/add_new_commodity" method="post">
                <p>商品名：<input type="text" name="cname" class="add_new_input"/></p>
                <p>单　价：<input type="text" name="price" class="add_new_input"/></p>
                <p>数　量：<input type="text" name="count" class="add_new_input"/></p>
                <div style="margin-left: 30px;">
                    图　片：<input type="file" name="file"/>
                </div>
                <input type="submit" value="提交" class="add_new_submit"/>
            </form>
        </div>
    </div>
</div>
<#include "../_footer.ftl">
</body>
</html>