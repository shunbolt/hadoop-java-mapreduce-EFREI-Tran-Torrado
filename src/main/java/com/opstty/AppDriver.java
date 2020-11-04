package com.opstty;

import com.opstty.job.DistrictCount;
import com.opstty.job.SpeciesCount;
import com.opstty.job.SpeciesCountWithTrees;
import com.opstty.job.WordCount;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("districtcount", DistrictCount.class,
                    "A map/reduce program that counts the trees of each district in the input .csv file.");
            programDriver.addClass("speciescount", SpeciesCount.class,
                    "A map/reduce program that counts the trees of each district in the input .csv file.");
            programDriver.addClass("speciescountwithtrees", SpeciesCountWithTrees.class,
                    "A map/reduce program that counts the trees of each district in the input .csv file.");
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
