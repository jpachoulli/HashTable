
public class HashNode {	
	
	HashNode next;						// instance variable next
	HashNode previous;					// instance variable previous
	
	String firstName;					// instance variable firstName
	String lastName;					// instance variable lastName
	String phone;						// instance variable phone
	String email;						// instance variable email
	
	String key;
	String value;
	
//	String key;
//	String value;
	
	public HashNode(String entry) {		
				
		String[] holder = entry.split(" ");	// splits the strings in 'entry' into an array
		
		this.firstName = holder[0];				// stores the value in element[0] as 'firstName'
		this.lastName = holder[1];				// stores the value in element[1] as 'lastName'
		this.phone = holder[2];					// stores the value in element[2] as 'phone'
		this.email = holder[3];					// stores the value in element[3] as 'email'
		
		
		this.key = firstName + " " + lastName;			// creates 'key' by combining element[0] and element[1]
		
		this.value = firstName.toUpperCase() + " " + lastName.toUpperCase() + " " + phone + " " + email;	// combines elements[0]-[3] to create 'value'
	
	}
	
	public boolean hasNext() {
		
		if(next == null) {
			
			return false;
			
		}
		
		return true;
		
	}
	
	public boolean hasPrevious() {
		
		boolean result = false;
		
		if(previous != null) {
			
			result = true;
		}
		
		return result;
		
	}
	
	public boolean contains(String entry) {
		
		if(entry == null) {
			
			return false;
			
		}
		
		return true;
		
	}
	
	
}
