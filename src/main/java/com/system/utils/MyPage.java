package com.system.utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页对象. 包含当前页数据及分页信息如总记录数.
 * 
 */
public class MyPage implements Serializable {
	
	private static final long serialVersionUID = 1L;
//	static private int DEFAULT_PAGE_SIZE = 20;
//	static private String DEFAULT_DIR = "DESC";
//	static private String DEFAULT_SORT = "id";
	
	 //总记录数
	private Long total;
	// 总页数
	private long totalPage;
	//当前页数
	private int page;
	//每页数量
	private int pageSize;
	//数据集合
	private List rows = new ArrayList();
	//过滤字段
	private String sidx;
	// 排序方式
	private String sord;
	//排序字段
	private String sort;
	
	//查询条件集合
	private Map<String, Object> queryParams;

	
	public long getTotalPage() {
		if (total > 0 && pageSize > 0){
			if (total %pageSize == 0){
				this.totalPage = total / pageSize;
			}
			else{
				this.totalPage = total/ pageSize + 1;
			}
		}
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public Map<String, Object> getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(Map<String, Object> queryParams) {
		this.queryParams = queryParams;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}

}