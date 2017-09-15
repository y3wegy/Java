package com.xml.manager.handler;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by e631876 on 9/6/2017.
 */
public class DMHSAXHandler extends DefaultHandler {
    private  static  final Logger logger = Logger.getLogger(DMHSAXHandler.class);

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        logger.info("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        logger.info("endDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        logger.info("startElement");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        logger.info("endElement");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        logger.info("characters");
    }
}
