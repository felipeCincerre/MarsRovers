package Model;

import javax.swing.JOptionPane;

public class Rover {

	public static final Integer N = 1; // North - Norte
	public static final Integer E = 2; // East - Leste
	public static final Integer S = 3; // South - Sul
	public static final Integer W = 4; // West - Oeste

	private Integer xSuperior;
	private Integer ySuperior;
	private Integer x;
	private Integer y;
	private Integer direcao;

	//Constructor
	public Rover() {
	}

	//Getters and Setters
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getxSuperior() {
		return xSuperior;
	}

	public void setxSuperior(Integer xSuperior) {
		this.xSuperior = xSuperior;
	}

	public Integer getySuperior() {
		return ySuperior;
	}

	public void setySuperior(Integer ySuperior) {
		this.ySuperior = ySuperior;
	}
	
	public void setDirecao(Integer direcao) {
		this.direcao = direcao;
	}
	
	public Integer getDirecao() {
		return direcao;
	}

	//Other Methods
	public void setPosicaoSuperior(Integer xSuperior, Integer ySuperior) {
		setxSuperior(xSuperior);
		setySuperior(ySuperior);
	}

	public void setPosicaoRobo(Integer x, Integer y, Integer direcao) {
		setX(x);
		setY(y);
		setDirecao(direcao);
	}

	public void andar(String instrucoes) {
		instrucoes = instrucoes.toUpperCase();
		for (int i = 0; i < instrucoes.length(); i++) {
			mudarPosicaoRobo(instrucoes.charAt(i));
		}
	}

	private void mudarPosicaoRobo(Character instrucao) {
		if (instrucao.equals('L')) {
			moverEsquerda();
		} else if (instrucao.equals('R')) {
			moverDireita();
		} else if (instrucao.equals('M')) {
			rodar();
		} else {
			throw new IllegalArgumentException("Instrução inválida! Digite L para Esquerda, R para direita ou M para mover o robô!");
		}
	}

	private void rodar() {
		if (getDirecao() == N) {
			if (!checarYSuperior(getY(), getySuperior())) {
				return;
			}
			setY(getY() + 1);
		} else if (getDirecao() == E) {
			if (!checarXSuperior(getX(), getxSuperior())) {
				return;
			}
			setX(getX() + 1);
		} else if (getDirecao() == S) {
			if (!checarYInferior(getY())) {
				return;
			}
			setY(getY() - 1);
		} else if (getDirecao() == W) {
			if (!checarXInferior(getX())) {
				return;
			}
			setX(getX() - 1);
		}
	}

	private boolean checarYSuperior(Integer y, Integer ySuperior) {
		if (y >= ySuperior) {
			throw new IllegalArgumentException("Não é possível mover para o Norte, pois foi atingida a margem superior do planalto!");
		}
		return true;
	}

	private boolean checarXSuperior(Integer x, Integer xSuperior) {
		if (x >= xSuperior) {
			throw new IllegalArgumentException("Não é possível mover para o Leste, pois foi atingida a margem direita do planalto!");
		}
		return true;
	}

	private boolean checarYInferior(Integer y) {
		if (y <= 0) {
			throw new IllegalArgumentException("Não é possível mover para o Sul, pois foi atingida a margem inferior do planalto!");
		}
		return true;
	}

	private boolean checarXInferior(Integer x) {
		if (x <= 0) {
			throw new IllegalArgumentException("Não é possível mover para o Oeste, pois foi atingida a margem esquerda do planalto!");
		}
		return true;
	}

	private void moverEsquerda() {
		if ((getDirecao() - 1) < N) {
			setDirecao(W);
		} else {
			setDirecao(getDirecao() - 1);
		}
	}

	private void moverDireita() {
		if ((getDirecao() + 1) > W) {
			setDirecao(N);
		} else {
			setDirecao(getDirecao() + 1);
		}
	}

	public void mostrarPosicaoRobo() {
		String posicao = checkPosicao();
		JOptionPane.showMessageDialog(null, "\nPosição Final do Robô:\n" + getX() + " " + getY() + " " + posicao + "\n");
	}

	private String checkPosicao() {
		String posicao = "N";
		if (getDirecao() == 1) {
			posicao = "N";
		} else if (getDirecao() == 2) {
			posicao = "E";
		} else if (getDirecao() == 3) {
			posicao = "S";
		} else if (getDirecao() == 4) {
			posicao = "W";
		}
		return posicao;
	}

}