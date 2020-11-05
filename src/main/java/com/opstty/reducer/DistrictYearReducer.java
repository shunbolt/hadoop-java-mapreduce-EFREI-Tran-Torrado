package com.opstty.reducer;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DistrictYearReducer extends Reducer<NullWritable, Text, Text, NullWritable> {
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
            for(Text t : values){
                context.write(t, NullWritable.get());
            }
    }
}
