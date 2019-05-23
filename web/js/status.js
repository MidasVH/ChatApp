var statusButton = document.getElementById("statusButton");
statusButton.onclick = changeStatus;

var getStatusRequest = new XMLHttpRequest();
var newStatusRequest = new XMLHttpRequest();

function changeStatus(){
    var statusText = document.getElementById("statusInput").value;
    var information = "status=" + encodeURIComponent(statusText);

    newStatusRequest.open("POST", "Controller?action=ChangeStatus&" + information, true);
    newStatusRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    newStatusRequest.send();
    document.getElementById("status").innerText = statusText;
}

function getNewStatus() {
    getStatusRequest.open("GET","Controller?action=getStatus", true);
    getStatusRequest.onreadystatechange = getData;
    getStatusRequest.send(null);
}

function getData() {
    if(getStatusRequest.status == 200){
        if(getStatusRequest.readyState == 4){
            console.log(getStatusRequest.responseText);
            var statusResponse = JSON.parse(getStatusRequest.responseText);
            var status = statusResponse.status;
            document.getElementById("status").innerText = status ;
        }
    }
    setTimeout(getNewStatus, 2000);
}