package com.jsp.ConnectionTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.jsp.Dao.CafeImplement;
import com.jsp.Dto.Cafe;

public class CafeTest {
	
	public static void main(String[] args) throws IOException {
		
		int id, choice = 0;
		String name;
		String type;
		String category;
		double price;
		
		Scanner sc = new Scanner(System.in);
		InputStreamReader str = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(str);
		System.out.println("1. Add Cafe, 2. Update Cafe, 3. GetById Cafe, 4. GetAll Cafe, 5. Delete Cafe");
		System.out.println("Enter choice");
		choice = sc.nextInt();
		
		CafeImplement fdi = new CafeImplement();
		
		switch(choice) {
		case 1: {
			System.out.println("Enter Cafe name");
			name = br.readLine();
			System.out.println("Enter Cafe type");
			type = br.readLine();
			System.out.println("Enter Cafe category");
			category = br.readLine();
			System.out.println("Enter Cafe price");
			price = sc.nextDouble();
			
			Cafe cafe = new Cafe(name, type, category, price);
			boolean b = fdi.addCafe(cafe);
			if(b) {
				System.out.println("Success");
			} else System.out.println("Fail");
			break;
		}
		case 2:{
			System.out.println("Enter existing Cafe Id");
			id = sc.nextInt();
			System.out.println("Enter Cafe name");
			name = br.readLine();
			System.out.println("Enter Cafe type");
			type = br.readLine();
			System.out.println("Enter Cafe category");
			category = br.readLine();
			System.out.println("Enter Cafe price");
			price = sc.nextDouble();
			
			Cafe cafe = new Cafe(id, name, type, category, price);
			cafe.setId(id);
			boolean b = fdi.updateCafe(cafe);
			if(b) {
				System.out.println("Success");
			} else System.out.println("Fail");
			break;
		}
		case 3:{
			System.out.println("Enter existing Cafe Id");
			id = sc.nextInt();
			Cafe cafe = fdi.searchCafeById(id);
			if(cafe != null) {
				System.out.println("Success");
				System.out.println();
				System.out.println("Cafe id is: "+cafe.getId());
				System.out.println("Cafe name is: "+cafe.getName());
				System.out.println("Cafe type is: "+cafe.getType());
				System.out.println("Cafe category is: "+cafe.getCategory());
				System.out.println("Cafe price is: "+cafe.getPrice());
			} else System.out.println("Fail");
			break;
		}
		case 4:{
			System.out.println("Get All Cafes");
			System.out.println();
			List<Cafe> cafe = fdi.getAllCafe();
			if(cafe != null && !(cafe.isEmpty())) {
				for(Cafe f: cafe) {
					System.out.println(f);
				}
			}
			break;
		}
		case 5:{
			System.out.println("Enter existing Cafe Id");
			id = sc.nextInt();
			boolean b = fdi.deleteCcafe(id);
			if(b) {
				System.out.println("Deleted");
			} else System.out.println("Fail");
			break;
		}
		}
	}
}
