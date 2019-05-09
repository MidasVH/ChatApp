var webSocket;

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8081/web_war_exploded/Blog");
    webSocket.onopen = function(event){};

    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };

    webSocket.onclose = function(event){};
}

function post(id){
    var post = {};
    post.commentId = id;
    post.name = document.getElementById("topic-" + id + "-name").value;
    post.post = document.getElementById("topic-" + id + "-post").value;
    post.rating = document.getElementById("topic-" + id + "-rating").value;

    webSocket.send(JSON.stringify(post));
}

function closeSocket(){
    webSocket.close();
}

function writeResponse(text){
    var result = JSON.parse(text);
    for(var i = 0; i < result.length; i++){
        var postUl = document.getElementById("topic-"+result[i].commentId+"-comments");
        var postLi = document.createElement('li');
        var postText = document.createTextNode(result[i].name + ": " + result[i].post + ". " + result[i].rating + "/5");
        postLi.appendChild(postText);
        postUl.appendChild(postLi);
    }
}

openSocket();