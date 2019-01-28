package com.weshare.manage.controller;
import com.weshare.manage.entity.GoodsDescription;
import com.weshare.manage.service.GoodsDescriptionService;
import com.weshare.manage.cto.Result;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodsDescription")
public class GoodsDescriptionController {
	@Autowired
	private GoodsDescriptionService goodsDescriptionService;
	@RequestMapping(value = "/add", method = RequestMethod.POST )
	public @ResponseBody Result add(@RequestBody GoodsDescription goodsDescription){
		try{
			return Result.success(goodsDescriptionService.add(goodsDescription));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE )
	public @ResponseBody
	Result delete(Long id){
		try{
			goodsDescriptionService.delete(id);
			return Result.success();
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody Result update(@RequestBody GoodsDescription goodsDescription){
		try{
			return Result.success(goodsDescriptionService.update(goodsDescription));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody Result get(Long id){
		try{
			GoodsDescription goodsDescription = goodsDescriptionService.get(id);
			if(goodsDescription==null){throw new RuntimeException();}
			return Result.success(goodsDescription);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody Result getAll(){
		try{
			return Result.success(goodsDescriptionService.getAll());
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	public @ResponseBody Result getPage(int page, int rows){
		try{
			Page<GoodsDescription> pageBean = goodsDescriptionService.getPage(page,rows);
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