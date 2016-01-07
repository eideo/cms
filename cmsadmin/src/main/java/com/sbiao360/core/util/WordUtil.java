package com.sbiao360.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.StyleDescription;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlException;

public class WordUtil {

	public static LinkedHashMap<String, LinkedHashMap<String, List<String>>> getWordTitlesDoc(
			String path) throws IOException {
		File file = new File(path);
		String filename = file.getName();
		filename = filename.substring(0, filename.lastIndexOf("."));
		InputStream is = new FileInputStream(path);
		HWPFDocument hwpfDocument = new HWPFDocument(is);
		Range range = hwpfDocument.getRange();

		LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = new LinkedHashMap<String, LinkedHashMap<String, List<String>>>();
		Pattern patternOne = Pattern.compile("标题\\s{0,}1.*");
		Pattern patternTwo = Pattern.compile("标题\\s{0,}2.*");
		Pattern patternThree = Pattern.compile("标题\\s{0,}3.*");
		int one = 0;
		int two = 0;
		int three = 0;
		String oneLevel = "";
		String twoLevel = "";
		String threeLevel = "";

		for (int i = 0; i < range.numParagraphs(); i++) {
			Paragraph p = range.getParagraph(i);
			int numStyles = hwpfDocument.getStyleSheet().numStyles();
			int styleIndex = p.getStyleIndex();
			if (numStyles > styleIndex) {
				StyleSheet style_sheet = hwpfDocument.getStyleSheet();
				StyleDescription style = style_sheet
						.getStyleDescription(styleIndex);
				String styleName = style.getName();
				if (styleName != null && styleName.contains("标题")) {
					Matcher matcherOne = patternOne.matcher(styleName);
					Matcher matcherTwo = patternTwo.matcher(styleName);
					Matcher matcherThree = patternThree.matcher(styleName);
					if (matcherOne.matches()) {
						one++;
						oneLevel = one + "|" + p.text().replaceAll("\r|\n", "");
						LinkedHashMap<String, List<String>> twoLevelMap = new LinkedHashMap<String, List<String>>();
						catalogMap.put(oneLevel, twoLevelMap);
					} else if (matcherTwo.matches()) {
						two++;
						twoLevel = two + "|" + p.text().replaceAll("\r|\n", "");
						LinkedHashMap<String, List<String>> twoLevelMap = catalogMap
								.get(oneLevel);
						List<String> threeList = new ArrayList<String>();
						twoLevelMap.put(twoLevel, threeList);
						catalogMap.put(oneLevel, twoLevelMap);
					} else if (matcherThree.matches()) {
						three++;
						threeLevel = three + "|"
								+ p.text().replaceAll("\r|\n", "");
						LinkedHashMap<String, List<String>> twoLevelMap = catalogMap
								.get(oneLevel);
						List<String> threeList = twoLevelMap.get(twoLevel);
						threeList.add(threeLevel);
						twoLevelMap.put(twoLevel, threeList);
						catalogMap.put(oneLevel, twoLevelMap);
					}
				}
			}
		}
		return catalogMap;
	}

	public static LinkedHashMap<String, LinkedHashMap<String, List<String>>> getWordTitlesDocx(
			String path) throws IOException, XmlException, OpenXML4JException {
		InputStream is = new FileInputStream(path);
		OPCPackage opcPackage = POIXMLDocument.openPackage(path);
		XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(opcPackage);
		// POIXMLDocument poiXMLDocument = xwpfWordExtractor.getDocument();
		XWPFDocument xwpfDocument = new XWPFDocument(is);
		List<XWPFParagraph> paras = xwpfDocument.getParagraphs();

		LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = new LinkedHashMap<String, LinkedHashMap<String, List<String>>>();
		int one = 0;
		int two = 0;
		int three = 0;
		String oneLevel = "";
		String twoLevel = "";
		String threeLevel = "";

		for (XWPFParagraph graph : paras) {
			String text = graph.getParagraphText();
			String style = graph.getStyle();
			if ("1".equals(style)) {
				one++;
				oneLevel = one + "|" + text.replaceAll("\r|\n", "");
				LinkedHashMap<String, List<String>> twoLevelMap = new LinkedHashMap<String, List<String>>();
				catalogMap.put(oneLevel, twoLevelMap);
			} else if ("2".equals(style)) {
				two++;
				twoLevel = two + "|" + text.replaceAll("\r|\n", "");
				LinkedHashMap<String, List<String>> twoLevelMap = catalogMap
						.get(oneLevel);
				List<String> threeList = new ArrayList<String>();
				twoLevelMap.put(twoLevel, threeList);
				catalogMap.put(oneLevel, twoLevelMap);
			} else if ("3".equals(style)) {
				three++;
				threeLevel = three + "|" + text.replaceAll("\r|\n", "");
				LinkedHashMap<String, List<String>> twoLevelMap = catalogMap
						.get(oneLevel);
				List<String> threeList = twoLevelMap.get(twoLevel);
				threeList.add(threeLevel);
				twoLevelMap.put(twoLevel, threeList);
				catalogMap.put(oneLevel, twoLevelMap);
			} else {
				continue;
			}
		}
		xwpfDocument.close();
		xwpfWordExtractor.close();
		return catalogMap;
	}

