package meuBanco;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
	public static void main(String[] args) {
		
		try{
			//Cria um Piped out e um in para cada Thread receptora ou seja, 9 pra cada
			PipedOutputStream out = new PipedOutputStream();
			PipedOutputStream out2 = new PipedOutputStream();
			PipedOutputStream out3 = new PipedOutputStream();
			PipedOutputStream out4 = new PipedOutputStream();
			PipedOutputStream out5 = new PipedOutputStream();
			PipedOutputStream out6 = new PipedOutputStream();
			PipedOutputStream out7 = new PipedOutputStream();
			PipedOutputStream out8 = new PipedOutputStream();
			PipedOutputStream out9 = new PipedOutputStream();
			PipedInputStream in = new PipedInputStream(out);
			PipedInputStream in2 = new PipedInputStream(out2);
			PipedInputStream in3 = new PipedInputStream(out3);
			PipedInputStream in4 = new PipedInputStream(out4);
			PipedInputStream in5 = new PipedInputStream(out5);
			PipedInputStream in6 = new PipedInputStream(out6);
			PipedInputStream in7 = new PipedInputStream(out7);
			PipedInputStream in8 = new PipedInputStream(out8);
			PipedInputStream in9 = new PipedInputStream(out9);
			
			Conta conta = new Conta();
			
			//Objetos servidor
			Servidor servidor = new Servidor(in, in2, in3, conta);
			Servidor servidor2 = new Servidor(in4, in5, in6, conta);
			Servidor servidor3 = new Servidor(in7, in8, in9, conta);
			
			Cliente cliente1 = new Cliente(out, out2, out3);
			cliente1.setName("Cliente1");
			Cliente cliente2 = new Cliente(out4, out5, out6);
			cliente2.setName("Cliente2");
			Cliente cliente3 = new Cliente(out7, out8, out9);
			cliente3.setName("Cliente3");	
		
			//Starta Threads cliente
			cliente1.start();
			cliente2.start();
			cliente3.start();
			

			
		} catch (IOException e){
			e.printStackTrace();
		}
		

	}

}
