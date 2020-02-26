//IntArrayList by Andrea Seguya
public class IntArrayList {
	private int[] a; // Underlying array
	private int length; // Number of added elements in a
	int start;// where the first thing goes
	
	// YOU WILL NEED TO ADD AT LEAST ONE NEW DATA FIELD HERE.

	public IntArrayList() {
		length = 0; // Start with no added elements in a
		a = new int[4]; // A little room to grow
		// YOU MAY NEED TO INITIALIZE YOUR NEW DATA FIELD(S).
		start=0;
	}

	public int get(int i) { // Retrieve an added element O(1)
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY GET WORKS
		int position=start+i;//where position is the exact point at which we are at
		if (position <start || position>= start+length) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		return a[position];// to get the position that we are at in the array of a
	}

	public int size() { // Number of added elements, O(1)
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY SIZE WORKS.
		return length; // The number of added elements
	}

	public void set(int i, int x) { // Modify an added element O(1)
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY SET WORKS.
		int position=start+i;
		if (position< start || position >= start+length) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		a[position] = x;// The position of a would now contain x
	}

	public void add(int x) {
		if (start+length >= a.length) {
			int middlestart=(a.length/2);//want my elements to be in the middle so I divided 
			//the size of the array by 2
			// Create new array of double the length
			int[] b = new int[a.length * 2];
			// Copy the elements of a to the corresponding indexes of b
			for (int i = 0; i < a.length; i++) {
				b[middlestart+i] = a[i];//new contents should appear in the middle
				
			}
			start+=middlestart;//starting point moves to the middle
			// Reassign a reference to b
			a = b;
		}
		// Place x at the end of the IntArrayList
		a[length+start] = x;
		// Increase length by 1
		length = length + 1;
	}

	public void addBefore(int x) { 
				if (start ==0) {
					int middlestart=(a.length/2);
					// Create new array of double the length
					int[] b = new int[a.length * 2];
					// Copy the elements of a to the corresponding indexes of b
					for (int i = 0; i < a.length; i++) {
						b[middlestart+i] = a[i];//new elements should be added to the
						//middle of the array
						
					}
					start+=middlestart;//new starting point is in the middle
					// Reassign a reference to b
					a = b;
				}
				// Place x at the end of the IntArrayList
				start=start-1;//the starting point shifts because of the new element
				a[start] = x; //the new starting point contains a
				length=length+1;//length increases by one
	}
	
}

