package model;

import java.util.ArrayList;

public class MainSponsor {

	// ArrayList
	private ArrayList<ArrayListContainer> sponsors;

	// List
	private ListContainer firstList;

	// ABB
	private AbbContainer rootAbb;

	private ArrayList<Long> base;

	public MainSponsor() {
		sponsors = new ArrayList<ArrayListContainer>();
		base = new ArrayList<Long>();
	}

	public ListContainer getFirstList() {
		return firstList;
	}

	public void setFirstList(ListContainer firstList) {
		this.firstList = firstList;
	}

	public AbbContainer getRootAbb() {
		return rootAbb;
	}

	public void setRootAbb(AbbContainer rootAbb) {
		this.rootAbb = rootAbb;
	}

	public ArrayList<ArrayListContainer> getSponsors() {
		return sponsors;
	}

	public void setSponsors(ArrayList<ArrayListContainer> sponsors) {
		this.sponsors = sponsors;
	}

	public void aleatorio(Long n) {
		long cont = 1;
		while (n != 0) {
			base.add(cont);
			cont++;
			n--;
		}
	}
	
	public void addArrayRAle() {
		for (int i = 0; i < base.size(); i++) {
			addArrayR(base.get(i));
		}
	}
	
	public void searchArrayIAle() {
		for (int i = 0; i < base.size(); i++) {
			searchArrayI(base.get(i));
		}
	}
	public void searchArrayRAle() {
		for (int i = 0; i < base.size(); i++) {
			searchArrayR(base.get(i),0);
		}
	}
	public void delectArrayIAle() {
		for (int i = 0; i < base.size(); i++) {
			deletArryI(base.get(i));
		}
	}
	
	public void delectArrayRAle() {
		for (int i = 0; i < base.size(); i++) {
			deletArryR(base.get(i),0);
		}
	}
	
	public void addListIAle() {
		for (int i = 0; i < base.size(); i++) {
			addListI(base.get(i));
		}
	}

	public void addListRAle() {
		for (int i = 0; i < base.size(); i++) {
			addListAR(base.get(i));
		}
	}

	public void searchListIAle() {
		for (int i = 0; i < base.size(); i++) {
			searchListI(base.get(i));
		}
	}

	public void searchListRAle() {
		for (int i = 0; i < base.size(); i++) {
			searchListAR(base.get(i));
		}
	}
	public void delectListIAle() {
		for (int i = 0; i < base.size(); i++) {
			deletListI(base.get(i));
		}
	}
	
	public void delectListRAle() {
		for (int i = 0; i < base.size(); i++) {
			deletListAR(base.get(i));
		}
	}

//	PARA TODOS:
//		·        En la estructura de datos de ArrayList no aplica lo de aregar iterativo ni agregar recursivo, solo hagan el .add().
//		·        En la estructura de datos de ArrayList al eliminar, no está permitido usar el .remove(). Deben de realizar un recorrido secuencial.
//		·        La estructura de listas enlazadas puede ser doble pero no circular y sin puntero hacia el último elemento.
	// -------------------------------ArrayList------------------------------ArrayList----------------------------ArrayList---------------------------------------------

	// Add Recursivo
	public void addArrayR(long n) {
		sponsors.add(new ArrayListContainer(n));
	}

	// Search Iterativo
	public boolean searchArrayI(long nn) {
		boolean n = false;
		for (int i = 0; i < sponsors.size() && !n; i++) {
			if (sponsors.get(i).getN() == nn) {
				n = true;
			}
		}
		return n;
	}

	// Search Recursivo
	public boolean searchArrayR(long nn, int cont) {
		if (cont >= sponsors.size()) {
			return false;
		} else if (sponsors.get(cont).getN() == nn) {
			return true;
		} else {
			return searchArrayR(nn, cont + 1);
		}
	}

//	lo mismo aplica para el insertar y el eliminar
	// Delete Iterativo
	public void deletArryI(long nn) {
		boolean mmm = false;
		for (int i = 0; i < sponsors.size() && !mmm; i++) {
			if (sponsors.get(i).getN() == nn) {
				sponsors.remove(sponsors.get(i).getN());
				mmm = true;
			}
		}
	}

	// Delete Recursivo
	public int deletArryR(long nn, int cont) {
		if (cont >= sponsors.size()) {
			return -1;
		} else if (sponsors.get(cont).getN() == nn) {
			sponsors.remove(cont);
			return 0;
		} else {
			return deletArryR(nn, cont + 1);
		}
	}

	// ---------------------------------LinkedList--------------------------------LinkedList-------------------------------------LinkedList-------------------------------------

	// Add Iterativo
	public void addListI(long n) {
		ListContainer current = firstList;
		ListContainer h = new ListContainer(n);
		if (firstList != null) {
			while (current != null) {
				current = current.getNext();
			}
			current.setNext(h);
			h.setPrev(current);
		} else {
			firstList = h;
		}
	}

	// Add Recursivo
	public void addListAR(long n) {
		ListContainer h = new ListContainer(n);
		ListContainer current = firstList;
		if (firstList != null) {
			addListBR(h, current);
		} else {
			firstList = h;
		}
	}

