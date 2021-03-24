package by.epam.home.service;

import by.epam.home.entity.Node;

public interface XMLParserService {
   Node parse(String fileName) throws XMLParserServiceException;
}
