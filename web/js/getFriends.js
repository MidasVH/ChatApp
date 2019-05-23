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
                html = html + "<tr><td id=" + serverResponse[i].userId + ">" + serverResponse[i].userId + "</td><td>" + serverResponse[i].status + "</td></tr>";
            }
            document.getElementById("friendsList").innerHTML = html;
            setTimeout(getFriends, 2000);
        }
    }
}

document.getElementById("friendsList").addEventListener("click", function(e){
    if(e.target.nodeName == "TD" && e.target){
        console.log(e.target.id);
        if(e.target.id !== "") {
            showChat(e.target.id);
        }
    }
});