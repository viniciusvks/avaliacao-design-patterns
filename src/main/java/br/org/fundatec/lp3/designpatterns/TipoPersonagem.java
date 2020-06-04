package br.org.fundatec.lp3.designpatterns;

public enum TipoPersonagem {

	ELFO(1),
	ORC(2);

	private int opcao;

	TipoPersonagem(int opcao) {
		this.opcao = opcao;
	}

	public int getOpcao() {
		return this.opcao;
	}

}
