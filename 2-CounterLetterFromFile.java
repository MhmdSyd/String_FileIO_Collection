import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCountChar{
    private String file;
    private char letter;
    //constructor that init value of search character and file location and name.
    FileCountChar(char letter,String file){
        this.letter = letter;
        this.file = file;

    }
    //Method that take file and letter and count how many times that letter repeated.
    public int count() {
        //declarate input file.
        // BufferedReader in = null;
        //definition that declare and init count value by zero.
        int count = 0;
        // use string that read line from file and store it in line string.
        String line;

        // try to open file.
        try (BufferedReader in = new BufferedReader(new FileReader(this.file)))
        {
           
            // in = new BufferedReader(new FileReader(this.file));
            // read line from file and check if it empty line or not.
            while ((line = in.readLine()) != null){
                //loop for line string by char.
                for(char i:line.toString().toCharArray()){
                    //check if letter = char to increase count.
                    if(letter == i){
                        count++;
                    }
                }
            }

        }catch (IOException x) {
            System.err.println(x);
        }
        // return how many times that letter repeat in file to main method.
        return count;
    }


    //Main Method
    public static void main(String[] args){
        
        if(args.length != 1 || args[0].length() != 1) {
            System.out.println("invalid input Value: 'You should input letter to search' ");

        }else {
            int count = new FileCountChar(args[0].charAt(0), "Xanadu.txt").count();
            System.out.printf("Letter %s repeat %d times\n",args[0].charAt(0), count);
        }

    }
}