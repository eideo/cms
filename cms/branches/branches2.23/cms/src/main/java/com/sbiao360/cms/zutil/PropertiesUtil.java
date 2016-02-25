package com.sbiao360.cms.zutil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class PropertiesUtil {

	public static Properties getProperties(String propertiesFile) {
		InputStream in = null;
		Properties properties = new Properties();
		try {
			in = Resources.getResourceAsStream(propertiesFile);
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return properties;
	}
}
