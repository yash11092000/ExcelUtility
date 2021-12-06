package Util;
import java.io.IOException;


class mythread extends Thread{
    public long finaltime1 = 0;
    @Override
    public void run() {
        long starttime = System.currentTimeMillis();
        FileReader obj;
        for (int i = 1; i <= 3; i++){
            String str = "Sample"+i+".txt";
            String str2 = "Changed"+i+".txt";
            obj = new FileReader("C:/Users/LENOVO/Desktop/Unprocessed/"+str, "C:/Users/LENOVO/Desktop/Processed/"+str2);
            obj.read();
        }
        long stoptime = System.currentTimeMillis();
        finaltime1 = stoptime-starttime;
        System.out.println("my Thread 1 finidhed at "+finaltime1);
    }
}

class mythread2 extends Thread{
    public long finaltime2 = 0;
    @Override
    public void run() {
        long starttime = System.currentTimeMillis();
        FileReader obj;
        for (int i = 4; i <= 6; i++){
            String str = "Sample"+i+".txt";
            String str2 = "Changed"+i+".txt";
            obj = new FileReader("C:/Users/LENOVO/Desktop/Unprocessed/"+str, "C:/Users/LENOVO/Desktop/Processed/"+str2);
            obj.read();
        }
        long stoptime = System.currentTimeMillis();
        finaltime2 = stoptime-starttime;
        System.out.println("my Thread 2 finidhed at "+finaltime2);
    }
}

class mythread3 extends Thread{
    public long finaltime3 = 0;
    @Override
    public void run() {
        long starttime = System.currentTimeMillis();
        FileReader obj;
        for (int i = 7; i <= 10; i++){
            String str = "Sample"+i+".txt";
            String str2 = "Changed"+i+".txt";
            obj = new FileReader("C:/Users/LENOVO/Desktop/Unprocessed/"+str, "C:/Users/LENOVO/Desktop/Processed/"+str2);
            obj.read();
        }
        long stoptime = System.currentTimeMillis();
        finaltime3 = stoptime-starttime;
        System.out.println("my Thread 3 finidhed at "+finaltime3);    }

}


public class Getdata extends FileReader{
    public void Dothesubstitute() throws IOException {
        Data();
        mythread t1 = new mythread();
        mythread2 t2 = new mythread2();
        mythread3 t3 = new mythread3();
        t1.start();
        t2.start();
        t3.start();
    }
    public void Dothesubstitute2() throws IOException {
        Data();
        for (int i = 1; i <= 10; i++){
            String str = "Sample"+i+".txt";
            String str2 = "Changed"+i+".txt";
            FileReader obj2 = new FileReader("C:/Users/LENOVO/Desktop/Unprocessed/"+str, "C:/Users/LENOVO/Desktop/Processed/"+str2);
            obj2.read();
        }
    }
    public void CreateCompareFile() throws IOException {
        Data();
        Data2();
        read2();
    }
    public void CompareFile(){
        Compare();
    }
}
