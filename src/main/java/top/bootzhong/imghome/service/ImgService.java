package top.bootzhong.imghome.service;

import org.springframework.web.multipart.MultipartFile;
import top.bootzhong.imghome.model.dto.ImgDTO;
import top.bootzhong.imghome.model.entity.Img;

import java.io.FileInputStream;

/**
 * 图片业务层
 * @author bootzhong
 */
public interface ImgService {
    /**
     * 新增图片
     * @param img
     * @return
     */
    ImgDTO add(MultipartFile img);

    /**
     * 获取图片信息
     * @param imgName
     * @return
     */
    Img getImg(String imgName);
}
