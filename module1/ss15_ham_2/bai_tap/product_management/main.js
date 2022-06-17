let productArray = ['samsung','nokia','lenovo'];
let all_product = document.getElementById('all_product');

// Show
function showProduct() {
    let data = "<table >";
    let countProduct = document.getElementById('countProduct');
    for(let i = 0; i < productArray.length; i++) {

        data = data + `<td style="width: 100px;">` + productArray[i] + `</td>`
                 + `<td style="width: 100px;">` + '<button class="btn-edit" id="btn_edit">Edit</button>' + "</td>"
                 + `<td style="width: 100px;">` + '<button class="btn-delete" id="btn_delete">Delete</button>' + "</td>" ;
        
        data = data + "</tr>";

    }

    console.log(productArray);

    data = data + "</table>";

    all_product.innerHTML += data;
    countProduct.innerHTML = productArray.length;
}

showProduct();

// Add
let btn_add = document.getElementById('btn_add');
btn_add.addEventListener('click', addNewProduct);

function addNewProduct() {
    let newProduct = document.getElementById('addProduct').value;
    productArray.push(newProduct);
    document.getElementById('addProduct').value = '';
    all_product.innerHTML = "";
    showProduct();

}
