<#import "parts/common.ftlh" as c>
<@c.page title="Список пользователей">
Список пользователей

    <table>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Роль</th>
            <th>Активация аккаунта по email</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.username!"null or missing"}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list> </td>
            <td>
                <#if user.activationCode?? && user.activationCode="null">
                    Активирован
                <#else>
                    Не активирован
                </#if>
            </td>

            <td><a href="/user/${user.id?c}"> Редактировать</a></td>
        </tr>
    </#list>
        </tbody>
    </table>
</@c.page>