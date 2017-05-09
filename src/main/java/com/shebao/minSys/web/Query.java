package com.shebao.minSys.web;

import org.apache.ibatis.session.RowBounds;

public class Query {
	//第几页
	private int page=1;
	//每页多少条数
	private int pageSize=10;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public RowBounds toRowBound(){
		return new RowBounds((page-1)*pageSize,pageSize);
		
	}
	@Override
	public String toString() {
		return "Query [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
}
