package com.weshare.manage.cto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class Result {
    private static final Integer SUCCESS_STATUS = 200;
    private static final Integer FAILURE_STATUS = 400;
    private static final Integer INTERNAL_ERROR_STATUS = 500;
    private static final String SUCCESS_MESSAGE = "success";
    private static final String FAILURE_MESSAGE = "failure";
    private static final String INTERNAL_ERROR_MESSAGE = "internal error";
    private Integer status;
    private String message;
    private Object data;
    private Result(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static Result success(){
        return new Result(SUCCESS_STATUS,SUCCESS_MESSAGE,null);
    }

    public static Result success(Object data){
        return new Result(SUCCESS_STATUS,SUCCESS_MESSAGE,data);
    }

    public static Result failure(){
        return new Result(FAILURE_STATUS,FAILURE_MESSAGE,null);
    }

    public static Result failure(String message){
        return new Result(FAILURE_STATUS,message,null);
    }

    public static Result internalError(){
        return new Result(INTERNAL_ERROR_STATUS,INTERNAL_ERROR_MESSAGE,null);
    }

    public static Result internalError(String message){
        return new Result(INTERNAL_ERROR_STATUS,message,null);
    }

    public static Result build(Integer status,String message,Object data){
        return new Result(status,message,data);
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Result format(String json) {
        try {
            return MAPPER.readValue(json, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Result formatToPojo(String json, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(json, Result.class);
            }
            JsonNode jsonNode = MAPPER.readTree(json);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Result formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}