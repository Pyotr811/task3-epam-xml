package by.epam.home.dao.impl;

import by.epam.home.dao.NodeFactory;
import by.epam.home.dao.XMLParserDAO;
import by.epam.home.dao.XMLParserDAOException;
import by.epam.home.entity.Attribute;
import by.epam.home.entity.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class XMLParserDAOImpl implements XMLParserDAO {
    private final NodeFactory nodeFactory = new NodeFactory();

    @Override
    public Node parse(String fileName) throws XMLParserDAOException, IOException{
        BufferedReader bufferedReader;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            line = bufferedReader.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new XMLParserDAOException("File for parsing not found!");
        }
        Deque<Node> stack = new ArrayDeque<>();
        String rootNodeName = nodeFactory.getTagName(line);
        Node node;
        while (line != null) {
            if (nodeFactory.openTagCheck(line)) {
                node = new Node();
                String tagName = (String) nodeFactory.getTagName(line);
                node.setName(tagName);
                if (nodeFactory.attributeCheck(line)) {
                    Attribute attribute = (Attribute) nodeFactory.getAttribute(line);
                    node.setAttribute(attribute);
                }
                if (nodeFactory.contentCheck(line)) {
                    String content = (String) nodeFactory.getContent(line);
                    node.setContent(content);
                }
                if (nodeFactory.closeTagCheck(line)) {
                    Node last = (Node) stack.removeLast();
                    nodeFactory.setElementToNode(last.getElements(), last, node);
                    stack.addLast(last);
                } else {
                    stack.addLast(node);
                }
            } else {
                if (!nodeFactory.getTagName(line).equals(rootNodeName)) {
                    Node childNode = (Node) stack.removeLast();
                    Node parentNode = (Node) stack.removeLast();
                    nodeFactory.setElementToNode(parentNode.getElements(), parentNode, childNode);
                    stack.addLast(parentNode);
                } else {
                    bufferedReader.close();
                    return stack.getFirst();
                }
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return stack.getFirst();
    }
}
