/**
 * classe que define uma sequência de dados além de alguns métodos capaz de manipulá-los
 */

public class RolaDados{
    private int qtdados;
    private Dado[] dados;
    private int[] topos;

    /**
     * Rola dados sem parametros: gera por padrão 5 dados aleatorizados.
     */

    public RolaDados(){
        qtdados = 5;
        dados = new Dado[5];
        topos = new int[5];
        for(int i = 0; i < 5; i++){
            dados[i] = new Dado();
            topos[i] = dados[i].getLado();
        }
    }

    /**
     * Rola dados com paramëtro n: número de dados
     * @param n cria uma instância com n dados.
     */

    public RolaDados(int n){
        qtdados = n;
        dados = new Dado[n];
        topos = new int[n];
        for(int i = 0; i < n; i++){
            dados[i] = new Dado();
            topos[i] = dados[i].getLado();
        }
    }

    /**
     * Método de sobrecarga para impressão
     * @return retorna uma string que quando impressa, mostra de maneira clara e bonita os dados rolados.
     */

    @Override
    public String toString() {
        String s[][] = new String[qtdados][];
        String str_final = "";


        for(int i = 1; i <= qtdados; i++) {
            str_final += i + "           ";
        }

        for(int i = 0; i < qtdados; i++) {
            s[i] = dados[i].toString().split("\n");
        }

        str_final += "\n";

        for(int j = 0; j < qtdados; j++) {
            for(int i = 0; i < qtdados; i++){
                str_final += s[i][j];
                str_final += "\t";
            }
            str_final += "\n";
        }
        
        return str_final;
    }

    /**
     * método rolar sem parämetros, rola todos os dados!
     * @return retorna o array com a face do topo de cada dado.
     */

    public int[] rolar(){
        for(int i = 0; i < qtdados; i++){
            this.dados[i].rolar();
            topos[i] = dados[i].getLado();
        }
        return topos;
    }

    /**
     * método rolar com parâmetro quais (array de booleans), rola apenas certos dados.
     * @param quais um array "máscara" que contêm True para dados os quais quero rolar e False caso contrário
     * @return retorna o array com a face do topo de cada dado.
     */

    public int[] rolar(boolean[] quais){
        for(int i = 0; i < qtdados; i++) {
            if (quais[i]) {
                this.dados[i].rolar();
                topos[i] = dados[i].getLado();
            }
        }
        return topos;
    }

    /**
     * método rolar com String como parâmetro, rola apenas os dados da string
     * @param s cadeia de números identificando aqueles dados que devem ser rodados
     * @return retorna o array com a face do topo de cada dado.
     */

    public int[] rolar(String s){
        String[] splits = s.split(" ");
        for(String str : splits){
            int num = Integer.parseInt(str);
            if(num > qtdados)
                continue;
            num--;
            dados[num].rolar();
            topos[num] = dados[num].getLado();
        }
        return topos;
    }

    /**
     * getter do tipo topos
     * @return retorna o array das faces do topo de cada dado.
     */

    public int[] getTopos() {
        return topos;
    }

    /**
     * main para testes
     */
    /*public static void main(String[] args) {
        RolaDados rd = new RolaDados();
        System.out.println(rd);

    }*/

}