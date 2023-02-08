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
	
	// You are given a two-digit integer n. Return the sum of its digits.
	int solution(int n) {
	    if(10<=n && n<=99){
	        int unidad = (n % 10);
	        int decimal = (n/10);
	        
	        return unidad + decimal;
	    }
	    return -1;
	}
	// Given an integer n, return the largest number that contains exactly n digits.
	int solution1(int n) {
	    
	    if(1 <= n && n<=9){
	        switch (n){
	            case 1: return 9; 
	            case 2: return 99;
	            case 3: return 999;
	            case 4: return 9999;
	            case 5: return 99999;
	            case 6: return 999999;
	            case 7: return 9999999;
	            case 8: return 99999999;
	            default: return 999999999;
	        }
	    }
	    
	    return -1;
	}
	
	// n children have got m pieces of candy. They want to eat as much candy as they can, but each child must eat exactly the same amount of candy as any other child. Determine how many pieces of candy will be eaten by all the children together. Individual pieces of candy cannot be split.
	int solution2(int n, int m) {
	    return (m/n) * n;
	}
	
	/*
	 * Your friend advised you to see a new performance in the most popular theater in the city. He knows a lot about art and his advice is usually good, but not this time: the performance turned out to be awfully dull. It's so bad you want to sneak out, which is quite simple, especially since the exit is located right behind your row to the left. All you need to do is climb over your seat and make your way to the exit.

The main problem is your shyness: you're afraid that you'll end up blocking the view (even if only for a couple of seconds) of all the people who sit behind you and in your column or the columns to your left. To gain some courage, you decide to calculate the number of such people and see if you can possibly make it to the exit without disturbing too many people.

Given the total number of rows and columns in the theater (nRows and nCols, respectively), and the row and column you're sitting in, return the number of people who sit strictly behind you and in your column or to the left, assuming all seats are occupied.
	 */
	int solution3(int nCols, int nRows, int col, int row) {
	    return ((nCols*nRows) - ((row*nCols + (col-1) * nRows) - (col-1)*row));
	}
	
	/*
	 * Given a divisor and a bound, find the largest integer N such that:

N is divisible by divisor.
N is less than or equal to bound.
N is greater than 0.
It is guaranteed that such a number exists.
	 */
	int solution4(int divisor, int bound) {
	    
	    int solucion = divisor;
	    
	    while(solucion <= bound){
	        solucion+=divisor;
	    }
	    
	    if(solucion > bound)
	        return solucion-=divisor;
	    return solucion;

	}
	
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
		FiguraGeometrica f = null;
		f.dibujar();
	
	}

}
