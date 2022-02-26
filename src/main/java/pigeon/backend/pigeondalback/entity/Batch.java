package pigeon.backend.pigeondalback.entity;

public class Batch {
    private Long bid;

    private Long bnum;

    private Byte bstatus;

    private String btrack;

    private String donationsDid;

    private Byte carrierCid;

    private Byte warehouseWid;

    private Byte manufacturerMid;

    private Byte productPid;

    private String shipmentSid;

    private String requestRid;

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getBnum() {
        return bnum;
    }

    public void setBnum(Long bnum) {
        this.bnum = bnum;
    }

    public Byte getBstatus() {
        return bstatus;
    }

    public void setBstatus(Byte bstatus) {
        this.bstatus = bstatus;
    }

    public String getBtrack() {
        return btrack;
    }

    public void setBtrack(String btrack) {
        this.btrack = btrack == null ? null : btrack.trim();
    }

    public String getDonationsDid() {
        return donationsDid;
    }

    public void setDonationsDid(String donationsDid) {
        this.donationsDid = donationsDid == null ? null : donationsDid.trim();
    }

    public Byte getCarrierCid() {
        return carrierCid;
    }

    public void setCarrierCid(Byte carrierCid) {
        this.carrierCid = carrierCid;
    }

    public Byte getWarehouseWid() {
        return warehouseWid;
    }

    public void setWarehouseWid(Byte warehouseWid) {
        this.warehouseWid = warehouseWid;
    }

    public Byte getManufacturerMid() {
        return manufacturerMid;
    }

    public void setManufacturerMid(Byte manufacturerMid) {
        this.manufacturerMid = manufacturerMid;
    }

    public Byte getProductPid() {
        return productPid;
    }

    public void setProductPid(Byte productPid) {
        this.productPid = productPid;
    }

    public String getShipmentSid() {
        return shipmentSid;
    }

    public void setShipmentSid(String shipmentSid) {
        this.shipmentSid = shipmentSid == null ? null : shipmentSid.trim();
    }

    public String getRequestRid() {
        return requestRid;
    }

    public void setRequestRid(String requestRid) {
        this.requestRid = requestRid == null ? null : requestRid.trim();
    }
}