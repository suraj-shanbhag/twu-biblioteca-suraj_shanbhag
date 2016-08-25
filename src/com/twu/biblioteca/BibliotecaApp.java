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
    public static String[] movie_list={
            "1,Life Of Brain,Donald Frost,2005,7",
            "2,Airplane,Katherine Cumburtin,2011,8",
            "3,The Pestige,Christopher Nolan,2006,9",
            "4,World War Z,David Cross,2012,6",
            "5,Kingsman Secret Service,Fred Robertson,2010,7"
    };
    public static String[] member_list={
            "1q2-qw3e,Mauro Hunt,maurohunt@hotmail.com,Wall street,65372651,hunt123",
            "2e4-ve5w,Scott Jain,scottjain@gmail.com,Car Street,87386328,jain123",
            "3g5-vi6n,Alok Carmack,alokcarmak@yahoomail.com,Baker Street,67382622,carmack123",
            "4j7-yy9d,Billy Knuth,billyknuth@redifmail.com,Donut Market,34622626,knuth123",
            "5i9-ra1s,Tanuj Schneider,tanujschneider@gmail.com,Luna Bay,98726278,schneider123"
    };
    public static ArrayList<Book> available_list=new ArrayList<Book>();
    public static ArrayList<Book> toReturn_list=new ArrayList<Book>();
    public static ArrayList<Movie> available_movie_list=new ArrayList<Movie>();
    public static ArrayList<Movie> to_return_movie_list=new ArrayList<Movie>();
    public static ArrayList<Member> memberArrayList=new ArrayList<Member>();

    private static void LibrarySetup(){
        for(String book: book_list){
            String[] details=book.split(",");
            Book newBook=new Book(Integer.valueOf(details[0]),details[1],details[2],details[3]);
            available_list.add(newBook);
        }
    }
    private static void MovieSetup(){
        for(String movie: movie_list){
            String[] details=movie.split(",");
            Movie newMovie=new Movie(Integer.valueOf(details[0]),details[1],details[2],details[3],details[4]);
            available_movie_list.add(newMovie);
        }
    }
    private static void MemberSetup(){
        for(String member: member_list){
            String[] details=member.split(",");
            Member newMember=new Member(details[0],details[1],details[2],details[3],details[4],details[5]);
            memberArrayList.add(newMember);
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
    public static boolean MemberValidation(String user,String password){
        for(Member m:memberArrayList){
            if((user.equals(m.getMember_id()))&&(password.equals(m.getPassword()))){
                clear();
                System.out.format("%s%32s%32s%32s\n","Name","Email","Address","Phone Number");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("%s%32s%32s%32s\n",m.getName(),m.getEmail(),m.getAddress(),m.getPhone_number());
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                return true;
            }
        }
        return false;
    }

    public static void Books(){
        while(true){
            clear();
            System.out.println("1: View Available Books \n2: Checkout a Book \n3: Return a Book\n4: Go Back");
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
                    clear();
                    return;
                default:
                    clear();
                    System.out.print("\t\t\t\t\tEnter a Valid Choice!!\n\n\n\n\n");
                    sleepFor2sec();
            }
        }
    }

    public static void ViewMovieList(){
        while(true){
            clear();
            System.out.format("%48s\n","MOVIE LIST");
            System.out.format("%s%24s%32s%45s%20s","Movie id","Title","Director","Year Of Release","Rating\n");
            System.out.println("===========================================================================================================================================================");
            for(Movie m: available_movie_list){
                System.out.format("%3s%32s%32s%32s%30s\n",String.valueOf(m.getMovie_id()),m.getTitle(),m.getDirector(),m.getYear(),m.getRating());
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
    public static void CheckoutMovie(){
        while(true){
            Boolean valid=false;
            System.out.format("%48s\n","CHECKOUT A MOVIE");
            System.out.format("%s%24s%32s%45s%20s","Movie id","Title","Director","Year Of Release","Rating\n");
            System.out.println("====================================================================================================================================================");
            for(Movie m: available_movie_list){
                System.out.format("%3s%32s%32s%32s%30s\n",String.valueOf(m.getMovie_id()),m.getTitle(),m.getDirector(),m.getYear(),m.getRating());
            }
            System.out.println("\nEnter The Movie ID You Want To Check Out ---OR--- Enter 0 to Go Back!\n");
            Scanner checkout = new Scanner(System.in);
            while (!checkout.hasNextInt()) checkout.next();
            int checkout_choice = checkout.nextInt();
            if(checkout_choice!=0){
                for(Movie m : available_movie_list){
                    if(Integer.valueOf(m.getMovie_id()).equals(checkout_choice)){
                        available_movie_list.remove(m);
                        to_return_movie_list.add(m);
                        clear();
                        System.out.println("\t\t\t\t\tThank you! Enjoy the Movie\n\n\n\n\n");
                        sleepFor2sec();
                        valid=true;
                        break;
                    }
                }
                if(!valid){
                    clear();
                    System.out.println("\t\t\t\t\tThat Movie is not available.\n\n\n\n\n");
                    sleepFor2sec();
                }
            }else{
                return;
            }
        }
    }
    public static void ReturnMovie(){
        while(true){
            clear();
            Boolean valid=false;
            System.out.format("%48s\n","MOVIES YET TO RETURN");
            System.out.format("%s%24s%32s%45s%20s","Movie id","Title","Director","Year Of Release","Rating\n");
            System.out.println("===========================================================================================================================================================");
            for(Movie m: to_return_movie_list){
                System.out.format("%3s%32s%32s%32s%30s\n",String.valueOf(m.getMovie_id()),m.getTitle(),m.getDirector(),m.getYear(),m.getRating());
            }
            System.out.println("\nEnter The Movie ID You Want To Return ---OR--- Enter 0 to Go Back!\n");
            Scanner ret_scan=new Scanner(System.in);
            while (!ret_scan.hasNextInt()) ret_scan.next();
            int return_choice = ret_scan.nextInt();
            if(return_choice!=0){
                for(Movie m : to_return_movie_list){
                    if(Integer.valueOf(m.getMovie_id()).equals(return_choice)){
                        available_movie_list.add(m);
                        to_return_movie_list.remove(m);
                        clear();
                        System.out.println("\t\t\t\t\tThank you for returning the movie.\n\n\n\n\n");
                        sleepFor2sec();
                        valid=true;
                        break;
                    }
                }
                if(!valid){
                    clear();
                    System.out.println("\t\t\t\t\tThat is not a valid Movie to return.\n\n\n\n\n");
                    sleepFor2sec();
                }
            }else{
                return;
            }
        }
    }
    public static void Movies(){
        while(true){
            clear();
            System.out.println("1: View Available Movies \n2: Checkout a Movie \n3: Return a Movie\n4: Go Back");
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.print("Enter Your Choice: \n");
            while (!reader.hasNextInt()) reader.next();
            int choice = reader.nextInt();
            switch (choice){
                case 1:
                    ViewMovieList();
                    break;
                case 2:
                    clear();
                    CheckoutMovie();
                    break;
                case 3:
                    clear();
                    ReturnMovie();
                    break;
                case 4:
                    clear();
                    return;
                default:
                    clear();
                    System.out.print("\t\t\t\t\tEnter a Valid Choice!!\n\n\n\n\n");
                    sleepFor2sec();
            }
        }
    }

    public static void main(String[] args) {
        LibrarySetup();
        MovieSetup();
        MemberSetup();
        System.out.println("Welcome to The Bangalore Public Library\n\n");
        while(true){
            System.out.println("Enter User Credentials\n");
            System.out.print("User id:");
            Scanner user_id = new Scanner(System.in);
            String user=user_id.next();
            System.out.print("Password:");
            Scanner pass_scn = new Scanner(System.in);
            String password=pass_scn.next();
            if(MemberValidation(user,password)){
                while(true){
                    System.out.println("Which one of these are you intrested in ?\n1: Books\n2: Movies\n3: Exit");
                    Scanner interest=new Scanner(System.in);
                    while (!interest.hasNextInt()) interest.next();
                    int interest_choice=interest.nextInt();
                    switch (interest_choice){
                        case 1:
                            Books();
                            break;
                        case 2:
                            Movies();
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            clear();
                            System.out.print("\t\t\t\t\tEnter a Valid Choice!!\n\n\n\n\n");
                            sleepFor2sec();
                    }
                }
            }else {
                clear();
                System.out.println("\t\t\t\t\t\t\tIncorrect Login Or Password ...Try Again!\n\n\n\n\n\n\n");
                sleepFor2sec();
                clear();
            }
        }

    }
}
