package view;
import java.util.concurrent.Semaphore;
import controller.CarrosThread;

public class Carros {
	
	public static void main(String[] args) {
		String[] sentido= {"N", "S","L","O"};
		Semaphore semaforo= new Semaphore(1);
		for(int i=0;i<4;i++) {
			Thread carro=new CarrosThread(sentido[i],semaforo);
			carro.start();
		}
	}
}
