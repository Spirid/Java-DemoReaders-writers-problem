
class Semaphore
{
  public Semaphore(int v) 
    { value = v; }
   
  public synchronized void P() 
    { --value;
      if (value < 0)
      {
        try
          {wait();}
        catch (InterruptedException e) {}
      }
    }
   
  public synchronized void V() 
    { 
      ++value;  
      if (value<=0) {notify();}
    }
   
  private int value;
}

