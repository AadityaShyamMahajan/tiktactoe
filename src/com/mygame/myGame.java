
package com.mygame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.SwingConstants;



public class myGame extends JFrame {
    
    JLabel heading,clockLabel;
    Font font= new Font("", Font.BOLD,40);
    JPanel mainPanel;
    
    JButton []btns =new JButton[9];
    myGame() {
        System.out.println("Creating instance of a game");
        setTitle("my tic-tac tole game..");
        setSize(850,850);
        ImageIcon icon= new ImageIcon("src/img/tictac.jpg");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        setVisible(true);
        
         
      
                
    }
    private void createGUI(){
         this.getContentPane().setBackground(Color.decode("#2196f3"));
         this.setLayout(new BorderLayout());
        
        //north heading..
        heading =new JLabel("Tic Tac Toe");
        heading.setFont(font);
        heading.setHorizontalAlignment(swingConstants.CENTER);
        heading.setForeground(Color.white);
        
        this.add(heading,BorderLayout.NORTH);
        
        //creting ovbject of JLabel for clock
        
        clockLabel = new JLabel("clock");
        clockLabel.setForeground(Color.white);
        
        clockLabel.setFont(font);
        clockLabel.setHorizontalAlignment(swingConstants.CENTER);
        this.add(clockLabel,BorderLayout.SOUTH);
        
        
         Thread t = new Thread(){
            @Override
            public void run(){
                try
                {
                    while (true){
                        String datetime = new Date().toLocaleString();
                        
                        
                        clockLabel.setText(datetime);
                        Thread.sleep(1000);
                    }
                    
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            
            
            
        };
         t.start();
         
         //panel
         
         mainPanel = new JPanel();
         mainPanel.setLayout(new GridLayout(3, 3));
         
         for(int i=1 ; i<=9;i++){
             JButton btn = new JButton();
             btn.setIcon(new ImageIcon("src/img/0.png"));
             btn.setBackground(Color.decode("#90caf9"));
             btn.setFont(font);
             mainPanel.add(btn);
             btns[i-1]=btn;
         }
         this.add(mainPanel,BorderLayout.CENTER);
         
        
    }
}
