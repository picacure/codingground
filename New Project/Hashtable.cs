using System.IO;
using System;
using System.Collections;

class Program
{
    static void Main()
    {
        
        
        Hashtable openWith = new Hashtable();

        // Add some elements to the hash table. There are no  
        // duplicate keys, but some of the values are duplicates.
        openWith.Add("txt", "notepad.exe");
        openWith.Add("bmp", "paint.exe");
        openWith.Add("dib", "paint.exe");
        openWith.Add("rtf", "wordpad.exe");
        
        
        Console.WriteLine("1" + openWith["rstf"] +"1"); 
        
    }
}
