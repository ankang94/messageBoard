package com.ankang.msgboard.infrastructure.persistence.mybatis.mapper;

import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.result.ArticleMessageDO;
import com.ankang.msgboard.infrastructure.persistence.mybatis.mapper.auto.MessageAutoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper extends MessageAutoMapper {
    List<ArticleMessageDO> fetchMsgList(@Param("articleId") Integer article,
                                        @Param("pageNum") Integer pageNum,
                                        @Param("pageSize") Integer pageSize);

    Long countMsg(@Param("articleId") Integer article);
}
