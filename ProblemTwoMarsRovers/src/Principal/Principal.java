package Principal;

import javax.swing.JOptionPane;

import Model.Rover;

public class Principal {
	public static final Integer N = 1; // North - Norte
	public static final Integer E = 2; // East - Leste
	public static final Integer S = 3; // South - Sul
	public static final Integer W = 4; // West - Oeste

	public static void main(String[] args) {
		Rover rover = new Rover();
		// Setting initial values
		rover.setDirecao(N);
		rover.setX(0);
		rover.setY(0);
		rover.setxSuperior(0);
		rover.setySuperior(0);

		// Setting Plateau Limit
		rover.setPosicaoSuperior(obterXSuperior(), obterYSuperior());

		// Setting first rover
		rover.setPosicaoRobo(obterX(), obterY(), obterDirecao());
		rover.andar(obterInstrucoes());
		rover.mostrarPosicaoRobo();

		// Setting second rover
		rover.setPosicaoRobo(obterX(), obterY(), obterDirecao());
		rover.andar(obterInstrucoes());
		rover.mostrarPosicaoRobo();
	}

	private static String obterInstrucoes() {
		return JOptionPane
				.showInputDialog("Digite as instruções para o Robô:\nL - Esquerda \nR - Direita\nM - Seguir em Frente");
	}

	private static int obterDirecao() {
		String direcao = "";
		Integer dir = 0;
			direcao = JOptionPane.showInputDialog("Digite a Posição do Robô:\nN - Norte \nE - Leste\nS - Sul\nW - Oeste ");
			if (direcao.equalsIgnoreCase("N")) {
				dir = 1;
			} else if (direcao.equalsIgnoreCase("E")) {
				dir = 2;
			} else if (direcao.equalsIgnoreCase("S")) {
				dir = 3;
			} else if (direcao.equalsIgnoreCase("W")){
				dir = 4;
			}else{
				throw new IllegalArgumentException("Direção inválida! Digite N para Norte, E para Leste, S para Sul ou W para Oeste!");
			}
		return dir;
	}

	private static int obterY() {
		Integer y = 0;
		try {
			y = Integer.parseInt(JOptionPane.showInputDialog("Digite o Y: "));
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Digite um valor inteiro para Y!");
		}
		return y;
	}

	private static int obterX() {
		Integer x = 0;
		try {
			x = Integer.parseInt(JOptionPane.showInputDialog("Digite o X: "));
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Digite um valor inteiro para X!");
		}
		return x;
	}

	private static int obterYSuperior() {
		Integer ySuperior = 0;
		try {
			ySuperior = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o Y Superior: "));
		} catch (NumberFormatException e) {
			throw new NumberFormatException(
					"Digite um valor inteiro para Y Superior!");
		}
		return ySuperior;
	}

	private static int obterXSuperior() {
		Integer xSuperior = 0;
		try {
			xSuperior = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o X Superior: "));
		} catch (NumberFormatException e) {
			throw new NumberFormatException(
					"Digite um valor inteiro para X Superior!");
		}
		return xSuperior;
	}

}
