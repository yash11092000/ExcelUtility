package Util;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {

//        Steps to Do
//        1>Create Object of GetData Class and Call Dothesubstitue() method
//        2>call the CreateCompareFile to create Reprocessed text file from processed File
//        3>call the CompareFile method to compare Unprocessed and Reprocessed
//

        Getdata obj = new Getdata();
        obj.Dothesubstitute2();
        obj.CreateCompareFile();
        obj.CompareFile();
    }
}
