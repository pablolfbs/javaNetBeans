/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var xmlHttpRequest = new XMLHttpRequest();

xmlHttpRequest.onreadystatechange = function () {
    if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
        // alert(xmlHttpRequest.responseText);
        obj = JSON.parse(xmlHttpRequest.responseText);
        document.getElementById("campoNome2").value = obj.nome;
        document.getElementById("campoIdade2").value = obj.idade;
    }
}

function enviar() {
    xmlHttpRequest.open("GET", "http://localhost:8080/JSON/Servlet1", true);
    xmlHttpRequest.send();
}


