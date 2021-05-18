<#import "parts/common.ftlh" as c>
<@c.page title="Мои сообщения">
    <h3>${userChannel.username}</h3>
    <div><#if haveUsers><#if type = "subscriptions">Мои подписки<#else>Подписчики</#if></#if></div>
    <ul class="list-group">
        <#list users as user>
        <li class="list-group-item">
            <a href="/user-messages/${user.id?c}">${user.getUsername()}</a>
        </li>
        </#list>
    </ul>
    <#if !haveUsers>
        <#if type = "subscriptions">
            <div> У вас не подписок</div>
        <#else>
            <div> У вас не подписчиков</div>
        </#if>
    </#if>
</@c.page>