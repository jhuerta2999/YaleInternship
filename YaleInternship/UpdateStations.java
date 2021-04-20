import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

class UpdateStations{

    public static void main(String[] args){

        File current = new File(args[0]);
        File changes = new File(args[1]);
        Scanner scanCurrent = null;
        Scanner scanChanges = null;
        PrintStream write = null;

        try{
            scanCurrent = new Scanner(current);
            scanChanges = new Scanner(changes);
            write = new PrintStream("updatedAffiliates.txt");
        }
        catch(FileNotFoundException fnf){
            System.out.println("File not found!");
            System.exit(1);
        }
        
        String readCurrent = scanCurrent.nextLine();
        String readChanges = scanChanges.nextLine();
        Scanner searchCurrent = new Scanner(readCurrent);
        Scanner searchChanges = new Scanner(readChanges);

        int rows = 3000;
        int cols = 38;
        String[][] table = new String[rows][cols];
        
        int rowAcc = 0;
        int currentAcc = 0;
        int changeAcc = 0;

        readCurrent = scanCurrent.nextLine();
        readChanges = scanChanges.nextLine();

        while(!(readChanges.contains("Changes:"))){
            
        }

        while(scanCurrent.hasNext()){

            String[] splitCurrent = readCurrent.split("\t");
           //System.out.println((splitPost[0]) + " - post");
            currentAcc++;
            int currentLength = splitCurrent.length;

            while(scanChanges.hasNext()){
                readChanges = scanChanges.nextLine();

                String[] splitChanges = readChanges.split("\t");
                //System.out.println((splitChanges[0]) + " - fb");
                changesAcc++;
                int changesLength = splitChanges.length;
                
                if(splitCurrent[0].equals(splitChanges[0])){
                    rowAcc++;
                    for(int i = 0; i < currentLength; i++){
                        table[postAcc][i] = splitFB[i];
                        System.out.println(table[postAcc][i]);
                    }
                }
                System.out.println(fbAcc);

                //System.out.println(readFBLine);
            }
            readPostLine = scanPostFile.nextLine();
            //System.out.println(readPostLine);

        }
       System.out.println(postAcc);

        
        table[0][0] = "Script ID" + "\t" + "\t" + "\t";
        table[0][1] = "\t" + "Title"+ "\t" + "\t";
        table[0][2] = "\t" + "Air Date" + "\t" ;
        table[0][3] = "Originator" + "\t" + "\t";
       
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                write.print(table[i][j]);
                write.print("\t");
            }
            write.print("\n");
        }
    }
}
