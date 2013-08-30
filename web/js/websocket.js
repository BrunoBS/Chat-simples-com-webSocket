/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var wsUri = "ws://" + document.location.host + document.location.pathname + "chatendpoint";
var websocket = new WebSocket(wsUri);
var output = document.getElementById("output");

websocket.onmessage = function(evt) {
    onMessage(evt);
};

websocket.onopen = function(evt) {
    onOpen(evt);
};

websocket.onerror = function(evt) {
    onError(evt);
};

function onError(evt) {
    writeToScreen('<span style="color: red;">Off-line</span>');
}
;

function onOpen(evt) {
    writeToScreen('<span style="color: green;">On-line</span>');
}
;

function onMessage(evt) {
    console.log("recebido: " + evt.data);
    var json = JSON.parse(evt.data);
    document.getElementById("mensagens").value += json.user + " disse:" + json.mensagem + "\n";
}
;

function sendText(json) {
    console.log("enviando texto/json: " + json);
    websocket.send(json);
}
;

function writeToScreen(message) {
    output.innerHTML += message + "<br>";
}
;
nome();