package pigeon.backend.pigeondalback.entity;

public class Batch {

    // UUID
    private String uuid;

    // Batch ID
    private Integer bid;

    // Batch Total Number
    private Integer btotal;

    // Status: Processing, Shipped, Delivered
    private Integer bstatus;

    // Tracking Number: 1ZX2887A4407123066
    private String btrack;

    // Donation ID
    private Integer did;

    // Shipment ID
    private Integer sid;

    // Warehouse ID
    private Integer wid;

    // Manufacturer ID
    private Integer mid;

    // Product ID
    private Integer pid;

    // Request ID
    private Integer rid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getBtotal() {
        return btotal;
    }

    public void setBtotal(Integer btotal) {
        this.btotal = btotal;
    }

    public Integer getBstatus() {
        return bstatus;
    }

    public void setBstatus(Integer bstatus) {
        this.bstatus = bstatus;
    }

    public String getBtrack() {
        return btrack;
    }

    public void setBtrack(String btrack) {
        this.btrack = btrack == null ? null : btrack.trim();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) { this.did = did; }

    public Integer getWid() { return wid; }

    public void setWarehouseWid(Integer wid) { this.wid = wid; }

    public Integer getManufacturerMid() { return mid; }

    public void setManufacturerMid(Integer mid) { this.mid = mid; }

    public Integer getPid() { return pid; }

    public void setProductPid(Integer pid) { this.pid = pid; }

    public Integer getShipmentSid() {
        return sid;
    }

    public void setShipmentSid(Integer sid) { this.sid = sid; }

    public Integer getRid() { return rid; }

    public void setRid(Integer rid) { this.rid = rid; }
}