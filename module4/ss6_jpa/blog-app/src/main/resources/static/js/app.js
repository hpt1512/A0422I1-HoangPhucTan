
function findByName() {
    let nameFind = $("#nameFindAjax").val();
    $.ajax({
        url: "http://localhost:8080/api/blog/findBlogByName",
        data: {
            name: nameFind
        },
        type: "get",
        dataType: "json",
        success: function (data) {
            console.log(data)
            let result = '';
            for (let i = 0; i < data.length; i++) {
                result += `
                    <tr>
                        <td>${data[i].id}</td>
                        <td>${data[i].name}</td>
                        <td>${data[i].content}</td>
                        <td>${data[i].category.name}</td>
                        <td><a th:href="@{/detail/{id}(id=${data[i].id})}">Detail</a></td>
                        <td><a th:href="@{/edit/{id}(id=${data[i].id})}">Update</a></td>
                        <td><a th:href="@{/delete/{id}(id=${data[i].id})}">Delete</a></td>
                    </tr>
                `;
            }

            $("#result").html(result);
            // $("table tr:eq(2)").remove();
        },
        error: function (e) {

        }
    });
}

function deleteCus(id) {

}

// function getAllBlog() {
//     let blog = $("#nameDraw").val();
//     $.ajax({
//         url: "http://localhost:8080/api/blog/list",
//         data: {
//             name: nameDraw
//         },
//         type: "get",
//         dataType: "json",
//         success: function (data) {
//             console.log(data);
//             let result = '';
//             for (let i = 0; i < data.length; i++) {
//                 result += `
//                     <tr>
//                         <td>${data[i].id}</td>
//                         <td>${data[i].name}</td>
//                         <td>${data[i].content}</td>
//                         <td>${data[i].category.name}</td>
//                         <td><a th:href="@{/detail/{id}(id=${data[i].id})}">Detail</a></td>
//                         <td><a th:href="@{/edit/{id}(id=${data[i].id})}">Update</a></td>
//                         <td><a th:href="@{/delete/{id}(id=${data[i].id})}">Delete</a></td>
//                     </tr>
//                 `;
//             }
//
//             $("#result").html(result);
//             // $("table tr:eq(2)").remove();
//         },
//         error: function (e) {
//
//         }
//     });
// // }

