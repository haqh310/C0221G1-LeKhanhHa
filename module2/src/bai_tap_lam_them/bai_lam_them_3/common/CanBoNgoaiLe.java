package bai_tap_lam_them.bai_lam_them_3.common;

public class CanBoNgoaiLe extends Exception {
    public CanBoNgoaiLe(String message) {
        super(message);
    }

    public static void checkHoTen(String name) throws CanBoNgoaiLe {
        String regex = "^[a-zA-Z]+$";
        if(!name.matches(regex)){
            throw new CanBoNgoaiLe("Dinh dang la chu");
        }
    }
    public static void checkNamSinh(String namSinh) throws CanBoNgoaiLe {
        String regex = "^[1-2][0-9]{3}$";
        if(!namSinh.matches(regex)){
            throw new CanBoNgoaiLe("Dinh dang la XXXX");
        }
    }
    public static void checkDiaChi(String diaChi) throws CanBoNgoaiLe {
        String regex = "^[a-zA-Z]+$";
        if(!diaChi.matches(regex)){
            throw new CanBoNgoaiLe("Dinh dang la chu");
        }
    }
    public static void checkbac(String diaChi) throws CanBoNgoaiLe {
        String regex = "^[1-7]/7$";
        if(!diaChi.matches(regex)){
            throw new CanBoNgoaiLe("Dinh dang la X/7");
        }
    }
}
