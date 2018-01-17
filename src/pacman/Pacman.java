//Eduarda C. G. Armstrong
//Matheus Almeida
//Prof: Andre Katayama
//5 periodo
//Sistemas de Informacao
package pacman;

import java.math.BigDecimal;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class Pacman extends Thread {

	// posicao do pacman
	int i = 8, j = 9;
	Terminal terminal;

	// construtor do terminal
	public Pacman(String str, Terminal terminal) {
		super(str);
		this.terminal = terminal;

	}

	public void run() {

		// inicia os Fantasmas
		Fantasma fantasma = new Fantasma("Fantasma", terminal);
		fantasma.start();

		Gasparzinho gasparzinho = new Gasparzinho("Gasparzinho", terminal);
		gasparzinho.start();

		Blue blue = new Blue("Blue", terminal);
		blue.start();

		Magenta magenta = new Magenta("Magenta", terminal);
		magenta.start();

		// fruta
		Frutas frutas = new Frutas("Frutas", terminal);

		Frutas2 frutas2 = new Frutas2("Frutas2", terminal);

		// pacman inicia nessa posicao
		int linhaAnterior = 8, colunaAnterior = 9;

		terminal.moveCursor(linhaAnterior, colunaAnterior);

		// cor do pacman: yellow
		terminal.applyForegroundColor(3);

		// representacao do pacman no tabuleiro
		terminal.putCharacter('@');

		terminal.moveCursor(linhaAnterior, colunaAnterior);

		// variavel

		int vidas = 2;
		int pontos = 0;

		// variaveis que utilizei para calcular o tempo
		double init = 0.0;
		double end = 0.0;
		double tempo = 0.0;

		// Enquanto vidas for maior que 0 e pontos diferente de 196 ele ficara
		// no loop
		while (true && vidas > 0 && pontos != 195) {

			// inicio do metodo que conta o tempo
			init = System.currentTimeMillis();

			// instancia a classe teclado
			Key key = terminal.readInput();

			Posicao posicaoFantasma = fantasma.getPos();
			Posicao posicaoGasparzinho = gasparzinho.getPos();
			Posicao posicaoBlue = blue.getPos();
			Posicao posicaoMagenta = magenta.getPos();
			Posicao posicaoFrutas = frutas.getPos();
			Posicao posicaoFrutas2 = frutas2.getPos();

			if (key != null)

			{

				if (null != key.getKind())

					switch (key.getKind()) {

					// seta para baixo
					case ArrowDown:

						j++;

						// se a posicao for diferente de parede ele entra no if
						if (Tabuleiro.getTab(i, j) != '#') {

							terminal.applyForegroundColor(7);

							terminal.moveCursor(i, j);

							// cor do pacman: yellow
							terminal.applyForegroundColor(3);

							// representacao do pacman no tabuleiro
							terminal.putCharacter('@');

							terminal.moveCursor(linhaAnterior, colunaAnterior);

							// se a posicao do pacman for a mesma de um dos
							// fantasmas ele perde uma vida e volta para o
							// inicio
							if (i == posicaoFantasma.getLinha() && j == posicaoFantasma.getColuna()
									|| i == posicaoGasparzinho.getLinha() && j == posicaoGasparzinho.getColuna()
									|| i == posicaoBlue.getLinha() && j == posicaoBlue.getColuna()
									|| i == posicaoMagenta.getLinha() && j == posicaoMagenta.getColuna()) {
								vidas--;
								i = 8;
								j = 9;

							}

							// se a posicao do pacman for igual a da frutinha o pacman ganha 1 vida
							else if (i == posicaoFrutas.getLinha() && j == posicaoFrutas.getColuna()
									|| i == posicaoFrutas2.getLinha() && j == posicaoFrutas2.getColuna()) {
								if (Tabuleiro.getTab(i, j) == '&' || Tabuleiro.getTab(i, j) == '$') {

									vidas++;
									Tabuleiro.setTab(i, j, ' ');
									terminal.putCharacter(' ');
								}

							}

							// se a posicao for igual a '.' entra no if soma
							// pontos e seta o tabuleiro
							else if (Tabuleiro.getTab(i, j) == '.') {

								// seta o tabuleiro
								Tabuleiro.setTab(i, j, ' ');

								terminal.putCharacter(' ');

								pontos++;
							}

							// se for diferente de '.' e '#' coloca um espaco em
							// branco
							else {

								terminal.putCharacter(' ');
							}

							terminal.moveCursor(i, j);

							linhaAnterior = i;

							colunaAnterior = j;

						}

						else {

							terminal.applyForegroundColor(1);

							j--;

							terminal.moveCursor(i, j);

							// cor do pacman: yellow
							terminal.applyForegroundColor(3);

							// representacao do pacman no tabuleiro
							terminal.putCharacter('@');
						}

						break;

					// seta para cima
					case ArrowUp:

						j--;

						if (Tabuleiro.getTab(i, j) != '#') {

							terminal.moveCursor(i, j);

							// cor do pacman: yellow
							terminal.applyForegroundColor(3);

							// representacao do pacman no tabuleiro
							terminal.putCharacter('@');

							terminal.moveCursor(linhaAnterior, colunaAnterior);

							// se a posicao do pacman for a mesma de um dos
							// fantasmas ele perde uma vida e volta para o
							// inicio
							if (i == posicaoFantasma.getLinha() && j == posicaoFantasma.getColuna()
									|| i == posicaoGasparzinho.getLinha() && j == posicaoGasparzinho.getColuna()
									|| i == posicaoBlue.getLinha() && j == posicaoBlue.getColuna()
									|| i == posicaoMagenta.getLinha() && j == posicaoMagenta.getColuna()) {
								vidas--;
								i = 8;
								j = 9;

							}

							// se a posicao do pacman for igual a da frutinha o
							// pacman ganha 1 vida
							else if (i == posicaoFrutas.getLinha() && j == posicaoFrutas.getColuna()
									|| i == posicaoFrutas2.getLinha() && j == posicaoFrutas2.getColuna()) {
								if (Tabuleiro.getTab(i, j) == '&' || Tabuleiro.getTab(i, j) == '$') {

									vidas++;
									Tabuleiro.setTab(i, j, ' ');
									terminal.putCharacter(' ');
								}

							}

							// se a posicao for igual a '.' entra no if soma
							// pontos e seta o tabuleiro
							if (Tabuleiro.getTab(i, j) == '.') {

								// seta o tabuleiro
								Tabuleiro.setTab(i, j, ' ');

								terminal.putCharacter(' ');

								pontos++;
							}

							// se for diferente de '.' e '#' coloca um espaco em
							// branco
							else {

								terminal.putCharacter(' ');
							}

							terminal.moveCursor(i, j);

							linhaAnterior = i;

							colunaAnterior = j;

						}

						else {

							terminal.applyForegroundColor(1);

							j++;

							terminal.moveCursor(i, j);

							// cor do pacman: yellow
							terminal.applyForegroundColor(3);

							// representacao do pacman no tabuleiro
							terminal.putCharacter('@');
						}

						break;

					// seta para a esquerda
					case ArrowLeft:

						i--;

						if (Tabuleiro.getTab(i, j) != '#') {

							terminal.moveCursor(i, j);

							// cor do pacman: yellow
							terminal.applyForegroundColor(3);

							// representacao do pacman no tabuleiro
							terminal.putCharacter('@');

							terminal.moveCursor(linhaAnterior, colunaAnterior);

							// se a posicao do pacman for a mesma de um dos
							// fantasmas ele perde uma vida e volta para o
							// inicio
							if (i == posicaoFantasma.getLinha() && j == posicaoFantasma.getColuna()
									|| i == posicaoGasparzinho.getLinha() && j == posicaoGasparzinho.getColuna()
									|| i == posicaoBlue.getLinha() && j == posicaoBlue.getColuna()
									|| i == posicaoMagenta.getLinha() && j == posicaoMagenta.getColuna()) {
								vidas--;
								i = 8;
								j = 9;

							}

							// se a posicao do pacman for igual a da frutinha o
							// pacman ganha 1 vida
							else if (i == posicaoFrutas.getLinha() && j == posicaoFrutas.getColuna()
									|| i == posicaoFrutas2.getLinha() && j == posicaoFrutas2.getColuna()) {

								if (Tabuleiro.getTab(i, j) == '&' || Tabuleiro.getTab(i, j) == '$') {

									vidas++;
									Tabuleiro.setTab(i, j, ' ');
									terminal.putCharacter(' ');
								}

							}

							// se a posicao for igual a '.' entra no if soma
							// pontos e seta o tabuleiro
							if (Tabuleiro.getTab(i, j) == '.') {

								// seta o tabuleiro
								Tabuleiro.setTab(i, j, ' ');

								terminal.putCharacter(' ');

								pontos++;
							}

							// se for diferente de '.' e '#' coloca um espaco em
							// branco
							else {

								terminal.putCharacter(' ');
							}

							terminal.moveCursor(i, j);

							linhaAnterior = i;

							colunaAnterior = j;

						}

						else {
							terminal.applyForegroundColor(1);

							i++;

							terminal.moveCursor(i, j);

							// cor do pacman: yellow
							terminal.applyForegroundColor(3);

							// representacao do pacman no tabuleiro
							terminal.putCharacter('@');
						}

						break;

					// seta para a direita
					case ArrowRight:

						i++;

						if (Tabuleiro.getTab(i, j) != '#') {

							terminal.moveCursor(i, j);

							// cor do pacman: yellow
							terminal.applyForegroundColor(3);

							// representacao do pacman no tabuleiro
							terminal.putCharacter('@');

							terminal.moveCursor(linhaAnterior, colunaAnterior);

							// se a posicao do pacman for a mesma de um dos
							// fantasmas ele perde uma vida e volta para o
							// inicio
							if (i == posicaoFantasma.getLinha() && j == posicaoFantasma.getColuna()
									|| i == posicaoGasparzinho.getLinha() && j == posicaoGasparzinho.getColuna()
									|| i == posicaoBlue.getLinha() && j == posicaoBlue.getColuna()
									|| i == posicaoMagenta.getLinha() && j == posicaoMagenta.getColuna()) {
								vidas--;
								i = 8;
								j = 9;

							}

							// se a posicao do pacman for igual a da frutinha o
							// pacman ganha 1 vida
							else if (i == posicaoFrutas.getLinha() && j == posicaoFrutas.getColuna()
									|| i == posicaoFrutas2.getLinha() && j == posicaoFrutas2.getColuna()) {

								if (Tabuleiro.getTab(i, j) == '&' || Tabuleiro.getTab(i, j) == '$') {

									vidas++;
									
									Tabuleiro.setTab(i, j, ' ');
									terminal.putCharacter(' ');
								}

							}

							// se a posicao for igual a '.' entra no if soma
							// pontos e seta o tabuleiro
							if (Tabuleiro.getTab(i, j) == '.') {

								// seta o tabuleiro
								Tabuleiro.setTab(i, j, ' ');

								terminal.putCharacter(' ');

								pontos++;
							}

							// se for diferente de '.' e '#' coloca um espaco em
							// branco
							else {

								terminal.putCharacter(' ');
							}

							terminal.moveCursor(i, j);

							linhaAnterior = i;

							colunaAnterior = j;

						}

						else {
							terminal.applyForegroundColor(1);

							i--;

							terminal.moveCursor(i, j);

							// cor do pacman:yellow
							terminal.applyForegroundColor(3);

							// representacao do pacman no tabuleiro
							terminal.putCharacter('@');

						}

						break;

					default:

						break;

					}

				// finaliza o metodo que conta o tempo
				end = System.currentTimeMillis();

				// calcula a diferenca, transforma em segundos e salva o
				// resultado na variavel tempo
				tempo = (0.001 * (end - init) / 60);

				// imprime no console a posicao do cursor, as vidas e pontos no
				// console
				System.out.println("i=" + i + " j=" + j);
				System.out.println("Vidas: " + vidas);
				System.out.println("pontos: " + pontos);

			}

			if (pontos == 80) {

				// inicia a frutinha

				frutas.run();

			}

			else if (pontos == 150) {

				// inicia a frutinha
				frutas2.run();
			}

		}

		// se ganhar imprime no terminal
		if (pontos == 195) {

			write("\nVoce ganhou \\0/", terminal);
			write("\nPontos: " + pontos, terminal);
			write("\nVidas: " + vidas, terminal);
			write("\nTempo de Jogo:  " + tempo, terminal);
		}

		// se perder imprime no terminal
		else {
			write("\nGAME OVER \n", terminal);
			write("\nPontos: " + pontos, terminal);
			write("\nVidas: " + vidas, terminal);
			write("\nTempo de Jogo: " + tempo, terminal);
		}

	}

	// metodo para imprimir textos no terminal
	private static void write(String print, Terminal terminal) {

		char[] printToChar = print.toCharArray();

		for (int i = 0; i < print.length(); i++)

		{

			terminal.putCharacter(printToChar[i]);

		}

	}

	// metodo utilixado para pegar a posicao atual do pacman
	public Posicao getPos() {
		Posicao posicao = new Posicao(i, j);
		return posicao;
	}
}