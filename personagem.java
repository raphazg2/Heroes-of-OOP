//CLASSE DO PERSONAGEM, COM SEUS ATRIBUTOS, METODOS E GETTERS/SETTERS
public class Personagem {
	
	//ATRIBUTOS
	private String nome;
	private int ataque;
	private int defesa;
	private double pontosVida;
	private boolean defendendo;
	
	//CONSTRUTOR
	public Personagem(int ataque, int defesa, int pontosVida, String nome) {
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setPontosVida(pontosVida);
		this.setNome(nome);
		this.defendendo = false;
	}

	public double getPontosVida() {
		return pontosVida;
	}
	
	public void setPontosVida(double d) {
		this.pontosVida = d;
	}
	
	public int getDefesa() {
		return defesa;
	}
	
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int atacar(){
		return 0;
	}

	public boolean isDefendendo() {
		return defendendo;
	}

	public void setDefendendo(boolean defendendo) {
		this.defendendo = defendendo;
	}
}
