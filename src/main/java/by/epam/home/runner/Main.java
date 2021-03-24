package by.epam.home.runner;
import by.epam.home.service.XMLParserService;
import by.epam.home.service.XMLParserServiceException;
import by.epam.home.service.XMLParserServiceProvider;



public class Main {
    public static void main(String[] args) throws XMLParserServiceException {
        XMLParserServiceProvider xmlParserServiceProvider = XMLParserServiceProvider.getInstance();
        XMLParserService xmlParserService = xmlParserServiceProvider.getXmlParserService();

        ConsoleWriter.write(xmlParserService.parse("source.xml"));


    }


}
