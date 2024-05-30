package cn.xju.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.xju.dto.UploadResult;


@RestController
public class ImgUploadRestController {
    @PostMapping("/admin/file/upload")
    public UploadResult adminFileUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        // 获取上传的图片文件数据
        // // 生成唯一的文件名
        // String uniqueName = "yymmdd"
        // String fileName = generateUniqueFileName(filePart);
        // 保存图片文件
        // String path = request.getServletContext().getRealPath("/upload");
        // File document = new File(path);
        // if(!document.exists()){
        //     document.mkdirs();
        // }
        // filePart.write(path+File.separator+fileName);

         try {  
            // 获取当前日期并格式化为yyyy/MM格式  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");  
            String directory = sdf.format(new Date());  
  
            // 创建目录（如果不存在）  
            File dir = new File( request.getServletContext().getRealPath("/")+"/upload/"+directory);  
            if (!dir.exists()) {  
                dir.mkdirs();  
            }  
            
            // 检测目录中的图片数量，然后给新图片命名并保存  
            File[] files = dir.listFiles();  
            int count = files != null ? files.length : 0;  
            String pattern = "\\.\\w*";
            
            Pattern r = Pattern.compile(pattern);  
            Matcher m = r.matcher(file.getOriginalFilename());  
            m.find();
            String suffix= m.group();
            String newFileName = (count + 1) + suffix; // 假设只处理jpg图片，可以根据需要修改扩展名  
            String link =dir.getPath()+"/"+newFileName;
            file.transferTo(new File(link));  
            System.out.println(link);
            return new UploadResult("/upload/"+directory+"/"+newFileName);
        } catch (IOException e) {  
            e.printStackTrace();  
            return new UploadResult(null);
        }  
    }  
}


