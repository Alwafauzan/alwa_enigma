public class NestedForEach {
    public static void main(String[] args) {
        String[][] nasabah = {
            {"b", "b@b", "088888", "jl.b", "aktif"},
            {"a", "a@a", "088888", "jl.a", "aktif"},
            {"c", "c@c", "088888", "jl.c", "aktif"}
        };
        String[][] duit = {
            {"a","1000_000"},
            {"c","3000_000"},
            {"b","2000_000"}
        };
    
        System.out.println("NASABAHHHHH");
        for (int i = 0; i < nasabah.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nasabah[i].length; j++) {
                sb.append(nasabah[i][j]).append(" ");
            }
            sb.append(duit[i][1]);
            // System.out.println(sb.toString());
            System.out.println(sb);
        }
    }
}