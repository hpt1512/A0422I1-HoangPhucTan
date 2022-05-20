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
// Phep cong
let btn_add = document.getElementById('btn_add');

btn_add.addEventListener("click", clickFunction_add);
function clickFunction_add() {
    let input_a = parseFloat(document.getElementById('input_a').value);
    let input_b = parseFloat(document.getElementById('input_b').value);

    let result = document.getElementById('result');

    result.innerHTML = 'Result : ' + add(input_a, input_b);

}


// Phep tru
let btn_sub = document.getElementById('btn_sub');

btn_sub.addEventListener("click", clickFunction_sub);
function clickFunction_sub() {
    let input_a = parseFloat(document.getElementById('input_a').value);
    let input_b = parseFloat(document.getElementById('input_b').value);

    let result = document.getElementById('result');

    result.innerHTML = 'Result : ' + sub(input_a, input_b);

}
// Phep nhan
let btn_mul = document.getElementById('btn_mul');

btn_mul.addEventListener("click", clickFunction_mul);
function clickFunction_mul() {
    let input_a = parseFloat(document.getElementById('input_a').value);
    let input_b = parseFloat(document.getElementById('input_b').value);

    let result = document.getElementById('result');

    result.innerHTML = 'Result : ' + mul(input_a, input_b);

}
// Phep chia
let btn_div = document.getElementById('btn_div');

btn_div.addEventListener("click", clickFunction_div);
function clickFunction_div() {
    let input_a = parseFloat(document.getElementById('input_a').value);
    let input_b = parseFloat(document.getElementById('input_b').value);

    let result = document.getElementById('result');

    result.innerHTML = 'Result : ' + div(input_a, input_b);

}