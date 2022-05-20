function convertMoney(amount, fromCurrency, toCurrency) {
    let result;
    if (fromCurrency == 'VietNam' && toCurrency == 'USD') {
        result = amount / 23000;
    }
    if (fromCurrency == 'USD' && toCurrency == 'VietNam') {
        result = amount * 23000;
    }
    return result;
}



let convert_btn = document.getElementById('convert_btn');

function clickFunction() {
    let amount = document.getElementById('amount').value;

    let fromCurrency = document.getElementById('fromCurrency').value;
    let toCurrency = document.getElementById('toCurrency').value;

    let kq = convertMoney(amount, fromCurrency, toCurrency);


    // console.log(amount);
    // console.log(fromCurrency);
    // console.log(toCurrency);
    // console.log(kq);

    let result = document.getElementById('result');
    result.innerHTML = 'Result : ' + kq;

}

convert_btn.addEventListener("click", clickFunction);

