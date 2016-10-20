package programa;

public class Cliente {
	private String nome;
	private String nascimento;
	private String cpf;
	private String estado;
	private String cidade;
	private String rua;
	private String cep;
	private String telefone;
	private int id;
	
	public String getNome () {		
		return this.nome;
	}
	
	public void setNome (String nome) throws LENException {
		if (nome.length()<10){
			this.nome = nome;			
		} else {
			LENException e = new LENException();
			throw e;
		}
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
	
	public void setCep (String cep) {
		this.cep = cep;
	}
	
	public String getCep () {		
		return this.cep;
	}
	
	public void setTelefone (String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone () {
		return this.telefone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId () {
		return this.id;
	}
}
