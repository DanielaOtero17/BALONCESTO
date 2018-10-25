package model;

public interface IFiba<T>{
	public void insertar(T o);
	public T getRaiz();
	public T search(String criterio,Double dato);
	public void Eliminar(T o);
	public int ObtenerBalance(T o);
	public Player rotacionIzq(T o);
	public Player rotacionDer(T o);
	public Player RotacionDobleIzq(T o);
	public Player RotacionDobleDer(T o);
}
