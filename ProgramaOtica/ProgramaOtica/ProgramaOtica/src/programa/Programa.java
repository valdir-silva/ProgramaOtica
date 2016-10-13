package programa;

import javax.swing.JOptionPane;

public class Programa {

	public static void main(String[] args) {
		
		//Cadastrar cliente
		
		Cliente me = new Cliente();
		
		me.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
		me.setNascimento(JOptionPane.showInputDialog("Qual sua data de nascimento?"));
		me.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
		me.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
		me.setCep(JOptionPane.showInputDialog("Qual o seu cep?"));
		me.setEstado(JOptionPane.showInputDialog("Qual o seu estado?"));
		me.setCidade(JOptionPane.showInputDialog("Qual a sua cidade?"));
		me.setRua(JOptionPane.showInputDialog("Qual a sua rua?"));
		
		//Fim Cadastrar
		
		//Saída com dados da instância
		
		System.out.printf("nome: %s\nnascimento: %s\ncpf: %s\ntelefone: %s\ncep: %s\nestado: %s\ncidade: %s\nrua: %s\n", 
				me.getNome(),me.getNascimento(),me.getCpf(),me.getTelefone(),me.getCep(),me.getEstado(),me.getCidade(),me.getRua());
		
		//Fim Saída
	}

}