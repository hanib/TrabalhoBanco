package meuBanco;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Conta {
	
	private double total = round2(100.398247389247);
	private int operacao;
	
	//para formatar as casas decimais do valor total
	public Double round2(Double value){
		BigDecimal valorExato = new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);	
		return valorExato.doubleValue();
	}
	
	//Metodo que realiza as alterações no saldo total da conta
	public void atualizaConta(int operacao){
		
		this.operacao = operacao;
		System.out.println("Operação é :" +this.operacao);
		if(this.operacao == 1){		//faz deposito
			
			this.total += 10;
			System.out.println("Adiciona 10");
			System.out.println("Saldo atualizado " + round2(total));
			
		}else if (this.operacao == 2){		//faz retirada
			
			this.total -= 3;
			System.out.println("Retirou 3");
			System.out.println("Saldo atualizado " +round2(total));
			
		}else if (this.operacao == 3){		//faz correção
			
			this.total *= 1.1;
			System.out.println("Aplicou correção");
			System.out.println("Saldo atualizado " +round2(total));
		}		
	}
}
