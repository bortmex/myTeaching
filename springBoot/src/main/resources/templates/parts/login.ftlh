<#macro login path button>
    <form action="${path}" method="post">
        <div><label> Пользователь : <input type="text" name="username"/> </label></div>
        <div><label> Пароль: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" value="${button}"/></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="submit" value="Выйти"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</#macro>