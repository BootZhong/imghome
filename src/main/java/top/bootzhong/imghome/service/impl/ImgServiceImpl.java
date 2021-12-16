package top.bootzhong.imghome.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import top.bootzhong.imghome.common.Const;
import top.bootzhong.imghome.common.ServerResponse;
import top.bootzhong.imghome.mapper.ImgMapper;
import top.bootzhong.imghome.model.dto.ImgDTO;
import top.bootzhong.imghome.model.entity.Img;
import top.bootzhong.imghome.service.ImgService;
import top.bootzhong.imghome.util.FileUtil;

import java.io.File;
import java.util.UUID;

/**
 * 图片业务层
 * @author bootzhong
 */
@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    private ImgMapper imgMapper;

    @Override
    public ImgDTO add(MultipartFile img) {
        String ukSign = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = img.getOriginalFilename();
        String newName = ukSign + FileUtil.getSuffix(originalFilename);

        String localPath = Const.IMG_LOCAL_PATH + newName;
        String cloudPath = Const.IMG_CLOUD_PATH + newName;

        try {
            //保存本地
            img.transferTo(new File(localPath));

            //保存数据库记录
            Img imgRecord = new Img();
            imgRecord.setLocalPath(localPath);
            imgRecord.setCloudPath(cloudPath);
            imgRecord.setSize(img.getSize());
            imgRecord.setName(newName);
            imgRecord.setOrginName(originalFilename);
            imgMapper.insert(imgRecord);

            //返回数据
            ImgDTO imgDTO = new ImgDTO();
            imgDTO.setUrl(cloudPath);
            imgDTO.setName(newName);
            return imgDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}
