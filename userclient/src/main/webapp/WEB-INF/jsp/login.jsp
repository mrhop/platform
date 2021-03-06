<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html id="auth">
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${messages["platform.name"]}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/vendor.css"/>
    <script type="text/javascript">
        var commonProperties = ${messagesStr}
    </script>
    <script src="${pageContext.request.contextPath}/js/vendor.js"></script>
    <script src="${pageContext.request.contextPath}/js/tools.js"></script>
    <script src="${pageContext.request.contextPath}/js/common-components.js"></script>
</head>
<body>
<main class="auth-main">
</main>
<script src="${pageContext.request.contextPath}/js/modules/login.js"></script>
</body>
</html>