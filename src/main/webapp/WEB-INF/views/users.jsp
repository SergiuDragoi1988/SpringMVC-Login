
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>
       <p> Hello </p>
       <p>
            <c:forEach var="u" items="${users}">
                <li><c:out value="${u.name}"/></li>
            </c:forEach>
        </p>

    </body>
</html>