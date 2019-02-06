// CREATE A NEW TEST CASE that deletes an entry from the middle of an index of multiple elements
// such as an index which contains 5 elements, and you're deleting element #3, or technically element[2]
// cause I have a feeling they're going to test for that...

public class HashTable {

	final int SIZE = 13;								// sets the size to an immutable amount, in this case 13

	HashNode[] bucket = new HashNode[SIZE];			// creates the table with 13 buckets

	public int getIDX(String key) {						// gets the index of the key

		int index = key.hashCode();						// generates hash code from the key
		index = index % SIZE;							// compresses index to prevent outOfBoundsException
		index = Math.abs(index);						// converts to absolute value of index to prevent outOfBoundsException

		return index;									// returns index

	}

	public void insert(String entry) {					// inserts a new entry into the table

		HashNode newNode = new HashNode(entry);		// creates a new node to insert

		int idx = getIDX(newNode.key);					// stores the index of newNode

		if(bucket[idx] == null) {						// checks to see if the first slot at the index is empty

			bucket[idx] = newNode;						// if so, insert the new node

			System.out.println("Added: " + newNode.value + " at index " + idx + ".");

			return;										// exit the method

		}

		HashNode currentNode = bucket[idx];			// creates currentNode for the node in the first slot

		while(currentNode.next != null) {				// if currentNode has another node after it...

			currentNode = currentNode.next;				// then keep searching...

		}

		currentNode.next = newNode;						// when currentNode.next is finally empty, insert newNode
		newNode.previous = currentNode;					// reference the node which came before newNode

		System.out.println("Added: " + newNode.value + " at index " + idx +
				" after " + newNode.previous.value + ".");

		return;											// exit the method

	}

	public void delete(String key) {

		int idx = getIDX(key);							// gets the index of the key

		HashNode delNode = bucket[idx];				// stores the index of the node to be deleted

		if(delNode == null) {
			
			System.out.println("The entry " + "'" + key.toUpperCase() + "'" + " does not exist in the table.");
			
		} else {			
			
			String keyHldr = bucket[idx].key;				// stores the value of the key of the node at that index

			while(!keyHldr.contains(key)) {					// while the indexed node key is not equal to the key being input...

				delNode = delNode.next;						// keep searching...

			}

			if(delNode.hasNext()) {

				delNode = delNode.next;						// checks to see if delNode has a next node

			} else {										// if not, then

				System.out.println("\n" + "Deleted: " + keyHldr.toUpperCase() + " from the table at index " + idx + "\n");

				bucket[idx] = null;							// sets the element at that index to null

			}
			
		}

		return;

	}

	public String lookup(String key) {					// finds an entry

		int idx = getIDX(key);							// gets the index of the key

		HashNode findNode = bucket[idx];
		
		String keyPass = null;
		
		if(findNode == null) {

			System.out.println("The entry " + "'" + key.toUpperCase() + "'" + " does not exist in the table.");
			
		} else {
			
			String keyHldr = bucket[idx].key;				// stores the value of the key of the node at that index
			
			while(!keyHldr.contains(key)) {					// while the indexed node key is not equal to the key being input...

				findNode = findNode.next;				// keep searching...
				keyHldr = findNode.key;


				//			System.out.println(keyHldr);

			}

			if(!keyHldr.contains(key)) {

				System.out.println("\n" + "The requested entry " + "'" + key + "'" + " cannot be found");
			
			} else {

				System.out.println("\n" + "Found: " + keyHldr.toUpperCase());					// print the located key from the table
				keyHldr = keyPass;
				
			}
						
		}

		return keyPass;									// return keyHldr and exit the method	
		
	}







	public static void main(String[] args) {

		HashTable table = new HashTable();
		
		System.out.println("JJ Bernsdorff (000291957) BHP1: HashTable" + "\n" + "-----------------------------------------" + "\n");

		table.insert("Bob Smith 555-235-1111 bsmith@somewhere.com");
		table.insert("Jane Williams 555-235-1112 jw@something.com");
		table.insert("Mohammed al-Salam 555-235-1113 mas@someplace.com");
		table.insert("Pat Jones 555-235-1114 pjones@homesweethome.com");
		table.insert("Billy Kidd 555-235-1115 billy_the_kid@nowhere.com");
		table.insert("H. Houdini 555-235-1116 houdini@noplace.com");
		table.insert("Jack Jones 555-235-1117 jjones@hill.com");
		table.insert("Jill Jones 555-235-1118 jillj@hill.com");
		table.insert("John Doe 555-235-1119 jdoe@somedomain.com");
		table.insert("Jane Doe 555-235-1120 jdoe@somedomain.com");

		table.lookup("Pat Jones");
		table.lookup("Billy Kidd");

		table.delete("John Doe");

		table.insert("Test Case 555-235-1121 Test_Case@testcase.com");
		table.insert("Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		table.insert("Jo Wu 555-235-1123 wu@h.com");
		table.insert("Millard Fillmore 555-235-1124 millard@theactualwhitehouse.us");
		table.insert("Bob vanDyke 555-235-1125 vandyke@nodomain.com");
		table.insert("Upside Down 555-235-1126 upsidedown@rightsideup.com");

		table.lookup("Jack Jones");
		table.lookup("Nadezhda Kanachekhovskaya");

		table.delete("Jill Jones");
		table.delete("John Doe");

		table.lookup("Jill Jones");
		table.lookup("John Doe");

	}

}
