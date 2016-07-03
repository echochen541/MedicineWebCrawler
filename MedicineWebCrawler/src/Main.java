
/**
 * @author EchoChen
 *
 */
public class Main {
	public static void main(String[] args) {
		// long start = System.currentTimeMillis();
		int begin = 1;
		int end = 100;
		for (int i = begin; i < end; i++) {
			String url = "http://www.360kad.com/product/" + i + ".shtml";
			Medicine medicine = Crawler.parseHtml(url);
			if (medicine != null)
				DBOperation.store(medicine);
		}
		// System.out.println((System.currentTimeMillis() - start) / 1000.0 +
		// "s");
	}
}
