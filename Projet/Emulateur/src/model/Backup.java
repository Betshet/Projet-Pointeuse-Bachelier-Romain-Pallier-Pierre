package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Backup implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4976591707062516330L;
	
	public static void makeBackup(Object savedObject,String fileName)
	{
		ObjectOutputStream oos = null;
		try 
		{
			final FileOutputStream fichier = new FileOutputStream(fileName);  //A CHANGER
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(savedObject);
			oos.flush();
		} 
		catch (final java.io.IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (oos != null) 
				{
					oos.flush();
					oos.close();
				}
			} 
			catch (final IOException ex) 
			{
				ex.printStackTrace();
			}
		}
	}
	
	public static Object readBackup(String fileName)
	{
		ObjectInputStream ois = null;
		Object TestBackup=null;
		try
		{
			final FileInputStream fichier = new FileInputStream(fileName); //A CHANGER
			ois = new ObjectInputStream(fichier);
			TestBackup=ois.readObject();
			
		}
		catch (final IOException ex) 
		{
			ex.printStackTrace();
		}
		catch(final ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				if (ois != null) 
				{
					ois.close();
				}
			} 
			catch (final IOException ex) 
			{
				ex.printStackTrace();
			}
		}
		return TestBackup;
	}
}
