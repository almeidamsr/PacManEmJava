//Eduarda C. G. Armstrong
//Matheus Almeida
//Prof: Andre Katayama
//5 periodo
//Sistemas de Informacao

package pacman;

import com.googlecode.lanterna.terminal.Terminal;

public class Frutas2 extends Thread {

	// posicao da fruta
	int i = 13, j = 1;

	// posicao da frutinha
	int linhaAnterior = 13, colunaAnterior = 1;

	Terminal terminal;

	// construtor terminal
	public Frutas2(String str, Terminal terminal) {
		super(str);
		this.terminal = terminal;
	}

	public void run() {

		terminal.moveCursor(linhaAnterior, colunaAnterior);

		// cor do frutinha: cyan
		terminal.applyForegroundColor(6);

		// seta o tabuleiro
		Tabuleiro.setTab(i, j, '$');

		// representacao da frutinha no tabuleiro
		terminal.putCharacter('$');

		terminal.moveCursor(linhaAnterior, colunaAnterior);

	}

	public Posicao getPos() {
		Posicao posicao = new Posicao(i, j);
		return posicao;
	}

}
