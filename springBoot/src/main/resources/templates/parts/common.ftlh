<#macro page title>
<!DOCTYPE html>
<html lang="en">
<style>
    @font-face {
        font-family: SlimamifMedium;
        src: url("font/20451.ttf");
    }
    .dateFont {
        font-family: SlimamifMedium, 'Comic Sans MS', cursive;
    }
</style>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>${title}</title>
</head>
<body>
    <#nested>
</body>
</html>
</#macro>