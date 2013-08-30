/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



function nome()
{
    document.getElementById("user").value = prompt("Qual o Seu nome?", "");

}



function enviarMensagem() {
    console.log("enviarMensagem");
    var mensagem = document.inputForm.mensagem;
    var user = document.getElementById("user");
    var json = JSON.stringify({
        "user": user.value,
        "mensagem": mensagem.value
    });

    document.inputForm.mensagem.value = "";
    sendText(json);
    return false;

}
;

