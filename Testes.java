package Projeto1;
import java.util.*;





class Testes {
    private static String posicoesOnas[] = { "primeirona", "segundona", "terceirona", "segundona", "primeirona", "nona", "quarteirona", "quintona", "setimona", "quarteirona"};

   public static void main(String[] args) {
      Collection<String> umaColecao = new TreeSet<String>();
      for (int i = 0; i < 10; i++) {
        umaColecao.add(posicoesOnas[i]);
      }
      
      System.out.println("Número de palavras sem contar réplicas = " 
              + umaColecao.size());
      System.out.println(umaColecao);
   }
}



