package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> voteResult = new HashMap<>();
		//c:\temp\in.txt
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while (line != null) {
				String[] vect = line.split(",");
				String name = vect[0];
				int count  = Integer.parseInt(vect[1]);
				
				if (voteResult.containsKey(name)) {
					int votesSoFar = voteResult.get(name);
					voteResult.put(name, count + votesSoFar);
				}
				else {
					voteResult.put(name, count);
				}
				
				
				line = br.readLine();
				
			}
			
			
			for (String key : voteResult.keySet()) {
				System.out.println(key + ": " + voteResult.get(key));
			}
		}
		
		catch (FileNotFoundException e)	{
			System.out.print("File not found");
		}
		
		catch (IOException e)	{
		}

		sc.close();
		
	}


}
