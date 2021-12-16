package top.bootzhong.imghome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.bootzhong.imghome.common.ServerResponse;
import top.bootzhong.imghome.model.entity.Img;
import top.bootzhong.imghome.service.ImgService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

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
        if (!img.isEmpty() && img.getSize() <= 0){
            return ServerResponse.createByErrorMessage("文件不能为空");
        }
        if (img.getOriginalFilename() ==  null){
            return ServerResponse.createByErrorMessage("文件不能为空");
        }

        return ServerResponse.createBySuccess(imgService.add(img));
    }

    /*@GetMapping("/{imgName}")
    public ServerResponse getImg(@PathVariable String imgName, HttpServletResponse response){
        Img img = imgService.getImg(imgName);

        try {
            FileInputStream inputStream = new FileInputStream(img.getLocalPath());

            response.setContentType("image/png");
            response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(img.getName(), "UTF-8"));
            ServletOutputStream out = response.getOutputStream();
            FileCopyUtils.copy(inputStream, out);
            // 不同文件的MimeType参考后续链接
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ServerResponse.createBySuccess();
    }*/
}
