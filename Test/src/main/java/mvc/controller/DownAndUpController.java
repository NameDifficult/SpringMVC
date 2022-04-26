package mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * @Author Mi
 * @Date 2022/4/3 13:38
 * @Version 1.0
 */
@Controller
public class DownAndUpController {

    /**
     * 下载
     */
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/img/1.png");
        InputStream inputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        MultiValueMap<String,String> map = new HttpHeaders();
        map.add("Content-Disposition","attachment;filename=1.png");
        HttpStatus httpStatus = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,map,httpStatus);
        inputStream.close();
        return responseEntity;
    }


    /**
     * 上传
     */
    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo , HttpSession session) throws IOException {
        String originalFilename = photo.getOriginalFilename();
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        originalFilename = uuid + suffixName;
        ServletContext servletContext = session.getServletContext();
        String img = servletContext.getRealPath("img");
        File file = new File(img);
        if (!file.exists()){
            file.mkdir();
        }
        String path = img + file.separator + originalFilename;
        photo.transferTo(new File(path));
        return "success";
    }

}
