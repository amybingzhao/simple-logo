package Controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * This class is used to parse command strings into Command objects.
 * @author amyzhao
 *
 */
public class Parser {
	private List<Entry<String, Pattern>> mySymbols;
	
	public Parser() {
		mySymbols = new ArrayList<>();
	}
	
	/**
	 * From regex example
	 * @param syntax: path to properties file.
	 */
	public void addPatterns(String syntax) {
		ResourceBundle resources = ResourceBundle.getBundle(syntax);
		Enumeration<String> iter = resources.getKeys();
		while (iter.hasMoreElements()) {
			String key = iter.nextElement();
			String regex = resources.getString(key);
			mySymbols.add(new SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
		}
	}
	
	public String getSymbol(String text) {
		final String ERROR = "NO MATCH";
		for (Entry<String, Pattern> e : mySymbols) {
			if (match(text, e.getValue())) {
				return e.getKey();
			}
		}
		return ERROR;
	}
	
	private boolean match(String text, Pattern regex) {
		return regex.matcher(text).matches();
	}
	
	private void addNewUserDefinedCommand() {
		// add name of new command + # args to numargs map
		
		// add string of the entire command to userdefinedcommands map
	}
	
	private void executeUserDefinedCommand() {
		//replace parameters with values before giving it back to the controller, e.g. for dash - replace all instances of
		// count and size with vals for count and size, then send that to parseCommand ^
	}
}
