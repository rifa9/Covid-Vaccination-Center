import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VaccinationCenter {
    private Booth[] booth;
    private int vaccine;

    LinkedList list = new LinkedList();

    public VaccinationCenter() {
        this.booth = new Booth[6];
        this.vaccine = 150;
    }

    public Booth[] getBooth() {
        return booth;
    }

    public void setBooth(Booth[] booth) {
        this.booth = booth;
    }

    public int getVaccine() {
        return vaccine;
    }

    public void setVaccine(int vaccine) {
        this.vaccine = vaccine;
    }

    //initialise
    public void initialise() {
        for (int x = 0; x < this.booth.length; x++) this.booth[x] = new Booth(x, null);
        System.out.println("initialise ");
    }

    // view all booths
    public void viewVaccinationBooth() {
        for (int x = 0; x < this.booth.length; x++) {
            if (this.booth[x].getPatient() == null) {
                System.out.println("booth " + x + " is empty");
            } else {
                System.out.println("booth " + x + " occupied by " + this.booth[x].toString());
            }
        }
    }

    //view empty booths only
    public void viewEmptyBooth() {
        for (int x = 0; x < this.booth.length; x++) {
            if (this.booth[x].getPatient() == null) System.out.println("booth " + x + " is empty");
        }
    }

    //adding patient to the booth
    public void addPatient() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 for AstraZeneca   ");
        System.out.println("Enter 2 for Sinopharm  ");
        System.out.println("Enter 3 for Pfizer  ");
        int requestedVaccine = input.nextInt();

        if (requestedVaccine<4 && requestedVaccine>0) {
            System.out.println("Enter the first name :");
            String firstName = input.next();

            System.out.println("Enter the surname :");
            String surName = input.next();

            System.out.println("Enter the age :");
            int age = input.nextInt();

            System.out.println("Enter the city :");
            String city = input.next();

            System.out.println("Enter the NIC number :");
            String NIC = input.next();

            Patient patient = new Patient(firstName, surName, age, city, NIC, requestedVaccine);

            if (this.vaccine > 0) {

                int vaccine = patient.getRequestedVaccine();
                if (vaccine == 1) {
                    if (booth[0].getPatient() == null) {
                        booth[0].setPatient(patient);
                        this.vaccine--;
                        System.out.println("Patient added");
                    } else if (booth[1].getPatient() == null) {
                        booth[1].setPatient(patient);
                        this.vaccine--;
                        System.out.println("Patient added");
                    } else {
                        list.insert(patient);
                        System.out.println("Booths for AstraZeneca are already occupied");
                        System.out.println("Waiting List :");
                        list.show();
                    }
                } else if (vaccine == 2) {
                    if (booth[2].getPatient() == null) {
                        booth[2].setPatient(patient);
                        this.vaccine--;
                        System.out.println("Patient added");
                    } else if (booth[3].getPatient() == null) {
                        booth[3].setPatient(patient);
                        this.vaccine--;
                        System.out.println("Patient added");
                    } else {
                        list.insert(patient);
                        System.out.println("Booths for Sinopharm are already occupied");
                        System.out.println("Waiting List :");
                        list.show();
                    }
                } else if (vaccine == 3) {
                    if (booth[4].getPatient() == null) {
                        booth[4].setPatient(patient);
                        this.vaccine--;
                        System.out.println("Patient added");
                    } else if (booth[5].getPatient() == null) {
                        booth[5].setPatient(patient);
                        this.vaccine--;
                        System.out.println("Patient added");
                    } else {
                        list.insert(patient);
                        System.out.println("Booths for Pfizer are already occupied");
                        System.out.println("Waiting List :");
                        list.show();
                    }
                }
            } else {
                System.out.println("Vaccination is not available");
            }
        } else {
            System.out.println("Entered integer is out of range");
        }
    }

    //remove patient from booth
    public void removePatient() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter booth number (0-5) :");
        int boothNumber = input.nextInt();
        Patient patient;

        if (booth[boothNumber].getPatient() == null) {
            System.out.println("The booth is already empty");
        } else {
            booth[boothNumber].setPatient(null);

            list.reverseList();
            Node node = list.head;
            while (node != null) {
                patient = node.patient;
                int vaccine = patient.getRequestedVaccine();

                if (vaccine == 1) {
                    if (booth[0].getPatient() == null) {
                        booth[0].setPatient(patient);
                        System.out.println("Patient removed");
                    } else if (booth[1].getPatient() == null) {
                        booth[1].setPatient(patient);
                        System.out.println("Patient removed");
                    }
                } else if (vaccine == 2) {
                    if (booth[2].getPatient() == null) {
                        booth[2].setPatient(patient);
                        System.out.println("Patient removed");
                    } else if (booth[3].getPatient() == null) {
                        booth[3].setPatient(patient);
                        System.out.println("Patient removed");
                    }
                } else if (vaccine == 3) {
                    if (booth[4].getPatient() == null) {
                        booth[4].setPatient(patient);
                        System.out.println("Patient removed");
                    } else if (booth[5].getPatient() == null) {
                        booth[5].setPatient(patient);
                        System.out.println("Patient removed");
                    }
                }node = node.next;
            }list.reverseList();
        }
    }

    //view patient in alphabetical order
    public void viewPatient() {
        Booth[] order = this.booth.clone();

        for (int j = 0; j < order.length; j++) {
            for (int i = j + 1; i < order.length; i++) {
                if (order[i].compareTo(order[j]) < 0) {
                    Booth temp = order[j];
                    order[j] = order[i];
                    order[i] = temp;
                }
            }
            if (order[j] != null) {
                System.out.println(order[j]);
            }
        }
    }

    //store information of patient in file
    public void storeData() {
        try {
            File data = new File("Info.txt");
            if (data.createNewFile()) {
                System.out.println("File created: " + data.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter myWriter = new FileWriter("Info.txt");
            for (int i = 0; i < this.booth.length; i++) {
                myWriter.write(i + "." + this.booth[i].getPatient() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //load information from file
    public void loadData() {
        try {
            File data = new File("Info.txt");
            Scanner input = new Scanner(data);
            while (input.hasNextLine()) {
                String info = input.nextLine();
                System.out.println(info);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // add extra vaccines to stock
    public void addVaccination() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the amount of vaccinations : ");
        int addStock = input.nextInt();
        this.vaccine+= addStock;
    }

}
