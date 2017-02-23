
public class Reader  extends Thread 
{
    private String m_Name;    
    private DataBase m_server;
    private int m_readerNum;
    
    public Reader(int r, DataBase db)
    {
        m_readerNum = r;
        m_server = db;
        m_Name = "Читатель № " + Integer.toString(r);
    }
    
    @Override
    public void run()
    {
 
        for (int i=1; i<=1; i++)
        {
            napping();
            System.err.println("reader " + m_readerNum + " wants to read.");
            int c = m_server.startRead(this);
            System.err.println("reader " + m_readerNum + " is reading. Reader Count = " + c);
            m_server.something();
            m_server.endRead(this);
        }
    }
    
    public void napping()
    {
        try
        {
            sleep((int) (Math.random()*5000));
        }
        catch(InterruptedException e) {}
    }
    
        public String getNameReader()
    {
        return m_Name;
    }
    

}
