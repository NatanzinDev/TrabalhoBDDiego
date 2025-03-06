package dominio;

public class Combustivel {
	
	@Override
	public String toString() {
		return "Nome: " + nome + " - " + "Tipo: " + tipo;
	}
 

	private int id;
	private String nome;
	private String valor;
	private String tipo;
	private Venda venda;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	
	

	

}
