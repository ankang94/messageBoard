package com.ankang.msgboard.infrastructure.persistence.mybatis.mapper.auto;

import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.VisitorDO;
import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.VisitorParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface VisitorAutoMapper {
    long countByExample(VisitorParam example);

    int deleteByExample(VisitorParam example);

    int insert(VisitorDO record);

    int insertSelective(VisitorDO record);

    List<VisitorDO> selectByExampleWithRowbounds(VisitorParam example, RowBounds rowBounds);

    List<VisitorDO> selectByExample(VisitorParam example);

    int updateByExampleSelective(@Param("record") VisitorDO record, @Param("example") VisitorParam example);

    int updateByExample(@Param("record") VisitorDO record, @Param("example") VisitorParam example);
}