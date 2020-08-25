<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Second Page</title>
</head>
<body>
${example2JSP.type}
<br/>
Введенное number: ${example2JSP.number};
<br/>
Результат ${example2JSP.result}
<br/>
<spring:form method="get"  modelAttribute="example2JSP" action="saveExample2">
       <spring:button>Скачать</spring:button>
</spring:form>
</body>
</html>