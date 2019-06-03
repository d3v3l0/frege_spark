package script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.A;

public class ScriptExecutor {

	static ScriptEngine frege;
	
	public static <A, B> B executeFunction(String functionName, A x) throws IOException, ScriptException {
		loadFunctions();
		return (B) frege.eval(functionName + " " + x.toString());
	}

	public static <A, B, C> C executeFunction2(String functionName, A v1, B v2) throws ScriptException, IOException {
		loadFunctions();
		return (C) frege.eval(functionName + " " + v1.toString() + " " + v2.toString());
	}

	public static void main(String arg[]) throws IOException, ScriptException {
		/*
		 * long startTime = System.currentTimeMillis(); executeScript(); long stopTime =
		 * System.currentTimeMillis(); long elapsedTime = stopTime - startTime;
		 * System.out.println("First: " + elapsedTime);
		 * 
		 * startTime = System.currentTimeMillis(); executeFunctionFromJar("addOne",
		 * 1.0); stopTime = System.currentTimeMillis(); elapsedTime = stopTime -
		 * startTime; System.out.println("Second: " + elapsedTime);
		 */
		loadFunctions();
	}

	/*
	 * Helper function to initiate ScriptEngine and load functions
	 *  
	 *  https://stackoverflow.com/questions/1463192/reading-content-of-a-jar-file-at-runtime
	 */
	static void loadFunctions() throws IOException, ScriptException {
		if (frege == null) {
			final ScriptEngineManager factory = new ScriptEngineManager();
			frege = factory.getEngineByName("frege");
			JarFile jarFile = new JarFile("frege-spark.jar");

			final Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements()) {
				final JarEntry entry = entries.nextElement();
				if (entry.getName().contains(".")) {
					// System.out.println("File : " + entry.getName());
					if (entry.getName().contains("FunctionPool.fr")) {
						JarEntry fileEntry = jarFile.getJarEntry(entry.getName());
						InputStream input = jarFile.getInputStream(fileEntry);
						InputStreamReader isr = new InputStreamReader(input);
						BufferedReader reader = new BufferedReader(isr);
						String line;
						while ((line = reader.readLine()) != null) {
							if (isFunctionDefinition(line)) {
								String script = line.trim();
								frege.eval(script);
								// System.out.println(script);
							}
						}
						reader.close();

					}
				}
			}
			jarFile.close();
		}
	}

	/*
	 *  helper function to determine whether a line is a frege function definition
	 */
	private static boolean isFunctionDefinition(String line) {
		return line.contains("=");
	}
}
