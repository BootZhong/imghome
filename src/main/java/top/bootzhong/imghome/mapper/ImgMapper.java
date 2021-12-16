package top.bootzhong.imghome.mapper;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import top.bootzhong.imghome.model.entity.Img;

@Repository
public interface ImgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);

    /**
     * 通过名称查询
     * @param imgName
     * @return
     */
    Img selectByName(@PathVariable("imgName") String imgName);
}