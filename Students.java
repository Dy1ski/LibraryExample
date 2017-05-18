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
public class Students extends Thread 
{
    Shelf myShelf;
    int ReadingTime;
    
 public Students(Shelf myShelf, int ReadingTime)
 {
     this.myShelf = myShelf;
     this.ReadingTime = ReadingTime;
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
                if(myShelf.shelfEmpty())
                {
                    Thread.sleep(1);
                    continue;
                }
                this.Read();
                System.out.println("Books avaliable after student takes book");
                myShelf.bookList();
            }
        }
        catch(Exception er)
        {}
    
    }
    
    
    
    
    
    
}
