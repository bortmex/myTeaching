<#include "security.ftlh">
<#import "pager.ftlh" as p>
<@p.pager url page/>
<div id="message-list">
    <#list page.content as message>
        <div class="card my-3" data-id="${message.id?c}">
            <#if message.file??>
                <img id="imageMessage" src="${message.file}" class="card-img-top" style="width: 18rem;"/>
            </#if>
            <div class="m-2">
                <span>${message.text}</span><br/>
                <i style="color:blue">${message.tag}</i>
            </div>
            <div class="card-footer text-right">
                <span class="dateFont">${message.strDateMessage}</span>
                <a href="/user-messages/${message.author.id?c}"> ${message.authorName} </a>
                <a class="col akign-self-center" href="/message/${message.id?c}/like">
                    <#if message.meLiked>
                    <i class="fas fa-heart"></i>
                    <#else>
                    <i class="far fa-heart"></i>
                    </#if>
                    ${message.likes}
                </a>
                <#if message.author.id = currentUserId>
                    <a class="btn btn-primary" href="/user-messages/${message.author.id?c}?message=${message.id?c}">
                        Редактировать </a>
                </#if>
            </div>
        </div>
    <#else >
        Нет сообщений
    </#list>
</div>

<@p.pager url page/>