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
				会员管理
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
                    <td>会员名</td>
                    <td>加入时间</td>
                    <td>电话号码</td>
                    <td>操作</td>
                </tr>
            <#list  userList as user>
                <tr>
                    <td>${user.username}</td>
                    <td>${user.createTime?string('yyyy年MM月dd日')}</td>
                    <#if user.phoneNum??>
                        <td>${user.phoneNum}</td>
                    </#if>
                    <#if !user.phoneNum??>
                        <td></td>
                    </#if>
                    <#switch user.status>
                        <#case 1>
                            <td><a href="/admin/delete_user?sid=${user.sid}">删除</a></td>
                            <#break>
                        <#default>
                            <td>
                                用户失效，<a href="/admin/reset_user?sid=${user.sid}">恢复</a>？<a href="/admin/deleteUser?sid=${user.sid}">删除</a>
                            </td>
                    </#switch>
                </tr>
            </#list>
            </table>
        </div>
    </div>
</div>
<#include "../_footer.ftl">
</body>
</html>