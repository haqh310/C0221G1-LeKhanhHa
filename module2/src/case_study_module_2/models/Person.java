package case_study_module_2.models;

public abstract class Person implements ShowInfo{
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String fullName, String dateOfBirth, String gender, String idCard, String phoneNumber, String email) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Person(String[] arr) {
        this.fullName = arr[0];
        this.dateOfBirth = arr[1];
        this.gender = arr[2];
        this.idCard = arr[3];
        this.phoneNumber = arr[4];
        this.email = arr[5];
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  fullName +
                "," + dateOfBirth +
                "," + gender +
                "," + idCard +
                "," + phoneNumber +
                "," + email;
    }


}
