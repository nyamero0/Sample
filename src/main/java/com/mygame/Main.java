package com.mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;


/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */


public class Main extends SimpleApplication {

    private Nifty nifty;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Box box = new Box(1,1,1);
        Geometry geom = new Geometry("Box", box);
        Material mat = new Material(this.assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        geom.setMaterial(mat);
        rootNode.attachChild(geom);
        NiftyJmeDisplay niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
                assetManager,
                inputManager,
                audioRenderer,
                viewPort
        );
        nifty = niftyDisplay.getNifty();
        Screen sc = nifty.getCurrentScreen();
        SampleState startScreen = new SampleState(this, sc, nifty);
        nifty.fromXml("Interface/Nifty/menu_gui.xml", "root", startScreen);
        
        guiViewPort.addProcessor(niftyDisplay);
        
        
        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);
        stateManager.attach(startScreen);
        
        inputManager.setCursorVisible(true);
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}

