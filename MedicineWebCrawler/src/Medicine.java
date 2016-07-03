
public class Medicine {
	private String name;
	private String category1;
	private String category2;
	private String category3;
	private int isOtc;
	private String specification;
	private String article;
	private String url;
	
	public Medicine(String name, String category1, String category2, String category3, int isOtc, String specification,
			String article, String url) {
		this.name = name;
		this.category1 = category1;
		this.category2 = category2;
		this.category3 = category3;
		this.isOtc = isOtc;
		this.specification = specification;
		this.article = article;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public int getIsOtc() {
		return isOtc;
	}

	public void setIsOtc(int isOtc) {
		this.isOtc = isOtc;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
