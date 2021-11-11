//CLASSE ARMA, USADA PARA ATRIBUIR UMA ARMA A UM PPERSONAGEM
public class Arma {
	//ATRIBUTOS
	private int ataque;
	private int defesa;
	
	//CONSTRUTOR
	public Arma(int ataque, int defesa){
		this.ataque = ataque;
		this.defesa = defesa;
	}
	
	//GETTERS/SETTERS
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
}
