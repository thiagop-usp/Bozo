/**
 * classe que define um Dado
 */
public class Dado {

    private int num_lados;
    private int topo;

    /**
     * função de sobrecarga para a formatação de um dado
     * @return retorna uma string no formato de um dado
     */

    @Override
    public String toString() {
        if (num_lados > 6 || num_lados < 1)
            return "";

        switch (topo) {
            case 1:
                return ("+-------+\n|       |\n|   •   |\n|       |\n+-------+\n");
            case 2:
                return ("+-------+\n| •     |\n|       |\n|     • |\n+-------+\n");
            case 3:
                return ("+-------+\n| •     |\n|   •   |\n|     • |\n+-------+\n");
            case 4:
                return ("+-------+\n| •   • |\n|       |\n| •   • |\n+-------+\n");
            case 5:
                return ("+-------+\n| •   • |\n|   •   |\n| •   • |\n+-------+\n");
            case 6:
                return ("+-------+\n| •   • |\n| •   • |\n| •   • |\n+-------+\n");

        }
        return "";
    }

    /**
     * construtor padrão ( 6 lados)
     */
    public Dado(){
        num_lados = 6;
        this.rolar();
    }

    /**
     * construtor customizado
     * @param num_lados especifica o numero de lados do dado
     */
    public Dado(int num_lados){
        this.num_lados = num_lados;
        this.rolar();
    }

    /**
     * rola o dado (aleatoriza o numero do topo)
     * @return retorna o valor aleatorizado
     */

    public int rolar(){
        Random r = new Random();
        topo = r.getIntRand(1, num_lados + 1);
        return topo;
    }

    /**
     * pega o valor do topo
     * @return retorna o valor do topo
     */

    public int getLado() {
        return topo;
    }

    /**
     * main apenas para tests
     */

    /*public static void main(String[] args) {
        Dado d = new Dado();
        System.out.println(d);
    }*/
}
