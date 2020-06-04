package br.org.fundatec.lp3.designpatterns;

import java.util.ArrayList;
import java.util.List;

import br.org.fundatec.lp3.designpatterns.arma.Arma;

public abstract class Personagem {

	protected List<TipoArma> armasDisponiveis;
	protected Arma primeiraArma;
	protected Arma segundaArma;
	protected Arma ultimaArmaUsada;
	protected Integer vida;

	public Personagem() {
		vida = 100;
		armasDisponiveis = new ArrayList<>();
	}

	public abstract List<TipoArma> tiposDeArmaDisponiveis();

	public abstract TipoPersonagem getTipoPersonagem();

	public void setPrimeiraArma(Arma primeiraArma) {
		this.primeiraArma = primeiraArma;
	}

	public void setSegundaArma(Arma segundaArma) {
		this.segundaArma = segundaArma;
	}

	public Arma getPrimeiraArma() {
		return primeiraArma;
	}

	public Arma getSegundaArma() {
		return segundaArma;
	}

	public int getVida() {
		return vida;
	}

	public int atacar(Personagem personagem) {

		if (ultimaArmaUsada == null || ultimaArmaUsada.equals(primeiraArma)) {
			personagem.sofrerDano(segundaArma.getDano());
			ultimaArmaUsada = segundaArma;
		} else {
			personagem.sofrerDano(primeiraArma.getDano());
			ultimaArmaUsada = primeiraArma;
		}

		return ultimaArmaUsada.getDano();

	}

	public Arma getUltimaArma() {
		return ultimaArmaUsada;
	}

	public void sofrerDano(int dano) {

		if (dano > vida) {
			vida = 0;
		} else {
			vida -= dano;
		}

	}

	public String toString() {

		String msg = "Personagem: %s, Primeira arma: %s, Segunda arma: %s";
		return String.format(msg, getTipoPersonagem().name(), getPrimeiraArma().toString(),
				getSegundaArma().toString());
	}

}
