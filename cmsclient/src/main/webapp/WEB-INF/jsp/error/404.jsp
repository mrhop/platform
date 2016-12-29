<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html id="page-404">
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${messages["404.error"]}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/vendor.css" />
    <script type="text/javascript">
        var commonProperties = ${messagesStr}
    </script>
    <script src="${pageContext.request.contextPath}/js/vendor.js"></script>
    <script src="${pageContext.request.contextPath}/js/tools.js"></script>
    <script src="${pageContext.request.contextPath}/js/common-components.js"></script>
</head>
<body>

<div class="page-not-found-modal">
</div>
<script src="${pageContext.request.contextPath}/js/modules/404.js"></script>
</body>
</html>