/**
 * classe que define o placar do jogo
 */

public class Placar {
    private boolean[] usado;
    private int[] pontuacao;
    private String[] resposta;

    /**
     * construtor padrão
     */

    public Placar(){
        usado = new boolean[10];
        pontuacao = new int[10];
        resposta = new String[10];
    }

    /**
     * função que calcula a pontuação final do jogador.
     * @return retorna a pontuação final (soma dos valores da tabela).
     */

    public int getScore(){
        int score = 0;
        for(int i = 0; i < 10; i++){
            score += pontuacao[i];
        }
        return score;
    }

    /**
     * função para inserção de uma pontuação na tabela
     * @param posicao posição em que será inserido os pontos
     * @param dados dados que foram rolados
     * @throws java.lang.IllegalArgumentException exceção dada quando a posição é inválida.
     */

    public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException {

        posicao--;
        int[] frequencia = new int[6];

        if(posicao < 0 || posicao > 9 || usado[posicao])
            throw new IllegalArgumentException("Posicao invalida");

        usado[posicao] = true;

        for(int d : dados){
            frequencia[d-1]++;
        }

        int score = 0;

        switch(posicao){
            case 6:
                boolean tres = false;
                boolean dois = false;
                for(int f: frequencia){
                    if(f == 2) dois = true;
                    if(f == 3) tres = true;
                }
                if(tres && dois){
                    score += 15;
                }
                break;

            case 7:
                int diferentes = 0;
                for(int f : frequencia){
                    if(f != 0) diferentes++;
                }
                if(diferentes == 5){
                    score += 20;
                }
                break;

            case 8:
                boolean quatro = false;
                for(int f : frequencia){
                    if(f == 4) quatro = true;
                }
                if(quatro){
                    score += 30;
                }
                break;
            case 9:
                boolean cinco = false;
                for(int f : frequencia){
                    if(f == 5) cinco = true;
                }
                if(cinco){
                    score += 40;
                }
                break;
            default:
                score += frequencia[posicao] * (posicao+1);
        }
        
        pontuacao[posicao] = score;

    }

    /**
     * função que gera a tabela do placar
     * @return retorna a string do placar formatada conforme o necessário.
     */

    @Override
    public String toString(){

        for(int i = 0; i < 10; i++){
            if(usado[i] == false) resposta[i] = "(" + Integer.toString(i+1) + ")";
            else resposta[i] = Integer.toString(pontuacao[i]);
        }


        String str = String.format("%7s|%7s|%7s\n%s\n%7s|%7s|%7s\n%s\n%7s|%7s|%7s\n%s\n%8s%7s%s\n%s\n",

                resposta[0], resposta[6], resposta[3],
                "-----------------------",
                resposta[1], resposta[7], resposta[4],
                "-----------------------",
                resposta[2], resposta[8], resposta[5],
                "-----------------------",
                "|", 	   resposta[9], "|",
                "       +-------+");

        return str;
    }
}
