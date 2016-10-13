package programa;

public class Cliente {
	private int id;
	private String nome;
	private String nascimento;
	private String cpf;
	private String telefone;
	private String cep;
	private String estado;
	private String cidade;
	private String rua;
	
	public String getNome () {		
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getNascimento () {		
		return this.nascimento;
	}
	
	public void setNascimento (String nascimento) { 
		this.nascimento = nascimento;
	}
	
	public void setCpf (String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {		
		return this.cpf;
	}
	
	public void setTelefone (String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone () {
		return this.telefone;
	}
	
	public void setCep (String cep) {
		this.cep = cep;
	}
	
	public String getCep () {		
		return this.cep;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado () {		
		return this.estado;
	}
	
	public void setCidade (String cidade) {
		this.cidade = cidade;
	}
	
	public String getCidade () {		
		return this.cidade;
	}
	
	public void setRua (String rua) {
		this.rua = rua;
	}
	
	public String getRua () {		
		return this.rua;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId () {
		return this.id;
	}
}
