package com.opstty.reducer;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SpeciesHeightReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
    private FloatWritable result = new FloatWritable();

    public void reduce(Text key, Iterable<FloatWritable> values, Context context)
            throws IOException, InterruptedException {
        float max_height = 0;
        for (FloatWritable val : values) {
            if(val.get() > max_height) {
                max_height = val.get();
            }
        }

        result.set(max_height);
        context.write(key,result);
    }
}
