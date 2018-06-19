//function processar1(){
//    document.getElementById("selectDoPeriodo1").disabled = false;
//    document.getElementById("option2").selected = true;
//    document.getElementById("option3").selected = true;
//    document.getElementById("option4").selected = true;
//    document.getElementById("option5").selected = true;
//    document.getElementById("selectDoPeriodo2").disabled = true;
//    document.getElementById("selectDoPeriodo3").disabled = true;
//    document.getElementById("selectDoPeriodo4").disabled = true;
//    document.getElementById("selectDoPeriodo5").disabled = true;
//}
//
//function processar2(){
//    document.getElementById("selectDoPeriodo2").disabled = false;
//    document.getElementById("option1").selected = true;
//    document.getElementById("option3").selected = true;
//    document.getElementById("option4").selected = true;
//    document.getElementById("option5").selected = true;
//    document.getElementById("selectDoPeriodo1").disabled = true;
//    document.getElementById("selectDoPeriodo3").disabled = true;
//    document.getElementById("selectDoPeriodo4").disabled = true;
//    document.getElementById("selectDoPeriodo5").disabled = true;
//}
//
//function processar3(){
//    document.getElementById("selectDoPeriodo3").disabled = false;
//    document.getElementById("option1").selected = true;
//    document.getElementById("option2").selected = true;
//    document.getElementById("option4").selected = true;
//    document.getElementById("option5").selected = true;
//    document.getElementById("selectDoPeriodo1").disabled = true;
//    document.getElementById("selectDoPeriodo2").disabled = true;
//    document.getElementById("selectDoPeriodo4").disabled = true;
//    document.getElementById("selectDoPeriodo5").disabled = true;
//}
//
//function processar4(){
//    document.getElementById("selectDoPeriodo4").disabled = false;
//    document.getElementById("option1").selected = true;
//    document.getElementById("option2").selected = true;
//    document.getElementById("option3").selected = true;
//    document.getElementById("option5").selected = true;
//    document.getElementById("selectDoPeriodo1").disabled = true;
//    document.getElementById("selectDoPeriodo2").disabled = true;
//    document.getElementById("selectDoPeriodo3").disabled = true;
//    document.getElementById("selectDoPeriodo5").disabled = true;
//}
//
//function processar5(){
//    document.getElementById("selectDoPeriodo5").disabled = false;
//    document.getElementById("option1").selected = true;
//    document.getElementById("option2").selected = true;
//    document.getElementById("option3").selected = true;
//    document.getElementById("option4").selected = true;
//    document.getElementById("selectDoPeriodo1").disabled = true;
//    document.getElementById("selectDoPeriodo2").disabled = true;
//    document.getElementById("selectDoPeriodo3").disabled = true;
//    document.getElementById("selectDoPeriodo4").disabled = true;
//}

function processar(number) {
    let options = [];
    for(let i = 1; i <= 5; i++) {
        options.push(document.getElementById('option' + i));
    }
    for (let option of options) {
        if (option.id.substr(-1) === number.toString()) {
            if (option.selected === false)
                continue;
            option.selected = 'true';
        } else {
            option.selected = 'false';
        }
    }
    toggleSelects(number);
}

function toggleSelects(number) {
    let selects = [];
    for(let i = 1; i <= 5; i++) {
        selects.push(document.getElementById('selectP' + i));
    }
    
    for(let select of selects) {
        if (select.id.substr(-1) === number.toString()) {
            select.removeAttribute('disabled');
        } else {
            select.setAttribute('disabled', 'true');
        }
    }
}

//function processar1() {
//    document.getElementById("option2").selected="true";
//    document.getElementById("selectDoPeriodo2").disabled="true";
//    document.getElementById("selectDoPeriodo1").disabled="false";
//}
//
//function processar2() {
//    document.getElementById("selectDoPeriodo2").disabled="false";
//    document.getElementById("option1").selected="true";
//    document.getElementById("selectDoPeriodo1").disabled="true";
//}
