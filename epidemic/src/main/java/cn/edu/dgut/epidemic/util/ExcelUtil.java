package cn.edu.dgut.epidemic.util;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ExcelUtil {
	/**
	 * 用户信息导出方法
	 * 
	 * @param response
	 *            响应
	 * @param fileName
	 *            文件名
	 * @param sheetName
	 *            sheet名字
	 * 
	 * @param columnList
	 *            每列的标题名
	 * @param dataList
	 *            导出的数据
	 */
	public static void uploadExcelAboutUser(HttpServletResponse response, String fileName, String sheetName,
			List<String> columnList, List<List<String>> dataList) {
		// 声明输出流
		OutputStream os = null;
		// 设置响应头
		setResponseHeader(response, fileName);
		try {
			// 获取输出流
			os = response.getOutputStream();
			// 内存中保留1000条数据，以免内存溢出，其余写入硬盘
			SXSSFWorkbook wb = new SXSSFWorkbook(1000);
			// 获取该工作区的第一个sheet
			Sheet sheet1 = wb.createSheet(sheetName);
			int excelRow = 0;
			// 创建标题行
			Row titleRow = sheet1.createRow(excelRow++);
			for (int i = 0; i < columnList.size(); i++) {
				// 创建该行下的每一列，并写入标题数据
				Cell cell = titleRow.createCell(i);
				cell.setCellValue(columnList.get(i));
			}
			// 设置内容行
			if (dataList != null && dataList.size() > 0) {
				// 序号是从1开始的
				int count = 1;
				// 外层for循环创建行
				for (int i = 0; i < dataList.size(); i++) {
					Row dataRow = sheet1.createRow(excelRow++);
					// 内层for循环创建每行对应的列，并赋值
					for (int j = -1; j < dataList.get(0).size(); j++) {// 由于多了一列序号列所以内层循环从-1开始
						Cell cell = dataRow.createCell(j + 1);
						if (j == -1) {// 第一列是序号列，不是在数据库中读取的数据，因此手动递增赋值
							cell.setCellValue(count++);
						} else {// 其余列是数据列，将数据库中读取到的数据依次赋值
							cell.setCellValue(dataList.get(i).get(j));
						}
					}
				}
			}
			// 将整理好的excel数据写入流中
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭输出流
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 设置浏览器下载响应头
	 */
	private static void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Excel表格导出
	 * 
	 * @param response
	 *            HttpServletResponse对象
	 * @param excelData
	 *            Excel表格的数据，封装为List<List<String>>
	 * @param sheetName
	 *            sheet的名字
	 * @param fileName
	 *            导出Excel的文件名
	 * @param columnWidth
	 *            Excel表格的宽度，建议为15
	 * @throws IOException
	 *             抛IO异常
	 */
	public static void exportExcel(HttpServletResponse response, List<List<String>> excelData, String sheetName,
			String fileName, int columnWidth) throws IOException {
		// 声明一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格，设置表格名称
		HSSFSheet sheet = workbook.createSheet(sheetName);
		// 设置表格列宽度
		sheet.setDefaultColumnWidth(columnWidth);
		// 写入List<List<String>>中的数据
		int rowIndex = 0;
		for (List<String> data : excelData) {
			// 创建一个row行，然后自增1
			HSSFRow row = sheet.createRow(rowIndex++);
			// 遍历添加本行数据
			for (int i = 0; i < data.size(); i++) {
				// 创建一个单元格
				HSSFCell cell = row.createCell(i);
				// 创建一个内容对象
				HSSFRichTextString text = new HSSFRichTextString(data.get(i));
				// 将内容对象的文字内容写入到单元格中
				cell.setCellValue(text);
			}
		}
		// 设置中文文件名与后缀
		String encodedFileName = URLEncoder.encode(fileName + ".xlsx", "utf-8").replaceAll("\\+", "%20");
		// 清除buffer缓存
		response.reset();
		// 设置导出Excel的名称
		response.setHeader("Content-disposition", "attachment;filename=" + encodedFileName + "");
		// 准备将Excel的输出流通过response输出到页面下载
		// 八进制输出流
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 刷新缓冲
		response.flushBuffer();
		// workbook将Excel写入到response的输出流中，供页面下载该Excel文件
		workbook.write(response.getOutputStream());
		// 关闭workbook
		workbook.close();
	}
}
