function nhap_diem(){
    let vat_ly= prompt("Nhập điểm vật lý:");
    let hoa_hoc = prompt("Nhập điểm hóa học:");
    let sinh_hoc = prompt("Nhập điểm sinh học:");
    let avg=(vat_ly+hoa_hoc+sinh_hoc)/3;
    document.getElementById("diem").innerHTML="Vật lý : "+vat_ly+"  Hóa học: "+hoa_hoc+" Sinh học: "+sinh_hoc;
   document.getElementById("trung_binh").innerHTML="Điểm trung bình là : "+avg;
}

function doi_nhiet_do() {
    let do_C = prompt("Nhập độ C:");
    let do_F=(do_C*9)/5 + 32;
    document.getElementById("nhap_do_c").innerHTML=do_C;
    document.getElementById("doi_nhiet_do").innerHTML="Độ F : "+do_F;
}

function hinh_tron() {
    let ban_kinh=prompt("Nhập bán kính hình tròn :")
    let dien_tich= ban_kinh*ban_kinh*3.14;
    let chu_vi=2*ban_kinh*3.14;
    document.getElementById("nhap_ban_kinh").innerHTML=ban_kinh;
    document.getElementById("dien_tich").innerHTML="Diện tích :"+dien_tich;
    document.getElementById("chu_vi").innerHTML="Chu vi :"+chu_vi;

}

