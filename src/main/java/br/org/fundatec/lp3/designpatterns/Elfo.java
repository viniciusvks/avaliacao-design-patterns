package br.org.fundatec.lp3.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Elfo extends Personagem {

	public Elfo() {

		armasDisponiveis = new ArrayList<>();
		armasDisponiveis.add(TipoArma.ARCOEFLECHA);
		armasDisponiveis.add(TipoArma.PUNHAL);
		armasDisponiveis.add(TipoArma.PUNHALDUPLO);
		armasDisponiveis.add(TipoArma.ESPADA);

	}

	@Override
	public TipoPersonagem getTipoPersonagem() {
		return TipoPersonagem.ELFO;
	}

	@Override
	public List<TipoArma> tiposDeArmaDisponiveis() {
		return armasDisponiveis;
	}

}
