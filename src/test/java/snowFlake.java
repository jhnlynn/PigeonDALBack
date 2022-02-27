import pigeon.backend.pigeondalback.config.SnowFlakeConfig;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
public class snowFlake {
    public void trysnow() {

        SnowFlakeConfig snowFlakeConfig  = new SnowFlakeConfig();
        for(int i = 0; i < 100; i += 1) {
            System.out.println(snowFlakeConfig.generateSnowFlakeId());
        }
    }

    public static void main(String[] args) {
        snowFlake s = new snowFlake();
        s.trysnow();
    }
}
