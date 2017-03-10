package strings;

public class CheckUnique {
	static int x = 10;
	int y = 20;
	
	public CheckUnique(int x, int y){
		this.x= x;
		this.y= y;
	}
	
	public CheckUnique(String S) {
		// TODO Auto-generated constructor stub
		String temp = S.replace(" ", "");
		temp = temp.replace("-","");
		int chunks = temp.length()/3;
		
		if((temp.length()-chunks*3)==1){
			chunks--;
		}
		
		StringBuilder sb = new StringBuilder(temp.length());
		char[] array = temp.toString().toCharArray();
		int countChunks = 0;
		for(int i = 0;i<array.length;i++){
			if(countChunks <chunks && i>0 && i%3 == 0){
				sb.append("-");
				countChunks++;
			}else if(countChunks>= chunks &&  i%2 == 0){
				sb.append("-");
			}
			sb.append(array[i]);
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "00-44  48 5555 836121";
		
		
	}

}
