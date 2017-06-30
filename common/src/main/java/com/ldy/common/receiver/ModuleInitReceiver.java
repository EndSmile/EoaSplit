package com.ldy.common.receiver;

import android.content.Context;

import com.ldy.common.EoaApplication;

/**
 * Created by ldy on 2017/6/21.
 * 为了让各模块完成初始化，在{@link EoaApplication#moduleInit()}时调用,需要在AndroidManifest.xml中application节点下注册</p>
 * {@link #META_VALUE}作为value的<meta-data/>节点，其name属性是继承自{@link ModuleInitReceiver}类的全名</p>
 * example:<p/>
 * <pre><code>
 * &#60application&#62
 *
 *  &#60meta-data
 *      android:name="com.ldy.eoa.receiver.ExampleInitReceiver"
 *      android:value="module_init"/&#62
 *
 * &#60/application&#62
 * </code></pre>
 */

public abstract class ModuleInitReceiver {

    public static final String META_VALUE = "module_init";


    /**
     * 初始化，{@link EoaApplication#moduleInit()}时调用，
     * 应该在此初始化自己的模块
     */
    public abstract void init(Context context);

    /**
     * 各模块初始化完毕，{@link EoaApplication#moduleInit()}时调用，
     * 应该在此调用或注册其它模块
     */
    public abstract void initFinish(Context context);
}