	private void addListBR(ListContainer h, ListContainer current) {
		if (current.getNext() == null) {
			current.setNext(h);
			h.setPrev(current);
		} else {
			addListBR(h, current.getNext());
		}
	}

	// Search Iterativo
	public boolean searchListI(long nn) {
		ListContainer current = firstList;
		boolean n = false;
		while (current != null && !(current.getNext().getN() == nn)) {
			current.getNext();
		}
		if (current.getN() == nn) {
			n = true;
		}
		return n;
	}

	// Search Recursivo
	public boolean searchListAR(long nn) {
		boolean n = false;
		ListContainer current = firstList;
		if (firstList != null) {
			n = searchListBR(nn, current);
		}
		return n;
	}

	public boolean searchListBR(long nn, ListContainer current) {
		boolean n = false;
		if (current.getN() == nn) {
			n = true;
		} else if (!n && current.getNext() != null) {
			n = searchListBR(nn, current.getNext());
		}
		return n;
	}

	// Delete Iterativo
	public void deletListI(long nn) {
		ListContainer current = firstList;
		if (firstList != null) {
			while (current != null && !(current.getN() == nn)) {
				current = current.getNext();
			}
			if (current == firstList && current.getN() == nn) {
				firstList = null;
			} else if (current != null && current.getN() == nn) {
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
			}
		}
	}

	// Delete Recursivo
	public void deletListAR(long nn) {
		ListContainer current = firstList;
		if (firstList != null) {
			deletListBR(nn, current);
		}
	}

	public void deletListBR(long nn, ListContainer current) {
		if (current.getN() == nn) {
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(current.getPrev());
		} else if (current.getNext() != null) {
			deletListBR(nn, current.getNext());
		}
	}

	// ------------------------------------------ABB-----------------------ABB-----------------ABB----------------------------------------------------------

	// Add Iterativo
	public void addAbbI(long n) {
		AbbContainer root = rootAbb;
		AbbContainer h = new AbbContainer(n);
		boolean oe = false;
		if (root != null) {
			if (root.getN() < n) {
				boolean oa = false;
				root = root.getRight();
				while (!oa) {
					if (root.getN() < h.getN() && root.getRight() == null) {
						root.setRight(h);
						oa = true;
					} else if (root.getN() < h.getN() && root.getRight() != null) {
						root = root.getRight();
					} else if (root.getN() > h.getN() && root.getLeft() == null) {
						root.setLeft(h);
						oa = true;
					} else if (root.getN() > h.getN() && root.getLeft() != null) {
						root = root.getLeft();
					}
				}
			} else if (root.getN() > n) {
				boolean oa = false;
				root = root.getLeft();
				while (!oa) {
					if (root.getN() < h.getN() && root.getRight() == null) {
						root.setRight(h);
						oa = true;
					} else if (root.getN() < h.getN() && root.getRight() != null) {
						root = root.getRight();
					} else if (root.getN() > h.getN() && root.getLeft() == null) {
						root.setLeft(h);
						oa = true;
					} else if (root.getN() > h.getN() && root.getLeft() != null) {
						root = root.getLeft();
					}
				}
			}

		} else {
			rootAbb = h;
		}
	}

	// Add Recursivo
	public void addAbbAR(long n) {
		AbbContainer root = rootAbb;
		AbbContainer h = new AbbContainer(n);
		if (rootAbb != null) {
			addAbbBR(h, root);
		} else {
			rootAbb = h;
		}
	}

	private void addAbbBR(AbbContainer h, AbbContainer root) {
		if (root.getN() < h.getN() && root.getRight() == null) {
			root.setRight(h);
		} else if (root.getN() < h.getN() && root.getRight() != null) {
			root = root.getRight();
			addAbbBR(h, root);
		} else if (root.getN() > h.getN() && root.getLeft() == null) {
			root.setLeft(h);
		} else if (root.getN() > h.getN() && root.getLeft() != null) {
			root = root.getLeft();
			addAbbBR(h, root);
		}
	}

	// Search Iterativo
	public long searchAbbI(long nn) {
		long n = 0;
		for (int i = 0; i < sponsors.size(); i++) {
			if (sponsors.get(i).getN() == nn) {
				n = nn;
			}
		}
		return n;
	}

	// Search Recursivo
	public long searchAbbAR(long nn) {
		long n = 0;
		for (int i = 0; i < sponsors.size(); i++) {
			if (sponsors.get(i).getN() == nn) {
				n = nn;
			}
		}
		return n;
	}

	public long searchAbbBR(long nn) {
		long n = 0;

		return n;
	}

	// Delete Iterativo
	public void deletAbbI(long nn) {
		boolean mmm = false;
		for (int i = 0; i < sponsors.size() && !mmm; i++) {
			if (sponsors.get(i).getN() == nn) {
				sponsors.remove(sponsors.get(i).getN());
				mmm = true;
			}
		}
	}

	// Delete Recursivo
	public void deletAbbAR(long nn) {
		boolean mmm = false;
		for (int i = 0; i < sponsors.size() && !mmm; i++) {
			if (sponsors.get(i).getN() == nn) {
				sponsors.remove(sponsors.get(i).getN());
				mmm = true;
			}
		}
	}

	public void deletAbbBR(long nn) {
		boolean mmm = false;

	}
}
