package com.imooc.myo2o.util;

public class PathUtil {
	private static String seperator = System.getProperty("file.separator");

	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "C:/o2oImg";
		} else {
			basePath = "/user/image";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
