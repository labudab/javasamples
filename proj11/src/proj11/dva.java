package proj11;

import java.util.*;

public class dva implements Runnable{
		
	int time;
	String name;
	Random r = new Random();
	
	public dva(String name){
		this.name = name;
		time = r.nextInt(999);
		
	}
	
	public void run() {
		System.out.printf("Поток %s спит %d\n", name, time);
		try{
			Thread.sleep(time);
		}catch(Exception e){}
		System.out.printf("Поток %s проснулся и закончился\n", name);
	}

}
