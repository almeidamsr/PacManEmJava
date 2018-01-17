//Eduarda C. G. Armstrong
//Matheus Almeida
//Prof: Andre Katayama
//5 periodo
//Sistemas de Informacao

package pacman;

import java.util.Random;

import com.googlecode.lanterna.terminal.Terminal;

public class Frutas extends Thread {

	int i = 8, j = 9;

	// posicao da frutinha
	int linhaAnterior = 8, colunaAnterior = 9;

	Terminal terminal;

	public Frutas(String str, Terminal terminal) {
		super(str);
		this.terminal = terminal;
	}

	public void run() {

		terminal.moveCursor(linhaAnterior, colunaAnterior);

		// cor do frutinha: cyan
		terminal.applyForegroundColor(6);

		// seta o tabuleiro
		Tabuleiro.setTab(i, j, '&');

		// representacao da frutinha no tabuleiro
		terminal.putCharacter('&');

		terminal.moveCursor(linhaAnterior, colunaAnterior);

	}

	public Posicao getPos() {
		Posicao posicao = new Posicao(i, j);
		return posicao;
	}
}
