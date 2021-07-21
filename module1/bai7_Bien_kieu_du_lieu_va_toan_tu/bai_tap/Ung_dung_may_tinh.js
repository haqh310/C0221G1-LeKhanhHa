function tinhToan(op) {
let a = document.getElementById("gia_tri_a").value;
let b = document.getElementById("gia_tri_b").value;
let c;
if (op=="+")
    c=a+"+"+b
else if (op=="-")
    c=a-b;
else if (op=="*")
    c=a*b;
else c=a/b;
document.getElementById("result").innerHTML=eval(c);
}