package com.opstty.reducer;

import com.opstty.comparator.HeightKey;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TreesHeightReducer extends Reducer<HeightKey, NullWritable, Text, NullWritable> {

    private Text outputKey;

    public void reduce(HeightKey hkey, Iterable<NullWritable> values,Context context)
            throws IOException, InterruptedException {
        outputKey = new Text (String.format("%s %.2f", hkey.geo, hkey.height));
        context.write(outputKey,NullWritable.get());
    }
}
