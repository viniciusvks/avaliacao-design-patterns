package br.org.fundatec.lp3.designpatterns.arma;

import br.org.fundatec.lp3.designpatterns.TipoArma;

public class Martelo implements Arma {

	@Override
	public TipoArma getTipoArma() {
		return TipoArma.MARTELO;
	}

	@Override
	public Integer getDano() {
		return 15;
	}

	public String toString() {
		return "Machado";
	}

}
