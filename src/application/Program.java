package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			Map<String, Integer> candidate = new HashMap<>();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);
				candidate.merge(name, votes, Integer::sum);
								
				line = br.readLine();
			}
			
			for (String key : candidate.keySet()) {
				System.out.println(key + ": " + candidate.get(key));
			}
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
