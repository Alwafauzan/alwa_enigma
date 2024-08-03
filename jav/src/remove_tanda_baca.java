public class remove_tanda_baca {
    public static void main(String[] args) {
        String foo = "aku- lala;t%^";
        System.out.println(foo.replaceAll("[^a-zA-Z0-9]", ""));
 
    }
}