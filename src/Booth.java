public class Booth implements Comparable<Booth>{
    private int boothNum;
    private Patient patient;

    public Booth(int boothNum, Patient patient){
        this.boothNum = boothNum;
        this.patient = patient;
    }


    public int getBoothNum() {
        return boothNum;
    }

    public void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        if (patient != null) {
            return patient.getFirstName() + " " + patient.getSurName();
        }
        return "";
    }

    @Override
    public int compareTo(Booth o) {
        if (this.getPatient() != null && o.getPatient() != null) {
            return this.getPatient().getFirstName().compareTo(o.patient.getSurName());
        }
        return 0;
    }

}
