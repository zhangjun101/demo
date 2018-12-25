package com.system.utils.controllerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * @corporation scwares
 * @author luojl
 * @date 2016-2-26 上午11:00:37
 * @path com.v2.scwares.system.action
 * @description
 */
public class SearchCondition implements ISearchCondition {

	//用于记录自定义查询条件值
	private List<Object> conditionvalue = new ArrayList<Object>();
	
	// 用于记录request中参数名称及值
	private Map<String, Object> values = new HashMap<String, Object>();

	
	public SearchCondition(HttpServletRequest request) {
		if (null == request)
			return;
		for (Iterator<?> i = request.getParameterMap().keySet().iterator(); i.hasNext();) {
			String key = (String) i.next();
			values.put(key, request.getParameter(key));
		}
	}


	@Override
	public String getValue(String key) {
		if (values.get(key) != null) {
			return (String) values.get(key);
		} else {
			return null;
		}
	}

	
	@Override
	public void setValue(String key, String val) {
		if (key==null){
			return;
		}else{
			if(key.equals("")){
				return;
			}else {
				values.put(key, val);
			}
		}
	}
	
	
	@Override
	public boolean valueIsEmpty(String key) {
		String v = getValue(key);
		if (v == null) {
			return true;
		} else {
			v = v.trim();
			if (v.length() == 0) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public Map<String, Object> getParameters() {
		return values;
	}
	
	
	@Override
	public void addCustomCondition(Object o) {
		this.conditionvalue.add(o);
	}

	
	@Override
	public Object[] getCustomCondition() {
		return this.conditionvalue.toArray();
	}



	
}
