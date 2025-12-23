package org.stockinventorydemo.stockinventorydemo.utils;
import java.awt.Dimension;
import java.awt.Toolkit;


public class ScreenResolutionHandler {
    Toolkit toolkit;
    Dimension screenSize;

    public ScreenResolutionHandler(){
        toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();
    }

    public int getScreenWidth(){
            return (int) screenSize.getWidth();
        }

        public int getScreenHeight(){
            return (int) screenSize.getHeight();
    }
}
