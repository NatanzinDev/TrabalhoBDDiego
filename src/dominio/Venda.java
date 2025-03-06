package dominio;

public class Venda {
	private int id;
	private String nomecliente;
	private String data;
	
	
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
