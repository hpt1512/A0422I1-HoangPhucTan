let cartoon__item__1 = document.getElementById("cartoon__item__1");
let cartoon__item__2 = document.getElementById("cartoon__item__2");
let cartoon__item__3 = document.getElementById("cartoon__item__3");
let cartoon__item__4 = document.getElementById("cartoon__item__4");

let cartoon__div__1 = document.getElementById("cartoon__div__1");
let cartoon__div__2 = document.getElementById("cartoon__div__2");
let cartoon__div__3 = document.getElementById("cartoon__div__3");
let cartoon__div__4 = document.getElementById("cartoon__div__4");

// console.log("123"); 
// console.log(cartoon__item__1);
cartoon__item__1.addEventListener('click', function() {
    cartoon__div__1.style.display = "block";
    cartoon__div__2.style.display = "none";
    cartoon__div__3.style.display = "none";
    cartoon__div__4.style.display = "none";
});

cartoon__item__2.addEventListener('click', function() {
    cartoon__div__2.style.display = "block";
    cartoon__div__1.style.display = "none";
    cartoon__div__3.style.display = "none";
    cartoon__div__4.style.display = "none";
});

cartoon__item__3.addEventListener('click', function() {
    cartoon__div__3.style.display = "block";
    cartoon__div__1.style.display = "none";
    cartoon__div__2.style.display = "none";
    cartoon__div__4.style.display = "none";
});

cartoon__item__4.addEventListener('click', function() {
    cartoon__div__4.style.display = "block";
    cartoon__div__1.style.display = "none";
    cartoon__div__2.style.display = "none";
    cartoon__div__3.style.display = "none";
});
