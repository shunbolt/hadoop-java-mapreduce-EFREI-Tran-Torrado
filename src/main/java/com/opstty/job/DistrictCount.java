package com.opstty.job;

import com.opstty.mapper.DistrictMapper;
import com.opstty.reducer.DistrictReducer;
import com.opstty.reducer.IntSumReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class DistrictCount {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

        if (otherArgs.length != 2) {
            System.err.println("Usage : districtcount <in> <out>");
            System.exit(2);
        }
        // Create hadoop job and set main class
        Job job = Job.getInstance(conf, "districtcount");
        job.setJarByClass(DistrictCount.class);

        // Set Mapper, Combiner, Reducer class
        job.setMapperClass(DistrictMapper.class);
        job.setCombinerClass(DistrictReducer.class);
        job.setReducerClass(DistrictReducer.class);

        // Type of output
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // Set input path
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));

        // Set output path
        FileOutputFormat.setOutputPath(job,new Path(otherArgs[1]));

        // run the job
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
