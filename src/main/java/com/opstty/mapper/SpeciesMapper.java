package com.opstty.mapper;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class SpeciesMapper extends Mapper<Object, Text, Text, NullWritable> {
    final String DELIMITER = ";" ;
    private Text specimen = new Text();
    int header = 0;


    public void map(Object key, Text value, Mapper.Context context)
            throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString(), "\n");
        while (itr.hasMoreTokens()) {
            if(header == 1) {
                specimen.set(itr.nextToken().split(DELIMITER)[2]);
                context.write(specimen, NullWritable.get());
            }
            else{
                itr.nextToken();
                header = 1;
            }
        }
    }
}
