package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
            "10,Why Joining So Late ?,Suraj Shanbhag,2016"
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
    private static void Checkout(){
        while(true){
            Boolean valid=false;
            System.out.format("%48s\n","CHECKOUT A BOOK");
            System.out.format("%s%24s%32s%45s","Book id","Name","Author","Year Of Publication\n");
            System.out.println("======================================================================================================================");

            for(Book b: available_list){
                System.out.format("%3s%32s%32s%32s\n",String.valueOf(b.getBook_id()),b.getTitle(),b.getAuthor(),b.getYear_published());
            }
            System.out.println("\nEnter The Book ID You Want To Check Out ---OR--- Enter 0 to Go Back!\n");
            Scanner checkout = new Scanner(System.in);
            while (!checkout.hasNextInt()) checkout.next();
            int checkout_choice = checkout.nextInt();
            if(checkout_choice!=0){
                for(Book b : available_list){
                    if(Integer.valueOf(b.getBook_id()).equals(checkout_choice)){
                        available_list.remove(b);
                        toReturn_list.add(b);
                        clear();
                        System.out.println("\t\t\t\t\tThank you! Enjoy the book\n\n\n\n\n");
                        sleepFor2sec();
                        valid=true;
                        break;
                    }
                }
                if(!valid){
                    clear();
                    System.out.println("\t\t\t\t\tThat book is not available.\n\n\n\n\n");
                    sleepFor2sec();
                }
            }else{
                return;
            }
        }
    }
    private static void Return(){
        while(true){
            clear();
            Boolean valid=false;
            System.out.format("%48s\n","BOOKS YET TO RETURN");
            System.out.format("%s%24s%32s%45s","Book id","Name","Author","Year Of Publication\n");
            System.out.println("======================================================================================================================");
            for(Book b: toReturn_list){
                System.out.format("%3s%32s%32s%32s\n",String.valueOf(b.getBook_id()),b.getTitle(),b.getAuthor(),b.getYear_published());
            }
            System.out.println("\nEnter The Book ID You Want To Return ---OR--- Enter 0 to Go Back!\n");
            Scanner ret_scan=new Scanner(System.in);
            while (!ret_scan.hasNextInt()) ret_scan.next();
            int return_choice = ret_scan.nextInt();
            if(return_choice!=0){
                for(Book b : toReturn_list){
                    if(Integer.valueOf(b.getBook_id()).equals(return_choice)){
                        available_list.add(b);
                        toReturn_list.remove(b);
                        clear();
                        System.out.println("\t\t\t\t\tThank you for returning the book.\n\n\n\n\n");
                        sleepFor2sec();
                        valid=true;
                        break;
                    }
                }
                if(!valid){
                    clear();
                    System.out.println("\t\t\t\t\tThat is not a valid book to return.\n\n\n\n\n");
                    sleepFor2sec();
                }
            }else{
                return;
            }
        }
    }
    public static void clear(){
        //Used this way of clearing as the other ways dont work in IDEA console(As much i know!)
        for(int i=0;i<200;i++){
            System.out.println("");
        }
    }
    public static void ViewList(){
        while(true){
            clear();
            System.out.format("%48s\n","BOOK LIST");
            System.out.format("%s%24s%32s%45s","Book id","Name","Author","Year Of Publication\n");
            System.out.println("======================================================================================================================");
            for(Book b: available_list){
                System.out.format("%3s%32s%32s%32s\n",String.valueOf(b.getBook_id()),b.getTitle(),b.getAuthor(),b.getYear_published());
            }
            System.out.println("Enter 0 to Go Back!\n");
            Scanner ret_scan=new Scanner(System.in);
            while (!ret_scan.hasNextInt()) ret_scan.next();
            int return_choice = ret_scan.nextInt();
            if(return_choice==0){
                return;
            }
        }

    }
    private static void sleepFor2sec(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            //Handle exception
        }
    }
    public static void main(String[] args) {
        LibrarySetup();
        System.out.println("Welcome to The Bangalore Public Library");
        while(true){
            clear();
            System.out.println("1: View Available Books \n2: Checkout a Book \n3: Return a Book\n4: Exit");
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.print("Enter Your Choice: \n");
            while (!reader.hasNextInt()) reader.next();
            int choice = reader.nextInt();
            switch (choice){
                case 1:
                    ViewList();
                    break;
                case 2:
                    clear();
                    Checkout();
                    break;
                case 3:
                    clear();
                    Return();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    clear();
                    System.out.print("\t\t\t\t\tEnter a Valid Choice!!\n\n\n\n\n");
                    sleepFor2sec();
            }
        }
    }
}
