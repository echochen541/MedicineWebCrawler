import java.sql.SQLException;

import org.apache.commons.lang.StringEscapeUtils;

public class DBOperation {

	public static void store(Medicine medicine) {
		String sql = "insert into medicine values ('" + medicine.getName() + "','" + medicine.getCategory1() + "','"
				+ medicine.getCategory2() + "','" + medicine.getCategory3() + "'," + medicine.getIsOtc() + ",'"
				+ medicine.getSpecification() + "','" + medicine.getArticle() + "','" + medicine.getUrl() + "')";
		DBHelper db = new DBHelper(sql);
		// System.out.println(sql);
		try {
			db.pst.executeUpdate();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
