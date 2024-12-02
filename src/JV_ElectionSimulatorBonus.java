import java.util.Scanner;

public class JV_ElectionSimulatorBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to João's U.S. Election Simulator (bonus version)");
        System.out.println("\nThis program will run a simulation of the U.S. presidential\n" +
                "election by randomly awarding Electoral College Votes for each state\n" +
                "or district.\n");

        System.out.print("Enter the data file path: ");
        String path = scanner.next();
        scanner.nextLine();

        System.out.println("\nPress ENTER to run the simulation...");
        scanner.nextLine();

        JV_ProjectMethods.reportBonusInformation(path);

    }
}
