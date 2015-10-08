package jp.ac.kyushu.iarch.checkplugin.handler;

import java.io.File;

public class Envs {

	public static final String UTF_8 = "UTF-8";
	public static final String SJIS = "SJIS";
	public static final String EUC_JP = "EUC-JP";

	public static String[] getClassPath() {
		// TODO Auto-generated method stub
		String property = System.getProperty("java.class.path", ".");
		return property.split(File.pathSeparator);
	}

	public static String[] getSourcePath() {
		// TODO Auto-generated method stub
		return new String[] { "." };
	}

	public static String getEncoding() {
		// TODO Auto-generated method stub
		return UTF_8;
	}

	public static String getLineSeparator() {
		return System.getProperty("line.separator", "\n");
	}
}