	public static LinkedHashMap<String, LinkedHashMap<String, List<String>>> getWordCatalogDoc(
			String path) throws IOException {
		File file = new File(path);
		String filename = file.getName();
		filename = filename.substring(0, filename.lastIndexOf("."));
		InputStream is = new FileInputStream(path);
		HWPFDocument hwpfDocument = new HWPFDocument(is);
		Range range = hwpfDocument.getRange();

		LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = new LinkedHashMap<String, LinkedHashMap<String, List<String>>>();
		Pattern patternOne = Pattern.compile("标题\\s{0,}1.*");
		Pattern patternTwo = Pattern.compile("标题\\s{0,}2.*");
		Pattern patternThree = Pattern.compile("标题\\s{0,}3.*");
		int one = 0;
		int two = 0;
		int three = 0;
		String oneLevel = "";
		String twoLevel = "";
		String threeLevel = "";

		for (int i = 0; i < range.numParagraphs(); i++) {
			Paragraph p = range.getParagraph(i);
			int numStyles = hwpfDocument.getStyleSheet().numStyles();
			int styleIndex = p.getStyleIndex();
			if (numStyles > styleIndex) {
				StyleSheet style_sheet = hwpfDocument.getStyleSheet();
				StyleDescription style = style_sheet
						.getStyleDescription(styleIndex);
				String styleName = style.getName();
				if (styleName != null && styleName.contains("目录")) {
					System.out.println("styleName=====" + styleName
							+ "text=====" + p.text());
				}
				if (styleName != null && styleName.contains("标题")) {
					Matcher matcherOne = patternOne.matcher(styleName);
					Matcher matcherTwo = patternTwo.matcher(styleName);
					Matcher matcherThree = patternThree.matcher(styleName);
					if (matcherOne.matches()) {
						one++;
						oneLevel = one + "|" + p.text().replaceAll("\r|\n", "");
						LinkedHashMap<String, List<String>> twoLevelMap = new LinkedHashMap<String, List<String>>();
						catalogMap.put(oneLevel, twoLevelMap);
					} else if (matcherTwo.matches()) {
						two++;
						twoLevel = two + "|" + p.text().replaceAll("\r|\n", "");
						LinkedHashMap<String, List<String>> twoLevelMap = catalogMap
								.get(oneLevel);
						List<String> threeList = new ArrayList<String>();
						twoLevelMap.put(twoLevel, threeList);
						catalogMap.put(oneLevel, twoLevelMap);
					} else if (matcherThree.matches()) {
						three++;
						threeLevel = three + "|"
								+ p.text().replaceAll("\r|\n", "");
						LinkedHashMap<String, List<String>> twoLevelMap = catalogMap
								.get(oneLevel);
						List<String> threeList = twoLevelMap.get(twoLevel);
						threeList.add(threeLevel);
						twoLevelMap.put(twoLevel, threeList);
						catalogMap.put(oneLevel, twoLevelMap);
					}
				}
			}
		}
		return catalogMap;
	}

