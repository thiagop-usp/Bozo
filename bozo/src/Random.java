import java.util.Calendar;

public class Random {

	private long m = 843314861;
	private long a = 453816693;
	private long p = 2147483648L;

	private long Semente = 51654;
	
	public Random(int x) {
		Semente = x;
	}

	public Random() {
		Semente = Calendar.getInstance().getTimeInMillis();
	}

	@Override
	public String toString() {
		return Semente + "";
	}

	public double getRand() {
		Semente = ((a + m * Semente) % p + p) % p;
		return Semente/(double)p;
	}

	public int getIntRand(int max) {
		double number = getRand() * max;
		return (int)number;
	}

	public int getIntRand(int min, int max){
		int number = getIntRand(max-min) + min;
		return number;
	}
	public void setSeed(int x) {
		Semente = x;
	}

}