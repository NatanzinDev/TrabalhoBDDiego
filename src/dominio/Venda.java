package dominio;

public class Venda {
	private int id;
	private String nomecliente;
	private String data;
	private Combustivel combustivel;
	
	
	public Combustivel getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	@Override
	public String toString() {
		return "Venda [nomecliente=" + nomecliente + ", data=" + data + "]";
	}
	public String getNomecliente() {
		return nomecliente;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
