package pigeon.backend.pigeondalback.entity;

public class Warehouse {
    private Byte wid;

    private String waddr1;

    private String waddr2;

    private String wcity;

    private String wstate;

    private String wcountry;

    private Long wzip;

    public Byte getWid() {
        return wid;
    }

    public void setWid(Byte wid) {
        this.wid = wid;
    }

    public String getWaddr1() {
        return waddr1;
    }

    public void setWaddr1(String waddr1) {
        this.waddr1 = waddr1 == null ? null : waddr1.trim();
    }

    public String getWaddr2() {
        return waddr2;
    }

    public void setWaddr2(String waddr2) {
        this.waddr2 = waddr2 == null ? null : waddr2.trim();
    }

    public String getWcity() {
        return wcity;
    }

    public void setWcity(String wcity) {
        this.wcity = wcity == null ? null : wcity.trim();
    }

    public String getWstate() {
        return wstate;
    }

    public void setWstate(String wstate) {
        this.wstate = wstate == null ? null : wstate.trim();
    }

    public String getWcountry() {
        return wcountry;
    }

    public void setWcountry(String wcountry) {
        this.wcountry = wcountry == null ? null : wcountry.trim();
    }

    public Long getWzip() {
        return wzip;
    }

    public void setWzip(Long wzip) {
        this.wzip = wzip;
    }
}