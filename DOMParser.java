package com.p9;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser {
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

    // 载入XML到DOM
    public Document parse(String filePath) {
        Document document = null;
        try {
            // DOM parser实例
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            // 载入XML到DOM
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return  document;
    }

    public static void main(String[] args) {
        DOMParser parser = new DOMParser();
        Document document = parser.parse("books.xml");
        // 得到根元素
        Element rootElement = document.getDocumentElement();
        // 遍历
        NodeList nodeList = rootElement.getChildNodes();
        for (int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                // 这里可以进一步处理
                System.out.println(node.getTextContent());
            }
        }
        // 按标记查找到元素
        NodeList nodeList1 = rootElement.getElementsByTagName("book");
        if (nodeList1 != null) {
            for (int i= 0;i<nodeList1.getLength();i++){
                Element element = (Element) nodeList1.item(i);
                String id = element.getAttribute("id");
            }
        }
    }
}
