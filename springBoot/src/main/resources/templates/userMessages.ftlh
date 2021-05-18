<#import "parts/common.ftlh" as c>
<#import "parts/messageEdit.ftlh" as medit>
<#include "parts/security.ftlh">
<@c.page title="Мои сообщения">
    <h3>${userChannel.username}</h3>
    <#if !isCurrentUser>
        <#if isSubscriber>
            <a class="btn btn-info" href="/user/unsubscribe/${userChannel.id?c}">Отписаться</a>
        <#else>
            <a class="btn btn-info" href="/user/subscribe/${userChannel.id?c}">Подписаться</a>
        </#if>
    <#else>
        <div class="container my-3">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title">Подписки</div>
                            <div class="card-text">
                                <a href="/user/subscriptions/${userChannel.id?c}/list">${subscriptionsCount}</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title">Подписчики</div>
                            <div class="card-text">
                                <a href="/user/subscribers/${userChannel.id?c}/list">${subscribersCount}</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#if>
    <#if isCurrentUser>
        <@medit.mupdateMssage urlControl="/user-messages/" + currentUserId?c></@medit.mupdateMssage>
    </#if>
    <#include "parts/messageList.ftlh" />
</@c.page>