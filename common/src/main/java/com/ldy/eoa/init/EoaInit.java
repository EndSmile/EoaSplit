package com.ldy.eoa.init;

import android.content.Context;

/**
 * Created by ldy on 2017/6/21.
 */

public interface EoaInit {
    void serviceInit(Context context);

    void serviceInitFinish(Context context);
}
