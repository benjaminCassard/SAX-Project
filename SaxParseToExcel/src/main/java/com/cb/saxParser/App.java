package com.cb.saxParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.cb.handler.SAXApp;

/**
 *
 */
public class App 
{
	private static final Logger LOGGER = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	LOGGER.info("Start app");
        try {
			XMLReader xr = XMLReaderFactory.createXMLReader();
			SAXApp handler = new SAXApp();
			xr.setContentHandler(handler);
			xr.setErrorHandler(handler);
			
			//Get file
			File file =  new File("D:/XMLFileTest.xml");
			
			FileReader r = new FileReader(file);
		    xr.parse(new InputSource(r));
		} catch (SAXException e) {
			LOGGER.error("Error: "+e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			LOGGER.error("Error: "+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			LOGGER.error("Error: "+e.getMessage());
			e.printStackTrace();
		}
    }
}
