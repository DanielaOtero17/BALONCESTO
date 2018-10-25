package model;

public interface IFiba<T>{
	public void insert(T o);
	public T getRaiz();
	public T search(String criterio,Double dato);
	public void delete(double da);
	public int getBalance(T o);
	public Player rotationIzq(T o);
	public Player rotationDer(T o);
	public Player rotationDobleIzq(T o);
	public Player rotationDobleDer(T o);
}
