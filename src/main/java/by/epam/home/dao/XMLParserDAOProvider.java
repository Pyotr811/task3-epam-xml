package by.epam.home.dao;

import by.epam.home.dao.impl.XMLParserDAOImpl;

public class XMLParserDAOProvider {

    public XMLParserDAOProvider() {
    }

    private static XMLParserDAOProvider xmlParserDAOProvider;
    private final XMLParserDAO xmlParserDAO = new XMLParserDAOImpl();

    public static XMLParserDAOProvider getInstance() {
        if (xmlParserDAOProvider == null) {
            xmlParserDAOProvider = new XMLParserDAOProvider();
        }
        return xmlParserDAOProvider;
    }

    public XMLParserDAO getXmlParserDAO() {
        return xmlParserDAO;
    }
}
