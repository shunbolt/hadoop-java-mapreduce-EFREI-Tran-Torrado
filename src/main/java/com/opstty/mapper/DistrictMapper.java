package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DistrictMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    final String DELIMITER = ";" ;

    public void map(Object key, Text value, Context context)
         throws IOException, InterruptedException {
            // Skip the first line
            String file = value.toString();
            String [] lines = file.split("\n");
            for (int i = 1; i < lines.length; i++) {
                String district = lines[i].split(DELIMITER)[1];
                // Retrieve the second column value of district
                context.write(new Text(district), one);
            }
        }

}