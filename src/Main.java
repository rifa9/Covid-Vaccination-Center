import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        vaccinationCenter.initialise();

        boolean run =true;

        while (run) {
            System.out.println(" ");
            System.out.println("100 or VVB: View all Vaccination Booths");
            System.out.println("101 or VEB: View all Empty Booths");
            System.out.println("102 or APB: Add Patient to a Booth");
            System.out.println("103 or RPB: Remove Patient from a Booth");
            System.out.println("104 or VPS: View Patients Sorted in alphabetical order");
            System.out.println("105 or SPD: Store Program Data into file");
            System.out.println("106 or LPD: Load Program Data from file");
            System.out.println("107 or VRV: View Remaining Vaccinations");
            System.out.println("108 or AVS: Add Vaccinations to the Stock");
            System.out.println("999 or EXT: Exit the Program ");
            System.out.print("Enter the code :");
            String task = input.nextLine();

            switch (task) {
                case "100":
                case "VVB":
                case "vvb":
                    System.out.println(" ");
                    vaccinationCenter.viewVaccinationBooth();
                    break;
                case "101":
                case "VEB":
                case "veb":
                    System.out.println(" ");
                    vaccinationCenter.viewEmptyBooth();
                    break;
                case "102":
                case "APB":
                case "apb":
                    System.out.println(" ");
                    vaccinationCenter.addPatient();
                    break;
                case "103":
                case "RPB":
                case "rpb":
                    System.out.println(" ");
                    vaccinationCenter.removePatient();
                    break;
                case "104":
                case "VPS":
                case "vps":
                    System.out.println(" ");
                    vaccinationCenter.viewPatient();
                    break;
                case "105":
                case "SPD":
                case "spd":
                    System.out.println(" ");
                    vaccinationCenter.storeData();
                    break;
                case "106":
                case "LPD":
                case "lpd":
                    System.out.println(" ");
                    vaccinationCenter.loadData();
                    break;
                case "107":
                case "VRV":
                case "vrv":
                    System.out.println(" ");
                    System.out.println(vaccinationCenter.getVaccine());
                    break;
                case "108":
                case "AVS":
                case "avs":
                    System.out.println(" ");
                    vaccinationCenter.addVaccination();
                    break;
                case "999":
                case "EXT":
                case "ext":
                    run = false;
                    System.out.println(" ");
                    System.out.println("The program has ended ");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Please enter the correct code ");
                    System.out.println(" ");
                    break;
            }
        }
    }
}
