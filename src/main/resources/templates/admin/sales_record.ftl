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
				销售记录
			</span>
            <hr/>
        </div>
        <div style="margin-top:20px;float: left;text-align: left;width: 100%;">
            第1页共1页
            <div style="float: right;">
                <button>上一页</button>
                <button>下一页</button>
            </div>
        </div>
        <div style="width: 100%;height: 35px;"></div>
        <div id="admin_index_content_table">
            <table>
                <tr id="table_title">
                    <td>商品</td>
                    <td>时间</td>
                    <td>金额</td>
                    <td>操作</td>
                </tr>
            <#list  orders as order>
                <tr>
                    <td>${order.cname}</td>
                    <td>${order.createTime?string('yyyy年MM月dd日')}</td>
                    <td>${order.price}</td>
                    <td>
                        <a href="/admin/delete_order_admin?sid=${order.sid}">删除</a>
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