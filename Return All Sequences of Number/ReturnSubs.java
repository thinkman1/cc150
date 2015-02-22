/**
 * Given an integer, return all sequences of numbers that sum to it. (Example: 3
 * -> (1, 2), (2, 1), (1, 1, 1))
 * 
 * @author thinkman
 * 
 */
public class ReturnSubs {

	public static void main(String[] args) {
		ReturnSubs ob = new ReturnSubs();
		ArrayList<ArrayList<Integer>> res = ob.getSubs(5);

		for (ArrayList<Integer> list : res) {

			for (Integer in : list) {
				System.out.print(in + " ");
			}

			System.out.println("");
		}
	}

	public ArrayList<ArrayList<Integer>> getSubs(int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		work(0, target, res, list);
		return res;
	}

	protected void work(int sum, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {

		if (sum > target) {
			return;
		}

		if (sum == target) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 1; i < target; i++) {
			list.add(i);
			work(sum + i, target, res, list);
			list.remove(list.size() - 1);
		}
	}
}
