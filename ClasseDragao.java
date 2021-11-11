//CLASSE DRAGÃO E SEUS GETTERS/SETTERS
public class Dragao extends Personagem{
	
	public Dragao(int ataque, int defesa, int pontosVida, String nome) {
		super(ataque, defesa, pontosVida, nome);
	}
	
	@Override
	public int atacar() {
		//super é uma referencia a classe pai do objeto
		int dano = super.getAtaque();
		return dano;
	}
}
