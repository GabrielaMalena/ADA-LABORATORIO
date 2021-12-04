import java.util.Arrays;

class numberLongest{
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        
        int largo = nums.length;
        int[] prueba= new int[largo];
        Arrays.fill(prueba,1);
        int maximo =1;
        for(int i=1; i<largo; i++){
            for(int j=0; j<i; j++){
                if(nums[i]> nums [j]){
                    prueba[i] =Math.max(prueba[i], prueba[j] +1);
                }
            }
            maximo = Math.max(maximo,prueba[i]);
        }
        
        return maximo;
        
    }
    
    public static void main(String[]args){
    	int arreglo[] = {0,1,0,3,2,3 }; 
    	//int arreglo[] = {7,7,7,7,7,7,7,7}; 	
    	//int arreglo[] = {10,9,2,5,3,7,101,18 };
		//numberLongest lengthOfLIS= new numberLongest();
		System.out.println(lengthOfLIS(arreglo));

	}  
}
