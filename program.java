import java.io.*;

public class program {
    static public void main(String[] args)throws IOException
    {
        File logFile = new File("logger.txt");
        logFile.createNewFile();
        FileWriter fw = new FileWriter(logFile);
        int[] array = new int[] {1, 2, 6, 3, 7, 5, 8};
        System.out.println("Все работает!\n");
        int count = 1;
        System.out.println("Исходный числовой массив:");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        for (int out = array.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if (array[in] > array[in + 1]){
                    int dummy = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = dummy;
                    fw.write("Iteration "+count+": ["+in+"]="+array[in]+" replaced with ["+(in + 1)+"]="+array[in + 1]+"\n");
                }
                else{
                    fw.write("Iteration "+count+": ["+in+"]="+array[in]+" not replaced with ["+(in + 1)+"]="+array[in + 1]+"\n");
                }
                count++;
            }
        }
        System.out.println("\nРезультат пузырьковой сортировки:");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        fw.flush();
        fw.close();
    }
}
