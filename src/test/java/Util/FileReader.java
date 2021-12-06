package Util;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    static HashMap<String,String> hm;
    static HashMap<String,String> hm2;
    static String ReadFile;
    static String WriteFile;
    public FileReader(String ReadFile,String WriteFile){
        this.ReadFile = ReadFile;
        this.WriteFile = WriteFile;

    }
    public FileReader(){

    }
    public static void read() {
        try {
            File input = new File(ReadFile);
            Scanner sc = new Scanner(input);
            FileWriter writer = new FileWriter(WriteFile);
            while (sc.hasNextLine()) {
                String str = sc.next();
                if (str=="\n"){
                    writer.write("\n");
                }
                if (hm.containsKey(str)) {
                    writer.write(hm.get(str) + " ");
                }
                else{
                    writer.write(str+" ");
                }

            }
            sc.close();
            writer.flush();
            writer.close();
            System.out.println("Writing Completed...");

        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found...! Check File Name Or directory");
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Something Went Wrong");
        }
    }

    public static void read2() {
        BufferedWriter out = null;
        try {
           File input = new File("C:/Users/LENOVO/Desktop/Processed/Changed1.txt");
            Scanner sc = new Scanner(input);
            out = new BufferedWriter(new FileWriter("C:/Users/LENOVO/Desktop/Reprocessed/Rechanged1.txt"));
            while (sc.hasNextLine()) {
                String str = sc.next();
                if (hm2.containsKey(str)){
                    String newstr = hm2.get(str);
                    out.write(newstr+" ");

                }
                else{
                    out.write(str+" ");
                }

            }
            System.out.println("Writing Completed...");

        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found...! Check File Name Or directory");
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e){
        }
        finally {
            if (out!=null){
                try {
                    out.close();
                    System.out.println("Writing Completed...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void Compare(){

        try {
            File input1 = new File("C:/Users/LENOVO/Desktop/Unprocessed/Sample1.txt");
            File input2 = new File("C:/Users/LENOVO/Desktop/Reprocessed/Rechanged1.txt");
            Scanner sc = new Scanner(input1);
            Scanner sc2 = new Scanner(input2);
            while (sc.hasNextLine()){
                String str1 = sc.next();
                String str2 = sc2.next();
                if (!str1.equals(str2)){
                    System.out.println(str1+" -- > "+str2);
                }
            }
            System.out.println("Done... Both File are Same");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            e.printStackTrace();
        }


    }

    public static void Data() throws IOException {
        ExcelReader obj = new ExcelReader("./Data/test.xlsx","Sheet1");
        hm = obj.GetDatas();

    }
    public static void Data2(){
        ExcelReader obj = new ExcelReader("./Data/test.xlsx","Sheet1");
        hm2 = obj.Convert();
    }

}
