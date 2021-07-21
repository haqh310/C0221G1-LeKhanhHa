package model.service;

import model.bean.NhanVien;
import model.repository.NhanVienRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NhanVienService {
    NhanVienRepository repository = new NhanVienRepository();
    private final String REGEX_NAME = "^[a-zA-Z]+$";
    public List<NhanVien> selectAll(){
        return repository.selectAll();
    }
    public NhanVien selectById(int id){
        return repository.selectById(id);
    }
    public Map<String, String> insert(NhanVien nhanVien){
        Map<String,String> mapMsg = new HashMap<>();
        boolean flag=true;
        if("".equals(nhanVien.getTen())){
            mapMsg.put("ten","Please input name");
            flag=false;
        }else if(!nhanVien.getTen().matches(REGEX_NAME)){
            mapMsg.put("ten","Invalid format a-z");
            flag=false;
        }
        if("".equals(nhanVien.getNgaySinh())) {
            mapMsg.put("ngaySinh", "Please input ngay sinh");
            flag = false;
        }else {
            boolean check =2021 - Integer.parseInt(nhanVien.getNgaySinh().split("-")[0]) < 18;
            if(check){
                mapMsg.put("ngaySinh" ,"Tuoi phai lon hon 18");
                flag=false;
            }
        }
        if(flag){
            repository.insert(nhanVien);
        }
        return mapMsg;
    }

    public Map<String, String> update( NhanVien nhanVien){
        Map<String,String> mapMsg = new HashMap<>();
        boolean flag=true;
        if("".equals(nhanVien.getTen())){
            mapMsg.put("ten","Please input name");
            flag=false;
        }else if(!nhanVien.getTen().matches(REGEX_NAME)){
            mapMsg.put("ten","Invalid format a-z");
            flag=false;
        }
        if("".equals(nhanVien.getNgaySinh())) {
            mapMsg.put("ngaySinh", "Please input ngay sinh");
            flag = false;
        }else {
            boolean check =2021 - Integer.parseInt(nhanVien.getNgaySinh().split("-")[0]) < 18;
            if(check){
                mapMsg.put("ngaySinh" ,"Tuoi phai lon hon 18");
                flag=false;
            }
        }
        if(flag){
            repository.update(nhanVien);
        }
        return mapMsg;
    }

    public boolean delete(int id){
        return repository.delete(id);
    }
}
