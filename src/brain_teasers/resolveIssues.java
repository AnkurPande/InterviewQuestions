package brain_teasers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//Given the data for company hierarchy where the issues 
//between any two employees can be resolved by their common manager.
public class resolveIssues {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		String inputString  = "Frank->Mary,Mary->Sam,Mary->Bob,Sam->Katie,Sam->Pete,Bob->John,Sam,Bob";
		String mgr = createEmployeeManagerDictionary(map,inputString);
		System.out.println("Mgr who will resolve the issue is: " + mgr);

	}

	private static String createEmployeeManagerDictionary(HashMap<String, String> map, String inputString) {
		StringTokenizer tokens = new StringTokenizer(inputString,",");
		StringBuffer sb = new StringBuffer();
		String emp1 = null;
		String emp2 = null;
		
		while (tokens.hasMoreElements()) {
			String token = tokens.nextToken();
			if(token.contains("->")){
				map.put(token.split("->")[1], token.split("->")[0]);
			}else{
				sb.append(token + ",");
			}
		}
		
		
		tokens = new StringTokenizer(sb.toString(),",");
		while (tokens.hasMoreElements()) {
			emp1 = tokens.nextToken();
			emp2 = tokens.nextToken();
		}
		
		String mgr = resolveIssue(emp1,emp2,map);
		return mgr;
		
	}

	private static String resolveIssue(String emp1, String emp2, HashMap<String, String> map) {
		ArrayList<String> sb1 = getTree(emp1,map);
		ArrayList<String> sb2 = getTree(emp2,map);
		
		if(sb1.size()==0 && sb2.size()!=0){
			int i = sb2.size();
			return sb2.get(i-1);
		}
		
		if(sb2.size()==0 && sb1.size()!=0){
			int i = sb1.size();
			return sb1.get(i-1);
		}
		
		if(sb1.size()>sb2.size()){
			return sb2.get(0);
		}else{
			return sb1.get(0);
		}
	
	}

	private static ArrayList<String> getTree(String emp, HashMap<String, String> map) {
		ArrayList<String> stringArray = new ArrayList<String>();
		while(map.containsKey(emp)){
			stringArray.add(map.get(emp));
			emp = map.get(emp);
		}
		return stringArray;
	}

}