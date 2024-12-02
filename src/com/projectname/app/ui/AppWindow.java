package com.projectname.app.ui;

import com.projectname.app.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AppWindow extends JFrame
{
    private Toolbar TOOLBAR;
    protected static final Rectangle MENU_VIEW_PORT = new Rectangle(Toolbar.WIDTH + 1, AppUIManager.DECORATION_OFFSET,
            AppUIManager.SCREEN_WIDTH - (Toolbar.WIDTH) - 17, AppUIManager.SCREEN_HEIGHT);

    public AppWindow()
    {
        init();
        initComponents();

        setVisible(true);
    }

    private void init()
    {
        TOOLBAR = new Toolbar();

        getContentPane().setLayout(null);
        setSize(AppUIManager.SCREEN_WIDTH, AppUIManager.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("UNTITLED PROJECT");
        addWindowListener(new AppWindowListener());

        setResizable(false);
    }

    private void initComponents()
    {
        //Initialize ContentPane
        getContentPane().setBackground(new Color(34,34,34));
        getContentPane().add(TOOLBAR);

        displayMenu(new HomeMenu());
    }

    protected void displayMenu(AppMenu menu)
    {
        Container appMenu = (Container) menu;
        appMenu.setBounds(MENU_VIEW_PORT);
        getContentPane().add(appMenu);
    }

    private static class AppWindowListener implements WindowListener
    {
        @Override
        public void windowOpened(WindowEvent e) {}

        @Override
        public void windowClosing(WindowEvent e) {Application.terminate();}

        @Override
        public void windowClosed(WindowEvent e) {}

        @Override
        public void windowIconified(WindowEvent e) {}

        @Override
        public void windowDeiconified(WindowEvent e) {}

        @Override
        public void windowActivated(WindowEvent e) {}

        @Override
        public void windowDeactivated(WindowEvent e) {}
    }
}
