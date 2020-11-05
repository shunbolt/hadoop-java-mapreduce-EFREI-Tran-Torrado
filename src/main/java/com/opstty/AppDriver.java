package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("districtcount", DistrictCount.class,
                    "A map/reduce program that counts the trees of each district in the input .csv file.");
            programDriver.addClass("districtoldest", DistrictOldest.class,
                    "A map/reduce program that displays the district with the oldest tree");
            programDriver.addClass("speciescount", SpeciesCount.class,
                    "A map/reduce program that counts the trees of each species in the input .csv file.");
            programDriver.addClass("speciescountwithtrees", SpeciesCountWithTrees.class,
                    "A map/reduce program that counts the trees of each species and their population in the input .csv file.");
            programDriver.addClass("speciesheight", SpeciesHeightMax.class,
                    "A map/reduce program that finds the highest tree of each specimen in the input .csv file.");
            programDriver.addClass("treesheightsort", TreesHeightSort.class,
                    "A map/reduce program that displays all trees in increasing height order");
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
