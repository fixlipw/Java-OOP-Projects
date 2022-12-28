public class Merge {
    public static int[] mergeSort(int[] a1, int[] a2) {

         // Variáveis para receber o tamanho dos vetores
        int a1_length = a1.length;
        int a2_length = a2.length;

        // Vetor para retorno, tem o tamanho igual a
        // soma do tamanho dos vetores de entrada
        int[] merged = new int[a1_length + a2_length];

        // Variáveis das posições do array
        // Representa o indice de iteração e o quanto o array tá cheio
        int a1_position, a2_position, merged_position;
        a1_position = a2_position = merged_position = 0;

        // ‘Loop’ que não para até que um dos vetores já esteja totalmente verificado
        // Verifica se o elemento do array 1 é igual ao elemento do array 2 e coloca no array de retorno
        while(a1_position < a1_length && a2_position < a2_length){
            if(a1[a1_position] < a2[a2_position]){
                merged[merged_position++] = a1[a1_position++];
            }
            else{
                merged[merged_position++] = a2[a2_position++];
            }
        }

        // Completa o array de retorno caso um dos arrays tenha terminado de ser verificado
        while(a1_position < a1_length){
            merged[merged_position++] = a1[a1_position++];
        }

        while(a2_position < a2_length){
            merged[merged_position++] = a2[a2_position++];
        }

        // Retorna o array de retorno
        return merged;
    }
}