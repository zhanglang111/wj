package com.evan.wj.Controller;

import com.evan.wj.Utils.PictureUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Code by langlang on 2020/2/24
 */
@RestController
public class PictrueController {

    @CrossOrigin
    @PostMapping("/api/admin/content/books/covers")
    public String uploadPic(@RequestBody MultipartFile file){
        PictureUtil pictureUtil = new PictureUtil();
        String folder = "F:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, pictureUtil.CreatePicUrlRomdomnNumString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (
                IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
