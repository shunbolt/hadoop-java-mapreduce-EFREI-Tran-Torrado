package com.opstty.mapper;

import com.opstty.comparator.HeightKey;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;



public class TreesHeightMapper extends Mapper<Object, Text, HeightKey, NullWritable>  {
    private float height;
    final String DELIMITER = ";" ;
    private String line = "";
    private String geo;
    int header = 0;

    private HeightKey heightkey = new HeightKey();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString(), "\n");
        while (itr.hasMoreTokens()) {
            if(header == 1) {
                line = itr.nextToken();
                geo = line.split(DELIMITER)[0];
                if (!line.split(DELIMITER)[6].isEmpty()){
                    height = Float.parseFloat(line.split(DELIMITER)[6]);
                }
                heightkey.set(geo,height);
                context.write(heightkey,NullWritable.get());
            }
            else{
                itr.nextToken();
                header = 1;
            }
        }
    }
}
