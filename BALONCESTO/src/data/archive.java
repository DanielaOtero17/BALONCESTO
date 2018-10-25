package data;

import java.util.*;

import Interfaz.PrincipalWindow;
import Model.Player;

import java.io.*;

public class archive {

	private File archive;
	private ArrayList<Player> players;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean start;
	private PrincipalWindow window;
	
	public archive(PrincipalWindow v)
	{
		window = v;
		players = new ArrayList<Player>();
		archive = new File("Data/archive.txt");
	
		if(archive.exists())
		{
			start = true;
			try {
				in = new ObjectInputStream(new FileInputStream(archive));
				players = (ArrayList<Player>)in.readObject();
				in.close();
					
			}catch (ClassNotFoundException | IOException e1) {
					System.out.print("Error leyend");
			}
		} else 
		{
			start = false;
		}
	}
	
	public void Save(Player j)
	{
		try {
			out = new ObjectOutputStream(new FileOutputStream(archive));
		
			if(window.getNew())
			{

				if(players == null)
				{
					players = new ArrayList<Player>();
					players.add(j);
					start = true;
				}
				else
				{
					players.add(j);
					refresh();
					start = true;
				}
			}
			else
			{
				players = window.guardarJuegoModificado();
			}
			out.writeObject(players);
			out.close();
		} catch (FileNotFoundException e) {
				System.out.print("Error A....");
		} catch (IOException e) {

			System.out.print("Error B....");
		}
	}
	
	
}
