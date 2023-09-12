package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.busiservice.CommonSzhjgService;
import com.fudian.szhjg.mapper.TDalxglMapper;
import com.fudian.szhjg.mapper.TGxhjglMapper;
import com.fudian.szhjg.pojo.*;
import com.fudian.szhjg.service.TDalxglService;
import com.fudian.szhjg.service.TGxhjglService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Api(tags = "A01  数字化加工公共Controller")
@RestController
@RequestMapping("/szhjgCommonController")
public class CommonSzhjgController {
    @Autowired
    private TDalxglService tDalxglService;
    @Autowired
    private TDalxglMapper tDalxglMapper;

    @Autowired
    private TGxhjglService tGxhjglService;
    @Autowired
    private TGxhjglMapper tGxhjglMapper;

    @Autowired
    private CommonSzhjgService commonSzhjgService;

    @ApiOperation("重名校验")
    @GetMapping("/chongMingCheck")
    @ApiOperationSupport(order = 1)
    public CommonResult chongMingCheck(String id,String mc, String type, String entity){
        CommonResult commonResult = new CommonResult();

        if("dalxgl".equals(entity)){
            TDalxgl tDalxgl = new TDalxgl();

            CommonTemplate commonTemplate = new CommonTemplate(tDalxgl,tDalxglService,tDalxglMapper);
            LambdaQueryWrapper<TDalxgl> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            if (mc==null){
                return commonResult;
            }else
                lambdaQueryWrapper.eq(TDalxgl::getDamc,mc);

            List<TDalxgl> list = commonTemplate.chongMingCheckList(lambdaQueryWrapper);
            if (list.size()>0){
                if("add".equals(type)){
                    commonResult.setCode(200);
                    commonResult.setMsg("重名");
                }
                if("update".equals(type)){
                    if(!id.equals(list.get(0).getId())){
                        commonResult.setCode(200);
                        commonResult.setMsg("重名");
                    }
                }
            }else{
                commonResult.setCode(200);
                commonResult.setMsg("不重名");
            }
        }

        if("gxhjgl".equals(entity)){
            TGxhjgl tGxhjgl = new TGxhjgl();

            CommonTemplate commonTemplate = new CommonTemplate(tGxhjgl,tGxhjglService,tGxhjglMapper);
            LambdaQueryWrapper<TGxhjgl> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            if (mc==null){
                return commonResult;
            }else
                lambdaQueryWrapper.eq(TGxhjgl::getGxmc,mc);

            List<TGxhjgl> list = commonTemplate.chongMingCheckList(lambdaQueryWrapper);
            if (list.size()>0){
                if("add".equals(type)){
                    commonResult.setCode(200);
                    commonResult.setMsg("重名");
                }
                if("update".equals(type)){
                    if(!id.equals(list.get(0).getId())){
                        commonResult.setCode(200);
                        commonResult.setMsg("重名");
                    }
                }
            }else{
                commonResult.setCode(200);
                commonResult.setMsg("不重名");
            }
        }

        return  commonResult;
    }


    /**项目批次选择框
     * 2023-02-17
     * @return
     */
    @ApiOperation("项目批次选择框")
    @ApiOperationSupport(order = 2)
    @GetMapping("/queryProjectBatch")
    public CommonResult queryProjectBatch(Integer gxId) {
        CommonResult commonResult = commonSzhjgService.queryProjectBatch(gxId);
        return commonResult;
    }

    /**页面动态展示工序名称
     * 2023-02-28
     * @return
     */
    @ApiOperation("页面动态展示工序名称")
    @ApiOperationSupport(order = 3)
    @GetMapping("/queryDisplayGx")
    public List<Object> queryDisplayGx(){
        List<Object> list= commonSzhjgService.queryDisplayGx();
        return list;
    }


    @ApiOperation("查询档案类型名称")
    @ApiOperationSupport(order = 4)
    @GetMapping("/queryArchivesName")
    @ResponseBody
    public List<Object> queryArchivesName (String dictType){
        return commonSzhjgService.queryArchivesName(dictType);
    }


    /**案卷绑定当前操作人员
     * 2023-03-02
     * @param nameId
     * @return
     */
    @ApiOperation("案卷绑定当前操作人员(用户)")
    @ApiOperationSupport(order = 5)
    @GetMapping("/bindingRecipient")
    public CommonResult bindingRecipient(String nameId){
        return commonSzhjgService.bindingRecipient(nameId);
    }



    @ApiOperation("查询案卷图像信息（图片地址集合）")
    @ApiOperationSupport(order = 6)
    @GetMapping("/selectPictureImage")
    public CommonResult selectPictureImage(String ajId,String jh) throws IOException {
        CommonResult result = new CommonResult();
        //查询案卷下指定文件信息
        List<TJianji> taskPieces = commonSzhjgService.taskPieceList(ajId,jh);
        List<String> img = new LinkedList<>();
        for (TJianji piece : taskPieces ){
            if (StringUtils.isNotBlank(piece.getTpdz())){
                img.add(piece.getTpdz());
            }
        }
        result.put("imgs",img);
        return CommonResult.success(result);
    }


    @ApiOperation("查看文件单张图像（字符流没有使用）")
    @ApiOperationSupport(order = 7)
    @GetMapping("/ioReadImg")
    public String ioReadImg(@RequestParam String url, HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
        FileInputStream ips = null;
        try {
            ips = new FileInputStream(new File(url));
            response.setContentType("multipart/form-data");
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
            ips.close();
        }
        return null;
    }

    @ApiOperation("查看文件单张图像（正在使用）")
    @ApiOperationSupport(order = 8)
    @GetMapping("/ioReadImg2")
    public void  ioReadImg2(@RequestParam String url, HttpServletResponse response) throws IOException {
        String suffix = url.substring(url.lastIndexOf(".") + 1);
        BufferedImage image = ImageIO.read(new File(url));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, suffix, outputStream);
        byte[] imageBytes = outputStream.toByteArray();

        response.setContentType("image/"+suffix); // 设置响应类型为图片类型
        response.setContentLength(imageBytes.length); // 设置响应长度为图片字节数组长度
        response.getOutputStream().write(imageBytes); // 将图片字节数组写入响应输出流
        response.getOutputStream().flush();
    }


}
