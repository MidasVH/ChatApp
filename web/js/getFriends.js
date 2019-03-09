var getFriendRequest = new XMLHttpRequest();

function getFriends(){
    getFriendRequest.open("GET", "Controller?action=getFriends", true);
    getFriendRequest.onreadystatechange = showData;
    getFriendRequest.send();
}

function showData(){
    if(getFriendRequest.status === 200){
        if(getFriendRequest.readyState === 4){
            var serverResponse = JSON.parse(getFriendRequest.responseText);
            var html = "";
            for(var i = 0; i < serverResponse.length; i++){
                html = html + "<tr><td>" + serverResponse[i].userId + "</td><td>" + serverResponse[i].status + "</td></tr>";
            }
            document.getElementById("friendsList").innerHTML = html;
            setTimeout(getFriends, 2000);
        }
    }
}