package com.example.a6_lab;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Parser {
    public static String[] getRateFromECB(InputStream stream) throws IOException {
        String result = "";
        String currencyName = "";
        String[] Data = new String[100];
        try {
            DocumentBuilderFactory xmlDocFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlDocBuilder = xmlDocFactory.newDocumentBuilder();
            Document doc = xmlDocBuilder.parse(stream);

            NodeList rateNodes = doc.getElementsByTagName(Constants.CUBE_NODE);
            for (int i = 0; i < rateNodes.getLength(); ++i) {
                Element cube = (Element) rateNodes.item(i);
                if(cube.hasAttribute(Constants.CURRENCY)){
                    currencyName = cube.getAttribute(Constants.CURRENCY);
                    result = cube.getAttribute(Constants.RATE);
                    currencyName = currencyName + " - " + result;
                    Data[i]=(currencyName);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return Data;
    }
}
