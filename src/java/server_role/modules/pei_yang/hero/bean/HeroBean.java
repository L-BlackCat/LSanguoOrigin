package server_role.modules.pei_yang.hero.bean;

/**
 * @author Chunlin Li
 * @date 2022/11/7
 * @desc
 */
public class HeroBean {
    long uid;
    long heroId;    //武将唯一id
    String heroName;    //武将名
    int level;
    int stage;
    int liLiang;
    int tiLi;
    int jiQiao;
    int minJie;
    int ganZhi;
    int yiZhi;

    public static  HeroBean create(long uid, long heroId, String heroName, int level, int stage, int liLiang, int tiLi, int jiQiao, int minJie, int ganZhi, int yiZhi) {
        HeroBean bean = new HeroBean();
        bean.uid = uid;
        bean.heroId = heroId;
        bean.heroName = heroName;
        bean.level = level;
        bean.stage = stage;
        bean.liLiang = liLiang;
        bean.tiLi = tiLi;
        bean.jiQiao = jiQiao;
        bean.minJie = minJie;
        bean.ganZhi = ganZhi;
        bean.yiZhi = yiZhi;
        return bean;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getHeroId() {
        return heroId;
    }

    public void setHeroId(long heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getLiLiang() {
        return liLiang;
    }

    public void setLiLiang(int liLiang) {
        this.liLiang = liLiang;
    }

    public int getTiLi() {
        return tiLi;
    }

    public void setTiLi(int tiLi) {
        this.tiLi = tiLi;
    }

    public int getJiQiao() {
        return jiQiao;
    }

    public void setJiQiao(int jiQiao) {
        this.jiQiao = jiQiao;
    }

    public int getMinJie() {
        return minJie;
    }

    public void setMinJie(int minJie) {
        this.minJie = minJie;
    }

    public int getGanZhi() {
        return ganZhi;
    }

    public void setGanZhi(int ganZhi) {
        this.ganZhi = ganZhi;
    }

    public int getYiZhi() {
        return yiZhi;
    }

    public void setYiZhi(int yiZhi) {
        this.yiZhi = yiZhi;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}
