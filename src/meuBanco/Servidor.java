package meuBanco;

import java.io.PipedInputStream;

public class Servidor{

	//Instancia os objetos Receptor e da start nas Threads receptoras
	public Servidor(PipedInputStream in, PipedInputStream in2, PipedInputStream in3, Conta conta){
		
		Receptor rec = new Receptor(in, conta);
		Receptor rec2 = new Receptor(in2, conta);
		Receptor rec3 = new Receptor(in3, conta);
		rec.start(); 
		rec2.start(); 
		rec3.start(); 

	}	
}
