
/**
 * @author EchoChen
 *
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	public static void main(String[] args) {
		parseHtml("http://www.360kad.com/product/1107195.shtml");
	}

	public static void parseHtml(String url) {
		Document doc;
		try {
			doc = (Document) Jsoup.connect(url).get();
			Elements eles = doc.getElementsByClass("noIndx");
			for (int i = 0; i < eles.size() - 1; i++) {
				Element ele = eles.get(i);
				String text = ele.text();
				System.out.println("第" + (i + 1) + "级分类:" + text);
			}

			eles = doc.getElementsByClass("prodetail06").select("p");
			for (int i = 1; i < eles.size(); i++) {
				Element ele = eles.get(i);
				String text = ele.text();
				System.out.println(text);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}
}
