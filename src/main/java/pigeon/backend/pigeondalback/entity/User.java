package pigeon.backend.pigeondalback.entity;

public class User {
    private String uid;

    private String ufname;

    private String ulname;

    private Double usex;

    private String uemail;

    private Byte utype;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUfname() {
        return ufname;
    }

    public void setUfname(String ufname) {
        this.ufname = ufname == null ? null : ufname.trim();
    }

    public String getUlname() {
        return ulname;
    }

    public void setUlname(String ulname) {
        this.ulname = ulname == null ? null : ulname.trim();
    }

    public Double getUsex() {
        return usex;
    }

    public void setUsex(Double usex) {
        this.usex = usex;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail == null ? null : uemail.trim();
    }

    public Byte getUtype() {
        return utype;
    }

    public void setUtype(Byte utype) {
        this.utype = utype;
    }
}