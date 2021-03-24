package by.epam.home.service;

import by.epam.home.service.impl.XMLParserServiceImpl;

public class XMLParserServiceProvider {
    private static XMLParserServiceProvider xmlParserServiceProvider;
    private final XMLParserService xmlParserService = new XMLParserServiceImpl();

    public XMLParserServiceProvider() {
    }

    public static XMLParserServiceProvider getInstance() {
        if (xmlParserServiceProvider == null) {
            xmlParserServiceProvider = new XMLParserServiceProvider();
        }
        return xmlParserServiceProvider;
    }

    public XMLParserService getXmlParserService() {
        return xmlParserService;
    }
}
