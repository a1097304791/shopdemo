package entity;

public class User {
    private String username;
    private String password;

    private Integer age;
    private String gender;
    private String address;
    private String tel;
    private String email;

    private String school;
    private String major;
    private String education;
    private String name;
    private Boolean isAdm;

    public User(String username, String password, Integer age, String gender, String address, String tel, String email, String school, String major, String education, String name, Boolean isAdm) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.school = school;
        this.major = major;
        this.education = education;
        this.name = name;
        this.isAdm = isAdm;
    }

    public User(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdm() {
        return isAdm;
    }

    public void setAdm(Boolean adm) {
        isAdm = adm;
    }
}
