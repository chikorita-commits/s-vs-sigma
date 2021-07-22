import java.util.Random;

class StatisticsTuple {
	private double mean;
	private double stdev;
	private double error;
	private double lowerBound;
	private double upperBound;
	private String captured;

	StatisticsTuple(double a, double b, double c) {
		mean = (a + b + c) / 3;
		stdev = Math.sqrt(a * a - a * (b + c) + b * b - b * c + c * c) / Math.sqrt(3);
		error = 1.96 * stdev / Math.sqrt(3);
		lowerBound = mean - error;
		upperBound = mean + error;
		if (5 >= lowerBound && 5 <= upperBound) {
			captured = "Yes";
		}
		else {
			captured = "No";
		}
	}
	public String toString(){
		return mean+" "+stdev+" "+error+" "+lowerBound+"-"+upperBound+" "+captured;
		
	}
}

public class Chikorita {
	public static void main(String[] args) {
		for(int i = 0; i < 25; i++) {
			Random rng = new Random();
			double x1 = rng.nextGaussian() * 2 + 5;
			double x2 = rng.nextGaussian() * 2 + 5;
			double x3 = rng.nextGaussian() * 2 + 5;
			StatisticsTuple tuple = new StatisticsTuple(x1,x2,x3);
			System.out.println(tuple);
		}
	}
}
