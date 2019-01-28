package com.weshare.manage.controller;
import com.weshare.manage.entity.UserCommentsImages;
import com.weshare.manage.service.UserCommentsImagesService;
import com.weshare.manage.cto.Result;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/userCommentsImages")
public class UserCommentsImagesController {
	@Autowired
	private UserCommentsImagesService userCommentsImagesService;
	@RequestMapping(value = "/add", method = RequestMethod.POST )
	public @ResponseBody Result add(UserCommentsImages userCommentsImages){
		try{
			return Result.success(userCommentsImagesService.add(userCommentsImages));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE )
	public @ResponseBody Result delete(Long id){
		try{
			userCommentsImagesService.delete(id);
			return Result.success();
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody Result update(UserCommentsImages userCommentsImages){
		try{
			return Result.success(userCommentsImagesService.update(userCommentsImages));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody Result get(Long id){
		try{
			UserCommentsImages userCommentsImages = userCommentsImagesService.get(id);
			if(userCommentsImages==null){throw new RuntimeException();}
			return Result.success(userCommentsImages);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody Result getAll(){
		try{
			return Result.success(userCommentsImagesService.getAll());
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	public @ResponseBody Result getPage(int page, int rows){
		try{
			Page<UserCommentsImages> pageBean = userCommentsImagesService.getPage(page,rows);
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