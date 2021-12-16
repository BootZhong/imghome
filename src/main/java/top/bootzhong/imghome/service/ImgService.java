package top.bootzhong.imghome.service;

import org.springframework.web.multipart.MultipartFile;
import top.bootzhong.imghome.model.dto.ImgDTO;

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
}
