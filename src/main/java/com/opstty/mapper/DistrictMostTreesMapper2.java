package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class DistrictMostTreesMapper2 extends Mapper<Object, Text, NullWritable, Text> {

    final String DELIMITER = "\t" ;
    private String line = "";
    private Text district = new Text();

    // Dummy variables used for comparison sake
    private String max_district;
    private int max_trees = 0;

    int header = 0;


    public void map(Object key, Text value, Mapper.Context context)
            throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString(), "\n");
        while (itr.hasMoreTokens()) {
            if(header == 1) {
                line = itr.nextToken();
                if (!line.split(DELIMITER)[1].isEmpty() && Integer.parseInt(line.split(DELIMITER)[1]) > max_trees) {
                    max_trees = Integer.parseInt(line.split(DELIMITER)[1]);
                    max_district = line.split(DELIMITER)[0];
                }
            }
            else{
                itr.nextToken();
                header = 1;
            }
        }
    }

    @Override
    public void cleanup(Mapper.Context context) throws IOException, InterruptedException {
        district.set(max_district);
        context.write(NullWritable.get(),district);
    }
}
