package lab9;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jie luo
 * 2017-11-15.
 * Class Madlib
 * Madlib will replace the filter with the content in the filter file
 *
 */
public class Madlib {
    public static void main(String[] args) {
        String filterFile = "src/lab9/fillter.txt";
        String madlibFile = "src/lab9/madlib.txt";
        String outputFile = "src/lab9/output.txt";

        // get the rows of the file content
        int count = countRows(filterFile);
        // initiate arrays
        String[] filter = new String[count];    // store the filter name
        String[] list = new String[count];      // store the filter value, list will be keep in one string,
                                                // separate when replacing

        // store filter name in filter[],  store filter value in list[]
        collectFilterAndList(filterFile, filter, list);

        // valid check
        if(!checkFilterValid(filter)){
            System.out.println("File is not valid!");
            return;
        }

        // find the filter in madlib file
        writeOutput( findFilter(madlibFile, filter, list), outputFile );

    }

    // return the rows of filter file to initiate the filter[] and list[]
    public static int countRows(String filterFile){
        int count = 0;
        try {
            Scanner sc = new Scanner(new File(filterFile));
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                String temp = sc.next();
                if(temp.equals("")) continue;   // skip the empty line
                count++;
            }
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    // store value to filter[] and list[]
    public static void collectFilterAndList(String filterFile, String[] filter, String[] list){
        int count = 0;
        try{
            // open file
            Scanner sc = new Scanner(new File(filterFile));
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                String temp = sc.next();
                if(temp.equals("")) continue;   // skip the empty line
                // find the index of ";" to separate the name and value
                String delimiter = ";";
                int i = findDelimiter(temp, delimiter);
                if(i == -1){
                    // delimiter not found, means it's wildcard filter value, and store it to the end of the array
                    list[filter.length-1] = temp;
                }else {
                    // store names and values
                    filter[count] = temp.substring(0, i);
                    list[count] = temp.substring(i + 1);
                    count ++;
                }
            }
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int findDelimiter(String str, String delimiter){
        for(int i = 0;i<str.length();i++){
            if( (""+str.charAt(i)).equals(delimiter) ){
                return i;
            }
        }
        return -1;
    }

    /*
     * check condition: has to be and only one wildcard filter value exist
     */
    public static boolean checkFilterValid(String[] filter){
        int count = 0;
        for(int i = 0;i<filter.length;i++){
            if(count > 1) return false;
            if(filter[i] == null) count++;
        }
        return count != 0;
    }

    public static String findFilter(String madlibFile, String[] filter, String[] list){
        String replacedStr = "";
        try{
            Scanner sc = new Scanner(new File(madlibFile));
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                String temp = sc.next();
                replacedStr += filterSeg(temp, filter, list)+"\n";
            }
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return replacedStr;
    }

    /**
     * @param str       it's each line of the madlibFile
     * @param filter    the array that stores all the filter name
     * @param list      the value of each liter name
     * @return          return each line after been replaced
     */
    public static String filterSeg(String str, String[] filter, String[] list){
        String name = "";
        String replacedStr="";
        int index;
        int h = -1, e = -1;     // h is the head of "$ $" pair, e is the end of "$ $" pair.

        for(int i = 0;i<str.length();i++){
            // check if the char is '$', if it is, then create a sub string when find the 2nd '$',
            if(str.charAt(i) == '$'){
                if(h == -1) {
                    h = i;
                    // add the original part of string
                    replacedStr += str.substring(e+1, i);
                }else{
                    e = i;
                    name = str.substring(h+1, i);
                    index = findFilterIndex(name, filter);
                    // get random val from list
                    replacedStr += randListVal(list, index);
                    // reset the h be 0;
                    h = -1;
                }
            }
        }
        replacedStr += str.substring(e+1);
        return replacedStr;
    }

    // find the index of the filter name
    public static int findFilterIndex(String str, String[] filter){
        for(int i = 0;i<filter.length-1;i++){
            if(filter[i].equals(str)){
                return i;
            }
        }
        // if there is no found, return the last index where store the wildcard
        return filter.length-1;
    }

    // return the random value of list according the filter index
    public static String randListVal(String[] list, int index){
        String[] l = list[index].split(",");
        Random rand = new Random();
        return l[rand.nextInt(l.length)].trim();
    }

    // write content to output file
    public static void writeOutput(String content, String outputFile){
        try{
            PrintWriter sc = new PrintWriter(new File(outputFile));
            sc.print(content);
            sc.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
