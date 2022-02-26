package pigeon.backend.pigeondalback.entity;

public class Product {
    private Byte pid;

    private String pname;

    private String requestRid;

    private Long rptotal;

    public Byte getPid() {
        return pid;
    }

    public void setPid(Byte pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getRequestRid() {
        return requestRid;
    }

    public void setRequestRid(String requestRid) {
        this.requestRid = requestRid == null ? null : requestRid.trim();
    }

    public Long getRptotal() {
        return rptotal;
    }

    public void setRptotal(Long rptotal) {
        this.rptotal = rptotal;
    }
}