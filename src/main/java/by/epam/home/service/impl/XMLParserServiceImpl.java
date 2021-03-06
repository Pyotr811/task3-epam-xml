package by.epam.home.service.impl;

import by.epam.home.dao.XMLParserDAO;
import by.epam.home.dao.XMLParserDAOException;
import by.epam.home.dao.XMLParserDAOProvider;
import by.epam.home.entity.Node;
import by.epam.home.service.XMLParserService;
import by.epam.home.service.XMLParserServiceException;



public class XMLParserServiceImpl implements XMLParserService {

    private final XMLParserDAOProvider xmlParserDAOProvider = XMLParserDAOProvider.getInstance();
    private final XMLParserDAO xmlParserDAO =xmlParserDAOProvider.getXmlParserDAO();
    @Override
    public Node parse(String fileName) throws XMLParserServiceException {
        Node rootNode;
        try {
            rootNode = xmlParserDAO.parse(fileName);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new XMLParserServiceException("Parser service layer exception!");
        }
        return rootNode;
    }
}
