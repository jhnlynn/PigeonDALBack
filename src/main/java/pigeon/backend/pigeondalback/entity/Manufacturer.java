package pigeon.backend.pigeondalback.entity;

public class Manufacturer {
    private Byte mid;

    private String mname;

    public Byte getMid() {
        return mid;
    }

    public void setMid(Byte mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }
}