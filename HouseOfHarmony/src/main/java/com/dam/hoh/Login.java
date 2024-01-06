package com.dam.hoh;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import panels.CustomTransparentJpanel;

import java.awt.geom.RoundRectangle2D;
import utils.CustomTextBox;
import utils.CustomJButton;
import utils.CustomJPasswordTextBox;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int mouseX, mouseY;

    public Login() {
        setUndecorated(true);
        setSize(500, 700);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(1, 23, 47));

        // Panel para botones personalizados
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(0, 0, 500, 30);
        getContentPane().add(buttonPanel);
        
        // Colores
        Color normalTextColor = new Color(137, 211, 176); // Gris blanquecino para el texto
        Color hoverTextColor = new Color(167,225,198); // Blanco para el texto en hover
      //TODO: Encapsular boton de minimizar con parametros
        // Botón de minimizar
        JButton minimizeButton = new JButton("_");
        minimizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setState(Frame.ICONIFIED);
            }
        });

        // Configuraciones iniciales similares a closeButton
        minimizeButton.setFocusPainted(false);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setOpaque(true);
        minimizeButton.setBackground(new Color(1, 23, 47)); // Color de fondo constante
        minimizeButton.setForeground(normalTextColor); // Utilizando el mismo normalTextColor
        Font normalFontMinimize = minimizeButton.getFont();
        Font boldFontMinimize = normalFontMinimize.deriveFont(Font.BOLD);

        // MouseListener para cambiar el color y estilo del texto en hover
        minimizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                minimizeButton.setForeground(hoverTextColor); // Utilizando el mismo hoverTextColor
                minimizeButton.setFont(boldFontMinimize);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimizeButton.setForeground(normalTextColor);
                minimizeButton.setFont(normalFontMinimize);
            }
        });
        buttonPanel.add(minimizeButton);
        
        //TODO Encapsular boton de cierre con parametros
        JButton closeButton = new JButton("X");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Configuración inicial del botón
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setOpaque(true);
        closeButton.setBackground(new Color(1, 23, 47)); // Color de fondo constante
        closeButton.setForeground(normalTextColor);
        Font normalFont = closeButton.getFont(); // Fuente normal
        Font boldFont = normalFont.deriveFont(Font.BOLD); // Fuente negrita

        // MouseListener para cambiar el color del texto en hover
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setForeground(hoverTextColor);
                closeButton.setFont(boldFont); // Cambiar a negrita
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	closeButton.setForeground(normalTextColor);
                closeButton.setFont(normalFont); // Volver a la fuente normal
            }
        });
        buttonPanel.add(closeButton);
        
        int[] transparentPanelColor = {1,23,47};
        
        CustomTransparentJpanel customTransparentJpanelMain = new CustomTransparentJpanel();
        customTransparentJpanelMain.setBounds(59, 88, 377, 510);
        customTransparentJpanelMain.setBackground(new Color(transparentPanelColor[0], transparentPanelColor[1], transparentPanelColor[2]));
        getContentPane().add(customTransparentJpanelMain);
        customTransparentJpanelMain.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/resources/MainLogoRs190x190.jpg")));
        lblNewLabel.setBounds(94, 43, 190, 190);
        customTransparentJpanelMain.add(lblNewLabel);
        
        CustomTextBox cstmtxtbxUsuario = new CustomTextBox(0);
        cstmtxtbxUsuario.setText("Usuario");
        cstmtxtbxUsuario.setToolTipText("Usuario");
        cstmtxtbxUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
        cstmtxtbxUsuario.setBounds(56, 244, 274, 24);
        customTransparentJpanelMain.add(cstmtxtbxUsuario);
        
        CustomJButton customJButton = new CustomJButton("Login");
        customJButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        customJButton.setBounds(130, 350, 131, 45);
        customTransparentJpanelMain.add(customJButton);
        
        CustomJPasswordTextBox customJPasswordTextBox = new CustomJPasswordTextBox(0);
        customJPasswordTextBox.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
        customJPasswordTextBox.setBounds(56, 290, 274, 24);
        customTransparentJpanelMain.add(customJPasswordTextBox);
        
        // Mover ventana
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
            }
        });

        // Define la forma redondeada
        RoundRectangle2D shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30);
        setShape(shape);
        
        
  
    }

    private void setBackground(int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
