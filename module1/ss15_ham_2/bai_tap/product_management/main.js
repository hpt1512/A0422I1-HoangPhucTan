let productArray = ['samsung','nokia','lenovo'];
let all_product = document.getElementById('all_product');

// Show
function showProduct() {
    let data = "<table id='sdds'>";
    let countProduct = document.getElementById('countProduct');
    for(let i = 0; i < productArray.length; i++) {

        data = data + `<td style="width: 100px;">` + productArray[i] + `</td>`
                 + `<td style="width: 100px;">` + '<button class="btn-edit" id="btn_edit">Edit</button>' + "</td>"
                 + `<td style="width: 100px;">` + '<button class="btn-delete" value='+ productArray[i] +' id="btn_delete_' + productArray[i] + '">Delete</button>' + "</td>" ;
        
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
    let newProduct = document.getElementById('newProduct').value;
    productArray.push(newProduct);
    document.getElementById('newProduct').value = '';
    all_product.innerHTML = "";
    showProduct();

}

// Delete
// let btn_delete = document.getElementsByClassName('btn-delete');
// btn_delete.addEventListener('click', deleteProduct(i));

function deleteProduct(i) {
    productArray.splice(i,1);
    all_product.innerHTML = "";
    showProduct();
}


let Buttons = document.querySelectorAll(".btn-delete");
Buttons.forEach(one_btn => {
    // if(one_btn.clicked === true){
    //     console.log(one_btn)
    // }        
    one_btn.onclick = function() {
        console.log(one_btn)
        let a = one_btn.value
        one_btn.addEventListener('click', deleteProduct(a) );
    }
    // console.log(one_btn);
    // one_btn.addEventListener('click', deleteProduct );
});

function deleteProduct(variable) {
    var carIndex = productArray.indexOf(variable);
    productArray.splice(carIndex,1);
    all_product.innerHTML = "";
    showProduct();
}