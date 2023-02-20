// happy coding 👻
console.log("hello world");

function fibonacci(n: number): number {
    if (n == 2 || n == 1) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2)
}

let n: number = parseInt(<string>prompt("nhap so n : "));

let sum: number = 0;
for (let i = 1 ; i <= n; i++) {
    console.log(fibonacci(i))
    sum += fibonacci(i);
}

document.write("tổng của dãy số fibonacci là " + sum)