import org.junit.Test;
import static org.junit.Assert.*;

public class BearFairTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 4;
		int b = 6;
		int[] upTo = new int[] {3,6};
		int[] quantity = new int[] {2,4};
		assertEquals("fair", new BearFair().isFair(n, b, upTo, quantity));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 4;
		int b = 6;
		int[] upTo = new int[] {3,6};
		int[] quantity = new int[] {2,3};
		assertEquals("unfair", new BearFair().isFair(n, b, upTo, quantity));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 2;
		int b = 6;
		int[] upTo = new int[] {1,2,3};
		int[] quantity = new int[] {1,1,2};
		assertEquals("unfair", new BearFair().isFair(n, b, upTo, quantity));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 50;
		int b = 1000;
		int[] upTo = new int[] {736,205,264,235,273,40,901,37,900,424,122,517,820,402,669,279,455,921,774,923,107,936,484,171,248,
186,970,231,321,902,606,24,451,585,823,270,361,292,128,521,689,683,270,726,980,652,996,909,196,357};
		int[] quantity = new int[] {35,9,9,9,9,3,46,3,46,18,7,25,39,18,32,9,20,49,37,49,7,49,24,8,9,8,49,9,12,46,29,2,20,29,39,9,16,11,7,27,33,32,9,34,49,32,50,47,8,16};
		assertEquals("fair", new BearFair().isFair(n, b, upTo, quantity));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int n = 4;
		int b = 1000;
		int[] upTo = new int[] {400,600};
		int[] quantity = new int[] {4,0};
		assertEquals("unfair", new BearFair().isFair(n, b, upTo, quantity));
	}
}
