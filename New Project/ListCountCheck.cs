using System.IO;
using System;
using System.Collections;

class Program
{
    private static ArrayList _mList = new ArrayList();
    
    static void Main()
    {
        for(int i = 0; i < 5; i++){
            _mList.Add(i);
        }
        
        int ltemp;
        for(int i = 0, len = _mList.Count; i < len ; i++){
            ltemp = (int)_mList[i];
            
            if(ltemp > 3){
                _mList.RemoveAt(i);
            }
            else{
                Console.WriteLine(ltemp);
            }
        }
        
        Console.WriteLine("Hello, World!");
    }
}
