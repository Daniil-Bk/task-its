<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Second Page</title>
</head>
<body>
${example1JSP.type}
<br/>
Введенное a1: ${example1JSP.a1};
<br/>
Введенный a2: ${example1JSP.a2};
<br/>
Результат ${example1JSP.result}
<br/>
<spring:form method="get"  modelAttribute="example1JSP" action="saveExample1">
    <spring:button>Скачать</spring:button>
</spring:form>
</body>
</html>