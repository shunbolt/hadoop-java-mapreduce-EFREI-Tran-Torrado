package com.opstty.job;


import com.opstty.mapper.DistrictYearMapper;
import com.opstty.reducer.DistrictYearReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class DistrictOldest {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

        if (otherArgs.length != 2) {
            System.err.println("Usage : districtoldest <in> <out>");
            System.exit(2);
        }
        // Create hadoop job and set main class
        Job job = Job.getInstance(conf, "districtoldest");
        job.setJarByClass(DistrictOldest.class);

        // Set Mapper, Combiner, Reducer, Comparator class
        job.setMapperClass(DistrictYearMapper.class);

        // Type of output
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setSortComparatorClass(IntWritable.Comparator.class);

        job.setCombinerClass(DistrictYearReducer.class);
        job.setReducerClass(DistrictYearReducer.class);

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
