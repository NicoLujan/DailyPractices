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
	
	public static Integer fibo(Integer x) {
		if(x <= 0)
			return 0;
		else if (x == 1)
			return 1;
		else
			return x = x * fibo(x-1);
	}
	/*
	 * Ratiorg got statues of different sizes as a present from CodeMaster for his birthday, 
	 * each statue having an non-negative integer size. Since he likes to make things perfect, 
	 * he wants to arrange them from smallest to largest so that each statue will be bigger than 
	 * the previous one exactly by 1. He may need some additional statues to be able to 
	 * accomplish that. Help him figure out the minimum number of additional statues needed.
	 *  
	 */
	
	int solution(int[] statues) {
		   
	    int n = statues.length;
	    int temp;
	    
	    for (int i = 0; i < n-1; i++) {
	        for (int j = 0; j < n-i-1; j++) {
	            if (statues[j] > statues[j+1]) {
	                temp = statues[j];
	                statues[j] = statues[j+1];
	                statues[j+1] = temp;
	            }
	        }
	    }
	    
	    //Arreglo ordenado [2,3,6,8]
	    
	    int aux = statues[0]; // 2 
	    int resultado = 0;
	    
	    for(int i=0; i < n-1; i++){
	        if(statues[i + 1] == aux + 1){
	            aux = statues[i+1];
	        }else{
	            aux++;
	            while(statues[i + 1] != aux){
	                resultado++;
	                aux++;
	            }
	        }
	    }
	    
	    return resultado;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer x = 4;
		
		System.out.println(fibo(x));
	
	}

}
