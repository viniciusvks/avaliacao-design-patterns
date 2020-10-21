package br.org.fundatec.lp3.designpatterns;

import br.org.fundatec.lp3.designpatterns.arma.ArcoEFlecha;
import br.org.fundatec.lp3.designpatterns.arma.Arma;
import br.org.fundatec.lp3.designpatterns.arma.EspadaElfo;
import br.org.fundatec.lp3.designpatterns.arma.PunhalDuplo;
import br.org.fundatec.lp3.designpatterns.arma.PunhalElfo;

public class ArmaElfoFactory implements ArmaFactory {

	@Override
	public Arma criarArma(TipoArma tipoArma) {
		
		switch(tipoArma) {
			
			case ARCOEFLECHA:
				return new ArcoEFlecha();
			case ESPADA:
				return new EspadaElfo();
			case PUNHAL:
				return new PunhalElfo();
			case PUNHALDUPLO:
				return new PunhalDuplo();
			default:
				return null;
		
		}
		
	}

}
