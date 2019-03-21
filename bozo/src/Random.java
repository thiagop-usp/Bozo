import java.util.Calendar;

/**
 * classe que define métodos capazes de gerar números pseudo-aleatórios
 */

public class Random {

	private long m = 843314861;
	private long a = 453816693;
	private long p = 2147483648L;

	private long Semente = 51654;
	
	public Random(int x) {
		Semente = x;
	}

	/**
	 * Semente eh gerada aleatoriamente (sleep para que nao se use a mesma semente no cálculo de ints aleatórios)
	 */
	public Random() {
		Semente = Calendar.getInstance().getTimeInMillis();
		try{
			Thread.sleep(123);
		} catch (InterruptedException e){ }
	}

	/**
	 * @return retorna a semente da instancia Random criada
	 */
	@Override
	public String toString() {
		return Semente + "";
	}

	/**
	 * método que gera um número double pseudo aleatório
	 * @return retorna um número double pseudo aleatório
	 */

	public double getRand() {
		Semente = ((a + m * Semente) % p + p) % p;
		return Semente/(double)p;
	}

	/**
	 * método que gera um número inteiro pseudo aleatório menor que max
	 * @return retorna um número inteiro pseudo aleatório menor que max
	 */


	public int getIntRand(int max) {
		double number = getRand() * max;
		return (int)number;
	}

	/**
	 * método que gera um número double pseudo aleatório entre min e max
	 * @return retorna um número double pseudo aleatório entre min e max
	 */


	public int getIntRand(int min, int max){
		int number = getIntRand(max-min) + min;
		return number;
	}

	/**
	 * setter da semente
	 * @param x semente x
	 */
	public void setSeed(int x) {
		Semente = x;
	}

}