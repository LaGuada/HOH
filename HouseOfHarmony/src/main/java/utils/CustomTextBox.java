package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomTextBox extends JTextField {
    private Color underlineColor; // Color del subrayado
    private final String placeholder = "Usuario"; //TODO pasar placeholder por parametro de constructor!!
    private boolean showingPlaceholder = true;
    private Color normalTextColor = new Color(134, 188, 198); // Color normal del texto
    private Color hoverTextColor = new Color(170, 225, 235); // Color más claro para el hover

    public CustomTextBox(int columns) {
        super(columns);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Ajustar según necesidad
        setBackground(new Color(1, 23, 47)); // Establece el color de fondo
        setForeground(normalTextColor); // Establece el color normal del texto
        setCaretColor(normalTextColor); // Establece el color del cursor (caret)
        underlineColor = normalTextColor; // Establece el color del subrayado
        // TODO Se ha intentado dar efecto hover pero no se nota mucho... probar otro
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
                    setForeground(normalTextColor); // Color del texto cuando el usuario escribe
                    showingPlaceholder = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(placeholder);
                    setForeground(Color.GRAY); // Color del texto predefinido
                    showingPlaceholder = true;
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!showingPlaceholder) {
                    setForeground(hoverTextColor); // Cambiar a color hover
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!showingPlaceholder) {
                    setForeground(normalTextColor); // Volver al color normal
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(underlineColor);
        g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}
