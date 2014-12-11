using System.IO;
using System;

public struct Ternary {
    public float velocty;
    public float acceleration;
    public float distance;
    public float time;
    public int flag;
};

class Program
{
    static void Main()
    {
        Console.WriteLine((new Ternary()).flag);
    }
}
