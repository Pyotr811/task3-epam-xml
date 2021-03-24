package by.epam.home.dao;

import by.epam.home.entity.Node;

import java.io.IOException;

public interface XMLParserDAO {
    Node parse(String fileName) throws XMLParserDAOException, IOException;
}
