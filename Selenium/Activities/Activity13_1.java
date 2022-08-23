import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity13_1 {
    public static void main(String[] args) throws IOException, CsvException{
        String FileName = "src/main/resources/Activity13_1.csv";
        //Create an object for the OpenCSV Class with the file path of the CSV as its parameter.
        //Load CSV file
        CSVReader reader = new CSVReader(new FileReader(FileName));
        //Use the readAll() method to read the contents of the CSV file.
        List<String[]> list = reader.readAll();
        //Use the size() method to count the number of rows in the CSV file.
        System.out.println("Rows in csv file is: "+list.size());
        //Create an iterator to iterate through the list and print all the rows of the file.
        Iterator<String[]> itr = list.iterator();
        while(itr.hasNext()){
            String[] str = itr.next();
            System.out.print("Values are: ");
            for(int i = 0;i<str.length;i++){
                System.out.print(" " + str[i]);
            }
            System.out.println(" ");
        }
        reader.close();
    }
}
