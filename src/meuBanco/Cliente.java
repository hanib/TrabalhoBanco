package meuBanco;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedOutputStream;

public class Cliente extends Thread {
	
	//variaveis para atribuir as operações realizadas na conta
	private int valorDep = 1;
	private int valorRet = 2;
	private int valorCor = 3;
	//Variaveis para contar quantas vezes cada operação foi realizada
	private int rodadasDep = 0;
	private int rodadasRet = 0;
	private int rodadasCor = 0;
	
	private DataOutputStream out;
	private DataOutputStream out2;
	private DataOutputStream out3;
	
	public Cliente(PipedOutputStream out, PipedOutputStream out2, PipedOutputStream out3){
		
			this.out = new DataOutputStream(out);	
			this.out2 = new DataOutputStream(out2);
			this.out3 = new DataOutputStream(out3);	
	}
	
	//Metodos que escrevem nos Piped qual opção será feita na conta.
	//Deposita escreve o valor 1
	public void deposita(){
		
		try {
			this.out.writeInt(this.valorDep);
			this.out.flush();
			sleep(300);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		this.rodadasDep++; 
		
	}
	
	//Retira escreve o valor 2
	public void retira(){
		
		try {
			this.out2.writeInt(this.valorRet);
			this.out2.flush();
			sleep(300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		this.rodadasRet++;
	}
	
	//Corrige escreve o valor 3
	public  void corrige(){
		
		try {
			this.out3.writeInt(this.valorCor);
			this.out3.flush();
			sleep(300);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		this.rodadasCor++;
	}
	
	public void run(){
		Thread thread = Thread.currentThread();		//Busca os valores da Thread atual
		System.out.println("Thread atual :" +thread.getName());		//Printa o nome atribuido a Thread
		while(true){
			
			if(this.rodadasDep < 40 && thread.getName().equals("Cliente1")){	//Condição de parada para Deposito
				this.deposita();				
			}
			if(this.rodadasRet < 40 && thread.getName().equals("Cliente2")){	//Condição de parada para Retirada
				this.retira();
			}
			if(this.rodadasCor < 40 && thread.getName().equals("Cliente3")){	//Condição de parada para Corrigir
				this.corrige();
			}
		}//fim do while
	}//fim do run
}//fim da classe Cliente
