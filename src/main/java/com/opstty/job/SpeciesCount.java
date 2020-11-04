package com.opstty.job;

import com.opstty.mapper.SpeciesMapper;
import com.opstty.reducer.SpeciesReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class SpeciesCount {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

        if (otherArgs.length != 2) {
            System.err.println("Usage : speciescount <in> <out>");
            System.exit(2);
        }
        // Create hadoop job and set main class
        Job job = Job.getInstance(conf, "speciescount");
        job.setJarByClass(SpeciesCount.class);

        // Set Mapper, Combiner, Reducer class
        job.setMapperClass(SpeciesMapper.class);
        job.setCombinerClass(SpeciesReducer.class);
        job.setReducerClass(SpeciesReducer.class);

        // Type of output
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        // Set input path
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));

        // Set output path
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

        // run the job
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
