package com.c.myParcel;

import com.c.dto.OrderProductPartVO;
import com.c.dto.OrderVO;
import com.c.service.MainService;

public class AutoBlankTableClean {

	public void BlankOrderDelete(MainService service) throws Exception {
		for (OrderVO or : service.selectOrder())
		if (service.select_empty_orderpart( or.getIndex() ).get(0).equals("0")) {
			service.deleteOrder(or.getIndex());
		}
		//쓸모없는 주문 테이블 열 제거
	}
	public void BlankOrderPartDelete(MainService service) throws Exception {
		for (OrderProductPartVO orpt : service.selectOrderproductpart())
		if (service.select_empty_order( orpt.getOrder_index() ).get(0).equals("0")) {
			service.deleteorderproductpart(orpt.getOrder_index());
		}
		//쓸모없는 주문 미리보기 이미지 테이블 열 제거
	}
}
