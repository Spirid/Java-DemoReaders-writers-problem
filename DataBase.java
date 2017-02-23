


import java.util.ArrayList;

enum ModeDataBase {Read, Write, Waiting, Stoped};


public class DataBase {
    
    private ModeDataBase m_modeDataBase;
    ArrayList<Reader> m_WaitingRead;
    ArrayList<Reader> m_Reading;
    
    ArrayList<Writer> m_WaintingWrite;
    Writer            m_WritingNow;
    
    private int m_ReadCount;

    
    Semaphore m_RC; //  Access to ReadCount
    Semaphore m_Access; // Access to data


            
    public DataBase()
    {
       m_ReadCount = 0;
       m_RC = new Semaphore(1);
       m_Access = new Semaphore(1);
    
       
       m_WaitingRead   = new ArrayList<Reader>(10);
       m_Reading       = new ArrayList<Reader>(10);
       m_WaintingWrite = new ArrayList<Writer>(10);
       m_WritingNow    = null;
       
       m_modeDataBase = ModeDataBase.Waiting;
       m_readWaiting  = false;
    }

    public ModeDataBase getState()
    {
        return m_modeDataBase;
    }
    
    private boolean m_readWaiting;
    
    public void startWrite(Writer writer)
    {
       m_Access.P();  
    }
    
    public void endWrite(Writer writer)
    {
        m_Access.V();           
    }
    
    public int startRead(Reader reader)
    {
 
       ++m_ReadCount;
       if (1 == m_ReadCount)
       {
           m_Access.P();
     
       }
       return m_ReadCount;
    }
    
    public void endRead(Reader reader)
    {       
       -- m_ReadCount;
       if (0 == m_ReadCount)
       {
           m_Access.V();           
           
       }  
     
    }
    
    public void something()
    {
  
        try
        {
            Thread.sleep((int) (Math.random()*5000));
        }
        catch(InterruptedException e) {}
     
   }

    
}

