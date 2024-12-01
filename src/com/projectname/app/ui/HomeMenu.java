package com.projectname.app.ui;

import javax.swing.*;
import java.awt.*;

public class HomeMenu extends JPanel implements AppMenu
{

    //Instance Variables
    private JButton FORWARD_BUTTON, BACKWARD_BUTTON;

    protected HomeMenu()
    {
        init();
        initComponents();
    }

    private void init()
    {
        setBackground(AppUIManager.MENU_BACKGROUND_COLOR);
        setLayout(null);

    }

    private void initComponents()
    {
        ButtonFactory factory = new ButtonFactory();
        JLabel label = new JLabel("Home Screen");
        label.setFont(new Font(AppUIManager.FONT, Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        add(label);

        BACKWARD_BUTTON = factory.createIconButton(ButtonFactory.GenericType.HOME_MENU_ARROW_BUTTON,
                "angle-circle-left.png",null);
        add(BACKWARD_BUTTON);
        BACKWARD_BUTTON.setBounds(0, (AppUIManager.SCREEN_HEIGHT/2) - 25,
                BACKWARD_BUTTON.getWidth(), BACKWARD_BUTTON.getHeight());

        FORWARD_BUTTON = factory.createIconButton(ButtonFactory.GenericType.HOME_MENU_ARROW_BUTTON,
                "angle-circle-right.png",null);
        add(FORWARD_BUTTON);
        FORWARD_BUTTON.setBounds((int)AppWindow.MENU_VIEW_PORT.getWidth() - 50, (AppUIManager.SCREEN_HEIGHT/2) - 25,
                FORWARD_BUTTON.getWidth(), FORWARD_BUTTON.getHeight());
    }
}
