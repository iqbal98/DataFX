package org.datafx.controller.context;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.util.Callback;

public class ViewMetadata<T> {

    private Class<T> controllerClass;

    private StringProperty titleProperty;

    private ObjectProperty<Callback<Dimension2D, Node>> graphicsFactoryProperty;

    public ViewMetadata(Class<T> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public String getTitle() {
        return titleProperty().get();
    }

    public StringProperty titleProperty() {
        if(titleProperty == null) {
            titleProperty = new SimpleStringProperty();
        }
        return titleProperty;
    }

    public void setTitle(String titleProperty) {
        titleProperty().set(titleProperty);
    }

    public Callback<Dimension2D, Node> getGraphicsFactory() {
        return graphicsFactoryProperty().get();
    }

    public ObjectProperty<Node> graphicsProperty() {
        return new SimpleObjectProperty<Node>(graphicsFactoryProperty().get().call(new Dimension2D(16,16)));
    }

    public ObjectProperty<Callback<Dimension2D, Node>> graphicsFactoryProperty() {
        if(graphicsFactoryProperty == null) {
            graphicsFactoryProperty = new SimpleObjectProperty<>((d) -> null);
        }
        return graphicsFactoryProperty;
    }

    public void setGraphicsFactory(Callback<Dimension2D, Node> graphicsFactoryProperty) {
        this.graphicsFactoryProperty().set(graphicsFactoryProperty);
    }

    public Class<T> getControllerClass() {
        return controllerClass;
    }
}
