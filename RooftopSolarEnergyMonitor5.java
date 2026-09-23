import java.util.Scanner;

public class RooftopSolarEnergyMonitor5 {
    static Scanner sc = new Scanner(System.in);//------------------------------------------>co-3
    static double[] energy = new double[7];
    static double[][] panel = new double[2][3];

    static void enterEnergy() {
        System.out.println("Enter energy for 7 days:");
        for (int i = 0; i < 7; i++) //------------------------------------------------>co-2
            energy[i] = sc.nextDouble();
    }

    static void display() {
        System.out.println("Daily Energy:");
        for (int i = 0; i < 7; i++)//---------------------------------------------------->
            System.out.println("Day " + (i + 1) + ": " + energy[i] + " kWh");
    }

    static void calculate() {
        double sum = 0, max = energy[0], min = energy[0];
        int high = 0;

        for (double x : energy) {
            sum += x;
            if (x > max) max = x;
            if (x < min) min = x;
            if (x > 15) high++;
        }

        System.out.println("Total = " + sum + " kWh");
        System.out.println("Maximum = " + max + " kWh");
        System.out.println("Minimum = " + min + " kWh");
        System.out.println("High Energy Days = " + high);
    }

    static void search() {
        System.out.print("Enter energy to search: ");
        double value = sc.nextDouble();
        boolean found = false;

        for (double x : energy)
            if (x == value) found = true;

        if (found)
            System.out.println("Energy found!");
        else
            System.out.println("Energy not found!");
    }

    static void panelData() {
        System.out.println("Enter energy for 2 panels, 3 days:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                panel[i][j] = sc.nextDouble();

        System.out.println("Panel Data:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(panel[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- SOLAR ENERGY MONITOR ---");
            System.out.println("1. Enter Energy");
            System.out.println("2. Display Energy");
            System.out.println("3. Calculate Total, Max and Min");
            System.out.println("4. Search Energy");
            System.out.println("5. Enter Panel Data");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: enterEnergy(); break;
                case 2: display(); break;
                case 3: calculate(); break;
                case 4: search(); break;
                case 5: panelData(); break;
                case 6: System.out.println("Thank you!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }
}