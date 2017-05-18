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
public class Students extends Thread 
{
    Shelf myShelf;
    int ReadingTime;
    Semaphore Permission;
    Semaphore transferPermission;
    
 public Students(Shelf myShelf, int ReadingTime, Semaphore Permission, Semaphore transferPermission)
 {
     this.myShelf = myShelf;
     this.ReadingTime = ReadingTime;
     this.Permission = Permission;
     this.transferPermission = transferPermission;
 }
 
 public void Read()
 {
     try
     {
         Thread.sleep(this.ReadingTime);
     }
     catch(InterruptedException e)
     {}
     this.myShelf.readBook(); // check this
 }
    public void run()
    {
        try
        {
            while(true)
            {
                
                Permission.acquire();
                System.out.println("Student Lock has been applied");
                if(myShelf.shelfEmpty())
                {
                    Thread.sleep(1);
                    continue;
                }
                this.Read();
                System.out.println("Books avaliable after student takes book");
                myShelf.bookList();
                transferPermission.release();
                System.out.println("Student Lock Released");
            }
        }
        catch(Exception er)
        {}
    
    }
    
    
    
    
    
    
}
