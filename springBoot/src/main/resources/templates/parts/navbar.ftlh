<#include "security.ftlh">
<#import "login.ftlh" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Чатик ^_^</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="https://github.com/bortmex/myTeaching/tree/master/springBoot">Код проекта</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
            </li>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/main">Чатик</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user-messages/${currentUserId?c}">Мои сообщения</a>
            </li>
            </#if>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">Список пользователей</a>
            </li>
            </#if>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">Профиль</a>
            </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3"> <#if user??>${name}<#else>Залогинься</#if> </div>
        <@l.logout/>
    </div>
</nav>