package com.system.utils.controllerUtil;



import java.util.Map;


/**
 * @corporation scwares
 * @author luojl
 * @date 2016-11-8 下午07:57:37
 * @path com.v2.scwares.core.web
 * @description
 */
public interface ISearchCondition {

	 /**
     * Description:[按参数名称取参数对应的值]<br>
     * @author:luojl
     * @update: 2015年5月18日
     * @param key  参数名称
     * @return 参数值
     */
    public String getValue(String key);
	
	
    /**
     * Description:[添加键-值对的参数]<br>
     * @author:luojl
     * @update: 2015年6月1日
     * @param key  键
     * @param val 参数值
     */
    public void setValue(String key, String val);
    
    
    
    /**
     * Description:[方法功能中文描述]<br>
     * @author:luojl
     * @update: 2015年5月18日
     * @param key
     * @return true为空，false不为空
     */
    public boolean valueIsEmpty(String key);
    
    
    /**
     * Description:[获取所有request传递参数的map]<br>
     * @author:luojl
     * @update: 2015年5月18日
     * @return 参数Map对象
     */
    public Map<String, Object> getParameters();
    
    
    /**
     * @description 写入转换后的条件值
     * @param o
     */
    public void addCustomCondition(Object o);
    
    /**
     * @description 读取条件值
     * @return
     */
    public Object[] getCustomCondition();


}
