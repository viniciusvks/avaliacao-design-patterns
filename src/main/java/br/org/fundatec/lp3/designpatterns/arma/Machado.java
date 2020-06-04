package br.org.fundatec.lp3.designpatterns.arma;

import br.org.fundatec.lp3.designpatterns.TipoArma;

public class Machado implements Arma {

	@Override
	public TipoArma getTipoArma() {
		return TipoArma.MACHADO;
	}

	@Override
	public Integer getDano() {
		return 30;
	}

	public String toString() {
		return "Machado";
	}

}
