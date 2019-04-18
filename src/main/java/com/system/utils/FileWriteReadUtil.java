package com.system.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.jboss.logging.Logger;

/**
 * @author ZHANGJUN
 * 文件从指定的路径上传读取/写入文件
 */
public class FileWriteReadUtil {
	
	static Logger logger=Logger.getLogger(FileWriteReadUtil.class);
	
	
	
//	
//	public static void main(String[] args) {
//		File file = new File("D:\\test.txt");
//		writeFile(file, "D:\\fileUpLoad");
//	}
//	
	
	
//	/**单个文件写入本地
//	* @param file     文件
//	* @param address  要写入的地址（文件夹）
//	*/
//	public static void writeFile(File file,String parentAddress){
//	  //文件名称
//	  String fileName = file.getName();
//	  
//	  //判断文件夹是否存在
//	  File parentFile= new File(parentAddress);
//	  if(!parentFile.exists()){
//		  parentFile.mkdir();
//	  }  
//	  
//	  int b = 0;
//      FileInputStream in = null;
//      FileOutputStream out = null;
//      try {
//          in = new FileInputStream(file);
//          // OutputStream有这个文件就往这个文件里面写, 没有的话就自动创建一个
//          out = new FileOutputStream(parentAddress+"\\"+fileName);
//          // 一边读, 一边写
//          while ((b = in.read()) != -1) {
//              out.write(b);
//          }
//          
//          br.close();
//          isr.close();
//          fis.close();
//          
//      } catch (Exception e) {
//    	  logger.error("文件写入异常",e);
//    	  out.
//      }
//      
//	}
//	
//	
	
	
	
	
//	/**单个文件写入本地
//	* @param file     文件
//	* @param address  要写入的地址（文件夹）
//	*/
//	public static void writeFiles(File file,String parentAddress){
//
//		
//	  //文件名称
//	  String fileName = file.getName();
//	  
//	  //判断文件夹是否存在
//	  File parentFile= new File(parentAddress);
//	  if(!parentFile.exists()){
//		  parentFile.mkdir();
//	  }  
//	  
//	  try {
//		//创建文件输入流
//		  FileInputStream fileInputStream = new FileInputStream(file);
//		//创建字符输入流
//		  InputStreamReader isr = new InputStreamReader(fileInputStream);
//		  //创建输入缓冲流
//          BufferedReader br = new BufferedReader(isr);
//          
//          
//          
//    	  
//        
//          
//          
//   
//		  
//          //创建文件输出流
//          FileOutputStream fos = new FileOutputStream(parentAddress+"\\"+fileName);
//          //创建字符输出流
//          OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
//          //创建输出缓冲流
//          BufferedWriter bw = new BufferedWriter(osw);
//          
//          // 一边读, 一边写
//          while ((b = in.read()) != -1) {
//              out.write(b);
//          }
//          
//          
//          osw.write("宣州谢朓楼饯别校书叔云\n");
//          osw.write("弃我去者，昨日之日不可留；\n");
//          osw.write("乱我心者，今日之日多烦忧。\n");
//          osw.close();
//          osw.close();
//          fos.close();
//          
//       } catch (FileNotFoundException e) {
//          e.printStackTrace();
//       } catch (UnsupportedEncodingException e) {
//          e.printStackTrace();
//       } catch (IOException e) {
//          e.printStackTrace();
//      }
//	  
//	}
	
	
	
}
