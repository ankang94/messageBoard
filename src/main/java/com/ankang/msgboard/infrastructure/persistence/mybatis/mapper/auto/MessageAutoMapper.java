package com.ankang.msgboard.infrastructure.persistence.mybatis.mapper.auto;

import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.MessageDO;
import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.MessageParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MessageAutoMapper {
    long countByExample(MessageParam example);

    int deleteByExample(MessageParam example);

    int insert(MessageDO record);

    int insertSelective(MessageDO record);

    List<MessageDO> selectByExampleWithBLOBsWithRowbounds(MessageParam example, RowBounds rowBounds);

    List<MessageDO> selectByExampleWithBLOBs(MessageParam example);

    List<MessageDO> selectByExampleWithRowbounds(MessageParam example, RowBounds rowBounds);

    List<MessageDO> selectByExample(MessageParam example);

    int updateByExampleSelective(@Param("record") MessageDO record, @Param("example") MessageParam example);

    int updateByExampleWithBLOBs(@Param("record") MessageDO record, @Param("example") MessageParam example);

    int updateByExample(@Param("record") MessageDO record, @Param("example") MessageParam example);
}