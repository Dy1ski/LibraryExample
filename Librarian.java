/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentbookborrowing;

//import java.util.Random ~ come back to this

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Librarian extends Thread {
    
   Shelf Bookshelf;
   int reStocking;
   Semaphore Permission;
   Semaphore passOnPermission;
   
    public Librarian (Shelf Bookshelf, int reStocking, Semaphore Permission, Semaphore passOnPermission)
    {
        this.Bookshelf = Bookshelf;
        this.reStocking = reStocking;
        this.Permission = Permission;
        this.passOnPermission = passOnPermission;
    }
    
    void stocking()
    {
            try
            {
                Thread.sleep(this.reStocking);
            }
            catch(InterruptedException e)
            {}
    
            Bookshelf.stockShelf(new Random().nextInt(50)); // produces a random int and puts into buffer
    }
    
    public void run()
    {
        try
        {
            while(true)
            {
                Permission.acquire();
                 System.out.println("Librarian Lock has been applied");
                if(Bookshelf.shelfFull())
                {
                    Thread.sleep(2);
                    continue;
                }
                this.stocking();
                System.out.println("Library Status after Librarian Finishes Stocking");
                Bookshelf.bookList();
                passOnPermission.release();
                System.out.println("Librarian Lock has been released");
            }   
        }
        catch(Exception tr)
        {}
    }
   

}
    

