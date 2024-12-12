package com.projectname.app.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * Contains method(s) to create a button for any UI usage
 * Buttons can be created using a Type or can be created by passing attributes into it
 */
public class ButtonFactory
{
    protected JButton createIconButton(SpecificType type)
    {
        //Specific UIButton setup
        JButton button = new JButton();
        button.setUI(new BasicButtonUI());
        button.setFocusable(false);
        button.setBorderPainted(false);

        //Apply type specific attributes
        button.setIcon(type.idleIcon);
        button.setPressedIcon(type.pressedIcon);
        button.setBackground(type.idleColor);

        button.addMouseListener(new GenericButtonMouseListener(type.idleColor, type.hoverColor));
        button.setSize(type.width, type.height);

        return button;
    }

    protected JButton createIconButton(GenericType type, String idleIconName, String pressedIconName)
    {
        //Generic UIButton setup
        JButton button = new JButton();
        button.setUI(new BasicButtonUI());
        button.setFocusable(false);
        button.setBorderPainted(false);

        //Apply type specific attributes

        button.setIcon(new ImageIcon(getClass().getResource(AppUIManager.IMAGE_PATH + idleIconName)));

        if(pressedIconName == null)
            button.setPressedIcon(button.getIcon());
        else
            button.setPressedIcon(new ImageIcon(getClass().getResource(AppUIManager.IMAGE_PATH + pressedIconName)));

        button.setBackground(type.idleColor);
        button.addMouseListener(new GenericButtonMouseListener(type.idleColor, type.hoverColor));
        button.setSize(type.width, type.height);

        return button;
    }

    protected JButton createTextButton(GenericType type, String text)
    {
        //Generic UIButton setup
        JButton button = new JButton(text);
        button.setUI(new BasicButtonUI());
        button.setFocusable(false);
        button.setBorderPainted(false);

        button.setBackground(type.idleColor);
        button.addMouseListener(new GenericButtonMouseListener(type.idleColor, type.hoverColor));
        button.setSize(type.width, type.height);

        button.setForeground(type.textColor);
        button.setFont(type.font);

        return button;
    }


    protected enum SpecificType implements ButtonType
    {
        ;
        private ImageIcon idleIcon, pressedIcon;
        private String idleIconName, pressedIconName;
        private Color hoverColor, idleColor;
        private int width, height;

        SpecificType(String idleIconName, String pressedIconName,
                     Color idleColor, Color hoverColor, int width, int height)
        {
            this.width = width;
            this.height = height;

            this.idleIconName = idleIconName;
            idleIcon = new ImageIcon(idleIconName);

            if(pressedIconName == null)
            {
                this.pressedIconName = idleIconName;
                pressedIcon = new ImageIcon(getClass().getResource(AppUIManager.IMAGE_PATH + idleIconName));
            }
            else
            {
                this.pressedIconName = pressedIconName;
                pressedIcon = new ImageIcon(getClass().getResource(AppUIManager.IMAGE_PATH + pressedIconName));
            }

            this.idleColor = idleColor;

            if(hoverColor == null) this.hoverColor = idleColor;
            else this.hoverColor = hoverColor;
        }

        public ImageIcon getIdleIcon() {return idleIcon;}
        public ImageIcon getPressedIcon() {return pressedIcon;}
    }

    protected enum GenericType implements ButtonType
    {
        TOOLBAR_BUTTON(new Color(24,24,24), new Color(44,44,54),
                null,50, 50, null),

        HOME_MENU_ARROW_BUTTON(AppUIManager.MENU_BACKGROUND_COLOR, new Color(74,74,84),
                null,50, 50, null),

        DATABASE_EDIT_EDIT_HOME_MENU_BUTTON(new Color(24, 24, 34), new Color(34, 34, 54),
                Color.WHITE,50,50, new Font(AppUIManager.FONT, Font.BOLD, 30)),

        DATABASE_EDIT_EXERCISE_MENU_CATEGORY_BUTTON(Color.RED, Color.BLUE, Color.WHITE,
                50,20, new Font(AppUIManager.FONT, Font.BOLD, 20)),

        DATABASE_ADD_BUTTON(AppUIManager.MENU_BACKGROUND_COLOR, new Color(42, 158, 6),
                Color.WHITE, 50, 50, null),

        DATABASE_REMOVE_BUTTON(AppUIManager.MENU_BACKGROUND_COLOR, Color.RED,
                Color.WHITE, 50,50,null);

        private Color hoverColor, idleColor, textColor;
        private int width, height;
        private Font font;

        GenericType(Color idleColor, Color hoverColor, Color textColor, int width, int height, Font font)
        {
            this.width = width;
            this.height = height;

            this.idleColor = idleColor;
            this.textColor = textColor;

            if(hoverColor == null) this.hoverColor = idleColor;
            else this.hoverColor = hoverColor;

            this.font = font;

        }
    }
    //TODO Implement (maybe?)
    protected static Color getHoverOverColor(Color idleColor, int colorDifference)
    {
        return null;
    }

    private class GenericButtonMouseListener implements MouseListener
    {
        private Color IDLE_COLOR, HOVER_COLOR;

        private GenericButtonMouseListener(Color idleColor, Color hoverColor)
        {
            IDLE_COLOR = idleColor;
            HOVER_COLOR = hoverColor;
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBackground(HOVER_COLOR);
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            JButton button = (JButton) e.getSource();
            button.setBackground(IDLE_COLOR);
        }
    }
}
