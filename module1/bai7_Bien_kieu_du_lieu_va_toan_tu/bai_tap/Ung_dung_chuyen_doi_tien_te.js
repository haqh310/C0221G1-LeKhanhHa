function chuyen_doi() {
    let amount = parseInt(document.doi_tien.amount.value) ;
    let from_cur = parseInt(document.doi_tien.from_curenncy.value) ;
    let to_cur =parseInt(document.doi_tien.to_curenccy.value) ;
    let result = amount*from_cur/to_cur;
    document.getElementById("result").innerHTML="Result : "+result;
}