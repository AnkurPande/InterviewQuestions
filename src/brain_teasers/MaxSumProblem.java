package brain_teasers;

//Find sub array having the maximum sum of an unsorted array. 
public class MaxSumProblem {
	
	public int getMaxSum(int[] a){
		int maximum_sum = 0;
		int sum = 0;
		for(int i=0; i<a.length;i++){
			sum = sum + a[i];
			if(maximum_sum<sum)
				maximum_sum = sum;
			else if(sum <0)
				sum = 0;
		}
		return maximum_sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumProblem obj = new MaxSumProblem();
		int[] a = {2,-10, 45, 10 , -3, 0, 1 , 8 , 7};
		System.out.println(obj.getMaxSum(a));
	}

}
