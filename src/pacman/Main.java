//Eduarda C. G. Armstrong
//Matheus Almeida
//Prof: Andre Katayama
//5 periodo
//Sistemas de Informacao

package pacman;

import com.googlecode.lanterna.TerminalFacade;

import com.googlecode.lanterna.input.Key;

import com.googlecode.lanterna.terminal.Terminal;

import com.googlecode.lanterna.terminal.TerminalSize;

import java.io.ObjectInputStream.GetField;
import java.nio.charset.Charset;

import java.util.ArrayList;
import pacman.Posicao;

public class Main {

	private static Object Posicao;

	public static void main(String[] args) {

		// cria o terminal
		Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
		terminal.enterPrivateMode();
		TerminalSize terminalSize = terminal.getTerminalSize();

		ArrayList<Posicao> tabuleiro = new ArrayList<>();
		tabuleiro = Tabuleiro.setTabuleiro(terminalSize);

		// for each imprime o tabuleiro
		for (Posicao i : tabuleiro) {

			terminal.moveCursor(i.linha, i.coluna);

			terminal.putCharacter(Tabuleiro.getTab(i.linha, i.coluna));

		}

		//inicia o Pacman
		Pacman pacman = new Pacman("Pacman", terminal);

		pacman.start();

	}
}