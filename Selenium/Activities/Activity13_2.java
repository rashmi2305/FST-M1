//'In this activity, we use POI to write to an Excel file.'
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity13_2 {
    //In the class, create three methods
    //Method To write to the Excel file: writeExcel(String filePath)
    public void writeExcel(String filePath) throws IOException, NullPointerException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet13_2a");
        //Creating data
        List<String[]> data = new ArrayList<String[]>();
        String[] heading = {"ID", "First Name", "Last Name", "Email", "Ph.No."};
        String[] row1 = {"1", "Satvik", "Shah", "satshah@example.com", "4537829158"};
        String[] row2 = {"2", "Avinash", "Kati", "avinashK@example.com", "4892184058"};
        String[] row3 = {"3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830"};
        //Add it to the List
        data.add(heading);
        data.add(row1);
        data.add(row2);
        data.add(row3);
        //Iterate over data form the list and write to the sheet
        int rownum = 0;
        for (String[] rowdata: data){
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            for(String celldata: rowdata){
                //Cell cell = sheet.getRow(rownum++).createCell(cellnum++);
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue(String.valueOf(celldata));
            }
        }
        //In a try block, add FileOutputStream to write the data to the Excel sheet.
        //Finally, close the output stream and the workbook.
        try {
            //FileOutputStream out = new FileOutputStream(new File(filePath));
            FileOutputStream out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();
            workbook.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //Method To read from the Excel file: readExcel(String filePath)
    public void readExcel(String filePath){
        try{
            //Open a FileInputStream with the filePath to read data from Excel sheet.
            FileInputStream in = new FileInputStream(filePath);
            //Create XSSFWorkbook and XSSFSheet objects.
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Create an iterator that will loop through each row:
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + " \t ");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + " \t ");
                            break;
                        default:
                            System.out.println("Invalid value");
                            break;
                    }
                }
                System.out.println("");
            }
            in.close();
            workbook.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //Main method: public static void main(String args[])
    public static void main(String[] args) throws IOException{
        //Create a String variable to save the file path.
        String filePath = "src/main/resources/sample13_2a.xlsx";
        //If the methods are not static, create an object for the class and use it to call the readExcel() and writeExcel() methods.
        Activity13_2 objExcel = new Activity13_2();         //to call the in build classes - //Create an object of current class
        objExcel.writeExcel(filePath);
        objExcel.readExcel(filePath);
    }
}
