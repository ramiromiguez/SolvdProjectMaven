package com.solvd.gym.excercise_file;

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

	File excerciseFile = new File("src/main/resources/excercise.txt");
	File quantityFile = new File("src/main/resources/quantityofwordsinexcercise.txt");
	FileUtils.touch(quantityFile);
	// copy the text of the file into a string
	String allWords = FileUtils.readFileToString(excerciseFile, StandardCharsets.UTF_8.name());

	// split the words of the string
	String[] words = allWords.split("[\\W]+");
	// a set is used so only unique can be added to it
	Set<String> uniqueWords = new HashSet<String>();
	for (String word : words) {
	    uniqueWords.add(word);
	}

	// create the string
	String introduction = "The quantity of unique words in this file is: " + Integer.toString(uniqueWords.size());

	// transform the string into a byte[] so the machine can read it
	byte[] bytes = introduction.getBytes();
	FileUtils.writeByteArrayToFile(quantityFile, bytes);

	// ---------------------------------------------------------------------------------
	// Creating a file and deleting it.
	File trashFile = new File("src/main/resources/trashile");
	File survivorFile = new File("src/main/resources/survivourFile");
	String data = "I'm the alpha file im the file who survives";
	byte[] bytes2 = data.getBytes();

	FileUtils.touch(trashFile);
	FileUtils.touch(survivorFile);
	FileUtils.writeByteArrayToFile(survivorFile, bytes2);
	FileUtils.forceDelete(trashFile);

	// copying survivor file
	File copyOfSurvivorFile = new File("src/main/resources/imaCopy");
	FileUtils.copyFile(survivorFile, copyOfSurvivorFile, false);
	// playing with StringUtils methods
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
