<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page title="Регистрация нового пользователя ">
<div>Добавить нового юзера</div>
<#if message??><div style="color: red">${message}</div></#if>
<@l.login "/registration" "Добавить"></@l.login>
</@c.page>