package utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CustomJPasswordTextBox extends JPasswordField {
    
    private Color underlineColor; // Color del subrayado
    private final String placeholder = "Contraseña";
    private boolean showingPlaceholder = true;

    public CustomJPasswordTextBox(int columns) {
        super(columns);
        underlineColor = new Color(134, 188, 198); // Color del subrayado
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Ajustar según necesidad
        setBackground(new Color(1, 23, 47)); // Establece el color de fondo
        setForeground(new Color(134, 188, 198)); // Color del texto predefinido
        setCaretColor(new Color(134, 188, 198)); // Establece el color del cursor (caret)
        setEchoChar((char) 0); // Eliminar el carácter de eco para mostrar el placeholder
        setText(placeholder); // Establece el texto predefinido
        
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setEchoChar('•'); // Establece el carácter de eco cuando el usuario empieza a escribir
                if (new String(getPassword()).equals(placeholder)) {
                    clear();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (new String(getPassword()).isEmpty()) {
                    showingPlaceholder = true;
                    setText(placeholder);
                    setForeground(Color.GRAY);
                    setEchoChar((char) 0); // Eliminar el carácter de eco para mostrar el placeholder
                }
            }
        });

        getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                showingPlaceholder = false;
            }

            public void removeUpdate(DocumentEvent e) {
                if (getPassword().length == 0) {
                    showingPlaceholder = true;
                }
            }

            public void changedUpdate(DocumentEvent e) {
                showingPlaceholder = false;
            }
        });
    }

    private void clear() {
        showingPlaceholder = false;
        setForeground(new Color(134, 188, 198));
        setText("");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(underlineColor);
        g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}

