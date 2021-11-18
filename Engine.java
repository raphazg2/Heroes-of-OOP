import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Engine {
	//LISTA USADA PARA GUARDAR OS PERSONAGENS CRIADOS PELO JOGADOR
	List<Personagem> personagens = new ArrayList<Personagem>();
	
	//AQUI FOI INSTANCIADO(CRIADO) UM OBJETO DRAGÃO, QUAL SERA O NOSSO INIMIGO DO JOGO
	Dragao dragao = new Dragao(60, 30, 300, "DRAGAO");
	
	public Engine(){}
	
	//METODO USADO PARA ADICIONAR UM PERSONAGEM QUE O JOGADOR CRIOU, NA LISTA DOS PERSONAGENS
	public void addPersonagem(Personagem personagem) {
		this.personagens.add(personagem);
	}
	
	//METODO USADO APENAS PARA PEGAR TODOS OS PERSONAGENS DA LISTA E ESCREVER OS SEUS ATRIBUTOS NA TELA
	public void escrevePersonagens() {
		for(Personagem personagemList : personagens) {
			personagemList.toString();
			System.out.println("\n");
		}
	}
	
	//METODO A SER DESENVOLVIDO PARA INICIAR O JOGO
	public void startGame() {
		Random random = new Random();
	    Scanner teclado = new Scanner(System.in);
	    int turno = 0;
		while(dragao.getPontosVida()>=0 && (personagens.size()!=0)){
			turno ++;
			for(Personagem personagemList : personagens) {
				boolean ataca;
				if(personagemList.getPontosVida() > 0) {
					personagemList.setDefendendo(false);
					System.out.println("1-atacar");
					System.out.println("2-defender");
					System.out.println("\n"+personagemList.getNome()+" ESCOLHA UMA AÇÃO: ");
					int escolha = teclado.nextInt();
					while (escolha != 1 && escolha !=2) {
						System.out.println("Valor invalido, digite um valor solicitado");
						escolha = teclado.nextInt();
					}
					ataca = (escolha == 1) ? true : false;
					if(ataca) {
						dragao.setPontosVida(dragao.getPontosVida()-(personagemList.atacar()-dragao.getDefesa()));
						System.out.println("vida do Dragão após ataque do " + personagemList.getNome() + ": " + dragao.getPontosVida());
					}else {
						personagemList.setDefendendo(true);
					}
				}
			}
				if(dragao.getPontosVida()>0) {
					int personagemAtacado = random.nextInt(personagens.size());
					if(personagens.get(personagemAtacado).isDefendendo()) {
						personagens.get(personagemAtacado).setPontosVida(personagens.get(personagemAtacado).getPontosVida()-(dragao.getAtaque()-(personagens.get(personagemAtacado).getDefesa()*1.1)));
					}else {
						personagens.get(personagemAtacado).setPontosVida(personagens.get(personagemAtacado).getPontosVida()-(dragao.getAtaque()-personagens.get(personagemAtacado).getDefesa()));
					}
					System.out.println(personagens.get(personagemAtacado).getNome() + " foi atacado, vida resultante: " + personagens.get(personagemAtacado).getPontosVida());
					if(personagens.get(personagemAtacado).getPontosVida()<=0) {
						System.out.println(personagens.get(personagemAtacado).getNome() + " morreu, seu corpo foi retirado do campo de batalha");
						personagens.remove(personagemAtacado);
					}
				}else {
					System.out.println("PARABENS VOCE MATOU O DRAGÃO !");
				}
		}
		if(dragao.getPontosVida()>0) {
			System.out.println("VOCE FOI DERROTADO PELO DRAGAO !");
		}
	}
}

