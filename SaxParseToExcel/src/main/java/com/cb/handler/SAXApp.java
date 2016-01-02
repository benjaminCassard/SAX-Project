package com.cb.handler;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXApp extends DefaultHandler {

	private static final Logger LOGGER = Logger.getLogger(SAXApp.class);
	
	public SAXApp(){
		super();
	}
	
	@Override
	public void startDocument() throws SAXException {
		LOGGER.info("Start document");
	}
	
	@Override
	public void endDocument() throws SAXException {
		LOGGER.info("End document");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if ("".equals (uri)){
			System.out.println("Start element: " + qName);
		}
		else{
			System.out.println("Start element: {" + uri + "}" + localName);
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.print("Characters:    \"");
		for (int i = start; i < start + length; i++) {
		    switch (ch[i]) {
		    case '\\':
			System.out.print("\\\\");
			break;
		    case '"':
			System.out.print("\\\"");
			break;
		    case '\n':
			System.out.print("\\n");
			break;
		    case '\r':
			System.out.print("\\r");
			break;
		    case '\t':
			System.out.print("\\t");
			break;
		    default:
			System.out.print(ch[i]);
			break;
		    }
		}
		System.out.print("\"\n");
	    
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("".equals (uri)){
			System.out.println("End element: " + qName);
		}
		else{
			System.out.println("End element:   {" + uri + "}" + localName);
		}
	}
}
