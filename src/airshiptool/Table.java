package airshiptool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Table {
	/**
	 * 船首のデータ配列
	 * Parts型 ArrayList
	 */
	static List<Parts> bow = new ArrayList<Parts>();    //船首
	/**
	 * 船体のデータ配列
	 * Parts型 ArrayList
	 */
	static List<Parts> hull = new ArrayList<Parts>();   //船体
	/**
	 * 艤装のデータ配列
	 * Parts型 ArrayList
	 */
	static List<Parts> rigging = new ArrayList<Parts>();//艤装
	/**
	 * 船尾のデータ配列
	 * Parts型 ArrayList
	 */
	static List<Parts> stern = new ArrayList<Parts>();  //船尾
	

	public static void makelist() throws NumberFormatException, IOException{

		//船首のリスト作成
		File f = new File("../../Airship_Parts_Datas","bow.csv");
		bow = new ArrayList<Parts>(addData(f));

		//船体のリスト作成
		f = new File("../../Airship_Parts_Datas","hull.csv");
		hull = new ArrayList<Parts>(addData(f));

		//艤装のリスト作成
		f = new File("../../Airship_Parts_Datas","rigging.csv");
		rigging = new ArrayList<Parts>(addData(f));

		//船尾のリスト作成
		f = new File("../../Airship_Parts_Datas","stern.csv");
		stern = new ArrayList<Parts>(addData(f));
		
	}

	/**
	 * ファイルからデータを読み取りParts型のArrayListを作成するメソッド
	 * @param f
	 * @return a
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	static List<Parts> addData(File f) throws NumberFormatException, IOException{
		String line;
		List<Parts> a = new ArrayList<Parts>();

		InputStreamReader osr  = new InputStreamReader(new FileInputStream(f), "SJIS");
		BufferedReader br = new BufferedReader(osr);

		StringTokenizer token;
		while((line  = br.readLine()) != null){
			Parts p = new Parts(null, null, null, null, null, null, null, null, null);
			token = new StringTokenizer(line,",");
			p.name = token.nextToken();
			p.exp_perf = token.nextToken();
			p.coll_perf = token.nextToken();
			p.cru_perf = token.nextToken();
			p.cru_dist = token.nextToken();
			p.luck = token.nextToken();
			p.repair = token.nextToken();
			p.cost = token.nextToken();
			p.rank = token.nextToken();
			a.add(p);
		}
		br.close();

		return a;

	}
}