	public static LinkedHashMap<String, LinkedHashMap<String, List<String>>> getWordCatalogDocx(
			String path) throws IOException, XmlException, OpenXML4JException {
		Map<String, String> variables = new HashMap<String, String>();
		variables.put("directory", "directory");
		variables.put("page", "page");
		String pattern = "(?<directory>.*)\\s(?<page>\\d+)";
		RegularExpressionUtil regularExpressionUtil = new RegularExpressionUtil(
				pattern, variables);

		InputStream is = new FileInputStream(path);
		OPCPackage opcPackage = POIXMLDocument.openPackage(path);
		XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(opcPackage);
		XWPFDocument xwpfDocument = new XWPFDocument(is);
		List<XWPFParagraph> paras = xwpfDocument.getParagraphs();

		LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = new LinkedHashMap<String, LinkedHashMap<String, List<String>>>();
		int one = 0;
		int two = 0;
		int three = 0;
		String oneLevel = "";
		String twoLevel = "";
		String threeLevel = "";

		for (XWPFParagraph graph : paras) {
			String text = graph.getParagraphText();
			String style = graph.getStyle();
			// System.out.println("style=====" + style + ", text=====" + text);
			if ("10".equals(style) && !"".equals(text)) {
				one++;
				Map<String, String> map = regularExpressionUtil.parse(text
						.trim());
				if (null != map && !map.isEmpty()) {
					oneLevel = one + "|" + map.get("directory").trim() + "|"
							+ map.get("page");
				}
				LinkedHashMap<String, List<String>> twoLevelMap = new LinkedHashMap<String, List<String>>();
				catalogMap.put(oneLevel, twoLevelMap);
			} else if ("20".equals(style) && !"".equals(text)) {
				two++;
				Map<String, String> map = regularExpressionUtil.parse(text
						.trim());
				if (null != map && !map.isEmpty()) {
					twoLevel = two + "|" + map.get("directory").trim() + "|"
							+ map.get("page");
				}
				LinkedHashMap<String, List<String>> twoLevelMap = catalogMap
						.get(oneLevel);
				if(null == twoLevelMap) {
					twoLevelMap = new LinkedHashMap<String, List<String>>();
				}
				List<String> threeList = new ArrayList<String>();
				twoLevelMap.put(twoLevel, threeList);
				catalogMap.put(oneLevel, twoLevelMap);
			} else if ("30".equals(style) && !"".equals(text)) {
				three++;
				Map<String, String> map = regularExpressionUtil.parse(text
						.trim());
				if (null != map && !map.isEmpty()) {
					threeLevel = three + "|" + map.get("directory").trim()
							+ "|" + map.get("page");
				}
				LinkedHashMap<String, List<String>> twoLevelMap = catalogMap
						.get(oneLevel);
				List<String> threeList = twoLevelMap.get(twoLevel);
				if(null == threeList) {
					threeList = new ArrayList<String>();
				}
				threeList.add(threeLevel);
				twoLevelMap.put(twoLevel, threeList);
				catalogMap.put(oneLevel, twoLevelMap);
			} else {
				continue;
			}
		}
		xwpfDocument.close();
		xwpfWordExtractor.close();
		return catalogMap;
	}

	public static HWPFDocument getDoc(String path) throws IOException {
		File file = new File(path);
		String filename = file.getName();
		filename = filename.substring(0, filename.lastIndexOf("."));
		InputStream is = new FileInputStream(path);
		HWPFDocument hwpfDocument = new HWPFDocument(is);
		return hwpfDocument;
	}

	public static XWPFDocument getDocx(String path) throws IOException,
			XmlException, OpenXML4JException {
		InputStream is = new FileInputStream(path);
		OPCPackage opcPackage = POIXMLDocument.openPackage(path);
		XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(opcPackage);
		XWPFDocument xwpfDocument = new XWPFDocument(is);
		return xwpfDocument;
	}

	public static LinkedHashMap<String, LinkedHashMap<String, List<String>>> getWordTitle(
			String path) throws IOException, XmlException, OpenXML4JException {
		LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = null;
		if (path.endsWith(".doc")) {
			catalogMap = getWordTitlesDoc(path);
		} else if (path.endsWith(".docx")) {
			catalogMap = getWordTitlesDocx(path);
		}
		return catalogMap;
	}

	public static LinkedHashMap<String, LinkedHashMap<String, List<String>>> getWordCatalog(
			String path) throws IOException, XmlException, OpenXML4JException {
		LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = null;
		if (path.endsWith(".doc")) {
			catalogMap = getWordCatalogDoc(path);
		} else if (path.endsWith(".docx")) {
			catalogMap = getWordCatalogDocx(path);
		}
		return catalogMap;
	}

