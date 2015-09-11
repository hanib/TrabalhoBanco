package meuBanco;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PipedInputStream;

//Receptor recebe o valor 1, 2 ou 3 enviado pelo cliente, para saber qual operação realizar.
public class Receptor extends Thread{
	
	private int operacao = 0;	//Variavel que permite passar para o objeto compartilhado Conta qual movimentação será feita
	
	private DataInputStream in;
	private Conta conta;
	
	public Receptor(){
		
	}
	
	public Receptor(PipedInputStream in, Conta conta){
		
		this.conta = conta;
		this.in = new DataInputStream(in);
	}
	
	//Métodos que fazem a chamada do método atualizaConta de Conta.
	public synchronized void deposita(){
		
		synchronized (this.conta) {
			
			//this.operacao = 1;		//altera o valor de operacao para 1 (deposito)
			conta.atualizaConta(operacao);
		}
		
	}
	
	public synchronized void retirar(){
		
		synchronized (this.conta) {
			
			//this.operacao = 2;		//altera o valor de operacao para 2 (retirada)
			conta.atualizaConta(operacao);
		}

	}
	
	public synchronized void aplicarCorrecao(){
		
		synchronized (this.conta) {
			
			//this.operacao = 3;		//altera o valor de operacao para 3 (corrige)
			conta.atualizaConta(operacao);
		}

	}
	
	public void run(){
		while(true) {
			try {
				this.operacao = this.in.readInt();		//Le o que está no Piped e atribui para a variável operacao
				sleep(500);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			
			if(this.operacao == 1 && this.operacao != 0){
				
				this.deposita();
				this.operacao = 0;
				
			}else if (this.operacao == 2 && this.operacao != 0){
				
				this.retirar();
				this.operacao = 0;
				
			}else if(this.operacao == 3 && this.operacao != 0){
				
				this.aplicarCorrecao();
				this.operacao = 0;
				
			}
		}//fim do while
		
	}//fim do run
	
}//fim da classe
