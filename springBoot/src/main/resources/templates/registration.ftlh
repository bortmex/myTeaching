<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page title="Регистрация нового пользователя ">
<div class="mb-1">Добавить нового юзера</div>
<#if message??><div style="color: red">${message}</div></#if>
    <#--${message?ifExists}-->
<@l.login "/registration" true></@l.login>
</@c.page>