package case_study_module_2.models;

public class ExtraService implements ShowInfo {
    private String ExtraServiceName;
    private String unit;
    private double money;

    public ExtraService() {
    }

    public ExtraService(String ExtraServiceName, String unit, double money) {
        this.ExtraServiceName = ExtraServiceName;
        this.unit = unit;
        this.money = money;
    }

    public String getExtraServiceName() {
        return ExtraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.ExtraServiceName = extraServiceName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return  ExtraServiceName +
                "," + unit +
                "," + money;
    }

    @Override
    public String showInfo() {
        return "ExtraService{" +
                "ExtraServiceName='" + ExtraServiceName + '\'' +
                ", unit='" + unit + '\'' +
                ", money=" + money +
                '}';
    }
}
