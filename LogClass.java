
/**
*@author Sahil Dogra
*
*/

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogClass implements Runnable {
        @Override
        public void run(){

            while(true){
                try {

                    File file = new File("C:/a.txt");
                    float store = file.length();
                    store = store/1024 ;
                    System.out.println("File length: " + store );

                    FileOutputStream out = new FileOutputStream("C:/b.txt", true);
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

                    System.out.println("At time: " + simpleDateFormat.format(date));

                    String temp = "At " + simpleDateFormat.format(date).toString() + ". The size of file is -> " + String.valueOf(store) + " KB \n";
                    byte[] log = temp.getBytes();

                    out.write(log);

                } catch(Exception ex) {
                    ex.printStackTrace();
                }

                try {
                    Thread.sleep(10000);         // To delay for 10 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        public static void main(String []args){
            Thread t = new Thread(new LogClass());
            t.start();
        }

    }
