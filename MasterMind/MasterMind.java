/**
 * 
 * @author thinkman
 *
 */
public class MasterMind {
	/**
	 * int[0] indicates number of hits
	 * int[1] indicates number of pseudo-hits
	 * 
	 * TestCases:
	 * RRRR, RRRR: 4,0
	 * RYBG, BYGG: 2,1
	 * GGRR, RGBY: 1,1
	 * 
	 * @param guess
	 * @param sol
	 * @return
	 */
	public static void main(String[] ar) {
		
		System.out.println(new MasterMind().estimate("RYBG", "BYGG"));
	}
	
	
	class Result {
		public int hits = 0;
		public int psHits = 0;
		
		public String toString() {
			return "(" + hits + ", " + psHits + ")";
		}
	}
	
	public int code(char c) {
		switch(c) {
		case 'B' : 
			return 0;
		case 'G' : 
			return 1;
		case 'R' : 
			return 2;
		case 'Y' : 
			return 3;
		default:
			return -1;
		}
	}
	
	public Result estimate(String guess, String solution) {
		if (guess.length() != solution.length()) return null;
		
		Result res = new Result();
		int[] frequencies = new int[4];
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				res.hits++;
			} else {
				int code = code(solution.charAt(i));
				frequencies[code]++;
			}
		}
		
		for (int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
				res.psHits++;
				frequencies[code]--;
			}
		}
		
		return res;
	}
}
