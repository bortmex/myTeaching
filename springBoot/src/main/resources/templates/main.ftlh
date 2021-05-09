<#import "parts/common.ftlh" as c>
<@c.page title="Чатик ^_^">
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter!}" placeholder="Поиск по тэгу">
                <button type="submit" class="btn btn-primary ml-2">Найти</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Добавить новое сообщение
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form action="/main" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="text" placeholder="Введи сообщение">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="tag" placeholder="Тэг">
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile" >Добавить
                            картинку</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value=${_csrf.token}>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>
    <div>
        <#list messages as message>
            <div class="card my-3">
                <#if message.file??>
                    <img id="imageMessage" src="${message.file}" class="card-img-top" style="width: 18rem;"/>
                </#if>
                <div class="m-2">
                    <span>${message.text}</span>
                    <i style="color:blue">
                        ${message.tag}
                    </i>
                </div>
                <div class="card-footer text-right" style="height: 35px;">
                    <span class="dateFont">${message.strDateMessage}</span>
                    ${message.authorName}
                </div>
            </div>
        <#else >
            Нет сообщений
        </#list>
    </div>
</@c.page>