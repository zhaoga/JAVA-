package com.p9;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParser {
    class BookHandler extends DefaultHandler {
        private List<String> nameList;
        private boolean title = false;

        public List<String> getNameList() {
            return nameList;
        }

        // 当遇到文档开始
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start parsing document...");
            nameList = new ArrayList<String>();
        }

        // 当遇到文档结束
        @Override
        public void endDocument() throws SAXException {
            System.out.println("End");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("title")) {
                title=true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (title) {
                title=false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (title) {
                String bookTitle = new String(ch,start,length);
                System.out.println("Book title:" + bookTitle);
                nameList.add(bookTitle);
            }
        }
    }

    public static void main(String[] args) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        BookHandler bookHandler = (new SAXParser()).new BookHandler();
        parser.setContentHandler(bookHandler);
        parser.parse("book.xml");
        System.out.println(bookHandler.getNameList());
    }
}
