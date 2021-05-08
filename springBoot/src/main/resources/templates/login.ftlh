<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page title="Мессенджер">
    ${message!}
    <@l.login "/login" false/>
</@c.page>