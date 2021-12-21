import java.util.*;

public class groupAnagrams {
	public  static List<List<String>> groupAnagrams(String[] strs){
		if(strs.length==0)  // longitud lista palabras
			return new ArrayList();
		Map<String,List> listado = new HashMap<String,List>(); // usando HashMap para nuestra lista
		for(String str :strs){
			char[] lista = str.toCharArray();
			Arrays.sort(lista); // ordenamiento mediante sort
			String cadena = String.valueOf(lista);
			if(!listado.containsKey(cadena))
				listado.put(cadena,new ArrayList());
			listado.get(cadena).add(str);
		}
		return new ArrayList(listado.values());
	}

	public static void main(String[] args) {
		String[] palabras = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> resultado = groupAnagrams(palabras);
		for(List listado :resultado){
			System.out.print(listado.toString());
			System.out.println();
		}
	}
}
