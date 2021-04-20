import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

class ExtractFbPost{

    public static void main(String[] args){
 
        File f = new File(args[0]);
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

        int rows = 2000;
        int cols = 1;
        String[][] table = new String[rows][cols];
        
        int rowAcc = 0;
        while(scan.hasNext()){
            line = scan.nextLine();

            if(line.contains("/")){
                rowAcc++;
                String[] id = line.split("/");
                int length = id.length;
                table[rowAcc][0] = "130268756992804_" + id[length-1];
            }
        }
        
        table[0][0] = "Post ID" + "\t" + "\t" + "\t";
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                write.print(table[i][j]);
                write.print("\t");
            }
            write.print("\n");
        }
    }
}
