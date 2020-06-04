package br.org.fundatec.lp3.designpatterns.arma;

import br.org.fundatec.lp3.designpatterns.TipoArma;

public class PunhalOrc implements Arma {

	@Override
	public TipoArma getTipoArma() {
		return TipoArma.PUNHAL;
	}

	@Override
	public Integer getDano() {
		return 18;
	}

	public String toString() {
		return "Punhal Orc";
	}

}
