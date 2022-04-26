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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Author Mi
 * @Date 2022/4/2 21:03
 * @Version 1.0
 */
@Controller
public class LoadAndUpController {

    /**
     *                  文件下载
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
        //获取servletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realpath = servletContext.getRealPath("/static/img/1.png");
        //创建输入流
        InputStream fileInputStream = new FileInputStream(realpath);
        //创建字节数组
        byte[] bytes = new byte[fileInputStream.available()];
        //将流读取到字节数组中
        fileInputStream.read(bytes);
        //创建httpHeads对象设置响应头信息
        MultiValueMap<String,String> headers = new HttpHeaders();
        //设置要下载的方式以及文件的名字
        headers.add("Content-Disposition","attachment;filename=1.png");
        //设置响应码状态
        HttpStatus httpStatus = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,headers,httpStatus);
        //关闭输入流
        fileInputStream.close();
        return responseEntity;
    }


    /**
     *          文件上传
     */
    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
        String originalFilename = photo.getOriginalFilename();
        //解决问价重名问题
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        originalFilename = uuid + suffixName;
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("photo");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdir();
        }
        String finalPath = realPath + file.separator + originalFilename;
        photo.transferTo(new File(finalPath));

        return "success";
    }


}
