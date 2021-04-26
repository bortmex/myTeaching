<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page title="Мессенджер">
    <a href="https://github.com/bortmex/myTeaching/tree/master/springBoot">Код проекта</a>
    <@l.login "/login" "Войти"/>
    <a href="/registration">Регистрация</a>
</@c.page>