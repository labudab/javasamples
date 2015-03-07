package proj11;

public class proj11 {

	public static void main(String[] args) {
	
		Thread t1 = new Thread(new dva("1"));
		Thread t2 = new Thread(new dva("2"));
		Thread t3 = new Thread(new dva("3"));
		t1.start();
		t2.start();
		t3.start();
	}

}
