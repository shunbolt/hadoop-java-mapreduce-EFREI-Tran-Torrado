package com.opstty.mapper;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class DistrictMapper extends Mapper<Object, Text, Text, NullWritable> {
    final String DELIMITER = ";" ;
    private Text district = new Text();
    int header = 0;


    public void map(Object key, Text value, Context context)
         throws IOException, InterruptedException {
            StringTokenizer itr = new StringTokenizer(value.toString(), "\n");
            while (itr.hasMoreTokens()) {
                if(header == 1) {
                    district.set(itr.nextToken().split(DELIMITER)[1]);
                    context.write(district, NullWritable.get());
                }
                else{
                    itr.nextToken();
                    header = 1;
                }
            }
        }

}
