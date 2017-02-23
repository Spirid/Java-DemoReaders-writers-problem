
public class Lab6 {

	
    public static void main(String[] args) {
        System.out.println("Lab6.Ex1");
                
        DataBase db = new DataBase();
        
        AdderUsers users = new AdderUsers(db);
	    
	
	users.addReadet();
    users.addReadet();
	users.addReadet();
	users.addReadet();
	
	users.addWriter();
	
	users.addReadet();
    users.addReadet();
	users.addReadet();
	users.addReadet();

	users.addWriter();  
        
		System.out.println("Lab6.Ex1.end");
		System.out.println();
        
    }
    
}
