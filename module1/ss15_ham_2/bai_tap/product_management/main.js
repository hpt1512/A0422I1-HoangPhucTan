let productArray = [];
// let table_product = document.getElementById('table_product');
let all_product = document.getElementById('all_product');

let data = "";


let btn_add = document.getElementById('btn_add');
btn_add.addEventListener('click', addNewProduct);
function addNewProduct() {
    let data = "<table >";
    let newProduct = document.getElementById('addProduct').value;

    productArray.push(newProduct);

    for (let i = 0; i < productArray.length; i++) {
        data = data + `<td style="width: 100px;">` + productArray[i] + `</td>`
            + `<td style="width: 100px;">` + '<button class="btn-edit">Edit</button>' + "</td>"
            + `<td style="width: 100px;">` + '<button class="btn-delete">Delete</button>' + "</td>";

        data = data + "</tr>";
    }

    // data = data + `<td style="width: 100px;">` + newProduct + `</td>`
    //     + `<td style="width: 100px;">` + '<button class="btn-edit">Edit</button>' + "</td>"
    //     + `<td style="width: 100px;">` + '<button class="btn-delete">Delete</button>' + "</td>";

    // data = data + "</tr>";
    data = data + "</table> <br>";




    document.getElementById('addProduct').value = '';

    // document.write(data);
    all_product.innerHTML += data;

}
console.log(productArray);

