package top.bootzhong.imghome.mapper;

import org.springframework.stereotype.Repository;
import top.bootzhong.imghome.model.entity.Img;

@Repository
public interface ImgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}