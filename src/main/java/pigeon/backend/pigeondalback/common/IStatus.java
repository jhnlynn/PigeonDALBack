package pigeon.backend.pigeondalback.common;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
public interface IStatus {
    /**
     * Status Code
     *
     * @return Status Code
     */
    Integer getCode();

    /**
     * Returning Info
     *
     * @return Returning Info
     */
    String getMessage();
}
