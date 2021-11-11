//CLASSE DO ARQUEIRO QUE EXTENDE DE PERSONAGEM (ARQUEIRO É CLASSE FILHA DE PERSONAGEM)
//COM SEUS ATRIBUTOS, METODOS E GETTERS/SETTERS ARQUEIRO TEM !!TUDO!! QUE PERSONAGEM TEM
public class Arqueiro extends Personagem{

	private Arma arma;
	
	//CONSTRUTOR
	public Arqueiro(int ataque, int defesa, int pontosVida, String nome) {
		super(ataque, defesa, pontosVida, nome);
	}

	//GETTER/SETTER
	public void setArma(int tipoArma) {
		switch (tipoArma) {
		case 1: {
			this.arma = new Arma(12, 13);
			break;
		}
		case 2: {
			this.arma = new Arma(15, 10);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipoArma);
		}
	}
	
	public Arma getArma() {
		return arma;
	}
	
	//METODO USADO APENAS PARA ESCREVER NA TELA OS ATRIBUTOS DO ARQUEIRO
	public String toString(){
		System.out.println("Nome: " + getNome());
		System.out.println("ataque: " + getAtaque());
		System.out.println("defesa: " + getDefesa());
		System.out.println("Vida: " + getPontosVida());
		System.out.println("Ataque arma: " + arma.getAtaque());
		System.out.println("Defesa arma: " + arma.getDefesa());
		return null;
	}
	
	@Override
	public int atacar() {
		//super é uma referencia a classe pai do objeto
		int dano = super.getAtaque() + arma.getAtaque();
		return dano;
	}
}
