package pigeon.backend.pigeondalback.entity;

public class User {

    // User UUID
    private String uuid;

    // User ID
    private Integer uid;

    // First Name
    private String ufname;

    // Last Name
    private String ulname;

    // Male: 0, Female: 1
    private Integer usex;

    // Email Address
    private String uemail;

    // Common: 0, Admin: 1
    private Integer utype;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) { this.uid = uid; }

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

    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail == null ? null : uemail.trim();
    }

    public Integer getUtype() {
        return utype;
    }

    public void setUtype(Integer utype) {
        this.utype = utype;
    }
}