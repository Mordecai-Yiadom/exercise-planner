package com.projectname.app.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/*
 * Contains method(s) to create a JLabel for any UI usage
 * JLabels can be created using a Type or can be created by passing attributes into it
 */
public class LabelFactory
{
    protected JLabel createIconLabel(SpecificType type)
    {
        JLabel label = new JLabel();
        label.setBackground(type.backgroundColor);
        label.setForeground(type.foregroundColor);
        label.setOpaque(true);
        label.setIcon(type.icon);
        label.setSize(type.width, type.height);
        label.setBorder(type.border);

        return label;
    }

    protected JLabel createIconLabel(GenericType type, String iconName)
    {
        JLabel label = new JLabel();
        label.setBackground(type.backgroundColor);
        label.setForeground(type.foregroundColor);
        label.setOpaque(true);
        label.setIcon(new ImageIcon(iconName));
        label.setSize(type.width, type.height);
        label.setBorder(type.border);

        return label;
    }

    protected JLabel createTextLabel(SpecificType type, String text)
    {
        JLabel label = new JLabel();
        label.setBackground(type.backgroundColor);
        label.setForeground(type.foregroundColor);
        label.setFont(type.font);
        label.setOpaque(true);
        label.setSize(type.width, type.height);
        label.setText(text);
        label.setBorder(type.border);

        return label;
    }

    protected JLabel createTextLabel(GenericType type, String text)
    {
        JLabel label = new JLabel();
        label.setBackground(type.backgroundColor);
        label.setForeground(type.foregroundColor);
        label.setFont(type.font);
        label.setOpaque(true);
        label.setSize(type.width, type.height);
        label.setText(text);
        label.setBorder(type.border);

        return label;
    }



    protected enum SpecificType implements LabelType
    {
        ;
        private ImageIcon icon;
        private String iconName;
        private Color backgroundColor, foregroundColor;
        private Font font;
        private int width, height;
        private Border border;

        SpecificType(Border border, String iconName, Color backgroundColor, Color foregroundColor, int width, int height, Font font)
        {
            this.iconName = iconName;
            icon = new ImageIcon(iconName);

            this.backgroundColor = backgroundColor;
            this.foregroundColor = foregroundColor;
            this.width = width;
            this.height = height;
            this.font = font;
            this.border = border;
        }
    }

    protected enum GenericType implements LabelType
    {
        WORKOUT_PLAN_ENTRY_DURATION_LABEL(BorderFactory.createLineBorder(Color.BLACK,5,false),
                Color.RED, Color.WHITE, 30,30, new Font(AppUIManager.FONT, Font.BOLD, 50)),
        WORKOUT_PLAN_ENTRY_NAME_LABEL(BorderFactory.createLineBorder(Color.BLACK,5,false),
                Color.BLUE, Color.WHITE,100, 30, new Font(AppUIManager.FONT, Font.BOLD, 50));

        private Color backgroundColor, foregroundColor;
        private Font font;
        private int width, height;
        private Border border;

        GenericType(Border border, Color backgroundColor, Color foregroundColor, int width, int height, Font font)
        {
            this.width = width;
            this.height = height;
            this.backgroundColor = backgroundColor;
            this.foregroundColor = foregroundColor;
            this.font = font;
            this.border = border;
        }
    }

}
