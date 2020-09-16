import java.util.List;
import java.util.NoSuchElementException;

public class SimpleLinkedList {
	
	public static String[] data;
	public static int size;
	
	public SimpleLinkedList() {
		data = new String[1];
		data[0] = "";
		size = 0;
	}
	
	public SimpleLinkedList(List<String> list) {
		data = new String[list.size()];
		for (int x = 0; x < list.size(); x++) {
			data[x] = list.get(x);
		}
		size = list.size();
	}
	
	public static void main(String[] args) {
		SimpleLinkedList test = new SimpleLinkedList();
		test.addFirst("Shit");
		System.out.println(test);
	}
	
	
	public void add (int index, String s) {
		String[] temp = new String[size+1];
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		} else {
			for (int x = 0; x <= size; x++) {
				if (x == index) {
					temp[x] = s;
				} else if (x < index) {
					temp[x] = data[x];
				} else {
					temp[x] = data[x-1];
				}
			}
			data = new String[size+1];
			data = temp;
			size++;
		}
	}
	
	public void addFirst (String s) {
		String[] temp = new String[size+1];
		temp[0] = s;
		for (int x = 0; x < size; x++) { 
			temp[x+1] = data[x];
		}
		data = new String[size+1];
		data = temp;
		size++;
	}
	
	public void addLast (String s) {
		String[] temp = new String[size+1];
		for(int x = 0; x < size; x++) {
			temp[x] = data[x];
		}
		temp[size] = s;
		data = new String[size+1];
		data = temp;
		size++;
	}
	
	public void clear () {
		data = new String[1]; 
		size = 0;
		data[0] = "";
		}
	
	public boolean contains (String s) {
		for(int x = 0; x < size; x++) {
			if (data[x] == s) {
				return true;
			}
		}
		return false;
	}
	
	public String get (int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return data[index];
	}
	
	public String getFirst () {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return data[0];
	}
	
	public String getLast () {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return data[size-1];
	}
	
	public int indexOf (String s) {
		for (int x = 0; x < size; x++) {
			if (data[x] == s) {
				return x;
			}
		}
		return -1;
	}
	
	public String remove (int index) {
		String[] temp = new String[size - 1];
		String removed = null;
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		} else {
			for (int x = 0; x < size; x++) {
				if (x == index) {
					removed = data[index];
				} else if (x < index) {
					temp[x] = data[x];
				} else {
					temp[x-1] = data[x];
				}
			}
			data = new String[size-1];
			data = temp;
			size--;
			return removed;
		}
	}
	
	public boolean remove (String s) {
		boolean removed = false;
		int index = -1;
		for(int x = 0; x < size; x++) {
			if (data[x] == s) {
				removed = true;
				index = x;
			}
		}
		if (removed == true) {
			String[] temp = new String[size-1];
			for (int x = 0; x < size; x++) {
				if (x < index) { 
					temp[x] = data[x];
				} else if (x >= index) {
					temp[x] = data[x+1];
				}
			}
			data = new String[size-1];
			data = temp;
			size--;
			return removed;
		} else {
			return removed;
		}
		
	}
	
	public String removeFirst () {
		String removed = data[0];
		String[] temp = new String[size-1];
		for (int x = 0; x < size-1; x++) {
			temp[x] = data[x+1];
		}
		size--;
		data = new String[size-1];
		data = temp;
		return removed;
	}
	
	public String removeLast () {
		String removed = data[size-1];
		String[] temp = new String[size-1];
		for (int x = 0; x < size-1; x++ ) {
			temp[x] = data[x];
		}
		size--;
		data = new String[size-1];
		data = temp;
		return removed;
	}
	
	public String set (int index, String s) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		String replaced = data[index];
		if (s == null) {
			s = "null";
		}
		data[index] = s;
		return replaced;
	}
	
	public int size () {
		return size;
	}
	
	public String toString () {
		String concat = "[";
		for (int x = 0; x < data.length; x++) {
			if (data[x] != null) {
				concat += data[x];
				concat += ", ";
			}
		}
		concat = concat.substring(0,concat.length()-2);
		return concat += "]";
	}
 }
 
