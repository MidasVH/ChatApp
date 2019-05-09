var getFriendRequest = new XMLHttpRequest();
var addFriendButton = document.getElementById("addFriendButton");
addFriendButton.onclick = addFriend;

function addFriend() {
    var friend = document.getElementById("friendNameInput").value;
    if(friend !== ''){
        getFriendRequest.open("post", "Controller?action=addFriend&friend="+encodeURIComponent(friend), true);
        getFriendRequest.setRequestHeader("Content-Type", "application/x-www-from-urlencoded");
        getFriendRequest.send();
    }
}