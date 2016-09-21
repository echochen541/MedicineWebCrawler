
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
		parseHtml("http://www.360kad.com/product/1262657.shtml");
	}

	public static Medicine parseHtml(String url) {
		Document doc;
		String name = "";
		String category1 = "";
		String category2 = "";
		String category3 = "";
		int isOtc = 0;
		String specification = "";
		String article = "";

		try {
			System.out.println(url);
			doc = (Document) Jsoup.connect(url).get();

			Elements eles = doc.select("#wrap990list1 > ul > li:nth-child(1)");
			Element ele = eles.get(0);
			String text = ele.text();
			name = text.substring(text.indexOf("：") + 1).trim();
			// System.out.println(name);

			// System.out.println("分类：");
			eles = doc.getElementsByClass("noIndx");
			for (int i = 0; i < eles.size(); i++) {
				ele = eles.get(i);
				text = ele.text();
				if (i == 0)
					category1 = text;
				if (i == 1)
					category2 = text;
				if (i == 2)
					category3 = text;
				// System.out.println("第" + (i + 1) + "级分类:" + text);
			}

			// System.out.println("是否处方药：");
			eles = doc.getElementsByClass("YIrd_p");
			if (eles.size() != 0) {
				if (eles.get(0).text().contains("非处方药"))
					isOtc = 1;
				else
					isOtc = 0;
				// System.out.println(eles.get(0).text());
			}

			// System.out.println("说明书：");
			eles = doc.select("#wrap990list8 > ul");
			for (int i = 0; i < eles.size(); i++) {
				ele = eles.get(i);
				text = ele.text();
				specification += text;
				// System.out.println(text);
			}

			// System.out.println("相关文章：");
			eles = doc.getElementsByClass("relative-article").select("a");
			for (int i = 0; i < eles.size(); i++) {
				ele = eles.get(i);
				text = ele.text();
				String link = ele.attr("abs:href");
				article += text + "-" + link + "|";
			}
			// System.out.println(article);

		} catch (Exception e) {
			// System.out.println(url);
			// e.printStackTrace();
		}
		if (name.equals("")) {
			System.out.println("fail");
			return null;
		} else {
			System.out.println("success");
			return new Medicine(name, category1, category2, category3, isOtc, specification, article, url);
		}
	}
}
