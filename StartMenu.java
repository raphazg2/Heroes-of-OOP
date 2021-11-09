//CLASSE RESPONSAVEL PELO MENU INICIAL
import java.io.IOException;
import java.util.Scanner;

public class StartMenu {
	//METODO MAIN (O METODO PRINCIPAL USADO PARA INICIAR O JOGO)
	public static void main(String[] args) throws IOException, InterruptedException {
		//INSTANCIA O OBJETO ENGINE DO JOGO, PARA PODER DAR UM "START" NO JOGO
		Engine engine = new Engine();
		
		//CRIA O OBJETO "TECLADO" PARA PEGAR TUDO OQUE O USUARIO DIGITAR QUANDO SOLICITADO
	    Scanner teclado = new Scanner(System.in);
	   
	    int personagensCriados = 0;
	    //variavel verdadeiro ou falso, usada para decidir quando encerrar o jogo
	    boolean continuaJogo = true;
	    
		while(continuaJogo) {
		    //IMPRIMI O MENUZINHO PARA O JOGADOR ESCOLHER UMA OPÇÃO
		    System.out.println("=========Bem vindo ao Heroes of OOP=========");
		    System.out.println("1-Criar personagem");
		    System.out.println("2-Começar partida");
		    System.out.println("3-Listar personagens");
		    System.out.println("4-Sair do jogo");
		    System.out.print("Escolha uma das opções: ");
		    //PEGA O PROXIMO VALOR INTEIRO QUE O JOGADOR DIGITAR
		    int escolha = teclado.nextInt();
		    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
		    //WHILE USADO PARA CRIAR 3 PERSONAGENS
		    
		    	//SWITCH UTILIZADO PARA INTERPRETAR AS ESCOLHAS DO JOGADOR NO MENU
			    switch (escolha) {
				case 1: {
					while(personagensCriados !=3) {
						System.out.println("Escolha um dos seguintes personagens:");
					    System.out.println("1-Guerreiro");
					    System.out.println("2-Mago");
					    System.out.println("3-Arqueiro");
					    System.out.print("Escolha com sabedoria: ");
					    int tipoPersonagem = teclado.nextInt();
					    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
					    //CHAMA O METODO DA CLASSE "ENGINE" PARA ADICIONAR UM PERSONAGEM NA LISTA DE PERSONAGENS
					    engine.addPersonagem(createCharacter(tipoPersonagem));
					    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
				    	personagensCriados++;
					}
					break;
				}
				case 2: {
					if(personagensCriados == 3) {
						engine.startGame();
					}else {
						System.out.println("crie os tres personagens primeiro !!!!");
						System.in.read();
					}
					break;
				}
				case 3: {
				    //APENAS ESCREVE OS ATRIBUTOS DOS PERSONAGENS NA TELA PARA CONFERIR SE ESTA TUDO OK
				    engine.escrevePersonagens();
					break;
				}
				case 4: {
					continuaJogo = false;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + escolha);
				}
		}
	}
	
	//METODO USADO PARA CRIAR UM PERSONAGEM E ESCOLHER A ARMA DE TAL PERSONAGEM
	private static Personagem createCharacter(int tipoPersonagem){
	    Scanner teclado = new Scanner(System.in);
		switch (tipoPersonagem) {
		case 1:{
			System.out.println("Escolha uma das seguintes armas para seu guerreiro: ");
			System.out.println("1-Espada atq +10 def +15");
			System.out.println("2-Machado atq +17 def +8");
			System.out.print("Escolha sua arma: ");
		    int tipoArma = teclado.nextInt();
			System.out.print("Digite o nome do seu personagem: ");
			//INSTANCIA O OBJETO PERSONAGEM PARA RETORNAR AO METODO E ADICIONALO A LISTA DE PERSONAGENS
			Guerreiro guerreiro = new Guerreiro(30, 20, 180, teclado.next());
			guerreiro.setArma(tipoArma);
			return guerreiro;
		}
		case 2:{
			System.out.println("Escolha uma das seguintes armas para seu mago: ");
			System.out.println("1-Varinha atq +16 def +9");
			System.out.println("2-Cajado atq +13 def +12");
			System.out.print("Escolha sua arma: ");
		    int tipoArma = teclado.nextInt();
		    System.out.print("Digite o nome do seu personagem: ");
			Mago mago = new Mago(20, 10, 200, teclado.next());
			mago.setArma(tipoArma);
			return mago;
		}
		case 3:{
			System.out.println("Escolha uma das seguintes armas para seu arqueiro: ");
			System.out.println("1-Arco Longo atq +12 def +13");
			System.out.println("2-Balestra atq +15 def +10");
			System.out.print("Escolha sua arma: ");
		    int tipoArma = teclado.nextInt();
		    System.out.print("Digite o nome do seu personagem: ");
			Arqueiro arqueiro = new Arqueiro(20, 30, 160, teclado.next());
			arqueiro.setArma(tipoArma);
			return arqueiro;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipoPersonagem);
		}
	}
}
