<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page title="Мессенджер">
    ${message!}
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message??>
    <div class="alert alert-danger" role="alert">
        ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
    </div>
    </#if>
    <@l.login "/login" false/>
</@c.page>