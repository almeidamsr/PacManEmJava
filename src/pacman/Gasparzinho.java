//Eduarda C. G. Armstrong
//Matheus Almeida
//Prof: Andre Katayama
//5 periodo
//Sistemas de Informacao
package pacman;

import java.util.Random;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalFacade;

import com.googlecode.lanterna.input.Key;

import com.googlecode.lanterna.terminal.TerminalSize;

public class Gasparzinho extends Thread {

	// posicao gasparzinho
	int i = 18, j = 10;

	// gasparzinho inicia nessa posicao
	int linhaAnterior = 18, colunaAnterior = 10;

	Terminal terminal;

	// construtor do terminal
	public Gasparzinho(String str, Terminal terminal) {
		super(str);
		this.terminal = terminal;
	}

	Random sort = new Random();

	// variavel que recebe o valor randomico
	int lado = 0;

	public void Caracteristicas() {

		terminal.moveCursor(linhaAnterior, colunaAnterior);

		// cor do gasparzinho: green
		terminal.applyForegroundColor(2);

		// representacao do gasparzinho no tabuleiro
		terminal.putCharacter('G');

		terminal.moveCursor(linhaAnterior, colunaAnterior);
	}

	public void Testes() {

		// se a posicao for diferente de #
		if (Tabuleiro.getTab(i, j) != '#') {

			terminal.moveCursor(i, j);

			// cor do gasparzinho: green
			terminal.applyForegroundColor(2);

			terminal.putCharacter('G');

			// se a posicao for igual a '.' quando o G sair da posicao
			// deixara '.'
			if (Tabuleiro.getTab(i, j) == '.') {

				terminal.moveCursor(linhaAnterior, colunaAnterior);

				// seta o tabuleiro
				Tabuleiro.setTab(i, j, '.');

				// mantem a cor dos pontinhos na cor branca
				terminal.applyForegroundColor(7);

				terminal.putCharacter('.');

				terminal.moveCursor(i, j);

				linhaAnterior = i;

				colunaAnterior = j;

			}

			// se a posicao for diferente de '.' quando o G sair
			// deixara ' '
			else if (Tabuleiro.getTab(i, j) == ' ') {

				terminal.moveCursor(linhaAnterior, colunaAnterior);

				// seta o tabuleiro
				Tabuleiro.setTab(i, j, ' ');

				terminal.putCharacter(' ');

				terminal.moveCursor(i, j);

				linhaAnterior = i;

				colunaAnterior = j;
			}

			// se a posicao for diferente de '.' quando o G sair
			// deixara '&'
			else if (Tabuleiro.getTab(i, j) == '&') {

				terminal.moveCursor(linhaAnterior, colunaAnterior);

				// seta o tabuleiro
				Tabuleiro.setTab(i, j, '&');

				terminal.putCharacter('&');

				terminal.moveCursor(i, j);

				linhaAnterior = i;

				colunaAnterior = j;
			}

			// se a posicao for diferente de '.' quando o G sair
			// deixara '$'
			else if (Tabuleiro.getTab(i, j) == '$') {

				terminal.moveCursor(linhaAnterior, colunaAnterior);

				// seta o tabuleiro
				Tabuleiro.setTab(i, j, '$');

				terminal.putCharacter('$');

				terminal.moveCursor(i, j);

				linhaAnterior = i;

				colunaAnterior = j;
			}

			else {

				terminal.moveCursor(linhaAnterior, colunaAnterior);

				terminal.moveCursor(i, j);

				linhaAnterior = i;

				colunaAnterior = j;

			}
		}

	}

	public void run() {
		Caracteristicas();

		// loop
		while (true) {
			// sorteia a posicao e salva em lado
			lado = sort.nextInt(4);
			try {

				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (lado) {
			// seta para baixo

			case 0:

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j++;

				// se a posicao for diferente de #
				if (Tabuleiro.getTab(i, j) != '#') {

					Testes();

				} else {
					j--;

				}

				break;

			// seta para cima
			case 1:

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				j--;

				// se a posicao for diferente de #
				if (Tabuleiro.getTab(i, j) != '#') {

					Testes();

				} else {
					j++;

				}

				break;

			// seta para a esquerda
			case 2:

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				i--;

				// se a posicao for diferente de #
				if (Tabuleiro.getTab(i, j) != '#') {

					Testes();

				} else {
					i++;

				}

				break;

			// seta para a direita
			case 3:

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				i++;

				// se a posicao for diferente de #
				if (Tabuleiro.getTab(i, j) != '#') {

					Testes();

				} else {
					i--;

				}

				break;

			default:

				break;

			}
		}
	}

	public Posicao getPos() {
		Posicao posicao = new Posicao(i, j);
		return posicao;
	}

}