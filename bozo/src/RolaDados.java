public class RolaDados{
    private qtdados;
    private Dado[] dados;
    private int[] topos;

    public RolaDados(int n){
        Dado[] d = new Dado(n);
        for(int i = 0; i < n; i++){
            d[i] = new Dado();
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RolaDados{" +
                "dados=" + java.util.Arrays.toString(dados) +
                ", topos=" + java.util.Arrays.toString(topos) +
                '}';
    }



    public int[] rolar(){

    }

    public int[] rolar(boolean[] quais){

    }

    public int[] rolar(String s){

    }


}