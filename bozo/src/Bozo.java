/**
 * classe encarregada de simular o jogo, utilizando as outras classes
 */

public class Bozo {

    /**
     * função intermediária para inserção na tabela
     * @param p p é o placar
     * @param dados dados é a sequência de dados que foi rolada
     * @throws Exception exceções que podem ser geradas quando o usuário tenta inserir numa posição inválida
     */

    public static void pontuar(Placar p, int[] dados) throws Exception{
        System.out.println(p);
        System.out.println("Onde deseja inserir sua pontuação?");
        
        while(true) {
            try {
                int pos = EntradaTeclado.leInt();
                p.add(pos, dados);
            } catch (IllegalArgumentException e) {
                System.out.println("Por favor digite uma opcao válida (não ocupada e que esteja no tabuleiro): ");
                continue;
            }
            break;
        }

        System.out.println(p);
    }

    /**
     * função main
     * @param args argumentos da linha de comando (não utilizados)
     * @throws Exception exceções de in/out
     */

    public static void main(String[] args) throws Exception{
        int rodada = 1;
        String querer;

        do {
            Placar p = new Placar();
            RolaDados rd = new RolaDados();
            int[] dados = rd.getTopos();

            System.out.println("Digite alguma coisa para começar o jogo");
            querer = EntradaTeclado.leString();

            System.out.println("RODADA NUMERO:" + rodada);
            rodada++;

            for (int i = 1; i <= 10; i++) {
                System.out.println("Turno " + i + ":\n");

                rd.rolar();
                dados = rd.getTopos();
                System.out.println(rd);

                for (int j = 0; j < 2; j++) {
                    System.out.println("Deseja rolar algum dado? s/n");
                    querer = EntradaTeclado.leString();

                    if (querer.equals("n")) {
                        break;
                    }

                    System.out.println("Digite os numeros dos dados que quer rolar: ");
                    querer = EntradaTeclado.leString();
                    rd.rolar(querer);
                    dados = rd.getTopos();
                    System.out.println(rd);
                }

                pontuar(p, dados);
            }


            System.out.println("Sua pontuação é: " + p.getScore());
            System.out.println("Quer jogar novamente? s/n");
            querer = EntradaTeclado.leString();

        } while(querer.equals("s"));
    }
}