/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function processar1() {
    document.getElementById("option2").selected="true";
    document.getElementById("selectDoPeriodo2").disabled="true";
    document.getElementById("selectDoPeriodo1").disabled="false";
}

function processar2() {
    document.getElementById("selectDoPeriodo2").disabled="false";
    document.getElementById("option1").selected="true";
    document.getElementById("selectDoPeriodo1").disabled="true";
}
