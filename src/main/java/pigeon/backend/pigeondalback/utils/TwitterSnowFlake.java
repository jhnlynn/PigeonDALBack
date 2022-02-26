package pigeon.backend.pigeondalback.utils;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
public class TwitterSnowFlake {
    /**
     * START_STAMP
     */
    private final static long START_STAMP = 1637863075532L;

    /**
     * BIT DISTRIBUTION
     */
    private final static long SEQUENCE_BIT = 12;
    private final static long MACHINE_BIT = 5;
    private final static long DATACENTER_BIT = 5;

    /**
     * MAXIMUM VALUE OF EACH DISTRIBUTION
     */
    private final static long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    /**
     * LEFT DISPLACEMENT
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    private final long datacenterId;
    private final long machineId;
    private long sequence = 0L;             // serial Number
    private long lastStamp = -1L;           // last time stamp

    public TwitterSnowFlake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * GENERATE NEXT ID
     *
     * @return NextId (long type)
     */
    public synchronized long nextId() {
        long currStamp = getNewStamp();
        if (currStamp < lastStamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStamp == lastStamp) {
            // in a single millisecond, serial number increments
            sequence = (sequence + 1) & MAX_SEQUENCE;
            // reaches the maximum serial number within the single millisecond
            if (sequence == 0L) {
                currStamp = getNextMill();
            }
        } else {
            // different ms, different serial numbers
            sequence = 0L;
        }

        lastStamp = currStamp;

        return (currStamp - START_STAMP) << TIMESTAMP_LEFT      // TIME STAMP
                | datacenterId << DATACENTER_LEFT               // DATA CENTER
                | machineId << MACHINE_LEFT                     // MACHINE
                | sequence;                                     // SERIAL
    }

    private long getNextMill() {
        long mill = getNewStamp();
        while (mill <= lastStamp) {
            mill = getNewStamp();
        }
        return mill;
    }

    private long getNewStamp() {
        return System.currentTimeMillis();
    }
}
