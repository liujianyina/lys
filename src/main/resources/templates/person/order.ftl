<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
<#include "../_header.ftl">
</head>
<body>
<#include "../_nav.ftl">
<div id="personal_index_content">
<#include "../_person_index.ftl">
    <div id="personal_index_content_right">
        <div id="personal_index_content_right_title_div">
            <span id="personal_index_content_right_title">
				我的订单
			</span>
            <hr/>
        </div>
        <div id="personal_index_content_right_content_div" style="margin-top: 15px;">
            <div style="margin-top:10px;margin-bottom:10px;float: left;text-align: left;width: 100%;">
                第1页共1页
                <div style="float: right;">
                    <button>上一页</button>
                    <button>下一页</button>
                </div>
            </div>
            <table id="show_info_table">
                <tr>
                    <td>日期</td>
                    <td>商品</td>
                    <td>花费</td>
                    <td>操作</td>
                </tr>

            <#list orderList as order>
                <tr>
                    <td>${order.createTime?string('yyyy年MM月dd日HH:mm:ss')}</td>
                    <td>${order.cname}</td>
                    <td>${order.price}</td>
                    <td>
                        <a href="/order/delete_user?sid=${order.sid}">删除</a>
                    </td>
                </tr>
            </#list>
            </table>
        </div>
    </div>
</div>
<#include "../_footer.ftl">
</body>
</html>