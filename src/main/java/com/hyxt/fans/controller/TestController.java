package com.hyxt.fans.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	@RequestMapping(value="/test")
	public String test(Model model,@RequestParam(value="pageIndex",defaultValue="1") Integer pageIndex){
		List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", "1");
		map.put("name", "zhangsan");
		map.put("mobile", "15038074114");
		map.put("money", 7.52);
		map.put("createTime","2014-11-21 10:09:10");
		items.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "2");
		map.put("name", "lisi");
		map.put("mobile", "");
		map.put("money", 12.52);
		map.put("createTime","2014-12-11 10:09:10");
		items.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "3");
		map.put("name", "wangwu");
		map.put("mobile", "13038074114");
		map.put("money", 18.2);
		map.put("createTime",null);
		items.add(map);
		model.addAttribute("items", items);
		Page page = new Page();
		page.setTotal(42);
		page.setPageIndex(pageIndex);
		model.addAttribute("page", page);
		return "test";
	}
	
	@RequestMapping(value="/detail")
	public String detail(){
		return "detail";
	}
	
	@RequestMapping(value="/go/{id}")
	public String go(@PathVariable("id") String id){
		return "detail";
	}
	
	@RequestMapping(value="/go/{id}/{name}")
	public String go1(@PathVariable("id") String id,@PathVariable("name") String name){
		return "detail";
	}
	
	class Page{
		private int total=0;
		private int pageSize=10;
		private int pageIndex=1;
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getPageIndex() {
			return pageIndex;
		}
		public void setPageIndex(int pageIndex) {
			this.pageIndex = pageIndex;
		}
	}
}
