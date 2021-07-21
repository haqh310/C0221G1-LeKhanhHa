let ketQua="";
function tinhToan(op) {
switch (op) {
    case  "+" :
        ketQua +="+";
        break;
    case  "-" :
        ketQua +="-";
        break;
    case  "*" :
        if(kiemTra(ketQua))
            ketQua +="*";
        else alert("Loi")
        break;
    case  "/" :
        if(kiemTra(ketQua))
            ketQua +="/";
        else alert("Loi")
        break;
    case  "%" :
        if(kiemTra(ketQua))
            ketQua +="%";
        else alert("Loi")
        break;
    case  "(" :
        ketQua +="(";
        break;
    case  ")" :
        ketQua +=")";
        break;
    case  "AC" :
        ketQua ="";
        break;
    case  "=" :
        ketQua=eval(ketQua);
        break;
    default :
        ketQua+=op;
}
document.getElementById("input").value = ketQua;
}
function kiemTra(chuoi) {
    if(chuoi.length!=0)
        return true;
    else
        return false;
}