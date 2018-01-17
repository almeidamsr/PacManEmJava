package pacman;

public class Posicao {

	public int linha, coluna;

	public Posicao() {

	}

	public Posicao(int linha, int coluna) {

		this.coluna = coluna;

		this.linha = linha;

	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

}