package com.opstty.job;


import com.opstty.comparator.HeightComparator;
import com.opstty.comparator.HeightKey;
import com.opstty.mapper.TreesHeightMapper;
import com.opstty.reducer.TreesHeightReducer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class TreesHeightSort {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

        if (otherArgs.length != 2) {
            System.err.println("Usage : treesheightsort <in> <out>");
            System.exit(2);
        }
        // Create hadoop job and set main class
        Job job = Job.getInstance(conf, "treesheightsort");
        job.setJarByClass(TreesHeightSort.class);

        // Set Mapper, Combiner, Reducer, Comparator class
        job.setMapperClass(TreesHeightMapper.class);


        // Type of output
        job.setMapOutputKeyClass(HeightKey.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setSortComparatorClass(HeightComparator.class);

        // job.setCombinerClass(TreesHeightReducer.class);
        job.setReducerClass(TreesHeightReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        job.setNumReduceTasks(1);

        // Set input path
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));

        // Set output path
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

        // run the job
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
