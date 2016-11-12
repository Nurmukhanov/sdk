package walkingdevs.http11;

import walkingdevs.data.Kvs;
import walkingdevs.data.mKv;
import walkingdevs.data.mKvs;
import walkingdevs.fun.Result;
import walkingdevs.val.mVal;

public class mQuery {
    public static Query mk() {
        Kvs<String, String> kvs = mKvs.mk();
        return mk(kvs);
    }

    public static Query mk(Kvs<String, String> keyVals) {
        return new QueryImpl(keyVals);
    }

    public static Query mk(final String queryString) {
        mVal.isIsBlank(queryString, "queryString").fail();
        mVal.mk(queryString, "queryString",
            new Result<Boolean>() {
                public Boolean get() {
                    return queryString.startsWith("?");
                }
            },
            "Cannot start with '?'"
        ).fail();
        mVal.mk(queryString, "queryString",
            new Result<Boolean>() {
                public Boolean get() {
                    return queryString.endsWith("#");
                }
            },
            "Cannot end with '#'"
        ).fail();

        Kvs<String, String> kvs = mKvs.mk();
        for (String kvString : queryString.split("&")) {
            String[] kv = kvString.split("=");
            if (kv.length == 1) {
                kvs.add(mKv.mk(kv[0], ""));
            } else if (kv.length == 2) {
                kvs.add(mKv.mk(kv[0], kv[1]));
            }
        }
        return mk(kvs);
    }
}