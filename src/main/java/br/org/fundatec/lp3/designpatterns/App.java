package br.org.fundatec.lp3.designpatterns;

import java.util.List;
import java.util.Scanner;

import br.org.fundatec.lp3.designpatterns.arma.ArcoEFlecha;
import br.org.fundatec.lp3.designpatterns.arma.EspadaElfo;
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

		int turno = 1;
		Personagem atacante = personagem1;
		Personagem atacado = personagem2;
		int dano;

		do {

			imprimirPlacar(personagem1, personagem2);

			dano = atacante.atacar(atacado);

			imprimirMensagemDeAtaque(atacante, atacado, dano);

			if (turno == 1) {
				atacante = personagem2;
				atacado = personagem1;
				turno = 2;
			} else {
				atacante = personagem1;
				atacado = personagem2;
				turno = 1;
			}

		} while (personagem1.getVida() > 0 && personagem2.getVida() > 0);

		imprimirPlacar(personagem1, personagem2);

		if (personagem1.getVida() > 0) {
			System.out.println(personagem1.getTipoPersonagem().name() + " venceu!");
		} else {
			System.out.println(personagem2.getTipoPersonagem().name() + " venceu!");
		}

	}

	private static void imprimirMensagemDeAtaque(Personagem atacante, Personagem atacado, int dano) {
		System.out.println(String.format(
			"> %s ataca %s com %s! Dano: %d",
			atacante.getTipoPersonagem().name(),
			atacado.getTipoPersonagem().name(),
			atacante.getUltimaArma().toString(),
			dano
		));
	}

	private static void imprimirPlacar(Personagem personagem1, Personagem personagem2) {
		System.out.println(String.format(
			"> %s %d x %d %s",
			personagem1.getTipoPersonagem().name(),
			personagem1.getVida(),
			personagem2.getVida(),
			personagem2.getTipoPersonagem().name()
		));
	}

	public Personagem montaPersonagem(Scanner scanner) throws Exception {

		Personagem personagem;

		System.out.print("> ");
		int opcaoPersonagem = scanner.nextInt();

		if (opcaoPersonagem == TipoPersonagem.ELFO.getOpcao()) {
			personagem = new Elfo();
		} else if (opcaoPersonagem == TipoPersonagem.ORC.getOpcao()) {
			personagem = new Orc();
		} else {
			return null;
		}

		System.out.println("> Primeira Arma: ");
		TipoArma tipoPrimeiraArma = montaArma(personagem, scanner);

		if (personagem.getTipoPersonagem().equals(TipoPersonagem.ELFO)) {

			if (tipoPrimeiraArma.equals(TipoArma.ARCOEFLECHA)) {
				personagem.setPrimeiraArma(new ArcoEFlecha());
			} else if (tipoPrimeiraArma.equals(TipoArma.ESPADA)) {
				personagem.setPrimeiraArma(new EspadaElfo());
			} else if (tipoPrimeiraArma.equals(TipoArma.PUNHAL)) {
				personagem.setPrimeiraArma(new PunhalElfo());
			} else if (tipoPrimeiraArma.equals(TipoArma.PUNHALDUPLO)) {
				personagem.setPrimeiraArma(new PunhalDuplo());
			}

		} else if (personagem.getTipoPersonagem().equals(TipoPersonagem.ORC)) {

			if (tipoPrimeiraArma.equals(TipoArma.MACHADO)) {
				personagem.setPrimeiraArma(new Machado());
			} else if (tipoPrimeiraArma.equals(TipoArma.MARTELO)) {
				personagem.setPrimeiraArma(new Martelo());
			} else if (tipoPrimeiraArma.equals(TipoArma.PUNHAL)) {
				personagem.setPrimeiraArma(new PunhalOrc());
			} else if (tipoPrimeiraArma.equals(TipoArma.ESPADA)) {
				personagem.setPrimeiraArma(new PunhalDuplo());
			}

		}

		System.out.println("> Segunda Arma: ");
		TipoArma tipoSegundaArma = montaArma(personagem, scanner);

		if (personagem.getTipoPersonagem().equals(TipoPersonagem.ELFO)) {

			if (tipoSegundaArma.equals(TipoArma.ARCOEFLECHA)) {
				personagem.setSegundaArma(new ArcoEFlecha());
			} else if (tipoSegundaArma.equals(TipoArma.ESPADA)) {
				personagem.setSegundaArma(new EspadaElfo());
			} else if (tipoSegundaArma.equals(TipoArma.PUNHAL)) {
				personagem.setSegundaArma(new PunhalElfo());
			} else if (tipoSegundaArma.equals(TipoArma.PUNHALDUPLO)) {
				personagem.setSegundaArma(new PunhalDuplo());
			}

		} else if (personagem.getTipoPersonagem().equals(TipoPersonagem.ORC)) {

			if (tipoSegundaArma.equals(TipoArma.MACHADO)) {
				personagem.setSegundaArma(new Machado());
			} else if (tipoSegundaArma.equals(TipoArma.MARTELO)) {
				personagem.setSegundaArma(new Martelo());
			} else if (tipoSegundaArma.equals(TipoArma.PUNHAL)) {
				personagem.setSegundaArma(new PunhalOrc());
			} else if (tipoSegundaArma.equals(TipoArma.ESPADA)) {
				personagem.setSegundaArma(new PunhalDuplo());
			}

		}

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
