package pigeon.backend.pigeondalback.mapper;

import pigeon.backend.pigeondalback.entity.Batch;

public interface BatchMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table batch_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table batch_info
     *
     * @mbg.generated
     */
    int insert(Batch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table batch_info
     *
     * @mbg.generated
     */
    int insertSelective(Batch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table batch_info
     *
     * @mbg.generated
     */
    Batch selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table batch_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Batch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table batch_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Batch record);
}