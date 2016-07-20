package edu.ittc.training.addressbook;

import java.util.Scanner;

public class AddressBookApp {
    private static Scanner dataReader;
    private static AddressBook book;

    public static void main(String[] args) {            
        book = new AddressBook(5);
        dataReader = new Scanner(System.in);
        
        boolean lContinue = true;
        while (lContinue) {
            switch (Character.toUpperCase(menu())) {
                case '1': addBookEntry(); break;                
                case '2': deleteEntry(); break;
                case '3': viewAllEntries(); break;
                case '4': editEntry(); break;
                case '5': searchEntryByName(); break; 
                case '6': searchEntryByRecord(); break;
                case 'X':
                    lContinue = false;
                    break;
                default:
                    System.out.println("\nInvalid Menu option");
            }            
        }
        System.out.println("\nEnd of program...");
    }

    public static char menu() {
        char choice;
        System.out.println("\nAddressBook Menu");
        System.out.println("1. Add Entry");        
        System.out.println("2. Delete Entry");
        System.out.println("3. View all Entries");
        System.out.println("4. Update an Entry");
        System.out.println("5. Search Entry By Name");
        System.out.println("7. Search Entry By TelNo");
        System.out.println("6. Search Entry By Record Number");
        System.out.println("X. Exit Program");
        System.out.print("\nSelect Menu Option: ");
        choice = dataReader.nextLine().charAt(0);
        return choice;
    }
    
    public static AddressBookEntry getEntryDetails(AddressBookEntry entry) {
        if( entry == null ) {
            entry = new AddressBookEntry();
        }
        System.out.print("\nName     : "); entry.setName(dataReader.nextLine());
        System.out.print("Address  : "); entry.setAddress(dataReader.nextLine());
        System.out.print("Phone No.: "); entry.setTelNo(dataReader.nextLine());
        System.out.print("Email    : "); entry.setEmailAdd(dataReader.nextLine());
        return entry;
    }
    
    public static void addBookEntry() {
        AddressBookEntry entry = getEntryDetails(null);
        if( entry != null ) {
            book.addAddressBookEntry(entry);
        }
    }
    
    public static void editEntry() {
        // TODO: edit a single record entry
        System.out.println("\nUnder construction....");
    }
    
    public static void searchEntryByRecord() {
        // TODO: search an entry using its record no.
        // display "record not found" if such record does not exist.
        // Display all its entry. 
        // Hint: use the method "findAddressBookEntryByRecordNo()" 
        //       from the AddressBook class
        System.out.println("\nUnder construction....");
    }
    
    
    public static void deleteEntry() {
        int recordNo;
        try {
            System.out.print("\nEnter record number to DELETE: ");
            recordNo = Integer.parseInt(dataReader.nextLine());
            if(book.deleteAddressBookEntry(recordNo)) {
                System.out.println("Record " + recordNo + " DELETION successfull.");
            } else {
                System.out.println("Record " + recordNo + " does not exist.");   
            }
        } catch(NumberFormatException ex) {
            System.out.println("Invalid entry...");
        }   
    }
    
    // display a single record
    public static void displayEntry(AddressBookEntry entry, int recNo) {        
        System.out.println("\nRecord No. " + recNo);
        System.out.println("Name     : " + entry.getName());
        System.out.println("Address  : " + entry.getAddress());
        System.out.println("Phone No.: " + entry.getTelNo());
        System.out.println("Email    : " + entry.getEmailAdd());
    }
    
    // Search all entries containing name search criteria
    public static void searchEntryByName() {       
        System.out.print("\nSearch[Name]: "); 
        // ensure no extraneous space and search criteria all in lowercase 
        String name = dataReader.nextLine().trim().toLowerCase();   
        
        // get a reference to the Addressbook list
        AddressBookEntry[] list = book.getAllEntries();             
        for( int i = 0; i < list.length; i++ ) {   
            // compare search criteria with every entry 
            if(list[i]!=null && list[i].getName().toLowerCase().contains(name)) {
                 displayEntry(list[i],i+1); 
            }
        }
        System.out.println("No more records follow...");
    }
    
    public static void viewAllEntries() {
        int validRecords = 0;
        
        // get a reference to the Addressbook list
        AddressBookEntry[] list = book.getAllEntries();
        if( list.length == 0) {
            System.out.println("\nList empty...");
        }
        
        for( int i = 0; i < list.length; i++ ) {
            if( list[i] != null ) {
                displayEntry(list[i],++validRecords);                
            }    
        }
        System.out.println("No more entries to follow...");
    }
}
