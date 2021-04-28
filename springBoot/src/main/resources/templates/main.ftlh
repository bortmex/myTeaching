<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page title="Чатик ^_^">
<div>
    <@l.logout/>
    <span><a href="/user">Список пользователей</a> </span>
</div>
<div>
    <form action="/main" method="post">
        <input type="text" name="text" placeholder="Введи месседж">
        <input type="text" name="tag" placeholder="Тэг">
        <input type="hidden" name="_csrf" value=${_csrf.token}>
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список сообщений</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter!""}">
    <button type="submit">Найти</button>
</form>
<#list messages as message>
<div>
    <span class="dateFont">${message.strDateMessage}</span>
    <strong> ${message.authorName}: </strong>
    <!--<b>${message.id}</b>-->
    <span>${message.text}</span>
    <i style="color:blue">
        ${message.tag}
    </i>
</div>
    <#else >
    Нет сообщений
</#list>
</@c.page>