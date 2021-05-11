/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(i);
    }
    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));

            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    //start of task code.
    public void readList(String fileName)throws IOException{
        //create object form Reader to read the file.
        BufferedReader in=null;
        int lineNumber = 0; //number of line in file.
        String line;    //to store readline in it
        int toIntger; // store int number of substring.
        String subLine; // slicing number value.
        StringBuilder vector = new StringBuilder("");   //vector string that user to merge number.

        try{
            // start of try number.
            System.out.println("Entering try statement in readList Method");
            //initial reader object by file input.
            in = new BufferedReader(new FileReader(fileName));
            //start to read file.
            while ((line = in.readLine()) != null){
                lineNumber++;
                line = line.replace(" ",""); //replace remove all " ".
                subLine = line.substring((line.indexOf('=',0))+1);  //slicing int number from string
                try
                {
                    toIntger = Integer.parseInt(subLine.trim());    // transform substring to integer.
                    System.out.println("line "+ lineNumber + " have int = " + toIntger);    //print interger number on screen
                }
                catch (NumberFormatException nfe) //Exception Handling if number cannot trasform into integer.
                {
                    System.out.println("NumberFormatException: " + nfe.getMessage());
                }
                vector.append(subLine); // append new number to vector to merge it.

            }
            System.out.println("vector = " + vector);   //print final value of vector that merged all number in file.
        } catch (IndexOutOfBoundsException e) { //Exception Handling that if accesse out of range.
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {       //Exception Handling that if File cannot open or not found.
            System.err.println("Caught IOException: " + e.getMessage());
        }finally{       //finally close the file if it open.
            if (in != null) {
                System.out.println("Closing ReaderFile");
                in.close();
            } else {
                System.out.println("ReaderFile not open");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        //create main Method, just only to test the code.
        ListOfNumbers in1 = new ListOfNumbers();
        System.out.println(in1.list);
        // in1.writeList();
        System.out.println("=====================");
        in1.readList("OutFile.txt");
    }
}