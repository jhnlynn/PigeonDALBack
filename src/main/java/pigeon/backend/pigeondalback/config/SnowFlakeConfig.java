package pigeon.backend.pigeondalback.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import pigeon.backend.pigeondalback.utils.TwitterSnowFlake;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
@Component
@ConfigurationProperties(prefix = "snowflake")
public class SnowFlakeConfig {
    private long dataCenterId;
    private long machineId;

    public long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }

    public long generateSnowFlakeId() {
        TwitterSnowFlake snowFlake = new TwitterSnowFlake(dataCenterId, machineId);
        return snowFlake.nextId();
    }
}
