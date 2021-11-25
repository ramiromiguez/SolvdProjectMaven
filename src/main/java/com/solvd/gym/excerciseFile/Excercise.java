package com.solvd.gym.excerciseFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;



public class Excercise {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Logger LOG = Logger.getLogger(Excercise.class.getName());
		
		File excerciseFile = new File("excercise.txt");
		// copy the text of the file into a string
		String allWords = FileUtils.readFileToString(excerciseFile, StandardCharsets.UTF_8.name());
		
		// split the words of the string
		String[] words = allWords.split("[\\W]+");
		// a set is used so only unique can be added to it
		Set<String> uniqueWords = new HashSet<String>();
		for (String word : words) {
		    uniqueWords.add(word);
		}
		
		//concat the Strings
		String introduction = "The quantity of unique words in this file is: ";
		// get the size of the set and transform it in a string
		String uniqueWordsQuantity = Integer.toString(uniqueWords.size());
		String firstCombination = introduction.concat(uniqueWordsQuantity);
		String finalCombination = allWords.concat(firstCombination);
		
		//transform the string into a byte[] so the machine can read it
	    byte[] bytes = finalCombination.getBytes();
	    FileUtils.writeByteArrayToFile(excerciseFile, bytes);
	    
	    //---------------------------------------------------------------------------------
	    //Creating a file and deleting it.
	    File trashFile = new File("trashile");
	    File survivourFile = new File("survivourFile");
	    String data = "I'm the alpha file im the file who survives";
	    byte[] bytes2 = data.getBytes();
	    
	    FileUtils.touch(trashFile);
	    FileUtils.touch(survivourFile);
	    FileUtils.writeByteArrayToFile(survivourFile, bytes2);
	    FileUtils.forceDelete(trashFile);
	    
	    //copying survivour file
	    File copyOfSurvivourFile = new File("imaCopy");
	    FileUtils.copyFile(survivourFile, copyOfSurvivourFile, false);
		//playing with StringUtils methods
	    LOG.log(Level.INFO, String.valueOf(StringUtils.isEmpty(data)));
	    LOG.log(Level.INFO, String.valueOf(StringUtils.isWhitespace(data)));
	    
	    String normalString = "hello how are you?";
	    String drunkString = StringUtils.reverse(normalString);
	    LOG.log(Level.INFO, drunkString);
	    String iDontLikeH = StringUtils.remove("hi i dont like hs", "h");
	    LOG.log(Level.INFO, iDontLikeH);
	    String iHateEandLoveO = StringUtils.replaceChars("The other day", "e", "o");
	    LOG.log(Level.INFO, iHateEandLoveO);
	}
}
