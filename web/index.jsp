<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <c:choose>
        <c:when test="${user!=null}">
            <p>Welcome ${user.getFirstName()}!</p>
            <form method="post" action="Controller?action=LogOut">
                <p>
                    <input type="submit" id="logoutbutton" value="Log Out">
                </p>
            </form>
        </c:when>
        <c:otherwise>
            <form method="post" action="Controller?action=LogIn">
                <p>
                    <label for="email">Your email </label>
                    <input type="text" id="email" name="email" value="jan@ucll.be">
                </p>
                <p>
                    <label for="password">Your password</label>
                    <input type="password" id="password" name="password" value="t">
                </p>
                <p>
                    <input type="submit" id="loginbutton" value="Log in">
                </p>
            </form>
        </c:otherwise>
    </c:choose>
    <div style="height: 100px"></div>

    <div class="topic-1">
        <h3>Hoe was de projectweek?</h3>
        <ul id="topic-1-comments">
        </ul>
        <input id="topic-1-name" type="text" placeholder="Name" style="width: 100px">
        <input id="topic-1-post" type="text" placeholder="Text">
        <input id="topic-1-rating" type="number" placeholder="Rating" style="width: 50px;">
        <input type="button" id="topic-1-button" onclick="post(1)" value="Post">
    </div>
    <div class="topic-2">
        <h3>Wat ben je van plan te doen vandaag?</h3>
        <ul id="topic-2-comments">

        </ul>
        <input id="topic-2-name" type="text" placeholder="Name" style="width: 100px">
        <input id="topic-2-post" type="text" placeholder="Text">
        <input id="topic-2-rating" type="number" placeholder="Rating" style="width: 50px;">
        <input type="button" id="topic-2-button" onclick="post(2)" value="Post">
    </div>
    <div class="topic-3">
        <h3>Hoe was de projectweek?</h3>
        <ul id="topic-3-comments">
        </ul>
        <input id="topic-3-name" type="text" placeholder="Name" style="width: 100px">
        <input id="topic-3-post" type="text" placeholder="Text">
        <input id="topic-3-rating" type="number" placeholder="Rating" style="width: 50px;">
        <input type="button" id="topic-3-button" onclick="post(3)" value="Post">
    </div>
    <div class="topic-4">
        <h3>Hoe was de projectweek?</h3>
        <ul id="topic-4-comments">
        </ul>
        <input id="topic-4-name" type="text" placeholder="Name" style="width: 100px">
        <input id="topic-4-post" type="text" placeholder="Text">
        <input id="topic-4-rating" type="number" placeholder="Rating" style="width: 50px;">
        <input type="button" id="topic-4-button" onclick="post(4)" value="Post">
    </div>
    <div class="topic-5">
        <h3>Hoe was de projectweek?</h3>
        <ul id="topic-5-comments">
        </ul>
        <input id="topic-5-name" type="text" placeholder="Name" style="width: 100px">
        <input id="topic-5-post" type="text" placeholder="Text">
        <input id="topic-5-rating" type="number" placeholder="Rating" style="width: 50px;">
        <input type="button" id="topic-5-button" onclick="post(5)" value="Post">
    </div>
</main>
<script src="js/comment.js" type="text/javascript"></script>
<div style="height: 100px"></div>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>