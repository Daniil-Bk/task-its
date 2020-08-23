<!-- обратите внимание на spring тэги -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Index Page</title>
</head>
<body>
<script type="text/javascript">

function showElem(contId, id, tag) {
var container = document.getElementById(contId);
var elems = container.getElementsByTagName(tag);
for (var i = 0; i < elems.length; i++) {
elems[i].style.display = 'none';
}
document.getElementById(id).style.display = 'block';
}

function isInteger(num) {
    return (num ^ 0) === num;
}

</script>

<select name="count" onchange="showElem('container', this.options[this.selectedIndex].value, 'div')">
    <option value="ex"> </option>
    <option value="ex1">examle 1</option>
    <option value="ex2">examle 2</option>
</select>
<div id="container">
<div id="ex1" style="display: none">
    <spring:form method="post"  modelAttribute="example1JSP" action="check1">

        a1 <spring:input path="a1"/>   <br/>
        a2 <spring:input path="a2"/>   <br/>

        <spring:button>Посчитать</spring:button>

    </spring:form>
    <spring:form method="POST" enctype="multipart/form-data" action="/uploadExample1">
        File to upload: <input type="file" name="file"><br /> <br /> <input type="submit"
                                                         value="Upload"> Press here to upload the file!
    </spring:form>
</div>

<div id="ex2" style="display: none">
    <spring:form method="post"  modelAttribute="example2JSP" action="check2">
        number <spring:input id="inputex2" path="number"/>   <br/>
        <spring:button  onClick="if(!isInteger(+document.getElementById('inputex2').value))
        {alert('Incorrect input');return false}
        else{return true;}">
            Посчитать
        </spring:button>
    </spring:form>
    <spring:form method="POST" enctype="multipart/form-data" action="/uploadExample2">
        File to upload: <input type="file" name="file"><br /> <br /> <input type="submit"
                                                                            value="Upload"> Press here to upload the file!
    </spring:form>
</div>
</div>
</body>
</html>