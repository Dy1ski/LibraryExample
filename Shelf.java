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
public class Shelf {
    private int[] bShelf;
    int lOshelf;
    int rOshelf;
    int shelfSize;


    public Shelf(int sOShelf)
    {
        bShelf = new int[10];
        this.lOshelf = 0;
        this.rOshelf = -1;
        this.shelfSize = sOShelf; // check this
    }
    /// getters and setters
    
    public int getShelfStart()
    {
        return lOshelf;
    }
    public int getShelfEnd()
    {
        return rOshelf;
    }
    public int getshelfSize()
    {
        return shelfSize;
    }
    
    public void stockShelf(int book)
    {
        this.rOshelf++;
        bShelf[rOshelf]= book;
    }
    
    public void readBook()
    {
        this.lOshelf++;
    }
    
    public boolean shelfEmpty()
    {
        if(lOshelf > rOshelf)
        {
            return true;
        }
        else
        {
        return false;
        }
    }
    public boolean shelfFull()
    {
     if((rOshelf-lOshelf) >=shelfSize)
        {
            return true;
        }
        else
        {
        return false;
        }
    }
    
    
    
    public void bookList()
    {
        System.out.println("Bookshelf Starts at: " + this.lOshelf + " -> End of Shelf " + this.rOshelf + " | " + 
                (rOshelf- lOshelf + 1 ) + " Books " );
        for (int i = this.lOshelf; i <= this.rOshelf; i++)
        {
            System.out.print(bShelf[i] + " ");
        }
        System.out.println();
        
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
        }
    }
    
}