/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JME3 Classes/BaseAppState.java to edit this template
 */
package com.mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.scene.Node;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.Nifty;

/**
 *  
 *  
 *
 * @author Wendy Andaya 
 */

public class SampleState extends BaseAppState implements ScreenController  {
    final private Application app;
    final Screen sc;
    final Nifty rootNifty;
    private Nifty nifty;
    
    private Screen screen;
    private Node localRootNode = new Node("Start Screen RootNode");
    private Node localGuiNode = new Node("Start Screen GuiNode");
    public SampleState(Application app, Screen sc, Nifty rootNifty){
        this.app = app;
        this.sc = sc;
        this.rootNifty = rootNifty;
    }
    
    @Override
    
     
    protected void initialize(Application app) {
    
        ((SimpleApplication) app).getRootNode().attachChild(localRootNode);
        ((SimpleApplication) app).getGuiNode().attachChild(localGuiNode);
       
        //It is technically safe to do all initialization and cleanup in the         
        //onEnable()/onDisable() methods. Choosing to use initialize() and         
        //cleanup() for this is a matter of performance specifics for the         
        //implementor.        
        //TODO: initialize your AppState, e.g. attach spatials to rootNode    
    }
 
    @Override 
    protected void cleanup(Application app) {
    
     
        //TODO: clean up what you initialized in the initialize method,        
        //e.g. remove all spatials from rootNode    
    } 
    //onEnable()/onDisable() can be used for managing things that should     
    //only exist while the state is enabled. Prime examples would be scene     
    //graph attachment or input listener attachment.    
    @Override 
    protected void onEnable() {
     
        //Called when the state is fully enabled, ie: is attached and         
        //isEnabled() is true or when the setEnabled() status changes after the         
        //state is attached.    
    }
    
    @Override 
    protected void onDisable() {
        
        //Called when the state was previously enabled but is now disabled         
        //either because setEnabled(false) was called or the state is being         
        //cleaned up.    
    } 
    
    @Override 
    public void update(float tpf) {
     
        //TODO: implement behavior during runtime    
     
    }
    @Override
    public void bind(Nifty nifty, Screen screen){
        this.nifty = nifty;
        this.screen = screen;
        System.out.printf("bind(%s)\n",screen.getScreenId());
        nifty.update();
        
    }
    @Override
    public void onStartScreen(){
        System.out.println("start screen");
    }
    @Override
    public void onEndScreen(){
        System.out.println("end screen");
    }
    public void quit(){
        app.stop();
    }
    public void play(){
        if(rootNifty != null)
            rootNifty.closePopup(screen.getScreenId());
    }
}
