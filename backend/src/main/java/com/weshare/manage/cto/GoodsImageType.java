package com.weshare.manage.cto;

public enum GoodsImageType {
	samll(1),
	medium(2), 
	large(3);
	
	private int value = 0;
	
	private GoodsImageType(int type)
	{
		this.value = value;
	}
	
	public static GoodsImageType valueOf(int value) {
		GoodsImageType result;
		switch (value) {
		case 1:
			result = samll;
			break;
		case 2:
			result = medium;
			break;
		case 3:
			result = large;
			break;
		default:
			result = large;
			break;
		}
		return result;
	}
}
