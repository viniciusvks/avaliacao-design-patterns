package br.org.fundatec.lp3.designpatterns;

public enum TipoPersonagem {

	ELFO(1, new Elfo()),
	ORC(2, new Orc());

	private int opcao;
	private Personagem personagem;

	TipoPersonagem(int opcao, Personagem personagem) {
		this.opcao = opcao;
		this.personagem = personagem;
	}

	public int getOpcao() {
		return this.opcao;
	}
	
	public Personagem getPersonagem() {
		return personagem;
	}
	
	public static Personagem buscarPorOpcao(int opcao) {
		
		TipoPersonagem[] tiposDePersonagem = values();
		
		for(TipoPersonagem tipoDePersonagem : tiposDePersonagem) {
			
			if(tipoDePersonagem.getOpcao() == opcao) {
				return tipoDePersonagem.getPersonagem();
			}
		}
		
		return null;
		
	}

}
