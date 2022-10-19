import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.opencsv.CSVWriter;

public class CSVFileReader1 {

	
	public static void main(String[] args) {
		Map<String, List<User>> map = new HashMap();
		
		Scanner sc = null;
		try {
			sc = new Scanner(new File("input.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
		sc.useDelimiter("\n");  
		
		
		while (sc.hasNext())  
		{  
		  String line  = sc.next();
		  String[] insuranceDetails = line.split(",");
		  User user = new User();
		  user.setUserId(insuranceDetails[0]);
		  user.setFirstName(insuranceDetails[1]);
		  user.setLastName(insuranceDetails[2]);
		  user.setVersion(Integer.valueOf(insuranceDetails[3]));
		  user.setInsuranceCompany(insuranceDetails[4].trim());
		
		  if(map.get(user.getInsuranceCompany().trim())==null)
		  {
			  List<User> userList = new ArrayList<>();
			  userList.add(user);
			  map.put(user.getInsuranceCompany().trim(), userList);
		  }else
		  {

			  List<User> userList = map.get(user.getInsuranceCompany().trim());
			 
			  List<User> finaList = new ArrayList<>();
			  boolean added= false;
			  for(User user1:  userList)
			  {
				  if(user1.getUserId().equalsIgnoreCase(user.getUserId()))
				  {
					  if(user.getVersion()>user1.getVersion())
					  {
						 user1.setVersion(user.getVersion());
						 added = true;
						 finaList.add(user1); 
					  }
					
				  }else
				  finaList.add(user1); 
			  }
			  if(!added)
				  finaList.add(user);
			  added =false;
			  map.put(user.getInsuranceCompany().trim(), finaList);
		  }
		  
		}   
		  sc.close();
		 Iterator it= map.keySet().iterator();
		  while(it.hasNext()) {
			  String fn =((String) it.next()).trim();
		  String fileName = fn +".csv";
		  try {
			  File file = new File(fileName);
			CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName));
			List<User> users = (map.get(fn));
			
			users.sort((User u1,User u2) -> u1.getFirstName().compareTo(u2.getFirstName()));
			
			
			List<String[]> list = new ArrayList<>();
			for(User user: users)
			{
				String line1[] = {user.getUserId(),user.getFirstName(),
						user.getLastName(),user.getVersion()+"",
						user.getInsuranceCompany()};
				list.add(line1);
			}
			csvWriter.writeAll(list);
			csvWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }
	}
}
