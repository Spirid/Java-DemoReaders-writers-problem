


public class Writer   extends Thread 
{
    private String m_Name;
    private DataBase m_server;
    private int m_writerNum;
    
    public Writer(int r, DataBase db)
    {
        m_writerNum = r;
        m_server = db;
        m_Name = "Writer № " + Integer.toString(r);
    }
    
    public void run()
    {
        for (int i=1; i<=1; i++)
        {
            napping();
            System.err.println("writer " + m_writerNum + " wants to write.");
            m_server.startWrite(this);
            
            System.err.println("-------------- WRITER " + m_writerNum + " IS WRITING.");
            m_server.something();
            
            System.err.println("               writer " + m_writerNum + " is done writing.");
            m_server.endWrite(this);
        }
    }
    
    public void napping()
    {
        try 
        {
            sleep((int) (Math.random())); 
        }
        catch(InterruptedException e) {}
    }
    
    public String getNameWriter()
    {
        return m_Name;
    }
}
