var current = "";



function showChat(id){
    current = id;
    setInterval(getChat, 500);
    var html = "<div style=\"border:1px solid black\"><h4 id=\"chatid\">" + id + "</h4>" +
        "<ul id=\"chatlist\"></ul>" +
        "<p>" +
        "<input type=\" text\" id=\"message\" >"+
        "<button id=\"send\" onclick=\"sendMessage('" + id + "')\">send</button>" +
        "</p></div>";
    $('#chat').html(html);
}

function sendMessage(id){
    var message = $('#message').val();
    $('#message').val("");
    $.post("Controller", {action: "SendMessage", message: message, userId: id});
}

function getChat(){
    if(current !== ""){
        $.ajax({
            type: "GET",
            url: "Controller?action=getChat&userId=" + current,
            dataType: "json",
            success: function (result) {
                $('#chatlist').empty();
                for(var i = 0; i < result.length; i++){
                    $('#chatlist').append("<li>" + result[i] + "</li>");
                }
            },
            error: function() {
                console.log("error has occured");
            }
        });
    }
}
