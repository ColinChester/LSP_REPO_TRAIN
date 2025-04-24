package org.howard.edu.lspfinal.question3;

public class InventoryReport extends Report {
    @Override
    public void loadData() {
        System.out.println("Loading inventory data...");
    }

    @Override
    public void formatData() {
        System.out.println("Formatting inventory data...");
    }

    @Override
    public void printReport() {
        System.out.println("Printing inventory report.");
    }
}
