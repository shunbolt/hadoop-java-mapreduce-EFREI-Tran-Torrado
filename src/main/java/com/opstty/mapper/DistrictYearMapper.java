package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class DistrictYearMapper extends Mapper<Object, Text, NullWritable, Text> {
    final String DELIMITER = ";" ;
    private String line = "";
    private Text district = new Text();

    // Dummy variables used for comparison sake
    private String min_district;
    private int min_year = 2020;

    int header = 0;


    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString(), "\n");
        while (itr.hasMoreTokens()) {
            if(header == 1) {
                line = itr.nextToken();
                if (!line.split(DELIMITER)[5].isEmpty() && Integer.parseInt(line.split(DELIMITER)[5]) < min_year) {
                    min_year = Integer.parseInt(line.split(DELIMITER)[5]);
                    min_district = line.split(DELIMITER)[1];
                }
            }
            else{
                itr.nextToken();
                header = 1;
            }
        }
    }

    @Override
    public void cleanup(Context context) throws IOException, InterruptedException {
        district.set(min_district);
        context.write(NullWritable.get(),district);
    }

}
