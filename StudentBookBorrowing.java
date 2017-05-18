/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentbookborrowing;

/**
 *
 * @author dylan
 */
import java.util.concurrent.Semaphore;

public class StudentBookBorrowing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int Avaliable_Books = 10;
        int readingTime = 1000;
        int restockingTime = 1000;
        
        Semaphore librarianPermission = new Semaphore(1);
        Semaphore StudentPermission = new Semaphore(0);
        
        Shelf shelf = new Shelf(Avaliable_Books); // buffer
        Librarian lib = new Librarian(shelf, restockingTime, librarianPermission, StudentPermission); // producer
        Students stu = new Students(shelf, readingTime, StudentPermission, librarianPermission); // consumer
        
        lib.start();
        stu.start();
    }
    
}
