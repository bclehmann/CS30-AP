package root;

import java.io.*;

public class Files {

    public static void saveFile(String filename, int[] array) {
        try {
            PrintWriter file = new PrintWriter( new FileWriter(filename) );
            for(int i=0; i<array.length; i++){
                file.println("" + array[i]);
            }
            
            file.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }//end saveFile
    
    
    public static void saveFile(String filename, double[] array) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));
            for (int i = 0; i < array.length; i++) {
                file.println("" + array[i]);
            }
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }//end saveFile
    public static void saveFile(String filename, String[] array) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));
            for (int i = 0; i < array.length; i++) {
                file.println("" + array[i]);
            }
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }//end saveFile

    public static String[] loadStringArr(String filename) {
        String addLines = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                addLines += file.readLine() + ",";

            }
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] tempStringArray = addLines.split(",");
        return tempStringArray;
    }//end loadStringArr

    public static int[] loadIntArr(String filename) {
        String addLines = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                addLines += file.readLine() + ",";

            }
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] tempStringArray = addLines.split(",");
        int[] tempIntArray = new int[tempStringArray.length];
        for (int i = 0; i < tempIntArray.length; i++) {
            tempIntArray[i] = Integer.parseInt(tempStringArray[i]);
        }
        return tempIntArray;

    }//end loadIntArr

    public static double[] loadDoubleArr(String filename) {
        String addLines = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                addLines += file.readLine() + ",";

            }
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] tempStringArray = addLines.split(",");
        double[] tempDoubleArray = new double[tempStringArray.length];
        for (int i = 0; i < tempDoubleArray.length; i++) {
            tempDoubleArray[i] = Double.parseDouble(tempStringArray[i]);
        }
        return tempDoubleArray;

    }//end loadIntArr

}//end Files Class
