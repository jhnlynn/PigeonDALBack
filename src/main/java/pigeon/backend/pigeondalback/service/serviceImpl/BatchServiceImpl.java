package pigeon.backend.pigeondalback.service.serviceImpl;

import org.springframework.beans.factory.annotation.*;
import pigeon.backend.pigeondalback.mapper.*;
import pigeon.backend.pigeondalback.service.IUserService;
/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
public class BatchServiceImpl {
    @Autowired
    private BatchMapper batchMapper;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private IUserService userService;
}
