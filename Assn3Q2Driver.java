//Author Peter Adamson

import java.util.Scanner;

public class Assn3Q2Driver{

	public static void main(String[] args){
		
		try{
			Assn3Q2DoubLinkList dList = new Assn3Q2DoubLinkList();
			Scanner sc = new Scanner(System.in);

			int value = 0;


			do{
				System.out.println("Please enter a positive value or 0 to exit: "); 
				value = sc.nextInt();
				sc.nextLine();
				if(value > 0){
					dList.insert(value);
				}
			
			} while(value > 0);
		
			if(dList.size() > 0){
				System.out.println(dList.toStringAscending());
				System.out.println("-----------------------------------------");
				System.out.println(dList.toStringDescending());
			}
		}
		catch(Exception exp){
			System.out.println("An exception was encountered!\n\n" + exp);
		}
	}
}
