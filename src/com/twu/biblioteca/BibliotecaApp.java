package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public static String[] book_list={
            "1,Life of Pi,Yann Martel,2012",
            "2,Fellowship of the Ring,J. R. R. Tolkien,2010",
            "3,Two Towers,J. R. R. Tolkien,2011",
            "4,Dune,Frank Herbert,2007",
            "5,The Hobbit,J. R. R. Tolkien,2014",
            "6,1984,George Orwell,1984",
            "7,Tom Sawyer,Mark Twain,1876",
            "8,Catcher in the Rye,J D Salinger,1951",
            "9,To Kill a Mockingbird,Kathryn Erskine,2000",
            "10,Domain Driven Design,Eric J. Evans,2007"
    };
    public static ArrayList<Book> available_list=new ArrayList<Book>();
    public static ArrayList<Book> toReturn_list=new ArrayList<Book>();

    private static void LibrarySetup(){
        for(String book: book_list){
            String[] details=book.split(",");
            Book newBook=new Book(Integer.valueOf(details[0]),details[1],details[2],details[3]);
            available_list.add(newBook);
        }
    }
    public static void main(String[] args) {
        LibrarySetup();
        while(true){
            System.out.println("1: View Available Books \n2: Checkout a Book \n3: Return a Book\n4: Exit");
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.print("Enter Your Choice: ");
            int choice = reader.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Book id , Name,Author , Year Of Publication");
                    for(Book b: available_list){
                        System.out.println(String.valueOf(b.getBook_id())+" , "+b.getTitle()+" , "+b.getAuthor()+" , "+b.getYear_published());
                    }
                    break;
                case 2:
                    System.out.println("Book id , Name , Author , Year Of Publication");
                    for(Book b: available_list){
                        System.out.println(String.valueOf(b.getBook_id())+" , "+b.getTitle()+" , "+b.getAuthor()+" , "+b.getYear_published());
                    }
                    System.out.println("Enter The Book ID You Want To Check Out");
                    Scanner checkout = new Scanner(System.in);
                    int checkout_choice = checkout.nextInt();
                    for(Book b : available_list){
                        if(Integer.valueOf(b.getBook_id()).equals(checkout_choice)){
                            available_list.remove(b);
                            toReturn_list.add(b);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
