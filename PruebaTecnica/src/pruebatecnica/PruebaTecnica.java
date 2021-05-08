package pruebatecnica;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sebastian Agudelo
 */
public class PruebaTecnica {

    /**
     * Metodo inicial
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        //creacion del arreglo inicial
        for (int i = 1; i <= 100; i++) {
            arrayList.add(i);
        }

        FirtExercise(arrayList, 9);
        TwoExercise(arrayList, 9);
        ThreeExercise(arrayList);
        FourExercise(arrayList, 50);
        FiveExercise(arrayList, new int[]{10, 11, 50, 30});
    }

    /**
     * Ejercicio 1: buscar el numero faltante en una Array de 1 a 100
     *
     * @param arrayList arreglo inicial
     * @param nAFaltar numero que se quiere que falte en el arreglo
     */
    public static void FirtExercise(ArrayList<Integer> arrayList, int nAFaltar) {

        //declaracion de variables
        ArrayList<Integer> array=new ArrayList<>(arrayList);// =arrayList;
        
        int nFaltante = -1;

        array.remove(nAFaltar-1);

        //metodo burbuja para el arreglo
        burbuja(array);

        //se realiza la busquedad numero Faltante. 
        for (int i = 1; i <= array.size(); i++) {
            if (!array.contains(i)) {
                nFaltante = i;
                break;
            }
        }

        //Impreciones por consola
        System.out.println("FirtExercise: ");
        System.out.println("Array: " + array.toString());

        if (nFaltante == -1) {
            System.out.println("Primer metodo: No hay numeros Faltantes ");
        } else {
            System.out.println("primer metodo: Numero Faltante= " + nFaltante);
        }

    }

    /**
     * Ejercicio 2: buscar el numero duplicado en una Arreglo de enteros
     *
     * @param arrayList Arreglo inicial
     * @param nDuplicado numero que se quiere que se este duplicado en el
     * arreglo
     */
    public static void TwoExercise(ArrayList<Integer> arrayList, int nDuplicado) {

        ArrayList<Integer> array = new ArrayList<>(arrayList);

        //se agrega el numero duplicado
        array.add(nDuplicado);

        //metodo de ordenamiento
        burbuja(array);

        int NumeroDuplicado = -1;
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) == array.get(i + 1)) {
                NumeroDuplicado = array.get(i);
            }
        }
        System.out.println("\nTwoExercise:");
        System.out.println("Array: " + array);
        System.out.println("Numero duplicado: " + NumeroDuplicado);

    }

    /**
     * Ejercicio 3: buscar el numero mas grande y el mas pequeño de una arreglo
     * de enteros
     *
     * @param arrayList arreglo inicial
     */
    public static void ThreeExercise(ArrayList<Integer> arrayList) {

        //Variables 
        ArrayList<Integer> array = new ArrayList(arrayList);
        int mayorValor = 0;
        int menorValor = array.size();

        //buscando el mayor y menor valor 
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) >= mayorValor) {
               
                mayorValor = array.get(i);
            }  if (array.get(i) <= menorValor) {

                menorValor = array.get(i);
            }
        }

        System.out.println("\nThreeExercise");
        System.out.println("Array: " + array);
        System.out.println("valor mayor: " + mayorValor);
        System.out.println("Valor menor: " + menorValor);

    }

    /**
     * Ejercicio 4: buscar el numero mas grande y el mas pequeño de una arreglo
     * de enteros
     *
     * @param arrayList arreglo inicial
     * @param totalSumaPares numero que se quiere alcanzar con la suma de los
     * pares del array
     */
    public static void FourExercise(ArrayList<Integer> arrayList, int totalSumaPares) {

        //varibles
        ArrayList<Integer> array = new ArrayList(arrayList);
        ArrayList arrayNpares = new ArrayList();
        int sumaPares = 0;

        //metodo de ordenamiento
        burbuja(array);
        //recorremos el arreglo
        for (int i = 0; i < array.size(); i++) {
            if (isPar(array.get(i))) {
                if (array.get(i) + sumaPares > totalSumaPares) {
                    break;
                } else {
                    arrayNpares.add(array.get(i));
                    sumaPares += array.get(i);
                }
            } else if (sumaPares > totalSumaPares) {
                break;
            }
        }
        System.out.println("\nCuarto Exercise");
        System.out.println("ArrayPares:" + arrayNpares);
        System.out.println("SumaPares: " + sumaPares);
        System.out.println("Numero a Alcanzar "+ totalSumaPares);
    }

    /**
     * Ejercicio 5: buscar todos los numeros duplicados de un arreglo que
     * contiene varios duplicados
     *
     * @param arrayList arreglo inicial
     * @param numerosADuplicar array de enteros que se quieren duplicar dentro
     * de del arreglo
     */
    public static void FiveExercise(ArrayList<Integer> arrayList, int[] numerosADuplicar) {

        //variables
        
        ArrayList arrayDuplicados = new ArrayList();
        ArrayList<Integer> array=new ArrayList<>(arrayList);// =arrayList;
        
        
        
        //se agregan los numero duplicados
        for (int i = 0; i < numerosADuplicar.length; i++) {
            array.add(numerosADuplicar[i]);           
        }
        
        //metodo de ordenamiento 
        burbuja(array);

        //se buscar los numeros duplicados
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) == array.get(i + 1)) {
                arrayDuplicados.add(array.get(i));
            }
        }//posible error si se ingresa una matriz con numero en duplciados en desorden [4,12,1,3,1,2,3]
        System.out.println("\nQuinto ejercicio ");
        System.out.println("array: "+array);
        System.out.println("Numeros duplicado: " + arrayDuplicados);
    }

    /**
     * dice si un numero es par o impar en otro caso
     *
     * @param num numero a saber si es par o impar
     * @return true si es par, false en otro caso
     */
    public static boolean isPar(int num) {
        return num % 2 == 0;
    }

    /**
     * dice si un numero hace parte de una arreglo dado, para saber en que
     * momento se puede añadir al arreglo original
     *
     * @param numerosADuplicar array de enteros a buscar
     * @param Buscar numero a buscar dentro del arreglo
     * @return true si es par, false en otro caso
     */
    public static boolean EstaEnMatriz(int[] numerosADuplicar, int Buscar) {
        for (int i = 0; i < numerosADuplicar.length; i++) {
            if (numerosADuplicar[i] == Buscar) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo de ordenamiento de un arrayList
     *
     * @param A valor de ArrayList pasado por referencia para su posterior
     * ordenamiento de menos a mayor
     *
     */
    public static void burbuja(ArrayList<Integer> A) {
        int i, j, aux;
        for (i = 0; i < A.size() - 1; i++) {
            for (j = 0; j < A.size() - i - 1; j++) {
                if (A.get(j + 1) < A.get(j)) {
                    aux = A.get(j + 1);
                    A.set(j + 1, A.get(j));
                    A.set(j, aux);
                }
            }
        }
    }

}
