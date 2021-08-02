/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;
/*import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
public class ReadDataFromExl {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
   public ReadDataFromExl()
   {
     conn = DbConnection1.ConnectDb();
   }
public static void main(String[] args) {
  
        String excelFilePath = "D:\\Demo\\student.xls";
 
        int batchSize = 20;
 
        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
            pst = conn.prepareStatement("INSERT INTO read_data_exel(name, age, height) VALUES (?,?,?)");    
            rs=pst.executeQuery();
             
            int count = 0;
             
            rowIterator.next(); // skip the header row
             
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
 
                    int columnIndex = nextCell.getColumnIndex();
 
                    switch (columnIndex) {
                    case 0:
                        String name = nextCell.getStringCellValue();
                        pst.setString(1, name);
                        break;
                    case 1:
                        int age = (int)nextCell.getNumericCellValue();
                        pst.setInt(2,age);
                    case 2:
                        int progress = (int) nextCell.getNumericCellValue();
                        pst.setInt(3, progress);
                    }
 
                }
                 
                pst.addBatch();
                 
                if (count % batchSize == 0) {
                    pst.executeBatch();
                }              
 
            }
 
            workbook.close();
             
            // execute the remaining queries
            pst.executeBatch();
  
            conn.commit();
            conn.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
             
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
 
    }
}
*/
