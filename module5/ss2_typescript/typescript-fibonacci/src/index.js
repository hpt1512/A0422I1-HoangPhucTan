// happy coding 👻
console.log("hello world");
function fibonacci(n) {
    if (n == 2 || n == 1) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
var n = parseInt(prompt("nhap so n : "));
var sum = 0;
for (var i = 1; i <= n; i++) {
    console.log(fibonacci(i));
    sum += fibonacci(i);
}
document.write("tổng của dãy số fibonacci là " + sum);
