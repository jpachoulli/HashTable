class BSTNode {
	
	String firstName;						// instance variable firstName
	String lastName;						// instance variable lastName
	String phone;							// instance variable phone
	String email;							// instance variable email

	String key;								// instance variable key
	String value;							// instance variable value

	BSTNode parent;							// instance variable parent
	BSTNode leftChild;						// instance variable leftChild
	BSTNode rightChild;						// instance variable rightChild

	public BSTNode(String entry) { 			// node constructor w/req'd parameters

		String[] holder = entry.split(" ");	// splits the entry into an array
		
		this.firstName = holder[0];			// stores element 0 in firstName
		this.lastName = holder[1];			// stores element 1 in lastName
		this.phone = holder[2];				// stores element 2 in phone
		this.email = holder[3];				// stores element 3 in email
		
		// uses firstName and lastName as the 'unique' key
		
		this.key = firstName.toUpperCase() + " " + lastName.toUpperCase(); // example" BOB SMITH
//		this.key = firstName.toUpperCase().concat(lastName.toUpperCase()); // example" BOBSMITH

		// passes formatted name, phone and email values to 'value'
		this.value = " " + "(" + phone.substring(0, 3) + ") " + phone.substring(4) + ", " + email;

	}

	public String toString() {		// allows the nodes to be printed as strings

		return value;				// returns the value of the node to be printed

	}	
	
	public boolean isLeaf() {		// checks to see if a node is a leaf

		boolean result = false;		// boolean variable 'result' set to false by default

		if(leftChild == null && rightChild == null) {	// checks to see if there are child nodes

			result = true;								// sets the value of 'result' to true if there are NOT children!

		}
		
		return result;									// returns the value of the 'result' variable (true or false)

	}

	public boolean hasLeftChild() {						// checks to see if a leftChild exists

		boolean result = false;							// boolean variable 'result' set to false by default

		if(leftChild != null) {							// if there IS a left child, then...

			result = true;								// if there is, sets the value of 'result' to true
		}

		return result;									// returns the value of the variable 'result' (true or false)

	}

	public boolean hasLeftChildOnly() {						// checks to see if only a leftChild exists

		boolean result = false;							// boolean variable 'result' set to false by default

		if(leftChild != null && rightChild == null) {	// if there IS only a left child, then...

			result = true;								// if there is, sets the value of 'result' to true
		}

		return result;									// returns the value of the variable 'result' (true or false)

	}
	
	public boolean isLeftChild() {
		
		boolean result = false;
		
		if(this.parent.hasLeftChild()) {
			
			result = true;
			
		}
		
		return result;
		
	}
	
	public boolean isRightChild() {
		
		boolean result = false;
		
		if(this.parent.hasRightChild()) {
			
			result = true;
			
		}
		
		return result;
		
	}

	public boolean hasRightChild() {					// checks to see if a rightChild exists

		boolean result = false;							// boolean variable 'result' set to false by default

		if(rightChild != null) {						// if there IS a right child, then...

			result = true;								// sets the value of 'result' to true

		}

		return result;									// returns the value of 'result'

	}

	public boolean hasRightChildOnly() {				// checks to see if only a rightChild exists

		boolean result = false;							// boolean variable 'result' set to false by default

		if(rightChild != null && leftChild == null) {	// if there IS only a right child, then...

			result = true;								// sets the value of 'result' to true

		}

		return result;									// returns the value of 'result'

	}

	public boolean hasTwoChildren() {					// checks to see if a node has two children
		
		boolean result = false;							// boolean variable 'result' set to false by default
		
		if((leftChild != null) && (rightChild != null)) {	// checks to see if both children exist
			
			result = true;								// if they do, sets the value of 'result' to true		
		}
		
		return result;									// returns the value of 'result'
		
	}
	
	public boolean isParent() {
		
		boolean result = false;
		
		if(!this.isLeaf()) {
			
			result = true;
			
		}
		
		return result;
		
	}
	
	public boolean hasParent() {
		
		boolean result = false;
		
		if(this.parent != null) {
			
			result = true;
			
		}
		
		return result;
		
	}
		

}


