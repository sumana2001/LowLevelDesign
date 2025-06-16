package SOLID.SingleResponsibility.Correct;

public class InvoiceDao {
    public static void saveToDB(){
        InvoicePrinter printer=new InvoicePrinter();
        printer.printInvoice();
        System.out.println("Saving to database");
    }
}
