package brain_teasers;

public class HundredLockers {

	public void display(boolean[] doors){
		int sum =0;
		for(int i=1; i<101;i++){
			if(doors[i]==true){
				sum = sum + 1;
			}
		}
		
		System.out.print(sum+ " ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] doors = new boolean[101];
		HundredLockers obj = new HundredLockers();
		
		for(int i = 1; i<100; i++){
			for(int j=1; j<100;j++){
				if(i == 1){
					doors[j] = true;
				} else if(i==2){
					if(j % i == 0){
						doors[j] = false;
					}
				}  else{
					if(j%i ==0){
						if(doors[j] == false) 
							doors[j] = true;
						else 
							doors[j] = false;
					}
				}
			}
			if(doors[100] == false) 
				doors[100] = true;
			else 
				doors[100] = false;
			
		}
		obj.display(doors);
		
		
	}

}
