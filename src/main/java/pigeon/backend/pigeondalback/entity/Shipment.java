package pigeon.backend.pigeondalback.entity;

public class Shipment {

    // Shipment ID
    private Integer sid;

    private Integer stype;

    private String[] trackNumber;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getStype() {
        return stype;
    }

    public void setStype(Integer stype) {
        this.stype = stype;
    }

    public String[] getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String[] trackNumber) {
        this.trackNumber = trackNumber;
    }
}