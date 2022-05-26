const numbers = document.getElementsByClassName('btn');
const result = document.getElementById('result');

for(let number of numbers) {
    number.addEventListener('click', function(){
        result.value += this.value
    });
}

function equal() {
    let res = result.value;
    let output = eval(res);
    result.value = output;
}
function clearValue() {
    result.value = '';
}
function alertA() {
    alert('a');
}
function undo() {
    let res = result.value;
    result.value = res.substring(0, res.length - 1);
}