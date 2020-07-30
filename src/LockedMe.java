import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class LockedMe {
	
	public static void sortedList(ArrayList<String> s_array)  {
			try {
				if (s_array.size() > 0) {
					Collections.sort(s_array);
					System.out.println(s_array.toString());
				}
				else 
					throw new Exception("\n No Files to display.. ");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	public static void addList(ArrayList<String> s_array, String f_name) {
		s_array.add(f_name);
		System.out.println("Added Successfully..");
	}
	
	public static int searchList(ArrayList<String> s_array, String f_name) {
		int count = 0;
		for (String st: s_array) {
			if (st.equals(f_name)) {
				return count;
			}
		}
		return -1;
	}
	
	public static void deleteList(ArrayList<String> s_array, String f_name)  {		
			if (s_array.remove(f_name));
				System.out.println("\n Removed file : "+ f_name + "\n Existing Array: " + s_array.toString());
	}
	
	@Override
	public String toString() {
		return "LockedMe [toString()=" + super.toString() + "]";
	}

	public static void main(String[] args)  {
		
		System.out.println("**************** WELCOME *****************");
		System.out.println("");
		System.out.println("------------   LockedMe.COM  -------------");
		System.out.println("");
		System.out.println("A product of Company Lockers Pvt Ltd.\n");
		System.out.println("Developed by John Smith - Full Stack Developer at Company Lockers \n");
		
		Scanner scan = new Scanner(System.in);
		boolean t=true;
		
		ArrayList<String> arr = new ArrayList<String>();
		
		while (t) {
			System.out.println("\n Enter the operation to be performed: ");
			System.out.println("\n 1 - Retrieve all files in ascending order \n 2 - Basic Operations \n 3 - Exit the application\n");
			int b_choice = scan.nextInt();
			
			switch (b_choice) {
				case 1: {
					sortedList(arr);
					break;
				}	
				
				case 2: {
					System.out.println("\n Enter the operation to be executed: ");
					System.out.println("\n 1 - Adding the file \n 2 - Search the file \n 3 - Delete the file\n");
					int op_choice = scan.nextInt();
					if (op_choice ==  1) {
						System.out.println("Enter the filename to be added: ");
						String filename = scan.next();
						addList(arr, filename);
						Serialize ser = new Serialize(arr);
						ser.serialize();
					}
					
					else if (op_choice == 2) {
						System.out.println("\n Enter the filename to be searched: ");
						String filename = scan.next();
						int ind = searchList(arr, filename);
						try {
							if (ind >= 0) {
								System.out.println("\n" + filename +" found at  position " + ind);
							}
							else {
								throw new FileNotFoundException("\n File not found.. ");
							}
						} catch (FileNotFoundException e) {
							System.out.println(e.getMessage());
						}
					}
					
					else if (op_choice == 3) {
						System.out.println("\n Enter the filename to be deleted: ");
						String filename = scan.next();
						deleteList(arr, filename);
					}
					
					else {
						t = true;
					}
					break;
				}
				
				case 3: {
					Serialize ser = new Serialize(arr);
					ser.deserialize();
					System.out.println("\n Exitted..");
					 t = false;
					 break;
					
				}
			}
		}
		scan.close();
	}
}
