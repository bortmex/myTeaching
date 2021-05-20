<#import "parts/common.ftlh" as c>
<#import "parts/messageEdit.ftlh" as medit>
<@c.page title="Чатик ^_^">
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter!}" placeholder="Поиск по тэгу"/>
                <button type="submit" class="btn btn-primary ml-2">Найти</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Добавить сообщение
    </a>
    <@medit.mupdateMssage urlControl="/main"></@medit.mupdateMssage>
    <#include "parts/messageList.ftlh" />
</@c.page>