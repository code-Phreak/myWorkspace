package evenodd;

public class EvenOddThread {
	
	public static void main(String[] args) {
		NumberPrinter np= new NumberPrinter();
		Thread even= new Thread(new EvenRunnable(np));
		Thread odd= new Thread(new OddRunnable(np));
		odd.start();
		even.start();
		
	}

}
