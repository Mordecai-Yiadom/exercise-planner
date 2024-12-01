package com.projectname.app.ui;

import javax.swing.*;
import java.awt.*;

public class HomeMenu extends JPanel implements AppMenu
{
    protected HomeMenu()
    {
        init();
        initComponents();
    }

    private void init()
    {
        setBackground(Color.RED);
        //setLayout(new SpringLayout());

    }

    private void initComponents()
    {
        JLabel label = new JLabel("Home Screen");
        label.setFont(new Font(AppUIManager.FONT, Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        add(label);
    }
}
