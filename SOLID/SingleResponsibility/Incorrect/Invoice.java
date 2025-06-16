package SOLID.SingleResponsibility.Incorrect;

public class Invoice {
    public int calculateTotal(){
        int total=20;
        return total;
    }

    public void printInvoice(){
        System.out.println("Printing Invoice"+calculateTotal());
    }

    public void saveToDB(){
        printInvoice();
        System.out.println("Saving to database");
    }
}
