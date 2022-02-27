package pigeon.backend.pigeondalback.vo;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
public class DonateRequestVO {
    private String uid;

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

    private byte[] trackid;

    private Byte stype;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

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
        this.btrack = btrack;
    }

    public String getDonationsDid() {
        return donationsDid;
    }

    public void setDonationsDid(String donationsDid) {
        this.donationsDid = donationsDid;
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
        this.shipmentSid = shipmentSid;
    }

    public String getRequestRid() {
        return requestRid;
    }

    public void setRequestRid(String requestRid) {
        this.requestRid = requestRid;
    }

    public byte[] getTrackid() {
        return trackid;
    }

    public void setTrackid(byte[] trackid) {
        this.trackid = trackid;
    }

    public Byte getStype() {
        return stype;
    }

    public void setStype(Byte stype) {
        this.stype = stype;
    }
}
