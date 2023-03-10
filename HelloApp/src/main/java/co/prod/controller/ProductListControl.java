package co.prod.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		// db결과 -> attribute("list")
		
		ProductService service = new ProductServiceImpl();
		
		
		
		
		return "product/productList.tiles";		// 실행할 페이지
	}

}
