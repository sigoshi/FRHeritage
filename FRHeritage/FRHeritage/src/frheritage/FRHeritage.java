/**
 * Published under the "i'm not fucking done with this, don't fuck with it" license
 * Terms: I'm not fucking done working on this, so don't fuck around with it.
 */
package frheritage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class FRHeritage {

	public static void main(String[] args) {
		// TODO add GUI

		if(Files.notExists(Paths.get("lair") )) new File("lair").mkdir();
		Scanner scin = new Scanner(System.in);
		Dragon temp = null;
		boolean cont=true;
		System.out.println("Welcome to Dragenealogy v a0.2");
		System.out.println();
		if(plchoose("Create Dragon","Modify Dragon")){
			while(cont){
				System.out.println("Dragon ID?\n");
				int id = scin.nextInt();
				temp = new Dragon(id);
				System.out.println("Dragon's Name?\n");
				scin.nextLine();
				String name = scin.nextLine();
				temp.setName(name);
				if(Files.exists(Paths.get("lair/"+id+".dragon"))){
					System.out.println("A dragon with that ID already exists. Retry?");
					if(!plchoose("Yes","No (will exit program)")){
						cont=false;
						break;
					}
				
				}
				else{
					saveDragon(temp);
					cont=false;
				}
			}
			System.exit(0);
		}
		else{
			System.out.println("Dragon ID?\n");
			int id=scin.nextInt();
			temp=loadDragon(id);
		}
	}
	
	public static boolean plchoose(String Y,String N){
		System.out.println("Y: "+Y+"\nN: "+N+"\n");
		Scanner read = new Scanner(System.in);
		String input;
		boolean cont=false;
		while(!cont){
			input = read.nextLine();
			System.out.println();
			input = input.toUpperCase();
			if(input.equals("Y")) {
				return true;
			}
			else if(input.equals("N")) {
				return false;
			}
			else System.out.println("Error: invalid option. Please retry.\n");
		}
		System.out.println("Program error encountered. Defaulting to \"N\" option");
		return false;
	}
	
	public static Dragon loadDragon(int id){
		Dragon temp=null;
		while(true){
			try{
				FileInputStream Load = new FileInputStream("/lair/"+id+".dragon");
				ObjectInputStream ObjIn = new ObjectInputStream(Load);
				temp = (Dragon) ObjIn.readObject();
				ObjIn.close();
				System.out.println(temp.DescSimple());
				System.out.println("Dragon loaded.");
				break;
			}catch (FileNotFoundException fnfe){
				System.out.println("There is no Dragon under that ID. Try again?");
				if(!plchoose("Yes","No")){
					System.out.println("Exiting.");
					System.exit(0);
				}
			}catch (IOException | ClassNotFoundException ioe){
				ioe.printStackTrace();
				System.exit(0);
			}
		}
		return temp;
		
	}
	
	public static boolean saveDragon(Dragon temp){
		int id=temp.getID();
		try{
			FileOutputStream Save = new FileOutputStream("/lair/"+id+".dragon");
			ObjectOutputStream ObjOut = new ObjectOutputStream(Save);
			ObjOut.writeObject(temp);
			ObjOut.close();
			System.out.println(temp.DescSimple());
			System.out.println("The above dragon has been saved.");
		}catch (IOException ioe){
			ioe.printStackTrace();
			return false;
		}
		return true;
		
	}
}
