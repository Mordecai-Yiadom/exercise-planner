package com.projectname.app.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Toolbar extends JPanel
{
    private JButton HOME_BUTTON, SETTINGS_BUTTON;

    private static final Color BACKGROUND_COLOR = new Color(24,24,24);
    private static final Color BUTTON_HOVER_COLOR = new Color(44, 44, 44);
    private static final int WIDTH = 90;

    protected Toolbar()
    {
        init();
        initComponents();
    }

    private void init()
    {
        setLayout(null);
        setBackground(BACKGROUND_COLOR);
        setSize(WIDTH, AppUIManager.HEIGHT);
    }

    private void initComponents()
    {
        HOME_BUTTON = createToolbarButton(ButtonType.HOME);
        this.add(HOME_BUTTON);

        SETTINGS_BUTTON = createToolbarButton(ButtonType.SETTINGS);
        this.add(SETTINGS_BUTTON);
    }

    private JButton createToolbarButton(ButtonType type)
    {
        JButton button = new JButton();
        button.setFocusable(false);
        button.setUI(new BasicButtonUI());
        button.setBackground(BACKGROUND_COLOR);
        button.setBorderPainted(false);

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBackground(BUTTON_HOVER_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBackground(BACKGROUND_COLOR);
            }
        });

        button.setBounds(type.xOffset, type.yOffset, type.width, type.height);

        ImageIcon imageIcon = new ImageIcon("C:\\Workspace\\School\\Data Structures Final Project\\assets\\images\\ui\\home.png");
        button.setIcon(imageIcon);

        return button;
    }

    private enum ButtonType
    {
        HOME(20,20, 50, 50),
        SETTINGS(20,90, 50, 50);

        protected int xOffset, yOffset, width, height;

        ButtonType(int xOffset, int yOffset, int width, int height)
        {
            this.xOffset = xOffset + AppUIManager.DECORATION_OFFSET;
            this.yOffset = yOffset + AppUIManager.DECORATION_OFFSET;
            this.width = width;
            this.height = height;
        }
    }
}
