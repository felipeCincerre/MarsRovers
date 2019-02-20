package Teste;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Model.Rover;

public class RoverTeste {
	public static final Integer N = 1; // North - Norte
	public static final Integer E = 2; // East - Leste
	public static final Integer S = 3; // South - Sul
	public static final Integer W = 4; // West - Oeste

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void testarPrimeiroRobo() {

		// Init
		Integer xSuperior = 5;
		Integer ySuperior = 5;
		Integer x = 1;
		Integer y = 2;
		Integer direcao = N;

		// Act
		Rover rover = new Rover();
		// Setting initial values
		rover.setxSuperior(xSuperior);
		rover.setySuperior(ySuperior);
		rover.setX(x);
		rover.setY(y);
		rover.setDirecao(direcao);
		rover.andar("LMLMLMLMM");

		// Check
		Assert.assertEquals(1L, rover.getX().longValue());
		Assert.assertEquals(3L, rover.getY().longValue());
		Assert.assertEquals(N.longValue(), rover.getDirecao().longValue());

	}

	@Test
	public void testarSegundoRobo() {

		// Init
		Integer xSuperior = 5;
		Integer ySuperior = 5;
		Integer x = 3;
		Integer y = 3;
		Integer direcao = E;

		// Act
		Rover rover = new Rover();
		// Setting initial values
		rover.setxSuperior(xSuperior);
		rover.setySuperior(ySuperior);
		rover.setX(x);
		rover.setY(y);
		rover.setDirecao(direcao);
		rover.andar("MMRMMRMRRM");

		// Check
		Assert.assertEquals(5L, rover.getX().longValue());
		Assert.assertEquals(1L, rover.getY().longValue());
		Assert.assertEquals(E.longValue(), rover.getDirecao().longValue());

	}

	@Test
	public void testarUltrapassandoNorte() {

		// Init
		Integer xSuperior = 5;
		Integer ySuperior = 5;
		Integer x = 1;
		Integer y = 2;
		Integer direcao = N;

		// Act
		Rover rover = new Rover();
		// Setting initial values
		rover.setxSuperior(xSuperior);
		rover.setySuperior(ySuperior);
		rover.setX(x);
		rover.setY(y);
		rover.setDirecao(direcao);

		// Check
		try {
			rover.andar("LMLMLMLMMMMM");
		} catch (final IllegalArgumentException e) {
			final String msg = "Não é possível mover para o Norte, pois foi atingida a margem superior do planalto!";
			Assert.assertEquals(msg, e.getMessage());
		}
	}
	
	@Test
	public void testarUltrapassandoLeste() {

		// Init
		Integer xSuperior = 5;
		Integer ySuperior = 5;
		Integer x = 3;
		Integer y = 2;
		Integer direcao = E;

		// Act
		Rover rover = new Rover();
		// Setting initial values
		rover.setxSuperior(xSuperior);
		rover.setySuperior(ySuperior);
		rover.setX(x);
		rover.setY(y);
		rover.setDirecao(direcao);

		// Check
		try {
			rover.andar("LMLMLMLMMMMM");
		} catch (final IllegalArgumentException e) {
			final String msg = "Não é possível mover para o Leste, pois foi atingida a margem direita do planalto!";
			Assert.assertEquals(msg, e.getMessage());
		}
	}
	
	@Test
	public void testarUltrapassandoSul() {

		// Init
		Integer xSuperior = 5;
		Integer ySuperior = 5;
		Integer x = 1;
		Integer y = 2;
		Integer direcao = S;

		// Act
		Rover rover = new Rover();
		// Setting initial values
		rover.setxSuperior(xSuperior);
		rover.setySuperior(ySuperior);
		rover.setX(x);
		rover.setY(y);
		rover.setDirecao(direcao);

		// Check
		try {
			rover.andar("LMLMLMLMMMMM");
		} catch (final IllegalArgumentException e) {
			final String msg = "Não é possível mover para o Sul, pois foi atingida a margem inferior do planalto!";
			Assert.assertEquals(msg, e.getMessage());
		}
	}
	
	@Test
	public void testarUltrapassandoOeste() {

		// Init
		Integer xSuperior = 5;
		Integer ySuperior = 5;
		Integer x = 1;
		Integer y = 2;
		Integer direcao = W;

		// Act
		Rover rover = new Rover();
		// Setting initial values
		rover.setxSuperior(xSuperior);
		rover.setySuperior(ySuperior);
		rover.setX(x);
		rover.setY(y);
		rover.setDirecao(direcao);

		// Check
		try {
			rover.andar("LMLMLMLMMMMM");
		} catch (final IllegalArgumentException e) {
			final String msg = "Não é possível mover para o Oeste, pois foi atingida a margem esquerda do planalto!";
			Assert.assertEquals(msg, e.getMessage());
		}
	}

}
