
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
		parseHtml("http://www.360kad.com/product/7.shtml");
	}

	public static void parseHtml(String url) {
		Document doc;
		try {
			System.out.println(url);
			doc = (Document) Jsoup.connect(url).get();
			System.out.println("���ࣺ");
			Elements eles = doc.getElementsByClass("noIndx");
			for (int i = 0; i < eles.size(); i++) {
				Element ele = eles.get(i);
				String text = ele.text();
				System.out.println("��" + (i + 1) + "������:" + text);
			}

			System.out.println("�Ƿ񴦷�ҩ��");
			eles = doc.getElementsByClass("YIrd_p");
			if (eles.size() != 0)
				System.out.println(eles.get(0).text());

			System.out.println("˵���飺");
			eles = doc.getElementsByClass("prodetail06").select("p");
			for (int i = 1; i < eles.size(); i++) {
				Element ele = eles.get(i);
				String text = ele.text();
				System.out.println(text);
			}

			System.out.println("������£�");
			eles = doc.getElementsByClass("articleList").select("a");
			for (int i = 0; i < eles.size(); i++) {
				Element ele = eles.get(i);
				String text = ele.text();
				String link = ele.attr("abs:href");
				System.out.println(text + "  " + link);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
