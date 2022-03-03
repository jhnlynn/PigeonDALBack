package pigeon.backend.pigeondalback.entity;

/**
 * PigeonDALBack
 *
 * @author Jason
 * @date 03.02.2022
 */
public class Request {

    // UUID
    private String uuid;

    // Request Id
    private Integer rid;

    // User Id
    private Integer uid;

    // Product Id
    private Integer pid;

    // Request Total Numbher
    private Integer rtotal;

    public Integer getRid() { return rid; }

    public void setRid(Integer rid) { this.rid = rid; }
}
