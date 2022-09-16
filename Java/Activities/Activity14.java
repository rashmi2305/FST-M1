package Activities;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class Activity14 {
    public static void main(String[] args) throws IOException{
        try{
            File file = new File("C:\\IBM FST Projects\\FST_Java\\TestFile.txt");
            boolean fStatus = file.createNewFile();         //To create n new file
            if(fStatus){
                System.out.println("File created successfully!");
            }
            //Write some text to file
            FileWriter myWriter = new FileWriter("C:\\IBM FST Projects\\FST_Java\\TestFile.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            ////get the file Object
            //File fileUtil = FileUtils.getFile("C:\\IBM FST Projects\\FST_Java\\TestFile.txt");
            ////Read file
            //System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
            //Create directory
            File destDir = new File("C:\\IBM FST Projects\\FST_Java\\destFilePath");
            //Copy file to directory
            FileUtils.copyFileToDirectory(file, destDir);
            //Get file from new directory
            File newFile = FileUtils.getFile(destDir, "newfile.txt");
            //Read data from file
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            //Print it
            System.out.println("Data in new file: " + newFileData);
        }catch(IOException errMessage) {
            System.out.println(errMessage);
        }
    }
}
