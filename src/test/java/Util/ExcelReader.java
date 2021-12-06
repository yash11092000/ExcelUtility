package Util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ExcelReader {

        static XSSFWorkbook workbook;
        static XSSFSheet sheet;
        static String ExcelPath;
        static ArrayList<String> list = new ArrayList<>();
        static HashMap<String,String> hm = new HashMap<>();
        static HashMap<String,String> hm2 = new HashMap<>();

        public ExcelReader(String excelPath,String SheetName) {

            try {
                ExcelPath = excelPath;
                workbook = new XSSFWorkbook(excelPath);
                sheet = workbook.getSheet(SheetName);
            }
            catch(Exception e){
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }



//    public static void getRowCount(){
////        String projdir = System.getProperty("user.dir");
////        System.out.println(projdir);
//        try {
////            String excelpath = "./Data/test.xlsx";
////            workbook = new XSSFWorkbook(excelpath);
////             sheet = workbook.getSheet("Sheet1");
//            int rowcount = sheet.getPhysicalNumberOfRows();
//            System.out.println("No of Rows are " + rowcount);
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//    }
//    public static void getCellData(){
//
//        try {
////            String excelpath = "./Data/test.xlsx";
////            XSSFWorkbook workbook = new XSSFWorkbook(excelpath);
//            DataFormatter dataFormatter = new DataFormatter();
//            Iterator<Sheet> sheets = workbook.sheetIterator();
//            while (sheets.hasNext()){
//                Sheet sh = sheets.next();
//                System.out.println("sheet name is "+sh.getSheetName());
//                System.out.println("------------");
//                Iterator<Row> iterator = sh.iterator();
//                while (iterator.hasNext()){
//                    Row row = iterator.next();
//                    Iterator<Cell> cellIterator = row.iterator();
//                    while (cellIterator.hasNext()){
//                        Cell cell = cellIterator.next();
//                        String cellvalue = dataFormatter.formatCellValue(cell);
//                        System.out.println(cellvalue+"\t");
//                        list.add(cellvalue);
//                    }
//                    System.out.println();
//                }
//                workbook.close();
//            }
////            XSSFSheet sheet = workbook.getSheet("Sheet1");
////            String value = sheet.getRow(1).getCell(0).getStringCellValue();
////            System.out.println(value);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    public static HashMap<String,String> GetDatas() throws IOException{
        FileInputStream inputStream = new FileInputStream(ExcelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        int row = sheet.getLastRowNum();
        int col = sheet.getRow(1).getLastCellNum();
        for (int i=1;i<=row;i++){
            XSSFRow rowobj = sheet.getRow(i);
            for (int j=0;j<col;j++){
                XSSFCell colobj = rowobj.getCell(j);
//                System.out.print(colobj.getStringCellValue()+"  ");
                list.add(colobj.getStringCellValue());
            }
//            System.out.println();
        }
//        System.out.println(list);
        for (int i=0;i<list.size();i+=2){
            hm.put(list.get(i),list.get(i+1));
        }
        return hm;

    }

    public static HashMap<String,String> Convert(){
            for (int i=list.size()-1;i>=0;i-=2){
                hm2.put(list.get(i),list.get(i-1));
            }
            return hm2;
    }

}
