package in.voidma.classroom.network.client.gui;

import controlP5.ControlEvent;
import controlP5.ControlListener;
import controlP5.ControlP5;
import controlP5.*;
import fisica.FWorld;
import fisica.Fisica;
import in.voidma.classroom.network.client.Client;
import processing.event.KeyEvent;

import java.lang.reflect.Method;

/**
 * Created by Zane on 4/4/2017.
 */
public abstract class Screen implements ControlListener {

    protected Client processing;
    protected FWorld world;
    protected ControlP5 cp5;

    public Screen(Client processing, FWorld world) {
        this.processing = processing;
        this.world = world;
        this.cp5 = new ControlP5(processing);
        this.cp5.addListener(this);
    }

    public Screen(Client processing) {
        this.processing = processing;
        Fisica.init(processing);
        this.world = new FWorld();
        this.cp5 = new ControlP5(processing);
        this.cp5.addListener(this);
    }

    public abstract void update(int seconds);
    public abstract void draw();

    public void keyPressed() {
    }

    public void keyPressed(KeyEvent event) {
    }

    public void controlEvent(ControlEvent controlEvent) {
        String name = controlEvent.getName();

        invokeNamedCallback(name);
        invokeNamedCallback(name, controlEvent.getValue());
        invokeNamedCallback(name, controlEvent.getArrayValue());
        invokeNamedCallback(name, controlEvent.getStringValue());
    }

    private void invokeNamedCallback(String name, Object parameter) {
        try {
            Method m = this.getClass().getMethod(name, parameter.getClass());
            m.invoke(this, parameter);
        } catch (Exception e) {
        }
    }

    private void invokeNamedCallback(String name) {
        try {
            Method m = this.getClass().getMethod(name);
            m.invoke(this);
        } catch (Exception e) {
        }
    }
}
