package mario.beans;

public class ChineseWord {
	private String zi;
	private Integer sheng;
	private String yun;
	
	public ChineseWord() {
	}
	
	public ChineseWord(String zi, Integer sheng, String yun) {
		this.zi = zi;
		this.sheng = sheng;
		this.yun = yun;
	}
	
	public String getZi() {
		return zi;
	}
	
	public void setZi(String zi) {
		this.zi = zi;
	}
	
	public Integer getSheng() {
		return sheng;
	}
	
	public void setSheng(Integer sheng) {
		this.sheng = sheng;
	}
	
	public String getYun() {
		return yun;
	}
	
	public void setYun(String yun) {
		this.yun = yun;
	}

	@Override
	public String toString() {
		return "ChineseWord [zi=" + zi + ", sheng=" + sheng + ", yun=" + yun + "]";
	}
}
