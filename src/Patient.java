public class Patient {
    private String firstName;
    private String surName;
    private int age;
    private String city;
    private String NIC;
    private int requestedVaccine;

    public Patient(int requestedVaccine) {
        this.requestedVaccine = requestedVaccine;

    }

    public Patient(String firstName, String surName, int age, String city, String NIC, int requestedVaccine){
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.city = city;
        this.NIC = NIC;
        this.requestedVaccine = requestedVaccine;
    }

    public Patient(String firstName, String surName, int age, String city, String NIC){
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.city = city;
        this.NIC = NIC;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public int getRequestedVaccine() {
        return requestedVaccine;
    }

    public void setRequestedVaccine(int requestedVaccine) {
        this.requestedVaccine = requestedVaccine;
    }

    @Override
    public String toString() {
        return "First Name='" + firstName + '\'' +
                ", Sur Name='" + surName + '\'' +
                ", Age=" + age +
                ", City='" + city + '\'' +
                ", NIC='" + NIC + '\'' +
                ", Vaccination Requested='" + requestedVaccine + '\'' ;
    }

}
