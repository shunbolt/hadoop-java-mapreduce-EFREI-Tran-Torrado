package com.opstty.job;

import com.opstty.mapper.SpeciesHeightMapper;
import com.opstty.reducer.SpeciesHeightReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class SpeciesHeightMax {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

        if (otherArgs.length != 2) {
            System.err.println("Usage : speciesheightmax <in> <out>");
            System.exit(2);
        }
        // Create hadoop job and set main class
        Job job = Job.getInstance(conf, "speciesheightmax");
        job.setJarByClass(SpeciesHeightMax.class);

        // Set Mapper, Combiner, Reducer class
        job.setMapperClass(SpeciesHeightMapper.class);
        job.setCombinerClass(SpeciesHeightReducer.class);
        job.setReducerClass(SpeciesHeightReducer.class);

        // Type of output
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FloatWritable.class);

        // Set input path
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));

        // Set output path
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

        // run the job
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
