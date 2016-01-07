package com.sbiao360.core.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionUtil {

	private Pattern pattern;

	private Map<String, String> variables;

	public RegularExpressionUtil(String pattern, Map<String, String> variables) {
		this.pattern = Pattern.compile(pattern);
		this.variables = Collections.unmodifiableMap(variables);
	}

	public String getPattern() {
		return pattern.pattern();
	}

	public Map<String, String> parse(String line) {
		Map<String, String> map = new HashMap<>();
		Matcher m = pattern.matcher(line);
		while (m.find()) {
			for (String key : variables.keySet()) {
				String multiKey = "?<" + key + ">";
				if (getPattern().indexOf(multiKey) > 0) {
					String nameGroup = variables.get(key);
					String value = m.group(key);
					map.put(nameGroup, value);
				}
			}
		}

		return map;
	}

	public static void main(String[] args) {
		String line = "一、2014年国际宏观经济运行情况	20";
		Map<String, String> variables = new HashMap<String, String>();
		variables.put("directory", "directory");
		variables.put("page", "page");
		String pattern = "(?<directory>.*)\\s(?<page>\\d+)";
		RegularExpressionUtil regularExpressionUtil = new RegularExpressionUtil(
				pattern, variables);
		Map<String, String> map = regularExpressionUtil.parse(line);
		System.out.println("map = " + map);
	}
}
