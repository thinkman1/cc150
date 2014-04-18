public class Solution {
	public void swap(int a, int b) {
		a = a - b;
		b = a + b;
		a = b - a;
	}
	
	public void swapOwn(int a, int b) {
		a = b + a;
		b = a - b;
		a = a - b;
	}
}