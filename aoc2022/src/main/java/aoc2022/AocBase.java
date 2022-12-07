package aoc2022;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public abstract class AocBase {
	
	protected BufferedReader reader;

	public AocBase(String path) {
		InputStream is = D02.class.getResourceAsStream(path);
		InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
		reader = new BufferedReader(streamReader);
	}
}
