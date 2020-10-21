package br.org.fundatec.lp3.designpatterns;

import java.util.List;
import java.util.Scanner;

import br.org.fundatec.lp3.designpatterns.arma.ArcoEFlecha;
import br.org.fundatec.lp3.designpatterns.arma.EspadaElfo;
import br.org.fundatec.lp3.designpatterns.arma.EspadaOrc;
import br.org.fundatec.lp3.designpatterns.arma.Machado;
import br.org.fundatec.lp3.designpatterns.arma.Martelo;
import br.org.fundatec.lp3.designpatterns.arma.PunhalDuplo;
import br.org.fundatec.lp3.designpatterns.arma.PunhalElfo;
import br.org.fundatec.lp3.designpatterns.arma.PunhalOrc;

public class App {

	public static void main(String[] args) throws Exception {

		App app = new App();

		Scanner scanner = new Scanner(System.in);
		System.out.println("|-- Batalha de personagens --|");
		System.out.println("> Escolha o primeiro personagem: 1 - Elfo 2 - Orc");
		Personagem personagem1 = app.montaPersonagem(scanner);
		System.out.println("> Escolha o segundo personagem: 1 - Elfo 2 - Orc");
		Personagem personagem2 = app.montaPersonagem(scanner);

		Jogo jogo = new Jogo();
		String resultado = jogo.executar(personagem1, personagem2);
		
		System.out.println(resultado);		

	}

	public Personagem montaPersonagem(Scanner scanner) throws Exception {

		System.out.print("> ");
		
		int opcaoPersonagem = scanner.nextInt();
		Personagem personagem = TipoPersonagem.comOpcao(opcaoPersonagem);
		
		if(personagem == null) {
			return null;
		}

		System.out.println("> Primeira Arma: ");
		TipoArma tipoPrimeiraArma = montaArma(personagem, scanner);
		personagem.setPrimeiraArma(tipoPrimeiraArma);
		
		System.out.println("> Segunda Arma: ");
		TipoArma tipoSegundaArma = montaArma(personagem, scanner);

		personagem.setSegundaArma(tipoSegundaArma);

		return personagem;

	}

	public TipoArma montaArma(Personagem personagem, Scanner scanner) throws Exception {

		List<TipoArma> tiposDeArmaDisponiveis = personagem.tiposDeArmaDisponiveis();

		for (TipoArma tipoArma : tiposDeArmaDisponiveis) {
			System.out.println(tipoArma.getOpcao() + " - " + tipoArma.getTitulo() + " ");
		}

		System.out.print("> ");
		int opcaoArma = scanner.nextInt();

		TipoArma tipoArma = TipoArma.buscaPorOpcao(opcaoArma);

		if (tipoArma == null) {
			throw new Exception("Opcao de arma invalida");
		}

		return tipoArma;

	}

}
