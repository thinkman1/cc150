public class MinimizeIndices {

	public int[] getIndices(int[] num) {
		int[] res = new int[2];
		Arrays.fill(res, -1);

		int leftEnd = getEndIndexOfLeftSub(num);
		int rightStart = getStartIndexOfRightSub(num);

		int minIndex = leftEnd + 1, maxIndex = rightStart - 1;
		if (minIndex >= num.length || maxIndex < 0)
			return res;

		for (int i = leftEnd+1; i <= rightStart-1; i++) {
			if (num[i] < num[minIndex])
				minIndex = i;
			if (num[i] > num[maxIndex])
				maxIndex = i;
		}
		
		res[0] = shrinkLeft(num, leftEnd, minIndex);
		res[1] = shrinkRight(num, rightStart, maxIndex);

		return res;
	}

	public int getEndIndexOfLeftSub(int[] num) {
		for (int i = 1; i < num.length; i++) {
			if (num[i] < num[i - 1])
				return i - 1;
		}

		return num.length - 1;
	}

	public int getStartIndexOfRightSub(int[] num) {
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i + 1] < num[i])
				return i + 1;
		}

		return 0;
	}

	public int shrinkLeft(int[] num, int leftEnd, int minIndex) {
		int min = num[minIndex];
		for (int i = leftEnd; i >= 0; i--) {
			if (num[i] <= min) {
				return i + 1;
			}
		}
		return 0;
	}

	public int shrinkRight(int[] num, int rightStart, int maxIndex) {
		int max = num[maxIndex];
		for (int i = rightStart; i < num.length; i++) {
			if (num[i] >= max) {
				return i - 1;
			}
		}

		return num.length - 1;
	}
}
