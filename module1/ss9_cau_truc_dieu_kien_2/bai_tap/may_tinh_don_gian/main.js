function add(a, b) {
    return result = a + b;
}
function sub(a, b) {
    return result = a - b;
}
function mul(a, b) {
    return result = a * b;
}
function div(a, b) {
    return result = a / b;
}

let this_input = document.getElementById('this_input');
// 1
let btn1 = document.getElementById('btn1');
btn1.addEventListener('click',clickFunction1);
function clickFunction1(){
    this_input.value = this_input.value + btn1.value;
}
// 2
let btn2 = document.getElementById('btn2');
btn2.addEventListener('click',clickFunction2);
function clickFunction2(){
    this_input.value = this_input.value + btn2.value;
}
// 3
let btn3 = document.getElementById('btn3');
btn3.addEventListener('click',clickFunction3);
function clickFunction3(){
    this_input.value = this_input.value + btn3.value;
}
// 4
let btn4 = document.getElementById('btn4');
btn4.addEventListener('click',clickFunction4);
function clickFunction4(){
    this_input.value = this_input.value + btn4.value;
}
// 5
let btn5 = document.getElementById('btn5');
btn5.addEventListener('click',clickFunction5);
function clickFunction5(){
    this_input.value = this_input.value + btn5.value;
}
// 6
let btn6 = document.getElementById('btn6');
btn6.addEventListener('click',clickFunction6);
function clickFunction6(){
    this_input.value = this_input.value + btn6.value;
}
// 7
let btn7 = document.getElementById('btn7');
btn7.addEventListener('click',clickFunction7);
function clickFunction7(){
    this_input.value = this_input.value + btn7.value;
}
// 8
let btn8 = document.getElementById('btn8');
btn8.addEventListener('click',clickFunction8);
function clickFunction8(){
    this_input.value = this_input.value + btn8.value;
}
// 9
let btn9 = document.getElementById('btn9');
btn9.addEventListener('click',clickFunction9);
function clickFunction9(){
    this_input.value = this_input.value + btn9.value;
}
// 0
let btn0 = document.getElementById('btn0');
btn0.addEventListener('click',clickFunction0);
function clickFunction0(){
    this_input.value = this_input.value + btn0.value;
}
// +
let btn_add = document.getElementById('btn_add');
btn_add.addEventListener('click',clickFunction_add);
function clickFunction_add(){
    this_input.value = this_input.value + btn_add.value;
}
// -
let btn_sub = document.getElementById('btn_sub');
btn_sub.addEventListener('click',clickFunction_sub);
function clickFunction_sub(){
    this_input.value = this_input.value + btn_sub.value;
}
// *
let btn_mul = document.getElementById('btn_mul');
btn_mul.addEventListener('click',clickFunction_mul);
function clickFunction_mul(){
    this_input.value = this_input.value + btn_mul.value;
}
// /
let btn_div = document.getElementById('btn_div');
btn_div.addEventListener('click',clickFunction_div);
function clickFunction_div(){
    this_input.value = this_input.value + btn_div.value;
}



