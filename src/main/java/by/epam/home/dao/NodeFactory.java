package by.epam.home.dao;

import by.epam.home.entity.Attribute;
import by.epam.home.entity.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NodeFactory {

    public String getTagName(String line) {
        Pattern pattern = Pattern.compile("</?([A-Za-z]+-?[A-Za-z]*\\b)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }

    public Attribute getAttribute(String line) {
        Pattern pattern = Pattern.compile("(([a-z]+)=\"(\\S+)\")");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String name = matcher.group(2).trim();
            String value = matcher.group(3).trim();
            Attribute attribute = new Attribute();
            attribute.setName(name);
            attribute.setValue(value);
            return attribute;
        }
        return null;
    }

    public String getContent(String line) {
        Pattern pattern = Pattern.compile("(>(.+)<)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(2).trim();
        }
        return "";
    }

    public boolean openTagCheck(String line) {
        Pattern pattern = Pattern.compile("<[^/]\\S+");
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public boolean attributeCheck(String line) {
        Pattern pattern = Pattern.compile("(([a-z]+)=\"(\\S+)\")");
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public boolean contentCheck(String line) {
        Pattern pattern = Pattern.compile("(>(.+)<)");
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public boolean closeTagCheck(String line) {
        Pattern pattern = Pattern.compile("</\\S+>$");
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public void setElementToNode(List<Node> elements, Node node, Node childNode) {
        if (elements == null) {
            elements = new ArrayList<>();
        }
        elements.add(childNode);
        node.setElements(elements);
    }
}
