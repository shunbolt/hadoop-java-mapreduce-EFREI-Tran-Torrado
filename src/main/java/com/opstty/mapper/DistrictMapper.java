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
            String file = value.toString();
            System.out.println(file);
            String[] lines = file.split("\n");
            for (int i = 1; i < lines.length; i++) {
                System.out.println(lines[i]);
                String district = lines[i].split(DELIMITER)[1];
                // Retrieve the second column value of district
                System.out.println(district);
                context.write(new Text(district), one);
            }
        }

}
