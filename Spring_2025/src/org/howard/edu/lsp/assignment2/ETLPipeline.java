package org.howard.edu.lsp.assignment2;
import java.io.*;
import java.util.Scanner;
public class ETLPipeline  {  
    public static void main(String[] args) throws Exception  {  
        Scanner sc = new Scanner(new File("data/products.csv"));
        sc.useDelimiter(",");
        while (sc.hasNext())  {  
            System.out.print(sc.next());
        }
    sc.close();
    }
} // code taken from https://www.javatpoint.com/how-to-read-csv-file-in-java and slightly edited to read products.csv