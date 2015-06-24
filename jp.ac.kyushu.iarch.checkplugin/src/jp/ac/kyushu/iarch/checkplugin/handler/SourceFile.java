package jp.ac.kyushu.iarch.checkplugin.handler;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SourceFile {
	private String path;
	private String code;

	public SourceFile(String sourceFilePath) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(sourceFilePath)));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		br.close();
		code = sb.toString();
		path = sourceFilePath;
	}

	public String getFilePath() {
		return path;
	}

	public String getSourceCode() {
		return code;
	}
}
