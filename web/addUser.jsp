<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minim
  Date: 20/02/2019
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Add User"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Add User" />
</jsp:include>
<main>
    <c:if test="${errors.size() > 0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form method="post" action="/web_war_exploded/Controller?action=AddUser">
        <p>
            <label for="email">Email</label>
            <input type="text" name="email" id="email" required>
        </p>
        <p>
            <label for="firstname">Firstname</label>
            <input type="text" name="firstname" id="firstname" required>
        </p>
        <p>
            <label for="lastname">Lastname</label>
            <input type="text" name="lastname" id="lastname" required>
        </p>
        <p>
            <label for="gender">Gender</label>
            <select name="gender" id="gender" required>
                <option>Male</option>
                <option>Female</option>
            </select>
        </p>
        <p>
            <label for="birthday">Birthday</label>
            <input type="date" name="birthday" id="birthday">
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" required>
        </p>
        <p>
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" name="confirmPassword" id="confirmPassword" required>
        </p>
        <p>
            <input type="submit" value="submit">
        </p>
    </form>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>

</body>
</html>
