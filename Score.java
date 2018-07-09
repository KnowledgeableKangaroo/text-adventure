public class Score {
	boolean hasSword;
	int playerLevel;
	double playerHealth;
	double playersStrength;
	int gold;
	public Score(boolean hsSw, int plLvl, double plHP, double plStr, int gold) {
		this.hasSword = hsSw;
		this.playerLevel = plLvl;
		this.playerHealth = plHP;
		this.playersStrength = plStr;
		this.gold = gold;
	}
	public int find() {
		int swordValue = (this.hasSword) ? 10 : -10;
		return (int)(this.playerLevel * (this.playerHealth + this.playersStrength) + swordValue + this.gold);
	}
}