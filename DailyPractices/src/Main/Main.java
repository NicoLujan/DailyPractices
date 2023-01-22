package Main;

/*
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place 
 * such that each unique element appears only once. The relative order of the elements should be 
 * kept the same.
 * 
 * Since it is impossible to change the length of the array in some languages, you must instead 
 * have the result be placed in the first part of the array nums. More formally, if there are k 
 * elements after removing the duplicates, then the first k elements of nums should hold the final
 * result. It does not matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * 
 * Do not allocate extra space for another array. You must do this by modifying the input array 
 * in-place with O(1) extra memory.
*/

public class Main {
	
	public static int removeDuplicates(int [] numeros) {
		
		int k = 0;
		
		for(int i=0;i<=numeros.length-1;i++) {
			int aux = 0;
			if(i != numeros.length-1)
				if(numeros[i] == numeros[i+1]) {
					for(int j=i+1 ; numeros[i] == numeros[j] ; j++) {
						numeros[j] = -1;
						k++;
						aux++;
					}
				
					i = i + aux;
				}
						
		}
		
		return k;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,1,2,2,2,3,3,4}; // Input array
		

		int k = removeDuplicates(nums); // Calls your implementation

		int[] expectedNums = new int[nums.length - k]; // The expected answer with correct length
		
		int indexAux=0;

		for(int i=0;i<nums.length;i++) {
			if(nums[i] != -1) {
				expectedNums[indexAux] = nums[i];
				indexAux++;
			}
		}
		
		for(int i=0;i<expectedNums.length;i++)
			System.out.println(expectedNums[i]);

	}

}
