package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class CustomJButton extends JButton {
    
    private static final int ARC_HEIGHT = 20;
    private static final int ARC_WIDTH = 20;
    private Color baseColor;
    private Color hoverColor;
    private Color clickColor;
    private Color currentColor;
    
    public CustomJButton(String label) {
        super(label);
        baseColor = new Color(7, 128, 171);
        hoverColor = baseColor.brighter(); // Establece el color de hover más claro
        clickColor = baseColor.darker(); // Establece el color de clic más oscuro
        currentColor = baseColor;
        
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(new Color(137, 211, 176));
        setBackground(baseColor);
        setFont(new Font("Tahoma", Font.BOLD, 60));
        setFocusPainted(false);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (currentColor != clickColor) {
                    currentColor = hoverColor;
                    repaint();
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (currentColor != clickColor) {
                    currentColor = baseColor;
                    repaint();
                }
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                currentColor = clickColor;
                repaint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                currentColor = e.getComponent().contains(e.getPoint()) ? hoverColor : baseColor;
                repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(currentColor);
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ARC_WIDTH, ARC_HEIGHT);
        g2.setColor(getForeground());
        super.paintComponent(g2);
        g2.dispose();
    }
}
