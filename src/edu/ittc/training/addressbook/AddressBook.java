package edu.ittc.training.addressbook;

public class AddressBook {
    private int size;
    private AddressBookEntry list[];
    
    public AddressBook(int size) {
        // variable size addressbook
        this.size = size;
        list = new AddressBookEntry[size];
    }
    
    public AddressBook() {
        // if size not specified, default no. of entries is 100
        size = 100;
        list = new AddressBookEntry[size];        
    }
    
    public boolean addAddressBookEntry(AddressBookEntry entry) {
        for( int i = 0; i < list.length; i++ ) {
            // find next available empty slot
            if(list[i] == null) {
                list[i] = entry;
                return true;
            }
        }
        // return false if no slot available, addressbook is full
        return false;
    }
    
    public boolean deleteAddressBookEntry(int recordNo) {
        int validRecord = 0;
        // record number is greater than the index number by 1
        if( recordNo > 0 && (recordNo-1) < size ) {
            for(int i = 0; i < list.length; i++ ) {
                if( list[i]!=null ) {
                    validRecord += 1;
                }
                if(validRecord == recordNo ) {
                    list[i] = null;
                    return true; // return true if deletion is successfull
                }
            } 
        }
        return false;
    }
    
    // finda specific record number using its record number
    public AddressBookEntry findAddressBookEntryByRecordNo(int recordNo) {
        if( recordNo > 0 && (recordNo-1) < size ) {
            if( list[recordNo-1]!= null ) {
                return list[recordNo-1];
            }
        } 
        return null;
    }
    
    public boolean updateAddressBookEntry(int recordNo, AddressBookEntry entry) {
        if( recordNo > 0 && (recordNo-1) < size ) {
            list[recordNo-1] = entry;
        }
        return false; 
    }
    
    public AddressBookEntry[] getAllEntries() {
        return list;
    }
    
}
