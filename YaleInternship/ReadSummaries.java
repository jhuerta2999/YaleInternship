import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

class ReadSummaries{

    public static void main(String[] args){
        
        File f = new File(args[0]); //This signifies that a text document will have to be enetered with the code when running it
        Scanner scan = null;
        PrintStream write = null;

        try{
            scan = new Scanner(f);
            write = new PrintStream("extracted"+args[0]);
        }
        catch(FileNotFoundException fnf){
            System.out.println("File not found!");
            System.exit(1);
        }
        
        String line = scan.nextLine();
        Scanner searchInfo = new Scanner(line);

        int rows = 21; //Number of rows that we want on our table, if there are more than 20 stories you will have to increse the the size of rows
        int cols = 22; // Number of columns that we want in our table if more headers or added or if some taken out this number will have to change 
        String[][] table = new String[rows][cols];
            
        int rowAcc = 0;

        //This is the process of reading the whole text file that is given to the code to read
        while(scan.hasNext() && rowAcc < 22){
            line = scan.nextLine();
            String[] info = line.split("\t"); //seperaates the lines by tabs 
            int size = info.length;

            for(int i = 0; i < size; i++){

                if(info[i].contains("CX")){
                    rowAcc++;
                    table[rowAcc][21] = info[i]; //Where the file id is being added to
                }

                else if(info[i].contains(":")){
                    String[] SubTitle = line.split(":");
                    int length = SubTitle.length;

                    //Depending on format of the doc it will take either of these paths but will still be added to the same spot
                    if(size > 2){
                        table[rowAcc][7] = SubTitle[length - 1];
                    }
                    else{
                        table[rowAcc][7] = SubTitle[1];
                    }
                }
            }
        }
        
        //This is where the headers for the table is created
        table[0][0] = "Carto ID" + "\t" + "\t";
        table[0][1] = "Geom"+ "\t" + "\t";
        table[0][2] = "Link" + "\t" + "\t";
        table[0][3] = "Originator" + "\t" + "\t";
        table[0][4] = "fid" + "\t" + "\t";
        table[0][5] = "URL" + "\t" + "\t";
        table[0][6] = "Title" + "\t" + "\t";
        table[0][7] = "SubTitle" + "\t" + "\t";
        table[0][8] = "Location" + "\t" + "\t";
        table[0][9] = "Detail" + "\t" + "\t";
        table[0][10] = "Lat" + "\t" + "\t";
        table[0][11] = "Long" + "\t" + "\t";
        table[0][12] = "Air Date" + "\t" + "\t";
        table[0][13] = "audio" + "\t" + "\t";
        table[0][14] = "Country" + "\t" + "\t";
        table[0][15] = "State" + "\t" + "\t";
        table[0][16] = "City" + "\t" + "\t";
        table[0][17] = "County" + "\t" + "\t";
        table[0][18] = "Street" + "\t" + "\t";
        table[0][19] = "Zip" + "\t" + "\t";
        table[0][20] = "Script ID" + "\t" + "\t";
        table[0][21] = "File Id" + "\t" + "\t";

        //This is the procces in where the program reads the table and writes a new document 
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                 write.print(table[i][j]);
                 write.print("\t");
            }
            write.println();
        }
    }
}

