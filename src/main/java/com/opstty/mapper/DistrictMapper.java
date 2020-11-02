package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DistrictMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private final Text district = new Text();
    final String DELIMITER = ";" ;

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        try {
            // Skip the first line
            if (value.toString().contains("GEOPOSITION"))
                return;
            else{
                String line = value.toString();
                String[] tokens = line.split(DELIMITER);
                district.set(tokens[1]); // Retrieve the second column value of district
                context.write(district,one);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
