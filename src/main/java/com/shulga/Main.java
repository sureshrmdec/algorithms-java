package com.shulga;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve("10:10", 24*61, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(String timet, int deltat, InputReader in, PrintWriter out) {
            String time = in.next();
            int delta = in.nextInt();
            if (delta == 0)     {
                out.println(time);
            }
            String[] split = time.split(":");
            int hour = Integer.valueOf(split[0]);
            int minutes = Integer.valueOf(split[1]);

            int hoursIncrement = (delta / 60) % 24;
            int minuteIncrement = delta - (hoursIncrement * 60);
            if (hoursIncrement != 0) {
                hour = (hour + hoursIncrement) % 24;
            }
            if ((minutes + minuteIncrement) / 60 != 0) {
                hour = (hour + (minutes + minuteIncrement) / 60) % 24;
            }
            minutes = (minutes + delta) % 60;
            String resHour = hour < 10 ? "0" + hour : String.valueOf(hour);
            String resMinute = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
            out.println(resHour + ":" + resMinute);
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}