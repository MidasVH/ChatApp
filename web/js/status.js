var statusButton = document.getElementById("statusButton");
statusButton.onclick = changeStatus;
var getStatusRequest = new XMLHttpRequest();
var newStatusRequest = new XMLHttpRequest();

function changeStatus(){
    var statusText = document.getElementById("statusInput").value;
    var information = "status=" + encodeURIComponent(statusText);

    newStatusRequest.open("POST", "Controller?action=ChangeStatus", true);
    newStatusRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    newStatusRequest.send(information);
}

function getNewStatus() {
    getStatusRequest.open("GET","Controller?action=getStatus", true);
    getStatusRequest.onreadystatechange = getData;
    getStatusRequest.send();
}

function getData() {
    if(getStatusRequest.readyState == 4){
        if(getStatusRequest.status == 200){
            var serverResponse = JSON.parse(getStatusRequest.responseText);
            console.log(serverResponse);
            var statusXML = serverResponse.status;

            var statusDiv = document.getElementById("statusDiv");
            var statusParagraph = statusDiv.childNodes[0];

            if(statusParagraph == null){
                statusParagraph.id = "statusText";
                var statusText = document.createTextNode(statusXML);
                statusParagraph.appendChild(statusText);
                statusDiv.appendChild(statusParagraph);
            }else{
                var statusText = document.createTextNode(statusXML);
                statusParagraph.removeChild(statusDiv.childNodes[0]);
                statusParagraph.appendChild(statusText);
            }
            setTimeout("getNewStatus()",1000);
        }
    }
}