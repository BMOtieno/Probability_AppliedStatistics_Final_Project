package Graphs;

import org.apache.commons.math3.analysis.function.Subtract;
import org.apache.commons.math3.analysis.function.Add;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SmoothData {
    /**
     * A program that imports Apache libraries to smooth a salted graph
     * @author Brian Odhiambo
     *
     * */
    final static Subtract subtract = new Subtract();
    final static Add add = new Add();
    // Smoother
    public static void smoothTheGraph() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ApacheSmoothedGraph.csv"))){
            StringBuilder stringBuilder = new StringBuilder();

            int m = 2;
            int y = 0;
            int z = 0;
            int p = 0;

            stringBuilder.append("Index X");
            stringBuilder.append(",");
            stringBuilder.append("Index Y");
            stringBuilder.append("\n");
            for(int i = 0; i < 20; i++){
                stringBuilder.append(i);
                stringBuilder.append("\n");
            }
            stringBuilder.append("\t");
            for(int j = 0; j < 20; j++){
                stringBuilder.append(",");
                y = (m * (int)subtract.value(j,2)) + 1;
                z = (m * (int)add.value(j , 2)) + 1;
                p = ((int)add.value(y , z) / 3) + 1;
                stringBuilder.append(p);
                stringBuilder.append("\n");
            }
            stringBuilder.append(",");
            bufferedWriter.write(stringBuilder.toString());
        }catch(Exception ex){
            System.out.println("Something wrong here");
        }finally {
            System.out.println("The program ran successfully");
        }
    }
    public static void main(String[] args) {
        smoothTheGraph();
    }
}
