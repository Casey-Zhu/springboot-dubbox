package com.yxhl.poi.util;


import java.net.URLEncoder;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.yxhl.platform.common.entity.DynamicBean;
 
/**
 * 包装类
 *
 * @param <T>
 */
public class ExportDynamicExcelWrapper extends ExportDynamicBeanExcelUtil {
	/**
	 * <p>
	 * 导出带有头部标题行的Excel <br>
	 * 时间格式默认：yyyy-MM-dd hh:mm:ss <br>
	 * </p>
	 * 
	 * @param title 表格标题
	 * @param headers 头部标题集合
	 * @param dataset 数据集合
	 * @param out 输出流
	 * @param version 2003 或者 2007，不传时默认生成2003版本
	 */
	public void exportExcel(String fileName, String title, String[] headers, Collection<DynamicBean> dataset, HttpServletResponse response,String version) {
		try {
			response.setContentType("application/vnd.ms-excel");  
			if(StringUtils.isBlank(version) || EXCEL_FILE_2003.equals(version.trim())){
				response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8") + ".xls");
				exportExcel2003(title, headers, dataset, response.getOutputStream(), "yyyy-MM-dd hh:mm:ss");
			}else{
				response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
				exportExcel2007(title, headers, dataset, response.getOutputStream(), "yyyy-MM-dd hh:mm:ss");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

