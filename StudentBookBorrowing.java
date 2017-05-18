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
public class StudentBookBorrowing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int Avaliable_Books = 10;
        int readingTime = 1000;
        int restockingTime = 1000;
        
        Shelf shelf = new Shelf(Avaliable_Books);
        Librarian lib = new Librarian(shelf, restockingTime);
        Students stu = new Students(shelf, readingTime);
        
        lib.start();
        stu.start();
    }
    
}
