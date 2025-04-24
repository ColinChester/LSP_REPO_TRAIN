package org.howard.edu.lspfinal.question3;

public class SalesReport extends Report {
    @Override
    public void loadData() {
        System.out.println("Loading sales data...");
    }

    @Override
    public void formatData() {
        System.out.println("Formatting sales data...");
    }

    @Override
    public void printReport() {
        System.out.println("Printing sales report.");
    }
}
