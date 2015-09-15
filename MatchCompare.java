/******************************************************************************

 *  Note: this program is designed to compare two sorting algorithms with
 *  roughly the same order of growth, e,g., insertion sort vs. selection
 *  sort or mergesort vs. quicksort. Otherwise, various system effects
 *  (such as just-in-time compiliation) may have a significant effect.
 *  One alternative is to execute with "java -Xint", which forces the JVM
 *  to use interpreted execution mode only.
 *
 ******************************************************************************/

import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class MatchCompare {

    public static int found = 0;

    public static double time(String alg, String pat, String txt) {
        Stopwatch sw = new Stopwatch();
        if      (alg.equals("BruteForce")) {
          found = BruteForce.search(pat, txt);
        }
        else if (alg.equals("KMP")) {
          KMP kmp = new KMP(pat);
          found = kmp.search(txt);
        }
        else if (alg.equals("BoyerMoore")) {
          BoyerMoore boyermoore = new BoyerMoore(pat);
          found = boyermoore.search(txt);
        }
        else if (alg.equals("RabinKarp")) {
          RabinKarp searcher = new RabinKarp(pat);
          found = searcher.search(txt);
        }
        else throw new IllegalArgumentException("Invalid algorithm: " + alg);
        return sw.elapsedTime();
    }

    // Use alg to sort T random arrays of length N.
    public static double testCorpusMatchTimeOfT(String alg, String pat, String txt, int T) {
        double total = 0.0;
        // Perform one experiment (generate and sort an array).
        for (int t = 0; t < T; t++) {
            total += time(alg, pat, txt);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        String alg1 = args[0];
        String alg2 = args[1];
        String pat = args[2];
        String path = args[3];
        int T = Integer.parseInt(args[4]);

        File file = new File(path);
        FileReader reader = new FileReader(file);

        BufferedReader br = new BufferedReader(reader);
        String line = "";
        StringBuffer buffer = new StringBuffer();
        while((line = br.readLine()) != null)
          buffer.append(line);
        String txt = buffer.toString();
        br.close();

        double time1 = testCorpusMatchTimeOfT(alg1, pat, txt, T); // Total for alg1.
        double time2 = testCorpusMatchTimeOfT(alg2, pat, txt, T); // Total for alg2.
        StdOut.printf("For %s\n    %s is", path, alg1);
        StdOut.printf(" %.1f times faster than %s\n", time2/time1, alg2);
        if(found < txt.length())
          StdOut.printf("found! position is : %d of %d.", found, txt.length());
    }
}
