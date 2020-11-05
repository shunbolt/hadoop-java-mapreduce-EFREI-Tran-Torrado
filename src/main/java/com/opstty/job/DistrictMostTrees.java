package com.opstty.job;

import com.opstty.mapper.DistrictMostTreesMapper1;
import com.opstty.mapper.DistrictMostTreesMapper2;
import com.opstty.reducer.DistrictMostTreesReducer1;
import com.opstty.reducer.DistrictMostTreesReducer2;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class DistrictMostTrees {

    public static void main(String[] args) throws Exception {
        // ********
        // Job 1
        // ********
        Configuration conf1 = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf1, args).getRemainingArgs();

        if (otherArgs.length != 3) {
            System.err.println("Usage : districtmosttrees <in> <output_mid> <output_final>");
            System.exit(2);
        }

        // Create hadoop job and set main class
        Job job1 = Job.getInstance(conf1, "districtmosttrees");
        job1.setJarByClass(DistrictMostTrees.class);

        // Set Mapper, Combiner, Reducer class
        job1.setMapperClass(DistrictMostTreesMapper1.class);
        job1.setCombinerClass(DistrictMostTreesReducer1.class);
        job1.setReducerClass(DistrictMostTreesReducer1.class);

        // Type of output
        job1.setOutputKeyClass(Text.class);
        job1.setOutputValueClass(IntWritable.class);

        // Set input path
        FileInputFormat.addInputPath(job1, new Path(otherArgs[0]));

        // Set output path
        FileOutputFormat.setOutputPath(job1, new Path(otherArgs[1]));

        job1.waitForCompletion(true);

        // *******
        // Job2
        // *******

        Configuration conf2 = new Configuration();

        // Create hadoop job and set main class
        Job job2 = Job.getInstance(conf2, "districtmosttrees2");
        job2.setJarByClass(DistrictMostTrees.class);

        // Set Mapper, Combiner, Reducer, Comparator class
        job2.setMapperClass(DistrictMostTreesMapper2.class);

        // Type of output
        job2.setMapOutputKeyClass(NullWritable.class);
        job2.setMapOutputValueClass(Text.class);
        job2.setSortComparatorClass(IntWritable.Comparator.class);

        job2.setCombinerClass(DistrictMostTreesReducer2.class);
        job2.setReducerClass(DistrictMostTreesReducer2.class);

        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(NullWritable.class);


        // Set input path
        FileInputFormat.addInputPath(job2, new Path(otherArgs[1]));

        // Set output path
        FileOutputFormat.setOutputPath(job2, new Path(otherArgs[2]));


        // run the job
        System.exit(job2.waitForCompletion(true) ? 0 : 1);
    }

}
