package controller;

import java.util.concurrent.Semaphore;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class CarrosThread extends Thread{
	
	private static Semaphore semaforo;
	private String sentido;
	static String sinal=null;
	static String []confirmarSentido = {"N","S","L","O"};
	
	public CarrosThread(String sentido, Semaphore semaforo) {
		this.semaforo=semaforo;
		this.sentido=sentido;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			farol();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			passarCarro();
			semaforo.release();
		}
	}

	private void passarCarro() {
		System.out.println("O carro da direcao "+sentido+" passou");
		System.out.println("================================================");
	}

	private void farol(){
		int timeSleep=(int)(Math.random()*1001)+1000;
		
		for(int i=0;i<4;i++) {
			if(confirmarSentido[i].equals(sentido)) {
				sinal="verde";
			}else {
				sinal="vermelho";
			}
			
			System.out.println("Sinal "+sinal+" para carro no sentido "+confirmarSentido[i]);
			
		}
		
		try {
			sleep(timeSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
