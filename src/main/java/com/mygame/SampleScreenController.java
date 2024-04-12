package com.mygame;
import com.jme3.app.Application;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

class SampleScreenController implements ScreenController  {
    final private Application app;
    public SampleScreenController(Application app){
        this.app = app;
    }
    @Override
    public void bind(Nifty nifty, Screen screen){
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
    public void printTitle(){
        System.out.print(app.toString());
        
    }
}
