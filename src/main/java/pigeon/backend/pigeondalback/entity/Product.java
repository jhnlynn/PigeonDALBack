package pigeon.backend.pigeondalback.entity;

public class Product {

    // Product Id
    private Integer pid;

    // Product Name
    private String pname;

    // Request ID
    private Integer rid;

    // Request Total Number
    private Integer rtotal;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) { this.rid = rid; }

    public Integer getRtotal() {
        return rtotal;
    }

    public void setRtotal(Integer rtotal) {
        this.rtotal = rtotal;
    }
}