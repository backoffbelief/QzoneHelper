package com.kael.login.qzone;

import javax.swing.SwingUtilities;

import com.kael.login.qzone.gui.Main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	
    	SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Main();
			}
		});
    }
}
