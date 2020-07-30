
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public  class Serialize implements Serializable {
	private static final long serialVersionUID = 1L;

	
	ArrayList<String> arr = new ArrayList<String>();
	
	String filename = "file.ser";
	
	public Serialize(ArrayList<String> s_array) {
		this.arr = s_array;
	}
	
	public void serialize() {
		try {    
	        FileOutputStream file = new FileOutputStream(filename); 
	        ObjectOutputStream out = new ObjectOutputStream(file);   
	        out.writeObject(arr);  
	        out.close(); 
	        file.close(); 
	          
	        System.out.println("Object has been serialized");
	        
	    } catch(IOException e) { 
	        System.out.println("IOException is caught"); 
	    } 	
	}
	
	Object obj1 = null;
	public void deserialize() {
		try
        {     
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            try {
				obj1 = in.readObject();
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			} 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized "); 
            System.out.println(obj1);
        }  catch(IOException e) { 
            	System.out.println("IOException is caught"); 
        } 
	}


}
