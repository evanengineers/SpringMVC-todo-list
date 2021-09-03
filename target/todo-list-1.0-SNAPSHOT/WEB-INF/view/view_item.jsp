<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="evan.jobprojects.util.Mappings" %>

<html>
<head>
    <title>View Item</title>
</head>

    <body>
        <div align="center">

        <table>
          <tr>
             <td><label>ID</label></td>
             <td>
                  <td><c:out value="${todoItem.id}"/></td>
             </td>
          </tr>
          <tr>
             <td><label>Title</label></td>
                    <td><c:out value="${todoItem.title}"/></td>
           </tr>
           <tr>
            <td><label>Deadline</label></td>
                    <td><c:out value="${todoItem.deadline}"/></td>
           </tr>
           <tr>
             <td><label>Details</label></td>
                    <td><c:out value="${todoItem.details}"/></td>
           </tr>
         </table>

         <c:url var="tableUrl" value="${Mappings.ITEMS}"/>
         <a href="${tableUrl}">Back to Full List</a>

        </div>
    </body>
</html>