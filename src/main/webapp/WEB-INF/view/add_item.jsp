<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="evan.jobprojects.util.AttributeNames" %>

<html>
<head>
    <title>Add Items</title>
</head>
    <body>
        <div align="center">
            <form:form method="POST" modelAttribute=${AttributeNames.TODO_ITEM}>


            </form:form>

        </div>
    </body>
</html>