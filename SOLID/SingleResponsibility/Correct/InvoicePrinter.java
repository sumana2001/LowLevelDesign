package SOLID.SingleResponsibility.Correct;

public class InvoicePrinter {
    
    public void printInvoice(){
        System.out.println("Printing Invoice: "+ Invoice.calculateTotal());
    }

    public static void main(String args[]){
        InvoicePrinter objIn = new InvoicePrinter();
        objIn.printInvoice();
    }
}


