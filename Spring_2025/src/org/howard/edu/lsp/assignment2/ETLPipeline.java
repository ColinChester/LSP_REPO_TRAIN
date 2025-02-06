package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLPipeline {
	
	public static List<String> readFile(File f) { // I repurposed the ReadFile class from https://www.w3schools.com/java/java_files_read.asp
		List<String> orders = new ArrayList<>();
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.isEmpty()) {
					orders.add(" ");
					continue;
				}
				String[] lineList = line.split(",");
				if (lineList[0].equals("ProductID")) {
					continue;
				}
				for (String s: lineList) {
					orders.add(s);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
			e.printStackTrace();
		}
		
		return orders;
	}
	
	public static void applyDiscount(List<String> orders) {
		double tempCost = 0;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).equals("Electronics")) {
				tempCost = Double.parseDouble(orders.get(i - 1));
				tempCost = tempCost - (tempCost * 0.1);
				orders.set(i - 1, String.format("%.2f", tempCost));
			}
		}
	}
	
	public static void productUpper(List<String> orders) {
		String tempName = "";
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).contains(".")) {
				tempName = orders.get(i - 1);
				tempName = tempName.toUpperCase();
				orders.set(i - 1, tempName);
			}
		}
	}
	
	public static void premiumElectronics(List<String> orders) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).equals("Electronics") && (Double.parseDouble(orders.get(i - 1))) > 500) {
				orders.set(i, "Premium Electronics");
			}
		}
	}
	
	public static void priceRange(List<String> orders) {
		for (int i = orders.size() - 1; i >= 0; i--) {
			if (orders.get(i).contains(".") && Double.parseDouble(orders.get(i)) < 10) {
				orders.add(i + 2, "Low");
			} else if (orders.get(i).contains(".") && Double.parseDouble(orders.get(i)) > 10.01 && Double.parseDouble(orders.get(i)) < 100) {
				orders.add(i + 2, "Medium");
			} else if (orders.get(i).contains(".") && Double.parseDouble(orders.get(i)) > 100.01 && Double.parseDouble(orders.get(i)) < 500) {
				orders.add(i + 2, "High");
			} else if (orders.get(i).contains(".") && Double.parseDouble(orders.get(i)) > 500){
				orders.add(i + 2, "Premium");
			}
		}
	}
	
	public static void writeOutput(List<String> orders) {// Implementation as described by Naveen Metta at https://www.quora.com/How-can-data-be-written-in-a-CSV-file-using-Java
	    File output = new File("../../../../../../data/output.csv");
	    try {
	        FileWriter outputWriter = new FileWriter(output);
	        outputWriter.write("ProductID,Name,Price,Category,PriceRange\n");
	        int count = 0;
	        for (int i = 0; i < orders.size(); i++) {
	            if (orders.get(i).equals(" ")) {
	                outputWriter.write("\n");
	                count = 0;
	            } else {
	                outputWriter.write(orders.get(i));
	                count++;
	                if (count % 5 == 0) {
	                    outputWriter.write("\n");
	                    count = 0;
	                } else {
	                    outputWriter.write(",");
	                }
	            }
	        }
	        if (count % 5 != 0) {
	            outputWriter.write("\n");
	        }
	        outputWriter.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		File orders = new File("../../../../../../data/products.csv");
		List<String> temp = readFile(orders);
		applyDiscount(temp);
		productUpper(temp);
		premiumElectronics(temp);
		priceRange(temp);
		writeOutput(temp);
	}
}