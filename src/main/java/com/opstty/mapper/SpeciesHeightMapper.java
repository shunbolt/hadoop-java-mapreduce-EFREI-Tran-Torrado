package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class SpeciesHeightMapper extends Mapper<Object, Text, Text, FloatWritable> {
    private final static FloatWritable height = new FloatWritable(0);
    final String DELIMITER = ";" ;
    private String line = "";
    private Text specimen = new Text();
    int header = 0;

    public void map(Object key, Text value, Mapper.Context context)
            throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString(), "\n");
        while (itr.hasMoreTokens()) {
            if(header == 1) {
                line = itr.nextToken();
                specimen.set(line.split(DELIMITER)[3]);
                if (!line.split(DELIMITER)[6].isEmpty()){
                    height.set(Float.parseFloat(line.split(DELIMITER)[6]));
                }
                context.write(specimen,height);
            }
            else{
                itr.nextToken();
                header = 1;
            }
        }
    }
}
