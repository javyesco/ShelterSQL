/**
 * Filename: theRefuge
 *
 *	Authors: Javier Escobar
 *
 *	Description: This code connects to a SQL Database which saves 
 *				 the information of a pet a user inputs.

 *	Javier Escobar <javyesco@hotmail.com>
 *
 *	History:
 *		10/17/19 - File completed
 */

package edu.pupr.RefugioSQL;

public class theRefuge {
	public static void main(String [] args) {
		new theRefugeDB().setVisible(true);
	}
}
