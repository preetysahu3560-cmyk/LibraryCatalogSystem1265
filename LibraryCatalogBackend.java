import java.util.ArrayList;
import java.util.Scanner;
class Book
{
    String id,title,author;

    Book(String id, String title, String author){
        this.id=id;
        this.title=title;
        this.author=author;
    }
    public String toString()
    {
        return "[" + id + "] " + title + "by" + author;
    }
}
public class LibraryCatalogBackend {
    private static ArrayList<Book> catalog=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args){
        int choice;
        do 
        {
            System.out.println("\n=== Library Catalog System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.err.println("3. Search Book by Title");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            choice= sc.nextInt();
            sc.nextLine(); 

            switch(choice) 
            {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> searchBook();
                case 4 -> System.out.println("Existing... Bye");
                default -> System.out.println("Invalid choice!");
             }
        }
        while (choice !=4);
     }
     private static void addBook() {
        System.out.println("Enter Book ID:");
        String id = sc.nextLine();
        System.out.println("Enter Book Title:");
        String title = sc.nextLine();
        System.out.println("Enter Author Name:");
        String author = sc.nextLine();
        catalog.add(new Book(id,title,author));
        System.out.println("Book Added Successfully!");
     }
     private static void viewBooks()
     {
        if (catalog.isEmpty()){
            System.out.println("No books in catalog!");
            return;
        }
        System.out.println("\n---All Books ---");
        for (Book b : catalog){
            System.out.println(b);
        }
     }
     private static void searchBook(){
      System.out.println("Enter Title to Search:");
     String search = sc.nextLine().toLowerCase();
      boolean found = false;
      for (Book b: catalog){
        if (b.title.toLowerCase().contains(search)){
            System.out.println("Found:" + b);
            found = true;
        }
      }
      if (!found)
      {
        System.out.println("No book found with title:");
      }
    }  
}