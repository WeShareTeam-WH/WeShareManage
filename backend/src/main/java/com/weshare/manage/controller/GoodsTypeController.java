package com.weshare.manage.controller;
import com.weshare.manage.entity.GoodsType;
import com.weshare.manage.service.GoodsTypeService;
import com.weshare.manage.cto.Result;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService goodsTypeService;
	@RequestMapping(value = "/add", method = RequestMethod.POST )
	public @ResponseBody Result add(@RequestBody GoodsType goodsType){
		try{
			return Result.success(goodsTypeService.add(goodsType));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE )
	public @ResponseBody Result delete(Long id){
		try{
			goodsTypeService.delete(id);
			return Result.success();
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody Result update(@RequestBody GoodsType goodsType){
		try{
			return Result.success(goodsTypeService.update(goodsType));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody Result get(Long id){
		try{
			GoodsType goodsType = goodsTypeService.get(id);
			if(goodsType==null){throw new RuntimeException();}
			return Result.success(goodsType);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody Result getAll(){
		try{
			return Result.success(goodsTypeService.getAll());
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	public @ResponseBody Result getPage(int page, int rows){
		try{
			Page<GoodsType> pageBean = goodsTypeService.getPage(page,rows);
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