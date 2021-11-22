
public class CapsLock {
    public static void main(String[] args){ 
        System.out.println ("Ingrese un string:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] s = str.toCharArray();
                 System.out.print ("Letras minusculas:");
        for (char s1:s) {
            if(Character.isLowerCase(s1))
            System.out.print(s1+" ");
        }
        System.out.println();
                 System.out.print ("Letras mayusculas:");
        for (char s2:s) {
            if (Character.isUpperCase(s2))
                System.out.print(s2+" ");
        }
        System.out.println();
    
     } 

}
