package programa;

import java.util.Scanner;

public class Venda {
	private Scanner ler = new Scanner(System.in);
	String nomeVenda;
	public void venda() {
		System.out.println();
		System.out.println("Qual produto você quer comprar?");
		nomeVenda = ler.nextLine();
	}
}