	public static Map<String, Integer> getWordProperties(String path)
			throws IOException, XmlException, OpenXML4JException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (path.endsWith(".doc")) {
			HWPFDocument hwpfDocument = getDoc(path);
			// 总页数
			int reportPages = hwpfDocument.getSummaryInformation()
					.getPageCount();
			// 总字符数
			int reportWords = hwpfDocument.getSummaryInformation()
					.getWordCount();
			map.put("reportPages", reportPages);
			map.put("reportWords", reportWords);
		} else if (path.endsWith(".docx")) {
			XWPFDocument xwpfDocument = getDocx(path);
			// 总页数
			int reportPages = xwpfDocument.getProperties()
					.getExtendedProperties().getUnderlyingProperties()
					.getPages();
			// 总字符数
			int reportWords = xwpfDocument.getProperties()
					.getExtendedProperties().getUnderlyingProperties()
					.getCharacters();
			map.put("reportPages", reportPages);
			map.put("reportWords", reportWords);
		}
		return map;
	}

	private static void getFileList(String filePath) throws Exception {
		File file = new File(filePath);
		if (null != file) {
			File[] fileArr = file.listFiles();
			for (File f : fileArr) {
				if (f.isFile()) {
					String path = f.getPath();
					System.out.println("path = " + path);
					writeTxtFile(path, "E:/report/catalogtxt/" + "catalogpath.txt");
					LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = null;
					catalogMap = getWordCatalog(path);
					for (Map.Entry<String, LinkedHashMap<String, List<String>>> entryOne : catalogMap
							.entrySet()) {
						String oneLevel = entryOne.getKey();
						writeTxtFile(oneLevel,
								"E:/report/catalogtxt/" + f.getName() + ".txt");
						LinkedHashMap<String, List<String>> oneValue = entryOne
								.getValue();
						for (Map.Entry<String, List<String>> entryTwo : oneValue
								.entrySet()) {
							String twoLevel = entryTwo.getKey();
							writeTxtFile(twoLevel,
									"E:/report/catalogtxt/" + f.getName()
											+ ".txt");
							List<String> twoValue = entryTwo.getValue();
							for (String threeLevel : twoValue) {
								writeTxtFile(threeLevel,
										"E:/report/catalogtxt/" + f.getName()
												+ ".txt");
							}
						}
					}
				} else {
					getFileList(f.getPath());
				}
			}
		}
	}

	public static void writeTxtFile(String content, String filePath)
			throws Exception {
		File file = new File(filePath);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(filePath, true);
		try {
			fw.write(content + "\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				fw.close();
			}
		}
	}

	public static void main(String[] args) throws IOException, XmlException,
			OpenXML4JException {
		String path = "E:/report/catalog/2014/2014-2019年中国桥梁和水利行业发展深度研究分析报告.docx";
		// path = "E:/report/重庆展帆电力工程勘察设计咨询有限公司--2014-2015年度电力行业分析及投资咨询报告.doc";
/*		LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = null;
		catalogMap = getWordCatalog(path);*/
/*		LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = null;
		catalogMap = getWordCatalog(path);

		for (Map.Entry<String, LinkedHashMap<String, List<String>>> entryOne : catalogMap
				.entrySet()) {
			String oneLevel = entryOne.getKey();
			System.out.println("oneLevel==========" + oneLevel);
			LinkedHashMap<String, List<String>> oneValue = entryOne.getValue();
			for (Map.Entry<String, List<String>> entryTwo : oneValue.entrySet()) {
				String twoLevel = entryTwo.getKey();
				System.out.println("twoLevel==========" + twoLevel);
				List<String> twoValue = entryTwo.getValue();
				for (String threeLevel : twoValue) {
					System.out.println("threeLevel==========" + threeLevel);
				}
			}
		}*/

		/*Map<String, Integer> map = new HashMap<String, Integer>();
		map = getWordProperties(path);
		System.out.println("reportPages = " + map.get("reportPages")
				+ ", reportWords = " + map.get("reportWords"));*/
		
		String filePath = "E:/report/catalog";
		try {
			getFileList(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
