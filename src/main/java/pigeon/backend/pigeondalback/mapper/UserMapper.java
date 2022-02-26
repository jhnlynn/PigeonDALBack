package pigeon.backend.pigeondalback.mapper;

import pigeon.backend.pigeondalback.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}