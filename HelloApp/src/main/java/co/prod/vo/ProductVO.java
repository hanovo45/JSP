package co.prod.vo;

import lombok.Data;

@Data
public class ProductVO {
	
	private String productCode;
	private String productName;
	private int originPrice;
	private int salePrice;
	private String productDesc;
	private double likeIt;
	private String image;
	
//	product_code varchar2(10) primary key,
//	product_name varchar2(100) not null,
//	origin_price number not null,
//	sale_price number,
//	product_desc varchar2(1000) not null,
//	like_it number(3,1) not null,
//	image varchar2(100)
}
