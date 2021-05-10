<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пользователь : </label>
            <div class="col-sm-6">
                <input class="form-control ${(usernameError??)?string('is-invalid','')}" type="text" name="username"
                       value="<#if user??>${user.username}</#if>" placeholder="Введите имя"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль: </label>
            <div class="col-sm-6">
                <input class="form-control ${(passwordError??)?string('is-invalid','')}" type="password" name="password"
                       placeholder="Введите пароль"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Пароль: </label>
                <div class="col-sm-6">
                    <input class="form-control ${(passwordError??)?string('is-invalid','')}" type="password"
                           name="password2" placeholder="Повторите пароль"/>
                    <#if passwordError??>
                        <div class="invalid-feedback">
                            ${passwordError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Email: </label>
                <div class="col-sm-6">
                    <input class="form-control ${(emailError??)?string('is-invalid','')}" type="email" name="email"
                           value="<#if user??>${user.email}</#if>" placeholder="символы@ебмейл.префикс"/>
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <#if !isRegisterForm>
            <a href="/registration">Регистрация</a>
        </#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm >Создать<#else>Войти</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary" type="submit">Выход</button>
    </form>
</#macro>