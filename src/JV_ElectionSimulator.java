/*
 *
 * */

import java.util.Scanner;

public class JV_ElectionSimulator {

    public static void main(String[] args) { // main method
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to João’s 2024 U.S. Election Simulator!\n");
        System.out.println("This program will run a simulation of the 2024 U.S. presidential\n" +
                "election by randomly awarding Electoral College Votes for each state\n" +
                "based on probabilities obtained from www.270towin.com 6 days\n" +
                "before the election.\n");

        System.out.println("Press ENTER to run the simulation...");
        scanner.nextLine();

//        Create the following three 56-element parallel arrays to store data which will be read from the
//        comma-delimited text file projections2024.csv:
//          a. An array to hold the name of each region (state or district).
//          b. An array to hold the number of Electoral College Votes awarded by each region.
//          c. An array to hold the probability (as a percent) that Trump will win in each region.
//        Choose a suitable type for each array. These will be parallel arrays because the value at the
//        same index in each array will correspond to the same region.

        String[] regions = new String[56];
        int[] numberElectoralVotes = new int[56];
        double[] trumpWinProbability = new double[56];

//        Populate each array by calling a method that you will code named readAllElectionData()
//        that will accept the path to the data file (projections2024.csv) as well as the three arrays created
//        in the previous step. The method will populate the arrays with data from the file. The method will
//        return a boolean value of true if the data was read into the arrays successfully, otherwise it
//        should return false. If the method returns false, then your program should terminate instead
//        of continuing with the remaining steps.

        boolean fileSuccess = JV_ProjectMethods.readAllElectionData(regions, numberElectoralVotes, trumpWinProbability);

        if(!fileSuccess){
            System.out.println("Error with the file.");
            return;
        }

//        Create a fourth parallel array of type boolean to store the outcome of the election in each
//        region. This array should be created using the new keyword and should have the same number
//        of elements as the arrays created earlier. Use the length property of one of the other arrays to
//        set the size of this array.

        boolean[] eachRegion = new boolean[regions.length];

//        Now initialize values to all elements in the boolean array using a loop. In the body of the loop
//        you should call a method that you will code named getRegionResult() which will return a
//        boolean value and which will accept a single number representing the probability of Trump
//        winning. When you call this method you will pass to it as an argument an element from
//        probabilities array (using the current array index as determined by the loop) and you will assign
//        the boolean value returned by the method to the current element in the boolean array using
//        the same array index.

        for (int i = 0; i < eachRegion.length; i++){
            eachRegion[i] = JV_ProjectMethods.getRegionResult(trumpWinProbability[i]);
        }

//        Report the names of the regions won by Trump and the number of Electoral College votes awarded to him by
//        each of these regions. See the sample output provided to see how this should look. You can loop through the
//        region names array, the Electoral College Votes array and the boolean outcomes array at the same time using a
//        single loop to generate this output. The states won by Trump will be indicated by the value true in the boolean
//        array.

        int trumpElectoralVotes = 0;
        int harrisElectoralVotes = 0;

        System.out.println("Republican Donald Trump has won the following Electoral College Votes:\n");

        for (int i = 0; i < eachRegion.length; i++){
            if (eachRegion[i]) {
                System.out.printf("%s (%d)\n", regions[i], numberElectoralVotes[i]);
                trumpElectoralVotes += numberElectoralVotes[i];
            }
        }

        System.out.println("\nDemocrat Kamala Harris has won the following Electoral College Votes:\n");

        for (int i = 0; i < eachRegion.length; i++){
            if (!eachRegion[i]) {
                System.out.printf("%s (%d)\n", regions[i], numberElectoralVotes[i]);
                harrisElectoralVotes += numberElectoralVotes[i];
            }
        }

//        Finally, call a void method that you will code called reportOutcome() which will accept the two
//        accumulator variables as the only arguments. This method will print a report about the outcome of the
//        simulated election on the screen as described in The Finer Details section.

        JV_ProjectMethods.reportOutcome(trumpElectoralVotes, harrisElectoralVotes);

    }
}