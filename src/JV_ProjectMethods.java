import java.io.*;

public class JV_ProjectMethods {

//    The purpose of the method is to read
//    all the projections data in the file provided and use it to populate the first three parallel arrays (see step
//    2 under WHAT YOUR PROGRAM SHOULD DO). The method will open the file and read each region
//    name into an element of the regions array, read each Electoral College Votes number into an element
//    of the votes array and read each probability into an element of the probabilities array.

//    For example, the first line of the file contains the following three fields (with comma delimiters):
//
//    Alabama,9,100,
//
//    The value Alabama must be inserted into the regions array. The value 9 must be inserted into the
//    votes array. The value 100 must be inserted into the probabilities array. The same index should be
//    used for all three arrays. In other words, you should be able to use the same index later in your
//    program to access the region name, the Electoral College Votes and the probability for a region.
//    The method must include exception-handling code that will display an error message if the data file
//    can’t be found. It should also include safeguards to prevent the method from going past the last valid
//    index of any of the arrays. The method must also return a boolean value of true if the data was read
//    into the arrays successfully, otherwise it should return false.

    public static boolean readAllElectionData(String[] regions, int[] numberElectoralVotes, double[] trumpWinProbability){

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/joaovitor/Documents/Projects/Elections Simulator/src/projections2024.csv"))) {
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null && i < 56) {

                String[] part = line.split(",");
                regions[i] = part[0];
                numberElectoralVotes[i] = Integer.parseInt(part[1]);
                trumpWinProbability[i] = Double.parseDouble(part[2]);

                i++;
            }
            return true;

        } catch (IOException e) {return false;}
    }

//    This method determines whether Trump or Harris wins a particular region. It will accept as an argument a
//    single number representing the expected probability as a percentage (between 0 and 100) that Trump will win the region
//    (a state or a district within a state). This method will return a boolean value. Use the following logic to determine
//    the result:
//            1.	Use the Math.random() method to generate a double value between 0 and 100.
//            2.	If the method argument contains a value that is greater than this random value then return true, otherwise
//            return false.
//    This logic will cause the method to randomly return true or false, but the probability of returning true will be directly
//    influenced by the percent probability of Trump winning as provided in the method’s argument. For example, if the method
//    argument contains 100, then the method will always return true, but if the argument contains 37 then it will have a 37%
//    chance of returning true and a 63% chance of returning false.


    public static boolean getRegionResult(double trumpWinProbability){
        return trumpWinProbability > Math.random() * 100;
    }

//    This will be a void method meaning it won’t return anything. It will accept two integer arguments: the number of
//    Electoral College Votes awarded to Trump and the number awarded to Harris. The method will generate formatted output
//    to the screen containing the number of Electoral College Votes for each candidate. It will also report the
//    winner(i.e. the next president) as follows:
//            1.	If Trump has at least 270 Electoral College Votes, report Donald Trump as the winner.
//            2.	Otherwise if Harris has at least 270 Electoral College Votes, report Kamala Harris as the winner.
//            3.	Otherwise report that neither candidate has enough Electoral College Votes to be declared the winner.


    public static void reportOutcome(int trumpVotes, int harrisVotes){
        System.out.println("\nTotal Electoral College Votes won:\n");
        System.out.printf("Trump: %d\n", trumpVotes);
        System.out.printf("Kamala: %d\n", harrisVotes);
        System.out.println();

        if (trumpVotes > harrisVotes){
            System.out.println("The next U.S. president is Donald Trump.");
        }else {
            System.out.println("The next U.S. president is Kamala Harris.");
        }
    }

    public static void reportBonusInformation(String path){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/joaovitor/Documents/Projects/Elections Simulator/src/" + path))) {
            String line;
            line = bufferedReader.readLine();

            String[] part = line.split(",");
            int electionYear = Integer.parseInt(part[0]);
            String firstCandidate = part[1];
            String secondCandidate = part[2];

            System.out.printf("*** This simulation is for the %d U.S. presidential election\n", electionYear);
            System.out.printf("*** between %s and %s.\n", firstCandidate, secondCandidate);

        } catch (IOException e) {
            System.out.println("Error with the file.");
        }
    }

}
