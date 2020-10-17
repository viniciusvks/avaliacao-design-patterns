package br.org.fundatec.lp3.designpatterns;

public class Jogo {

	public String executar(Personagem personagem1, Personagem personagem2) {
		
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
			return personagem1.getTipoPersonagem().name() + " venceu!";
		} else {
			return personagem2.getTipoPersonagem().name() + " venceu!";
		}
		
	}
	
	private void imprimirPlacar(Personagem personagem1, Personagem personagem2) {
		System.out.println(String.format(
			"> %s %d x %d %s",
			personagem1.getTipoPersonagem().name(),
			personagem1.getVida(),
			personagem2.getVida(),
			personagem2.getTipoPersonagem().name()
		));
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
	
	
}
