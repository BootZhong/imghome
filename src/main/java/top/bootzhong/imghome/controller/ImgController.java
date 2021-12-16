package top.bootzhong.imghome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.bootzhong.imghome.common.ServerResponse;
import top.bootzhong.imghome.service.ImgService;

/**
 * 控制层
 * @author bootzhong
 */
@RestController
public class ImgController {
    @Autowired
    private ImgService imgService;

    @PostMapping("/upload")
    public ServerResponse upload(@RequestParam("img") MultipartFile img){
        if (!img.isEmpty()&&img.getSize()>0){
            return ServerResponse.createByErrorMessage("文件不能为空");
        }
        if (img.getOriginalFilename() ==  null){
            return ServerResponse.createByErrorMessage("文件不能为空");
        }

        return ServerResponse.createBySuccess(imgService.add(img));
    }
}
