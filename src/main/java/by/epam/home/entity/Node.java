package by.epam.home.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Node implements Serializable {

    private String name;
    private Attribute attribute;
    private List<Node> elements;
    private String content;

    public Node() {
    }

    public String getName() {
        return name;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public List<Node> getElements() {
        return elements;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public void setElements(List<Node> elements) {
        this.elements = elements;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) &&
                Objects.equals(attribute, node.attribute) &&
                Objects.equals(elements, node.elements) &&
                Objects.equals(content, node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attribute, elements, content);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", attribute=" + attribute +
                ", elements=" + elements +
                ", content='" + content + '\'' +
                '}';
    }
}
