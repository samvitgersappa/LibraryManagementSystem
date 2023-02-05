import java.time.*;
import java.util.*;

public class Book {

    int slno;
    String name;
    boolean issued;

    LocalDate issueDate;

    LocalDate DueDate;
    static List<Book> books;



    Book(int slno,String name,boolean issued){
        this.name = name;
        this.issued = issued;
        this.slno = slno;

    }
     /*public void input(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Hello!, Welcome to the library management system:) ");
         System.out.print("Enter your Username: ");
         String name = sc.nextLine();
         System.out.print("Enter your password: ");
         String pass = sc.nextLine();

     }*/

    public static void clist(){
        books = new Vector<Book>();
        Book b = new Book(1,"Java: A Complete Reference", false);
        books.add(b);
        Book b1 = new Book(2,"The Art of Library Management",false);
        books.add(b1);
        Book b2 = new Book(3,"Mathematics for Machine Learning",false);
        books.add(b2);
        Book b3 = new Book(4,"Principles of Green Chemistry",false);
        books.add(b3);
        Book b4 = new Book(5,"English Grammar",false);
        books.add(b4);
        Book b5 = new Book(6,"The Complete Python Manual",false);
        books.add(b5);
        Book b6 = new Book(7,"Spiritual: The Quest for Enlightenment",false);
        books.add(b6);


    }

    public static void display(){
        List<String[]> table = new ArrayList<String[]>();
        String[] header = {"Sl. No.", "Book Title", "Status", "Issue Date","Due Date"};
        table.add(header);

        for(Book b: books) {
            String[] row = {Integer.toString(b.slno), b.name, b.issued ? "Issued": "Available", b.issueDate == null ? "Not issued yet" : b.issueDate.toString(),b.DueDate == null? "Not issued yet" : b.DueDate.toString()};
            table.add(row);
        }

        String[][] booksTable = new String[table.size()][];
        booksTable = table.toArray(booksTable);

        String format = "| %9s | %40s | %10s | %20s | %20s |\n";
        String line = "+-----------+------------------------------------------+------------+----------------------+----------------------+";

        System.out.println(line);
        for(int i = 0; i < booksTable.length; i++) {
            String[] s = booksTable[i];
            if (i == 1) {
                System.out.println(line);
            }
            System.out.printf(format.toString(), s);
        }
        System.out.println(line);



         /*
         for(Book i : books){
             System.out.print(i.slno+". "+i.name+"           ");
             String r = "\u001B[31m";
             String reset = "\u001B[0m";
             String available = i.issued ? "Issued": "Available";
             System.out.println(r + available + reset);
         }

          */
    }

    public static void issue(){
        Scanner issue = new Scanner(System.in);
        System.out.println("");
        System.out.print("Enter the slno of the book you want to issue: ");
        int inp = issue.nextInt();
        for(Book b : books) {
            if (b.slno == inp) {
                b.issued = true;
                b.issueDate = LocalDate.now();
                b.DueDate = b.issueDate.plusDays(14);
                System.out.println("");
                String c = "\u001B[33m";
                String reset = "\u001B[0m";
                System.out.println(  "YOU HAVE SUCCESSFULLY ISSUED THE BOOK - "+ c +b.name+ reset + ". YOU ARE SUPPOSED TO RETURN IT WITHIN 14 DAYS." );
                System.out.println("");
                System.out.println(c + "UPDATED BOOK INFORMATION: " + reset);
                System.out.println("");

            }
        }




    }

    public static void returnb(){

    }


    public static void main(String[] args) {


        Book.clist();
        Book.display();
        Book.issue();
        Book.display();



    }
}
