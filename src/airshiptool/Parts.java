package airshiptool;
/**
 * 各パーツの基本パラメータ構成のコンストラクタ
 */
public class Parts {
	String name;//パーツ名
	String exp_perf;//探査性能
	String coll_perf;//収集性能
	String cru_perf;//巡航性能
	String cru_dist;//航続距離
	String luck;//運
	String repair;//必要修理材数
	String cost;//コスト
	String rank;//装備可能ランク


	//コンストラクタ
	public Parts(String name,String exp_perf,String coll_perf,
			String cru_perf,String cru_dist,String luck,
			String repair,String cost,String rank){
		this.name = name;
		this.exp_perf = exp_perf;
		this.coll_perf = coll_perf;
		this.cru_perf = cru_perf;
		this.cru_dist = cru_dist;
		this.luck = luck;
		this.repair = repair;
		this.cost = cost;
		this.rank = rank;
	}
}
