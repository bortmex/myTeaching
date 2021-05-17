<#import "parts/common.ftlh" as c>
<#import "parts/messageEdit.ftlh" as medit>
<#include "parts/security.ftlh">
<@c.page title="Мои сообщения">
    <#if isCurrentUser>
        <@medit.mupdateMssage urlControl="/user-messages/" + currentUserId?c></@medit.mupdateMssage>
    </#if>
    <#include "parts/messageList.ftlh" />
</@c.page>