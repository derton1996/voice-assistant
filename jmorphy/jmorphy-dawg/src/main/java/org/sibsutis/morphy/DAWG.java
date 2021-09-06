package org.sibsutis.morphy;

import org.apache.commons.io.input.SwappedDataInputStream;

import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class DAWG {
    protected final DataInput input;
    protected final Dict dict;

    public DAWG(InputStream stream) throws IOException {
        input = new SwappedDataInputStream(new BufferedInputStream(stream));
        dict = new Dict(input);
    }

    public List<String> prefixes(String key) throws IOException {
        int index = Dict.ROOT;
        int keyLength = key.length();
        List<String> res = new ArrayList<String>();
        int pos = 1;
        for (byte b : key.getBytes("UTF-8")) {
            index = dict.followByte(b, index);
            if (index == Dict.MISSING) {
                break;
            }
            if (dict.hasValue(index)) {
                res.add(key.substring(0, pos / 2));
            }
            pos++;
        }
        return res;
    }
}
