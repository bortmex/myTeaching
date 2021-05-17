<#macro mupdateMssage urlControl>
    <div class="collapse <#if message??>show</#if>" id="collapseExample">
        <div class="form-group mt-3">
            <form action="${urlControl}" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <#if message??>
                        <span class="dateFont">${message.strDateMessage}</span>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid','')}"
                           value="<#if message??>${message.text}</#if>" name="text" placeholder="Введи сообщение">
                    <#if textError??>
                        <div class="invalid-feedback">
                            ${textError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control ${(tagError??)?string('is-invalid','')}"
                           name="tag" value="<#if message??>${message.tag}</#if>" placeholder="Тэг">
                    <#if tagError??>
                        <div class="invalid-feedback">
                            ${tagError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Добавить
                            картинку</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value=${_csrf.token}>
                <input type="hidden" name="id" value=<#if message??>${message.id?c}</#if>>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить сообщение</button>
                </div>
            </form>
        </div>
    </div>
</#macro>