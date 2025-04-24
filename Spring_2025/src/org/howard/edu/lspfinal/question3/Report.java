package org.howard.edu.lspfinal.question3;

public abstract class Report {
	public final void generateReport() {
		loadData();
		formatData();
		printReport();
		System.out.println();
	}
	
	public abstract void loadData();
	public abstract void formatData();
	public abstract void printReport();
}
