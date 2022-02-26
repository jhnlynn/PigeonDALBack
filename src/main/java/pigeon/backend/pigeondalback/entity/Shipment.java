package pigeon.backend.pigeondalback.entity;

public class Shipment {
    private String sid;

    private Byte stype;

    private byte[] trackid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public Byte getStype() {
        return stype;
    }

    public void setStype(Byte stype) {
        this.stype = stype;
    }

    public byte[] getTrackid() {
        return trackid;
    }

    public void setTrackid(byte[] trackid) {
        this.trackid = trackid;
    }
}