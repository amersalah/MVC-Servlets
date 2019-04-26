<%-- 
    Document   : newSearch
    Created on : Mar 26, 2019, 2:00:18 PM
    Author     : Aly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <jsp:include page="search.html"></jsp:include>

            <table border="1" width="100%">

            <c:forEach items="${requestScope.users}" var="row">
                    <tr>
                        <td><c:out value="${row.name}"/></td>
                        <td><c:out value="${row.email}"/></td>
                    </tr>
                </c:forEach> 

            </table>

    </body>
</html>
