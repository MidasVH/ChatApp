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
        <jsp:param name="title" value="Chat"/>
    </jsp:include>
    <body onload="getNewStatus();">
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="Chat" />
        </jsp:include>
        <main>
            <div id="statusDiv">
                <p style="float: right" id="status"></p>
            </div>
            <div>
                <h3>Friends</h3>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Status</th>
                    </tr>
                    <tr>
                        <td>bib</td>
                        <td>statusbib</td>
                    </tr>
                    <tr>
                        <td>an</td>
                        <td>statusAn</td>
                    </tr>
                </table>

            </div>
            <p>Change status</p>
            <input type="text" name="statusInput" id="statusInput"/>
            <input type="button" id="statusButton" name="statusButton" value="Change Status"/>
            <script src="js/status.js" type="text/javascript"></script>

            <p>Add Friend</p>
            <input type="text" name="friendNameInput" id="friendNameInput"/>
            <input type="button" name="addFriendButton" id="addFriendButton" value="Add Friend"/>
            <script src="js/addFriend.js" type="text/javascript"></script>
        </main>
        <jsp:include page="footer.jsp">
            <jsp:param name="title" value="Chat"/>
        </jsp:include>

    </body>
</html>
