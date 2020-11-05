package com.opstty.comparator;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class HeightKey implements WritableComparable<HeightKey> {
    public String geo;
    public float height;

    public HeightKey() {
    }

    public HeightKey(String geo, float height) {
        super();
        this.set(geo,height);
    }

    public void set(String geo,float height) {
        this.geo = (geo == null) ? "" : geo;
        this.height = height;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(geo);
        out.writeFloat(height);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        geo = in.readUTF();
        height = in.readFloat();
    }

    // Check values between height then checks geoposition string
    @Override
    public int compareTo(HeightKey o) {
        int heightCmp = Float.compare(height, o.height);
        if (heightCmp != 0) {
            return heightCmp;
        } else {
            return geo.toLowerCase().compareTo(o.geo.toLowerCase());
        }
    }

}
