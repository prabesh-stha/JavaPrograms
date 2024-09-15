package lab2;

import java.awt.*;
import javax.swing.*;

public class MenusJava extends JFrame {
	public MenusJava(){  
        setTitle("Menu and MenuItem Example");  
        MenuBar menubar=new MenuBar();  
        Menu menu=new Menu("Menu");  
        Menu submenu=new Menu("Sub Menu");  
        MenuItem i1=new MenuItem("Item 1");  
        MenuItem i2=new MenuItem("Item 2");  
        MenuItem i3=new MenuItem("Item 3");  
        MenuItem i4=new MenuItem("Item 4");  
        MenuItem i5=new MenuItem("Item 5");  
        menu.add(i1);  
        menu.add(i2);  
        menu.add(i3);  
        submenu.add(i4);  
        submenu.add(i5);  
        menu.add(submenu);  
        menubar.add(menu);  
        setMenuBar(menubar);  
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
}  
public static void main(String args[])  
{  
new MenusJava();  
} 
}
