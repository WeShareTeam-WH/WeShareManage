package com.weshare.manage.controller;

import com.weshare.manage.common.QiniuConfig;
import com.weshare.manage.cto.HttpResponse;
import com.weshare.manage.entity.Goods;
import com.weshare.manage.entity.GoodsDetailModel;
import com.weshare.manage.entity.GoodsImage;
import com.weshare.manage.entity.GoodsSku;
import com.weshare.manage.repository.GoodsRepository;
import com.weshare.manage.service.GoodsService;
import com.weshare.manage.cto.Result;
import com.weshare.manage.utils.ImageUtil;
import com.weshare.manage.utils.UtilsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/goods")
@RestController
public class GoodsController {
    private static Logger logger = LogManager.getLogger(GoodsController.class);

    @Autowired
    private GoodsRepository adminRepository;

    @Autowired
    private QiniuConfig qiniuConfig;

	@RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
	public @ResponseBody
	HttpResponse imgUpload(@RequestBody GoodsImage goodsImage)
	{
		HttpResponse data = new HttpResponse(HttpStatus.SERVICE_UNAVAILABLE, null);
		String path = "D:/"+goodsImage.getGoods().getId()+"/"+ UtilsHelper.getRandomNum(10)+".png";
		ImageUtil.GenerateImage(goodsImage.getImgBase64());
		return  data;
	}
    /*
    @RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
    public @ResponseBody
    HttpResponse profileImgCut(@RequestBody MultipartFile file, @RequestBody GoodsSku goodsSku, @RequestBody GoodsDescription goodsDetail) {
    	HttpResponse data = new HttpResponse(HttpStatus.SERVICE_UNAVAILABLE, null);
        String name = avatar_file.getOriginalFilename();
        String parentPath = request.getSession().getServletContext().getRealPath("/");
        String path = parentPath + "static/goodsImage" + "/" + goodsid + "/";
        //判断文件的MIMEtype
        String type = avatar_file.getContentType();
        if (type == null || !type.toLowerCase().startsWith("image/")) {
            data.setMessage("不支持的文件类型，仅支持图片！");
        }

        String fileName = GoodsImageType.valueOf(imageType).toString();

        //开始上传
        File targetFile = new File(path, fileName);
        //保存
        try {
            if (!targetFile.exists()) {
                targetFile.mkdirs();

                ImageCutSize size = JsonUtil.jsonToObject(avatar_data, ImageCutSize.class);
                if (size != null && size.getWidth() > 0 && size.getHeight() > 0) {
                    InputStream in = avatar_file.getInputStream();
                    ImageUtil.cut(in, targetFile, size.getX(), size.getY(), size.getWidth(), size.getHeight());
                    in.close();
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return data;
    }
     */
    
    @Autowired
	private GoodsService goodsService;
    
	@RequestMapping(value = "/goodsBasic", method = RequestMethod.POST)
	public @ResponseBody Result addGoodsBasic(@RequestBody GoodsDetailModel goods){
		try{
			goodsService.addGoodsBasic(goods);
			return Result.success();
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}

	@RequestMapping(value = "/goodsBasic", method = RequestMethod.PUT)
	public @ResponseBody Result editGoodsBasic(@RequestBody GoodsDetailModel goods){
		try{
			String imagePath = ImageUtil.GenerateImage(goods.getGoods().getBase64Image());
			if (imagePath != null)
			{
				goods.getGoods().setGoodsImageUrl(imagePath);
				goodsService.editGoodsBasic(goods);
				goods.getGoods().setBase64Image("");
				return Result.success(goods);
			}
			else
			{
				return Result.failure("Image upload failed!");
			}

		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}

	@RequestMapping(value = "/goodsDescription", method = RequestMethod.POST)
	public @ResponseBody Result addGoodsDescription(@RequestBody GoodsDetailModel goods){
		try{
			goodsService.addGoodsDescription(goods);
			return Result.success();
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE )
	public @ResponseBody Result delete(Long id){
		try{
			goodsService.delete(id);
			return Result.success();
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody Result update(@RequestBody Goods goods){
		try{
			return Result.success(goodsService.update(goods));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable Long id){
		try{
			GoodsDetailModel goodsDetailModel = goodsService.get(id);
			if(goodsDetailModel==null){throw new RuntimeException();}
			return Result.success(goodsDetailModel);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody Result getAll(){
		try{
			List<Goods> goods = goodsService.getAll();
			return Result.success(goods);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	public @ResponseBody Result getPage(int page, int rows){
		try{
			Page<Goods> pageBean = goodsService.getPage(page,rows);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total",pageBean.getTotalElements());
			result.put("rows",pageBean.getContent());
			return Result.success(result);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
}
